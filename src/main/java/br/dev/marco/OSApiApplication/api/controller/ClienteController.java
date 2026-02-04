package br.dev.marco.OSApiApplication.api.controller;

import br.dev.marco.OSApiApplication.domain.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController 
{
    List<Cliente> listaClientes;
    
    
    @GetMapping("/clientes")
    public String listas() {
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1, "KGe", "kge@teste.com", "11-99999-9999"));
        listaClientes.add(new Cliente(1, "Maria", "maria@teste.com","11-88888-8888"));
        listaClientes.add(new Cliente(1, "Joao", "joao@teste.com","11-77777-7777")); 
        return "teste api";
    }
    
}