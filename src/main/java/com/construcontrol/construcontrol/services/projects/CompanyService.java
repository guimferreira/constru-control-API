package com.construcontrol.construcontrol.services.projects;

import com.construcontrol.construcontrol.DTO.projects.AddressDTO;
import com.construcontrol.construcontrol.DTO.projects.CompanyDTO;
import com.construcontrol.construcontrol.model.domain.projects.Company;
import com.construcontrol.construcontrol.repositories.projects.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ViaCepService viaCepService;

    public CompanyDTO criarCompany(CompanyDTO companyDTO) {
        Company company = convertToEntity(companyDTO);

        AddressDTO address = viaCepService.findAddress(companyDTO.getCep());
        company.setLogradouro(address.getLogradouro());
        company.setComplemento(address.getComplemento());
        company.setBairro(address.getBairro());
        company.setLocalidade(address.getLocalidade());
        company.setUf(address.getUf());

        return convertToDTO(companyRepository.save(company));
    }

    public List<CompanyDTO> listarCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CompanyDTO> buscarCompanyPorId(Long id) {
        return companyRepository.findById(id)
                .map(this::convertToDTO);
    }

    public Optional<CompanyDTO> atualizarCompany(Long id, CompanyDTO companyDTO) {
        return companyRepository.findById(id).map(company -> {
            company.setCompany(companyDTO.getCompany());
            company.setCnpj(companyDTO.getCnpj());
            return convertToDTO(companyRepository.save(company));
        });
    }

    public boolean deletarCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CompanyDTO convertToDTO(Company company) {
        return new CompanyDTO(
                company.getId(),
                company.getCompany(),
                company.getCnpj(),
                company.getCep(),
                company.getLogradouro(),
                company.getComplemento(),
                company.getBairro(),
                company.getLocalidade(),
                company.getUf()
        );
    }

    private Company convertToEntity(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setCompany(companyDTO.getCompany());
        company.setCnpj(companyDTO.getCnpj());
        company.setCep((companyDTO.getCep()));
        return company;
    }

}
