package com.construcontrol.construcontrol.controllers.projects;

import com.construcontrol.construcontrol.DTO.projects.ApartamentDTO;
import com.construcontrol.construcontrol.services.projects.ApartamentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/apartaments")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ApartamentController {
    private final ApartamentService apartamentService;

    @Operation(summary = "Create an apartament", description = "Method that creates an apartament in the database", tags = {"apartaments"})
    @PostMapping
    public ResponseEntity<ApartamentDTO> criarApartament(@Valid @RequestBody ApartamentDTO apartamentDTO) {
        log.info("Chamando criarApartament no ApartamentController com dados: {}", apartamentDTO);
        ApartamentDTO newApartament = apartamentService.criarApartament(apartamentDTO);
        return ResponseEntity.ok(newApartament);
    }

    @Operation(summary = "Get all apartaments", description = "Method that returns all apartaments registered in the database", tags = {"apartaments"})
    @GetMapping
    public ResponseEntity<List<ApartamentDTO>> listarApartaments() {
        log.info("Chamando listarApartaments no ApartamentController");
        List<ApartamentDTO> apartaments = apartamentService.listarApartaments();
        return ResponseEntity.ok(apartaments);
    }

    @Operation(summary = "Get apartaments by id", description = "Method that returns an apartament registered in the database by id", tags = {"apartaments"})
    @GetMapping("/{id}")
    public ResponseEntity<ApartamentDTO> buscarApartamentPorId(@Valid @PathVariable long id) {
        log.info("Chamando buscarApartamentPorId no ApartamentController com id: {}", id);
        Optional<ApartamentDTO> apartament = apartamentService.buscarApartamentPorId(id);
        return apartament.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get apartaments by Construction", description = "Method that returns an apartament registered in the database by Construction", tags = {"apartaments"})
    @GetMapping("/{construction}")
    public ResponseEntity<List<ApartamentDTO>> listarApartamentPorConstruction(@PathVariable String construction) {
        log.info("Chamando listarApartamentPorConstruction no ApartamentController com constructionDTO: {}", construction);
        List<ApartamentDTO> apartaments = apartamentService.listarApartamentPorConstruction(construction);
        return ResponseEntity.ok(apartaments);
    }

    @Operation(summary = "Update an apartament", description = "Method that updates an apartament in the database", tags = {"apartaments"})
    @PatchMapping("/{id}")
    public ResponseEntity<ApartamentDTO> atualizarApartament(@Valid @PathVariable long id, @RequestBody ApartamentDTO apartamentDTO) {
        log.info("Chamando atualizarApartament no ApartamentController com id: {} e dados: {}", id, apartamentDTO);
        Optional<ApartamentDTO> apartamentAtualizado = apartamentService.atualizarApartament(id, apartamentDTO);
        return apartamentAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an apartament", description = "Method that deletes an apartament in the database", tags = {"apartaments"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarApartament(@Valid @PathVariable long id) {
        log.info("Chamando deletarApartament no ApartamentController com id: {}", id);
        boolean deletado = apartamentService.deletarApartament(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
