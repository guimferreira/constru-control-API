package com.construcontrol.construcontrol.DTO.projects;

import com.construcontrol.construcontrol.utils.ConstantsError;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConstructionDTO {
    private long id;

    @NotBlank(message = ConstantsError.MESSAGE_NAME_CONSTRUCTION_BLANK)
    private String construction;

    @NotNull(message = ConstantsError.MESSAGE_START_DATE_BLANK)
    private Date startDate;

    @NotNull(message = ConstantsError.MESSAGE_END_DATE_BLANK)
    private Date endDate;

}
