package br.com.fiap.sprint.service;

import br.com.fiap.sprint.controller.dto.CaracteristicasClienteDTO;
import br.com.fiap.sprint.model.CaracteristicasCliente;
import br.com.fiap.sprint.repository.CaracteristicasClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicasClienteService {

    @Autowired
    private CaracteristicasClienteRepository caracteristicasClienteRepository;

    // Cadastrando as caracteristicas dos clientes

    public CaracteristicasCliente cadastrarCaracteristicasCliente(CaracteristicasClienteDTO caracteristicasClienteDTO) {
        CaracteristicasCliente caracteristicasCliente = new CaracteristicasCliente();
        caracteristicasCliente.setBiotipo(caracteristicasClienteDTO.getBiotipo());
        caracteristicasCliente.setEstiloPreferencia(caracteristicasClienteDTO.getEstiloPreferencia());
        caracteristicasCliente.setColorometria(caracteristicasClienteDTO.getColorometria());
        return caracteristicasClienteRepository.save(caracteristicasCliente);
    }

    // Atualizando as caracteristicas dos clientes

    public CaracteristicasCliente atualizarCaracteristicasClientes(Long id, CaracteristicasClienteDTO novaCaracteristicaCliente) {
        Optional<CaracteristicasCliente> caracteristicasClienteExistente = caracteristicasClienteRepository.findById(id);

        if(caracteristicasClienteExistente.isPresent()) {
            CaracteristicasCliente caracteristicasClienteAtualizadas = caracteristicasClienteExistente.get();
            caracteristicasClienteAtualizadas.setBiotipo(novaCaracteristicaCliente.getBiotipo());
            caracteristicasClienteAtualizadas.setEstiloPreferencia(novaCaracteristicaCliente.getEstiloPreferencia());
            caracteristicasClienteAtualizadas.setColorometria(novaCaracteristicaCliente.getColorometria());
            return caracteristicasClienteRepository.save(caracteristicasClienteAtualizadas);
        } else {
            throw new RuntimeException("Caracteristicas do cliente não encontradas com o ID: " + id);
        }
    }

    // Listando as caracteristicas dos clientes

    public List<CaracteristicasCliente> listarCaracteristicasClientes() {
        return caracteristicasClienteRepository.findAll();
    }

    // Deletando as caracteristicas dos clientes

    public void removerCaracteristicasClientes(Long id) {
        if (caracteristicasClienteRepository.existsById(id)) {
            caracteristicasClienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Caracteristicas do cliente não encontradas com o ID: " + id);
        }
    }
}
