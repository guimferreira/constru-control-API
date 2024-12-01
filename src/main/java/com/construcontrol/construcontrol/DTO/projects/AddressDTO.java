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
public class AddressDTO {
    @NotBlank(message = ConstantsError.MESSAGE_CEP_BLANK)
    @Size(min = ConstantsError.CEP_LENGTH,
            max = ConstantsError.CEP_LENGTH,
            message = ConstantsError.MESSAGE_CEP_SIZE)
    private String cep;

    @NotBlank(message = ConstantsError.MESSAGE_STREET_BLANK)
    private String logradouro;

    private String complemento;

    @NotBlank(message = ConstantsError.MESSAGE_NEIGHBORHOOD_BLANK)
    private String bairro;

    @NotBlank(message = ConstantsError.MESSAGE_LOCATION_BLANK)
    private String localidade;

    @NotBlank(message = ConstantsError.MESSAGE_UF_BLANK)
    private String uf;
}
