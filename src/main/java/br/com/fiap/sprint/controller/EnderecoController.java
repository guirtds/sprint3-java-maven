package br.com.fiap.sprint.controller;

import br.com.fiap.sprint.controller.dto.EnderecoDTO;
import br.com.fiap.sprint.model.Endereco;
import br.com.fiap.sprint.service.EnderecoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@Valid @RequestBody EnderecoDTO endereco) {
        Endereco novoEndereco = enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO novoEndereco) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, novoEndereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Endereco>> listarEndereco() {
        List<Endereco> enderecos = enderecoService.listarEndereco();
        return ResponseEntity.ok(enderecos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEndereco(@PathVariable Long id) {
        enderecoService.removerEndereco(id);
        return ResponseEntity.ok().build();
    }
}