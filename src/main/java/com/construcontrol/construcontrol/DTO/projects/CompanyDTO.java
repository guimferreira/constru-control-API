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
public class CompanyDTO {
    private long id;

    @NotBlank(message = ConstantsError.MESSAGE_COMPANY_NAME_BLANK)
    private String company;

    @NotBlank(message = ConstantsError.MESSAGE_CNPJ_BLANK)
    @Size(min = ConstantsError.CNPJ_LENGTH,
            max = ConstantsError.CNPJ_LENGTH,
            message = ConstantsError.MESSAGE_CNPJ_SIZE)
    private String cnpj;
}
