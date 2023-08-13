package com.lucianoneves.cadastrodeclienteseenderecos.services;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesModel;
import com.lucianoneves.cadastrodeclienteseenderecos.repositories.ClientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private final ClientesRepository clientesRepository;

    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Transactional
    public ClientesModel save(ClientesModel clientesModel) {
        return clientesRepository.save(clientesModel);
    }

    public boolean existsByEmail(String email) {
        return clientesRepository.existsByEmail(email);
    }

    public List<ClientesModel> findAll() {
        return clientesRepository.findAll();
    }

    public Optional<ClientesModel> findById(Long id) {
        return clientesRepository.findById(id);
    }

    @Transactional
    public void delete(ClientesModel clientesModel) {
        clientesRepository.delete(clientesModel);
    }

}
