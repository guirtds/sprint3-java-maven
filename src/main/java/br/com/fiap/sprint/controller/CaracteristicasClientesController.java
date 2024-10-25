package br.com.fiap.sprint.controller;

import br.com.fiap.sprint.controller.dto.CaracteristicasClienteDTO;
import br.com.fiap.sprint.model.CaracteristicasCliente;
import br.com.fiap.sprint.service.CaracteristicasClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caracteristicasCliente")
public class   CaracteristicasClientesController {

    private final CaracteristicasClienteService caracteristicasClienteService;

    @Autowired
    public CaracteristicasClientesController(CaracteristicasClienteService caracteristicasClienteService) {
        this.caracteristicasClienteService = caracteristicasClienteService;
    }

    @PostMapping
    public ResponseEntity<CaracteristicasCliente> cadastrarCaracteristicasCliente(@Valid @RequestBody CaracteristicasClienteDTO caracteristicasCliente) {
        CaracteristicasCliente novaCaracteristicaCliente = caracteristicasClienteService.cadastrarCaracteristicasCliente(caracteristicasCliente);
        return ResponseEntity.ok(novaCaracteristicaCliente);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CaracteristicasCliente> atualizarCaracteristicasClientes(@PathVariable Long id, @RequestBody CaracteristicasClienteDTO novaCaracteristicaCliente) {
        CaracteristicasCliente caracteristicasClienteAtualizadas = caracteristicasClienteService.atualizarCaracteristicasClientes(id, novaCaracteristicaCliente);
        return ResponseEntity.ok(caracteristicasClienteAtualizadas);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CaracteristicasCliente>> listarCaracteristicasClientes() {
        List<CaracteristicasCliente> caracteristicasClientes = caracteristicasClienteService.listarCaracteristicasClientes();
        return ResponseEntity.ok(caracteristicasClientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCaracteristicasClientes(@PathVariable Long id) {
        caracteristicasClienteService.removerCaracteristicasClientes(id);
        return ResponseEntity.ok().build();
    }
}
