package evidence.controllers;

import evidence.models.dtos.InsuranceDTO;
import evidence.models.dtos.InsuredDTO;
import evidence.models.exceptions.DuplicateEmailException;
import evidence.models.services.InsuranceService;
import evidence.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping("/pojisteni-app/pojistenci")
    public String renderInsuredTable(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<InsuredDTO> insuredPage = insuredService.getAll(pageable);
        model.addAttribute("insuredPage", insuredPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", insuredPage.getTotalPages());
        return "pages/insured/insured";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/pojisteni-app/pojistenci/novy")
    public String renderInsuredForm(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/insuredForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/pojisteni-app/pojistenci/novy")
    public String processInsuredForm(@Valid @ModelAttribute InsuredDTO insuredDTO,
                                     BindingResult result,
                                     RedirectAttributes redirectAttributes,
                                     Model model) {
        if (result.hasErrors()) {
            return "pages/insured/insuredForm";
        }
        try {
            insuredService.create(insuredDTO);
        } catch (DuplicateEmailException e) {
            model.addAttribute("danger", "Pojištěnec s tímto e-mailem již existuje.");
            return "pages/insured/insuredForm";
        }
        redirectAttributes.addFlashAttribute("success", "Pojištěnec byl uložen.");
        return "redirect:/pojisteni-app/pojistenci";
    }

    @GetMapping("/pojisteni-app/pojistenci/detail/{id}")
    public String renderInsuredDetail(@PathVariable long id, @RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        InsuredDTO insured = insuredService.getById(id);
        model.addAttribute("insured", insured);
        Page<InsuranceDTO> insurancesPage = insuranceService.getByInsuredId(id, pageable);
        model.addAttribute("insurancePage", insurancesPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", insurancesPage.getTotalPages());

        return "pages/insured/insuredDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/pojisteni-app/pojistenci/odstranit/{id}")
    public String deleteInsured(@PathVariable long id, RedirectAttributes redirectAttributes) {
        insuredService.remove(id);
        redirectAttributes.addFlashAttribute("danger", "Pojištěnec byl odstraněn.");
        return "redirect:/pojisteni-app/pojistenci";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/pojisteni-app/pojistenci/edit/{id}")
    public String renderEditForm(@PathVariable long id, Model model) {
        InsuredDTO insuredDTO = insuredService.getById(id);
        model.addAttribute("insuredDTO", insuredDTO);
        return "pages/insured/insuredEdit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/pojisteni-app/pojistenci/edit")
    public String processEditForm(@ModelAttribute InsuredDTO insuredDTO,
                                  @RequestParam(value = "redirect") String redirect,
                                  RedirectAttributes redirectAttributes) {
        if (Arrays.stream(new Object[] {insuredDTO.getPostCode(),insuredDTO.getName(),insuredDTO.getSurname(),insuredDTO.getEmail(),insuredDTO.getPhone(),insuredDTO.getCity(),insuredDTO.getStreet()})
                .map(obj -> (String) obj)
                .anyMatch(String::isEmpty)) {
            System.out.println("Null value detected!");
            redirectAttributes.addFlashAttribute("errorMessage", "Všechna pole jsou povinná.");
            return "redirect:/pojisteni-app/pojistenci/edit/" + insuredDTO.getId();
        }
        insuredService.edit(insuredDTO);
        redirectAttributes.addFlashAttribute("warning", "Pojištěnec byl úspěšně editován.");

        if ("detail".equals(redirect)) {
            return "redirect:/pojisteni-app/pojistenci/detail/" + insuredDTO.getId();
        } else {
            return "redirect:/pojisteni-app/pojistenci";
        }
    }
}
