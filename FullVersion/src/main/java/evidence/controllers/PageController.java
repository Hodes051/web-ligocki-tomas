package evidence.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/pojisteni-app")
    public String renderAboutApp() {
        return "pages/aboutApp";
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
