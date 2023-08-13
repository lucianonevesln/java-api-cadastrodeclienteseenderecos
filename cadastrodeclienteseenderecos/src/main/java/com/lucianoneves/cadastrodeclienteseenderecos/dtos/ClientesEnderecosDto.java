package com.lucianoneves.cadastrodeclienteseenderecos.dtos;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientesEnderecosDto {

    private ClientesModel clientesModel;

    @NotBlank
    private String bairro;

    @NotBlank
    private String logradouro;

    @NotNull
    private int cep;

    @NotNull
    private int numero;

    @NotBlank
    private String cidade;

    @NotBlank
    @Size(max = 2)
    private String uf;

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
