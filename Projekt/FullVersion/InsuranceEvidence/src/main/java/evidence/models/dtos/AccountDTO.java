package evidence.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AccountDTO {

    @Email(message = "Vyplňte validní email")
    @NotBlank(message = "Vyplňte uživatelský email")
    private String email;

    @NotBlank(message = "Vyplňte uživatelské heslo")
    @Size(min = 6, message = "Heslo musí mít alespoň 6 znaků")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$", message = "Heslo musí obsahovat alespoň jedno číslo a jedno velké písmeno")
    private String password;

    @NotBlank(message = "Vyplňte uživatelské heslo")
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
