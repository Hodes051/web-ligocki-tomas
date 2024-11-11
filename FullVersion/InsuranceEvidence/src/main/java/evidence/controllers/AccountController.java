package evidence.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/pojisteni-app/login")
    public String renderLogin() {
        return "pages/account/login";
    }

    @GetMapping("/pojisteni-app/register")
    public String renderRegister() {
        return "pages/account/register";
    }
}
