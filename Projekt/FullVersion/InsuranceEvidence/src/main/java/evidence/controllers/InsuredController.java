package evidence.controllers;

import evidence.models.dtos.InsuredDTO;
import evidence.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @GetMapping("/pojisteni-app/pojistenci")
    public String renderInsured(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<InsuredDTO> insuredPage = insuredService.getAll(pageable);
        model.addAttribute("insuredPage", insuredPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", insuredPage.getTotalPages());
        return "pages/insured/insured";
    }

    @GetMapping("/pojisteni-app/pojistenci/novy")
    public String renderInsuredForm(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/insuredForm";
    }

    @PostMapping("/pojisteni-app/pojistenci/novy")
    public String processInsuredForm(@Valid @ModelAttribute InsuredDTO insuredDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pages/insured/insuredForm";
        }
        insuredService.create(insuredDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec byl uložen.");
        return "redirect:/pojisteni-app/pojistenci";
    }

    @GetMapping("/pojisteni-app/pojistenci/detail/{id}")
    public String renderInsuredDetail(@PathVariable long id, Model model) {
        InsuredDTO insured = insuredService.getById(id);
        model.addAttribute("insured", insured);
        return "pages/insured/insuredDetail";
    }

    @GetMapping("/pojisteni-app/pojistenci/odstranit/{id}")
    public String deleteInsured(@PathVariable long id, RedirectAttributes redirectAttributes) {
        insuredService.remove(id);
        redirectAttributes.addFlashAttribute("danger", "Pojištěnec byl odstraněn.");
        return "redirect:/pojisteni-app/pojistenci";
    }

    @GetMapping("/pojisteni-app/pojistenci/edit/{id}")
    public String renderEditForm(@PathVariable long id, Model model) {
        InsuredDTO insuredDTO = insuredService.getById(id);
        model.addAttribute("insuredDTO", insuredDTO);
        return "pages/insured/insuredEdit";
    }

    @PostMapping("/pojisteni-app/pojistenci/edit")
    public String processEditForm(@ModelAttribute InsuredDTO insuredDTO,
                                  @RequestParam(value = "redirect") String redirect,
                                  RedirectAttributes redirectAttributes) {
        insuredService.edit(insuredDTO);
        redirectAttributes.addFlashAttribute("warning", "Pojištěnec byl úspěšně editován.");

        if ("detail".equals(redirect)) {
            return "redirect:/pojisteni-app/pojistenci/detail/" + insuredDTO.getId();
        } else {
            return "redirect:/pojisteni-app/pojistenci";
        }
    }
}
