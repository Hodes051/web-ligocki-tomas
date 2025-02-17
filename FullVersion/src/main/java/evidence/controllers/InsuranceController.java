package evidence.controllers;

import evidence.models.dtos.InsuranceDTO;
import evidence.models.dtos.InsuredDTO;
import evidence.models.services.InsuranceService;
import evidence.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Objects;

@Controller
public class InsuranceController {

    @Autowired
    InsuredService insuredService;

    @Autowired
    InsuranceService insuranceService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/pojisteni-app/pojisteni/nove/{id}")
    public String renderInsuranceForm(@PathVariable long id, Model model,
                                      @ModelAttribute InsuranceDTO insuranceDTO) {
        if (insuranceDTO.getInsuranceType() == null) {
            insuranceDTO.setInsuranceType("");
        }
        InsuredDTO insured = insuredService.getById(id);
        model.addAttribute("insured", insured);
        return "pages/insurance/insuranceForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/pojisteni-app/pojisteni/nove/{id}")
    public String processInsuranceForm(@Valid @ModelAttribute InsuranceDTO insuranceDTO,
                                       BindingResult result,
                                       @PathVariable long id,
                                       RedirectAttributes redirectAttributes,
                                       Model model) {
        if (insuranceDTO.getDateFrom() == null || insuranceDTO.getDateTo() == null) {
            result.rejectValue("dateFrom", "error.dateRange", "");
            result.rejectValue("dateTo", "error.dateRange", "");
        } else if (!insuranceDTO.getDateFrom().isBefore(insuranceDTO.getDateTo())) {
            result.rejectValue("from", "error.dateRange", "Platnost od musí být menší než platnost do.");
        }

        if (result.hasErrors()) {
            InsuredDTO insured = insuredService.getById(id);
            model.addAttribute("insured", insured);
            return "pages/insurance/insuranceForm";
        }
        insuranceDTO.setInsuredId(id);
        insuranceService.create(insuranceDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo uloženo.");
        return "redirect:/pojisteni-app/pojistenci/detail/" + id;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/pojisteni-app/pojisteni/odstranit/{id}")
    public String deleteInsurance(@PathVariable long id, RedirectAttributes redirectAttributes) {
        InsuranceDTO insuranceDTO = insuranceService.getById(id);
        insuranceService.remove(id);
        redirectAttributes.addFlashAttribute("danger", "Pojištění bylo odstraněno.");
        return "redirect:/pojisteni-app/pojistenci/detail/" + insuranceDTO.getInsuredId();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/pojisteni-app/pojisteni/edit/{id}")
    public String renderEditForm(@PathVariable long id, Model model) {
        InsuranceDTO insuranceDTO = insuranceService.getById(id);
        InsuredDTO insured = insuredService.getById(insuranceDTO.getInsuredId());
        model.addAttribute("insured", insured);
        model.addAttribute("insuranceDTO", insuranceDTO);
        return "pages/insurance/insuranceEdit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/pojisteni-app/pojisteni/edit")
    public String processEditForm(@ModelAttribute InsuranceDTO insuranceDTO,
                                  @RequestParam(value = "redirect") Long insuredId,
                                  RedirectAttributes redirectAttributes) {
        if (Arrays.stream(new Object[] {insuranceDTO.getInsuranceType(), insuranceDTO.getAmount(), insuranceDTO.getInsuredSubject(), insuranceDTO.getDateFrom(), insuranceDTO.getDateTo()})
                .anyMatch(Objects::isNull)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Všechna pole jsou povinná.");
            return "redirect:/pojisteni-app/pojisteni/edit/" + insuranceDTO.getId();
        } else if (!insuranceDTO.getDateFrom().isBefore(insuranceDTO.getDateTo())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Platnost od musí být menší než platnost do.");
            return "redirect:/pojisteni-app/pojisteni/edit/" + insuranceDTO.getId();
        }
        insuranceDTO.setInsuredId(insuranceDTO.getId());
        insuranceService.edit(insuranceDTO);
        redirectAttributes.addFlashAttribute("warning", "Pojištění bylo úspěšně editováno.");
        return "redirect:/pojisteni-app/pojistenci/detail/" + insuredId;
    }

    @GetMapping("/pojisteni-app/pojisteni/detail/{id}")
    public String renderInsuranceDetail(@PathVariable long id, Model model) {
        InsuranceDTO insuranceDTO = insuranceService.getById(id);
        model.addAttribute("insuranceDTO", insuranceDTO);
        return "pages/insurance/insuranceDetail";
    }
}
