package com.lucianoneves.cadastrodeclienteseenderecos.services;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesEnderecosModel;
import com.lucianoneves.cadastrodeclienteseenderecos.repositories.ClientesEnderecosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesEnderecosService {

    private final ClientesEnderecosRepository clientesEnderecosRepository;

    public ClientesEnderecosService(ClientesEnderecosRepository clientesEnderecosRepository) {
        this.clientesEnderecosRepository = clientesEnderecosRepository;
    }

    @Transactional
    public ClientesEnderecosModel save(ClientesEnderecosModel clientesEnderecosModel) {
        return clientesEnderecosRepository.save(clientesEnderecosModel);
    }

    public List<ClientesEnderecosModel> findAll() {
        return clientesEnderecosRepository.findAll();
    }

    public Optional<ClientesEnderecosModel> findById(Long id) {
        return clientesEnderecosRepository.findById(id);
    }

    @Transactional
    public void delete (ClientesEnderecosModel clientesEnderecosModel) {
        clientesEnderecosRepository.delete(clientesEnderecosModel);
    }

}
