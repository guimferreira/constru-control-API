package com.construcontrol.construcontrol.DTO.projects;

import com.construcontrol.construcontrol.utils.ConstantsError;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CompanyDTO {
    private long id;

    @NotBlank(message = ConstantsError.MESSAGE_COMPANY_NAME_BLANK)
    private String company;

    @NotBlank(message = ConstantsError.MESSAGE_CNPJ_BLANK)
    @CNPJ(message = ConstantsError.MESSAGE_CNPJ)
    private String cnpj;

    @NotBlank(message = ConstantsError.MESSAGE_CEP_BLANK)
    @Size(min = 8, max = 8, message = ConstantsError.MESSAGE_CEP_SIZE)
    private String cep;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
