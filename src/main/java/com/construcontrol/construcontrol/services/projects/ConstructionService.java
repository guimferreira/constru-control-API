package com.construcontrol.construcontrol.services.projects;

import com.construcontrol.construcontrol.DTO.projects.ConstructionDTO;
import com.construcontrol.construcontrol.model.domain.projects.Construction;
import com.construcontrol.construcontrol.repositories.projects.ConstructionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConstructionService {
    private final ConstructionRepository constructionRepository;

    public ConstructionDTO criarConstruction(ConstructionDTO constructionDTO) {
        Construction construction = convertToEntity(constructionDTO);
        return convertToDTO(constructionRepository.save(construction));
    }

    public List<ConstructionDTO> listarConstructions() {
        return constructionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ConstructionDTO> buscarConstructionPorId(Long id) {
        return constructionRepository.findById(id)
                .map(this::convertToDTO);
    }

    public Optional<ConstructionDTO> atualizarConstruction(Long id, ConstructionDTO constructionDTO) {
        return constructionRepository.findById(id).map(construction -> {
            construction.setId(constructionDTO.getId());
            construction.setConstruction(constructionDTO.getConstruction());
            construction.setStartDate(constructionDTO.getStartDate());
            construction.setEndDate(constructionDTO.getEndDate());
            return convertToDTO(constructionRepository.save(construction));
        });
    }

    public boolean deletarConstruction(Long id) {
        if (constructionRepository.existsById(id)) {
            constructionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ConstructionDTO convertToDTO(Construction construction) {
        return new ConstructionDTO(
                construction.getId(),
                construction.getConstruction(),
                construction.getStartDate(),
                construction.getEndDate()
        );
    }

    private Construction convertToEntity(ConstructionDTO constructionDTO) {
        Construction construction = new Construction();
        construction.setId(constructionDTO.getId());
        construction.setConstruction(constructionDTO.getConstruction());
        construction.setStartDate(constructionDTO.getStartDate());
        construction.setEndDate(constructionDTO.getEndDate());
        return construction;
    }

}
