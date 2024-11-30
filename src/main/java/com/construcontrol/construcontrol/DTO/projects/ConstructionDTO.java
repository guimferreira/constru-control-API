package com.construcontrol.construcontrol.DTO.projects;

import com.construcontrol.construcontrol.utils.ConstantsError;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConstructionDTO {
    private long id;

    @NotBlank(message = ConstantsError.MESSAGE_NAME_CONSTRUCTION_BLANK)
    private String construction;

    @NotBlank(message = ConstantsError.MESSAGE_CNPJ_BLANK)
    @Size(min = ConstantsError.CNPJ_LENGTH,
            max = ConstantsError.CNPJ_LENGTH,
            message = ConstantsError.MESSAGE_CNPJ_SIZE)
    private String cnpj;

    @NotBlank(message = ConstantsError.MESSAGE_START_DATE_BLANK)
    private Date startDate;

    @NotBlank(message = ConstantsError.MESSAGE_END_DATE_BLANK)
    private Date endDate;

    @NotBlank(message = ConstantsError.MESSAGE_COMPANY_NAME_BLANK)
    private CompanyDTO company;
}
