package com.construcontrol.construcontrol.DTO.projects;

import com.construcontrol.construcontrol.utils.ConstantsError;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @NotBlank(message = ConstantsError.MESSAGE_START_DATE_BLANK)
    private Date startDate;

    @NotBlank(message = ConstantsError.MESSAGE_END_DATE_BLANK)
    private Date endDate;

}
