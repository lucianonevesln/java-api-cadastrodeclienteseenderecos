package com.lucianoneves.cadastrodeclienteseenderecos.controllers;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesEnderecosModel;
import com.lucianoneves.cadastrodeclienteseenderecos.services.ClientesEnderecosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes-enderecos")
public class ClientesEnderecosController {

    private final ClientesEnderecosService clientesEnderecosService;

    public ClientesEnderecosController(ClientesEnderecosService clientesEnderecosService) {
        this.clientesEnderecosService = clientesEnderecosService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClienteEndereco(@RequestBody @Valid ClientesEnderecosModel clientesEnderecosModel) {
        return ResponseEntity.status(HttpStatus.OK).body(clientesEnderecosService.save(clientesEnderecosModel));
    }

    @GetMapping
    public ResponseEntity<List<ClientesEnderecosModel>> getAllClientesEnderecos() {
        return ResponseEntity.status(HttpStatus.OK).body(clientesEnderecosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneClienteEnderecos(@PathVariable(value = "id") Long id) {
        Optional<ClientesEnderecosModel> clientesEnderecosModelOptional = clientesEnderecosService.findById(id);
        if (clientesEnderecosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clientesEnderecosModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não localizado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClienteEnderecos(@PathVariable(value = "id") Long id,
                                                         @RequestBody @Valid ClientesEnderecosModel clientesEnderecosModel) {
        Optional<ClientesEnderecosModel> clientesEnderecosModelOptional = clientesEnderecosService.findById(id);
        if (clientesEnderecosModelOptional.isPresent()) {
            clientesEnderecosModel.setId(clientesEnderecosModelOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(clientesEnderecosService.save(clientesEnderecosModel));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não localizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClienteEnderecos(@PathVariable(value = "id") Long id) {
        Optional<ClientesEnderecosModel> clientesEnderecosModelOptional = clientesEnderecosService.findById(id);
        if (clientesEnderecosModelOptional.isPresent()) {
            clientesEnderecosService.delete(clientesEnderecosModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não localizado.");
    }

}
