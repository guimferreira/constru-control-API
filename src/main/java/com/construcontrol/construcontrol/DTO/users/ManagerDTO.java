package com.construcontrol.construcontrol.DTO.users;

import com.construcontrol.construcontrol.model.domain.users.enums.UserRole;
import com.construcontrol.construcontrol.utils.ConstantsError;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ManagerDTO {
    private long id;

    @NotBlank(message = ConstantsError.MESSAGE_USERNAME_BLANK)
    @Size(min = ConstantsError.USERNAME_MIN_LENGTH,
          max = ConstantsError.USERNAME_MAX_LENGTH,
          message = ConstantsError.MESSAGE_USERNAME_LENGTH)
    private String name;

    @NotBlank(message = ConstantsError.MESSAGE_CPF_BLANK)
    @Size(min = ConstantsError.CPF_LENGTH,
            max = ConstantsError.CPF_LENGTH,
            message = ConstantsError.MESSAGE_CPF_SIZE)
    private String cpf;

    @Size(min = ConstantsError.RG_MIN_LENGTH,
            max = ConstantsError.RG_MAX_LENGTH,
            message = ConstantsError.MESSAGE_RG_SIZE)
    private String rg;

    @Size(min = ConstantsError.PHONE_MIN_LENGTH, message = ConstantsError.MESSAGE_PHONE_SIZE)
    private String phone;

    @NotBlank(message = ConstantsError.MESSAGE_EMAIL_BLANK)
    @Email(message = ConstantsError.MESSAGE_EMAIL_FORMAT)
    private String email;

    @NotBlank(message = ConstantsError.MESSAGE_PASSWORD_BLANK)
    @Size(min = ConstantsError.PASSWORD_MIN_LENGTH, message = ConstantsError.MESSAGE_PASSWORD_SIZE)
    private String password;

    @NotNull(message = ConstantsError.MESSAGE_USER_ROLE_BLANK)
    private UserRole userRole;
}
