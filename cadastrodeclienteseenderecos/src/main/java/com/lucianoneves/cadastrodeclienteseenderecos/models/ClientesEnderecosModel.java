package com.lucianoneves.cadastrodeclienteseenderecos.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "clientes_enderecos")
public class ClientesEnderecosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
    @JsonBackReference
    private ClientesModel clientesModel;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int cep;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;

    public ClientesEnderecosModel() {

    }

    public ClientesEnderecosModel(Long id, ClientesModel clientesModel, String bairro, String logradouro, int cep,
                                  int numero, String cidade, String uf) {
        this.id = id;
        this.clientesModel = clientesModel;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientesModel getClientesModel() {
        return clientesModel;
    }

    public void setClientesModel(ClientesModel clientesModel) {
        this.clientesModel = clientesModel;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
