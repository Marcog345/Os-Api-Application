package br.dev.marco.OsApiApplication.api.controller;

import br.dev.marco.OsApiApplication.domain.model.OrdemServico;
import br.dev.marco.OsApiApplication.domain.service.OrdemServicoService;
import br.dev.marco.domain.dto.AtualizaStatusDTO;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public OrdemServico criar (@RequestBody OrdemServico ordemServico) {
        
        return ordemServicoService.criar(ordemServico);
    }  
    /**
 * Implementa o endpoint para alteração de Status
 *
 * @param ordemServicoID Identificação da OS
 * @param statusDTO - Status a ser atribuído
 * @return 200 OK, 404 ou throw exception.
 */
@PutMapping("/atualiza-status/{ordemServicoID}")
public ResponseEntity<OrdemServico> atualizaStatus(
        @PathVariable Long ordemServicoID,
        @Valid @RequestBody AtualizaStatusDTO statusDTO) {

    Optional<OrdemServico> optOS = ordemServicoService.atualizaStatus(
            ordemServicoID,
            statusDTO.status());

    if (optOS.isPresent()) {
        return ResponseEntity.ok(optOS.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}
}

