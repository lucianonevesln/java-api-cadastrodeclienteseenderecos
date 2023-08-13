package com.lucianoneves.cadastrodeclienteseenderecos.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClientesModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, length = 11, nullable = false)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
    @JsonManagedReference
    private List<ClientesEnderecosModel> clientesEnderecosList = new ArrayList<>();

    public void addClientesEnderecosList(ClientesEnderecosModel clientesEnderecosModel) {
        clientesEnderecosList.add(clientesEnderecosModel);
    }

    public void removeClientesEnderecosListList(ClientesEnderecosModel clientesEnderecosModel) {
        clientesEnderecosList.remove(clientesEnderecosModel);
    }

    public ClientesModel() {

    }

    public ClientesModel(Long id, String nome, String email, String cpf, List<ClientesEnderecosModel>
            clientesEnderecosList) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.clientesEnderecosList = clientesEnderecosList;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ClientesEnderecosModel> getClientesEnderecosList() {
        return clientesEnderecosList;
    }

}
