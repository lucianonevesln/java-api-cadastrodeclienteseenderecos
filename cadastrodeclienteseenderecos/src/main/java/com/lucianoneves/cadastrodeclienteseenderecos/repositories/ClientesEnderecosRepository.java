package com.lucianoneves.cadastrodeclienteseenderecos.repositories;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesEnderecosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesEnderecosRepository extends JpaRepository<ClientesEnderecosModel, Long> {
}
