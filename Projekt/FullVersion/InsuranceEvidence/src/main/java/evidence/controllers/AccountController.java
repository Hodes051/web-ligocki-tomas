package evidence.controllers;

import evidence.models.dtos.AccountDTO;
import evidence.models.exceptions.DuplicateEmailException;
import evidence.models.exceptions.PasswordsDoNotEqualException;
import evidence.models.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/pojisteni-app/login")
    public String renderLogin() {
        return "pages/account/login";
    }

    @GetMapping("/pojisteni-app/register")
    public String renderRegister(@ModelAttribute AccountDTO accountDTO) {
        return "pages/account/register";
    }

    @PostMapping("/pojisteni-app/register")
    public String register(@Valid @ModelAttribute AccountDTO accountDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors())
            return renderRegister(accountDTO);

        try {
            accountService.create(accountDTO, false);
        } catch (DuplicateEmailException e) {
            bindingResult.rejectValue("email", "error", "Email je již používán.");
            return "pages/account/register";
        } catch (PasswordsDoNotEqualException e) {
            bindingResult.rejectValue("password", "error", "Hesla se neschodují.");
            bindingResult.rejectValue("confirmPassword", "error", "Hesla se neschodují.");
            return "pages/account/register";
        }

        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
        return "redirect:/pojisteni-app/login";
    }
}
