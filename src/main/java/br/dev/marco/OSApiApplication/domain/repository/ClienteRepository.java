<<<<<<< HEAD

package br.dev.marco.OSApiApplication.domain.repository;

import br.dev.marco.OSApiApplication.domain.model.Cliente;
=======

package br.dev.marco.OsApiApplication.domain.repository;

import br.dev.marco.OsApiApplication.domain.model.Cliente;
>>>>>>> a634348be2bf724b6d26fd01ca7c72e4ea350f23
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
    @Repository
    public interface ClienteRepository extends JpaRepository<Cliente, Long> {
        List<Cliente> findByNome(String nome);
        List<Cliente> findByNomeContaining(String nome);                                    
    }
=======
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
}
>>>>>>> a634348be2bf724b6d26fd01ca7c72e4ea350f23
