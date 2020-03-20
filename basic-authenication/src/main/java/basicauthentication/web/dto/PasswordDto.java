package basicauthentication.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordDto {

    private String oldPassword;

    @ValidPassword
    private String newPassword;
}