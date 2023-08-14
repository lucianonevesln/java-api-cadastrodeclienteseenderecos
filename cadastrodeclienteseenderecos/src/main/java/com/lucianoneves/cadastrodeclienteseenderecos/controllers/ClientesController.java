package com.lucianoneves.cadastrodeclienteseenderecos.controllers;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesEnderecosModel;
import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesModel;
import com.lucianoneves.cadastrodeclienteseenderecos.services.ClientesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClientesModel clientesModel) {
        if (clientesService.existsByEmail(clientesModel.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já existe.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientesService.save(clientesModel));
    }

    @GetMapping
    public ResponseEntity<List<ClientesModel>> getAllClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(clientesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") Long id) {
        Optional<ClientesModel> clientesModelOptional = clientesService.findById(id);
        if (clientesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clientesModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid ClientesModel clientesModel) {
        Optional<ClientesModel> clientesModelOptional = clientesService.findById(id);
        if (clientesModelOptional.isPresent()) {
            clientesModel.setId(clientesModelOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(clientesService.save(clientesModel));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não houve atualização! Cliente não encontrado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id) {
        Optional<ClientesModel> clientesModelOptional = clientesService.findById(id);
        if (clientesModelOptional.isPresent()) {
            clientesService.delete(clientesModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não houve exclusão! Cliente não encontrado.");
    }

}
