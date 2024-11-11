package evidence.controllers;

import evidence.data.entities.InsuredEntity;
import evidence.data.repositories.InsuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class PageController {

    @Autowired
    private InsuredRepository insuredRepository;

    @GetMapping("/pojisteni-app")
    public String renderAboutApp() {
        return "pages/aboutApp";
    }

    @GetMapping("/pojisteni-app/pojistenci")
    public String renderInsured(Model model) {
        List<InsuredEntity> insured = insuredRepository.findAll();
        model.addAttribute("insured", insured);
        return "pages/insured/insured";
    }

    @GetMapping("/pojisteni-app/pojisteni")
    public String renderInsurance() {
        return "pages/insurance/insurance";
    }

    @GetMapping("/pojisteni-app/udalosti")
    public String renderEvents() {
        return "pages/events";
    }
}
