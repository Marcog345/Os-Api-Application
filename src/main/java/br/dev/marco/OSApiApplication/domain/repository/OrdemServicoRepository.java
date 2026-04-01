
package br.dev.marco.OsApiApplication.domain.repository;

import br.dev.marco.OsApiApplication.domain.model.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
List<OrdemServico> findByClienteId(Long clienteId);
}
