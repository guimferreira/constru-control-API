package com.construcontrol.construcontrol.DTO.projects;

import com.construcontrol.construcontrol.utils.ConstantsError;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApartamentDTO {
    private long id;

    @NotNull(message = ConstantsError.MESSAGE_NAME_CONSTRUCTION_BLANK)
    private long constructionId;

    @NotNull(message = ConstantsError.MESSAGE_NUMBER_APARTMENT_BLANK)
    private String number;

    @NotNull(message = ConstantsError.MESSAGE_AREA_APARTMENT_BLANK)
    private double area;

    @NotNull(message = ConstantsError.MESSAGE_PRICE_APARTMENT_BLANK)
    private double price;

    @NotNull(message = ConstantsError.MESSAGE_SOLD_STATUS_APARTMENT_BLANK)
    private boolean soldStatus = false;

}
