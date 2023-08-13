package com.lucianoneves.cadastrodeclienteseenderecos.repositories;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {

    public boolean existsByEmail(String email);

}
