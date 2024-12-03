package com.construcontrol.construcontrol.services.projects;

import com.construcontrol.construcontrol.DTO.projects.ApartamentDTO;
import com.construcontrol.construcontrol.DTO.projects.ConstructionDTO;
import com.construcontrol.construcontrol.model.domain.projects.Apartament;
import com.construcontrol.construcontrol.model.domain.projects.Construction;
import com.construcontrol.construcontrol.repositories.projects.ApartamentRepository;
import com.construcontrol.construcontrol.repositories.projects.ConstructionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApartamentService {
    private final ApartamentRepository apartamentRepository;
    private final ConstructionRepository constructionRepository;

    public ApartamentDTO criarApartament(ApartamentDTO apartamentDTO) {
        Apartament apartament = convertToEntity(apartamentDTO);
        return convertToDTO(apartamentRepository.save(apartament));
    }

    public List<ApartamentDTO> listarApartaments() {
        return apartamentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ApartamentDTO> buscarApartamentPorId(Long id) {
        return apartamentRepository.findById(id)
                .map(this::convertToDTO);
    }

    public List<ApartamentDTO> listarApartamentPorConstruction(Long constructionId) {
        return apartamentRepository.findByConstructionId(constructionId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ApartamentDTO> atualizarApartament(Long id, ApartamentDTO apartamentDTO) {
        return apartamentRepository.findById(id).map(apartament -> {
            Construction construction = constructionRepository.findById(apartamentDTO.getConstructionId())
                    .orElseThrow(() -> new RuntimeException("Construction not found with ID: " + apartamentDTO.getConstructionId()));
            apartament.setConstruction(construction);

            apartament.setNumber(apartamentDTO.getNumber());
            apartament.setArea(apartamentDTO.getArea());
            apartament.setPrice(apartamentDTO.getPrice());
            apartament.setSoldStatus(apartamentDTO.isSoldStatus());
            return convertToDTO(apartamentRepository.save(apartament));
        });
    }

    public boolean deletarApartament(Long id) {
        if (apartamentRepository.existsById(id)) {
            apartamentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ApartamentDTO convertToDTO(Apartament apartament) {
        return new ApartamentDTO(
                apartament.getId(),
                apartament.getConstruction() != null ? apartament.getConstruction().getId() : null,
                apartament.getNumber(),
                apartament.getArea(),
                apartament.getPrice(),
                apartament.isSoldStatus()
        );
    }

    private Apartament convertToEntity(ApartamentDTO apartamentDTO) {
        Apartament apartament = new Apartament();
        apartament.setId(apartamentDTO.getId());

        Construction construction = constructionRepository.findById(apartamentDTO.getConstructionId())
                .orElseThrow(() -> new RuntimeException("Construction not found with ID: " + apartamentDTO.getConstructionId()));
        apartament.setConstruction(construction);

        apartament.setNumber(apartamentDTO.getNumber());
        apartament.setArea(apartamentDTO.getArea());
        apartament.setPrice(apartamentDTO.getPrice());
        apartament.setSoldStatus(apartamentDTO.isSoldStatus());
        return apartament;
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
