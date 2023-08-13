package com.lucianoneves.cadastrodeclienteseenderecos.dtos;

import com.lucianoneves.cadastrodeclienteseenderecos.models.ClientesEnderecosModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ClientesDto {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    private List<ClientesEnderecosModel> clientesEnderecosList;

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

    public void setClientesEnderecosList(List<ClientesEnderecosModel> clientesEnderecosList) {
        this.clientesEnderecosList = clientesEnderecosList;
    }
}
