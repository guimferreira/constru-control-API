package com.construcontrol.construcontrol.DTO.projects;

import com.construcontrol.construcontrol.utils.ConstantsError;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuthenticationDTO {
    @NotBlank(message = ConstantsError.MESSAGE_LOGIN)
    private String login;

    @NotBlank(message = ConstantsError.MESSAGE_PASSWORD_BLANK)
    @Size(min = ConstantsError.PASSWORD_MIN_LENGTH, message = ConstantsError.MESSAGE_PASSWORD_SIZE)
    private String password;
}
