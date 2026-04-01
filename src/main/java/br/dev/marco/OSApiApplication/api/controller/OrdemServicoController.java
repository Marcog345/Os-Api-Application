package br.dev.marco.OsApiApplication.api.controller;

import br.dev.marco.OsApiApplication.domain.model.OrdemServico;
import br.dev.marco.OsApiApplication.domain.service.OrdemServicoService;
import br.dev.marco.domain.dto.AtualizaStatusDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
     @Operation(summary = "Criar ordem de serviço", description = "Criar ordem de serviço")
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public OrdemServico criar (@RequestBody OrdemServico ordemServico) {
        
        return ordemServicoService.criar(ordemServico);
    }  
 @Operation(summary = "Atualiza o status da ordem de serviço", description = "Atualiza status")
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
 @Operation(summary = "Listar por cliente pelo Id", description = "Listar pelo cliente")
@GetMapping("/clientes/{clienteId}/ordens-servico")
public List<OrdemServico> listarPorCliente(@PathVariable Long clienteId) {
    return ordemServicoService.listarPorCliente(clienteId);
}

}

