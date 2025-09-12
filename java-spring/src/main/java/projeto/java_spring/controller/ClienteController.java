package projeto.java_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.java_spring.model.Cliente;
import projeto.java_spring.repository.ClienteRepository;

import java.util.List;

@RequestMapping("/client")
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listAll (){
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity <Cliente> salvar (@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
}
