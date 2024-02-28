<h1 align="center">
  <a>Sistema Financeiro</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</h1>

# 

<p align="center">
  <a> Diagrama</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

![Captura de Tela 2024-02-24 às 13 02 19](https://github.com/sqc-cyh/MyWeb-discussion/assets/57195630/219f835f-6623-4d69-a5e3-b9c2a7cb1489)

##

<p align="center">
  <a>Projeto</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

- Spring Initializr

- Maven

- Java 17

- Springboot 3.2.3

- Packaging Jar

##  
<p align="center">
  <a>Dependências</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

- Spring Web

- Spring Data JPA

- PostgreSQL Driver
  
- Validation

## Endpoints

/usuarios <br/>
/produtos <br/>
/vendas

##
## Rota para cadastro de usuário:

`POST /usuarios - FORMATO DA RESPOSTA - STATUS 200`

```json
{
    "idUsuario": "5e3292a7-bc69-49d3-adb3-fa35f2385268",
    "nome": "Gabriel Marque",
    "cpf": "56502505023",
    "email": "gabriel@mail.com",
    "telefone": "11999852300"
}
```


## Rota para buscar todos usuários:

`GET /usuarios - FORMATO DA RESPOSTA - STATUS 200`

```json
[
    {
        "idUsuario": "a186ce25-20b3-41cd-a0f0-a40236cc3f2e",
        "nome": "Luiz Antonio",
        "cpf": "36684071099",
        "email": "luiz@mail.com",
        "telefone": "11925630978"
    },
    {
        "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
        "nome": "Jorginho De Lima",
        "cpf": "78890145600",
        "email": "jorginho@mail.com",
        "telefone": "11988761203"
    },
    {
        "idUsuario": "5e3292a7-bc69-49d3-adb3-fa35f2385268",
        "nome": "Gabriel Marque",
        "cpf": "56502505023",
        "email": "gabriel@mail.com",
        "telefone": "11999852300"
    }
]
```

## Rota para buscar um usuários específico: 

`GET /usuarios/{id} - FORMATO DA RESPOSTA - STATUS 200`

```json
{
    "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
    "nome": "Jorginho De Lima",
    "cpf": "78890145600",
    "email": "jorginho@mail.com",
    "telefone": "11988761203"
}
```

## Rota para criar uma produto: 

`POST /produtos - FORMATO DA RESPOSTA - STATUS 201`

```json
{
    "idProduto": "8a75e691-bd72-4f55-b627-4d06fedfa910",
    "categoria": "Monitor",
    "titulo": "Monitor Gamer Pichau 49 Polegadas Curvo",
    "descricao": "Monitor novo, na caixa lacrado, nunca usado.",
    "preco": 5000.00,
    "quantidade": 50,
    "cep": "8912360"
}
```

## Rota para buscar todos produtos: 

`GET /produtos - FORMATO DA RESPOSTA - STATUS 200`

```json
[
    {
        "idProduto": "4aa1b89a-56fb-4e0e-a527-34c8c68eff7f",
        "categoria": "Celular",
        "titulo": "Iphone 13 Pro Max",
        "descricao": "Telefone novo, sem nenhum risco, todos acessórios originais.",
        "preco": 3500.00,
        "quantidade": 0.00,
        "cep": "05267980"
    },
    {
        "idProduto": "9c798418-276f-4e64-b864-66e23a66f021",
        "categoria": "Monitor",
        "titulo": "Monitor Gamer Pichau 49 Polegadas Curvo",
        "descricao": "Monitor novo, na caixa lacrado, nunca usado.",
        "preco": 5000.00,
        "quantidade": 44.00,
        "cep": "8912360"
    }
]
```

## Rota para buscar um produto pelo id: 

`GET /produtos/{id} - FORMATO DA RESPOSTA - STATUS 200`

```json
{
    "idProduto": "4aa1b89a-56fb-4e0e-a527-34c8c68eff7f",
    "categoria": "Celular",
    "titulo": "Iphone 13 Pro Max",
    "descricao": "Telefone novo, sem nenhum risco, todos acessórios originais.",
    "preco": 3500.00,
    "quantidade": 0.00,
    "cep": "05267980"
}
```

## Rota para criar uma venda: 

`POST /vendas - FORMATO DA RESPOSTA - STATUS 201`

```json
{
    "idVenda": "c5d385fd-40ce-4748-bae3-8e5d3b65d7ad",
    "usuario": {
        "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
        "nome": "Jorginho De Lima",
        "cpf": "78890145600",
        "email": "jorginho@mail.com",
        "telefone": "11988761203"
    },
    "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
    "tipoPagamento": "Boleto",
    "frete": "Normal"
}
```

## Rota para buscar vendas pelo id de um usuário: 

`GET /usuarios/{id}/vendas - FORMATO DA RESPOSTA - STATUS 201`

```json
[
    {
        "idVenda": "c5d385fd-40ce-4748-bae3-8e5d3b65d7ad",
        "usuario": {
            "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
            "nome": "Jorginho De Lima",
            "cpf": "78890145600",
            "email": "jorginho@mail.com",
            "telefone": "11988761203"
        },
        "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
        "tipoPagamento": "Boleto",
        "frete": "Normal"
    },
    {
        "idVenda": "11a6bafb-370f-4bd9-96c8-99567ec21d3d",
        "usuario": {
            "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
            "nome": "Jorginho De Lima",
            "cpf": "78890145600",
            "email": "jorginho@mail.com",
            "telefone": "11988761203"
        },
        "idUsuario": "9c792d7b-0f31-47b7-abbf-417dcc8a1001",
        "tipoPagamento": "Boleto",
        "frete": "Normal"
    }
]
```

##
