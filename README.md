--------------------------------------------------------------------------------

Projeto - Java API Rest Cadastro Relacional

Tecnologias Utilizadas:

- Java;

- Spring Boot (Data JPA, Validation e Web);

- Docker;

- MySQL.

Para utilizar a aplicação, siga os passos abaixo:

1 - Clone o repositório:

```
git clone https://github.com/lucianonevesln/java-api-cadastrodeclienteseenderecos.git
```

2 - Execute o seguinte comando no terminal, na pasta raiz do projeto:

```
docker-compose up --build
```

3 - Caso não tenha o Docker e esteja com o MySQL instalado, basta criar o banco
de dados "cadastro_db", com as credenciais que estão em de "application.properties"
e executar a aplicação;

4 - Para inserir um novo cliente, use o Postman ou similar, selecione o método
"POST", acesse  link "http://localhost:8080/clientes", insira o JSON a seguir e
pressione o botão "Send":

```
{
    "nome": "Luciano Teste 1",
    "email": "lucianoteste1@email.com",
    "cpf": "11111111111"
}
```

5 - Para listar todos os clientes, use o Postman ou similar, acesse link
"http://localhost:8080/clientes", selecione o método "GET" e pressione
o botão "Send";

6 - Para listar um cliente, use o Postman ou similar, acesse link
"http://localhost:8080/clientes/{id}", selecione o método "GET" e pressione
o botão "Send";

7 - Para atualizar um cliente, use o Postman ou similar, acesse link
"http://localhost:8080/clientes/{id}", selecione o método "PUT", insira o JSON
a seguir, com o(s) dado(s) modificado(s) e pressione o botão "Send":

```
{
    "nome": "Luciano Teste 1 atualizado",
    "email": "lucianoteste1atualizado@email.com",
    "cpf": "11111111111"
}
```

8 - Para deletar um cliente, use o Postman ou similar, acesse link
"http://localhost:8080/clientes/{id}", selecione o método "DELETE" e pressione
o botão "Send":

9 - Para inserir um cliente com um endereço relacionado, use o Postman ou
similar, selecione o método "POST", acesse o link "http://localhost:8080/clientes",
insira o JSON a seguir e pressione o botão "Send":

```
{
    "nome": "Luciano Teste 2",
    "email": "lucianoteste2@email.com",
    "cpf": "22222222222",
    "clientesEnderecosList":
    [
        {
            "bairro": "Bairro 2",
            "logradouro": "Rua Teste 2",
            "cep": "22222222",
            "numero": "2",
            "cidade": "São Paulo",
            "uf": "SP"
        }
    ]
}
```

10 - Para inserir um novo endereço, use o Postman ou similar, selecione o método
"POST", acesse o link "http://localhost:8080/clientes-enderecos" insira o JSON
a seguir e pressione o botão "Send":

```
{
    "bairro": "Bairro 1",
    "logradouro": "Rua Teste 1",
    "cep": "11111111",
    "numero": "1",
    "cidade": "São Paulo",
    "uf": "SP"
}
```

11 - Para listar todos os endereços, use o Postman ou similar, acesse link
"http://localhost:8080/clientes-enderecos", selecione o método "GET" e pressione
o botão "Send";

12 - Para listar um endereço, use o Postman ou similar, acesse link
"http://localhost:8080/clientes-enderecos/{id}", selecione o método "GET" e pressione
o botão "Send";

13 - Para atualizar um endereço, use o Postman ou similar, acesse link
"http://localhost:8080/clientes-enderecos/{id}", selecione o método "PUT",
insira o JSON a seguir, com o(s) dado(s) modificado(s) e pressione o botão "Send":

```
{
    "bairro": "Bairro 2 atualizado",
    "logradouro": "Rua Teste 2 atualizado",
    "cep": "22222222",
    "numero": "2",
    "cidade": "São Paulo",
    "uf": "SP"
}
```

14 - Para deletar um endereço, use o Postman ou similar, acesse link
"http://localhost:8080/clientes-enderecos/{id}", selecione o método "DELETE" e
pressione o botão "Send".

15 - Se estiver usando docker, ao terminar de utilizar a aplicação não esqueça
de desligar o conteiner executando o comando no terminal:

```
Ctrl + C
```

--------------------------------------------------------------------------------