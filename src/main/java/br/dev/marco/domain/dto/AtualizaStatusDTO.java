package br.dev.marco.domain.dto;

import br.dev.marco.OsApiApplication.domain.model.StatusOrdemServico;
import jakarta.validation.constraints.NotNull;

public record AtualizaStatusDTO(
        @NotNull(message = "Status é obrigatório")
        StatusOrdemServico status
        ) {}
