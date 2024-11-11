package evidence.controllers;

import evidence.data.entities.InsuredEntity;
import evidence.data.repositories.InsuredRepository;
import evidence.models.dtos.InsuredDTO;
import evidence.models.dtos.mappers.InsuredMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsuredController {

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuredMapper insuredMapper;

    @GetMapping("/pojisteni-app/pojistenci/novy")
    public String renderInsuredForm(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/insuredForm";
    }

    @PostMapping("/pojisteni-app/pojistenci/novy")
    public String processInsuredForm(@Valid @ModelAttribute InsuredDTO insuredDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "pages/insured/insuredForm";
        }
        InsuredEntity insuredEntity = insuredMapper.toEntity(insuredDTO);
        insuredRepository.save(insuredEntity);
        return "redirect:/pojisteni-app/pojistenci";
    }
    @GetMapping("/pojisteni-app/pojistenci/detail/{id}")
    public String renderInsuredDetail(@PathVariable Long id, Model model) {
        InsuredEntity insured = insuredRepository.findById(id).get();
        model.addAttribute("insured", insured);
        return "pages/insured/insuredDetail";
    }
}
