## Título e Imagem de Capa
## <p align="center">Bankend Debits </p> 
<p align="center">
<img src="https://user-images.githubusercontent.com/79177544/159943471-ab55c6eb-2eb3-441d-9f06-fbaaf69d67ca.jpg" />
</p>

## Índice 

* [Título e Imagem de capa](#Título-e-Imagem-de-capa)
* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Status do Projeto](#status-do-Projeto)
* [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Pessoa Desenvolvedora do Projeto](#pessoas-desenvolvedoras)
* [Conclusão](#conclusão)

## Descrição do Projeto
<p> Este projeto é a continuação do Bankend onde aplicamos o conceito de Microservices, pois se trata de um DTO (Objeto de Transferência de Dados) 
  que realiza uma transação entre contas.
  
 O serviço de transação solicita os dados de duas contas, uma para debitar e outra (Beneficiary) para creditar conforme Json abaixo:
</p>

```
{
  "accountNumber": "string",
  "beneficiary": {
    "accountNumber": "string",
    "documentNumber": "string",
    "name": "string"
  },
  "debitDate": "2022-03-26T19:00:21.446Z",
  "debitValue": 0,
  "documentNumber": "string",
  "name": "string"
}
```



## Status do projeto
<p>
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Funcionalidades e Demonstração da Aplicação
<p>Após criar duas contas com saldo no aplicativo Bankend, podemos realizar a transferência ou cobrança de uma conta para a outra. 
  O serviço solicita dados da conta a ser debitada e a conta a ser creditada.</p>
<p>
  Com o Swagger podemos visualizar esta função de forma dinâmica:</p>
  
  ![Aplicação Swagger Debits](https://user-images.githubusercontent.com/79177544/160255390-7c511910-4028-4abc-a333-b3ad15e1cb7a.gif)

<p> Quando o a função é bem sucedida recebemos um UUID (debitId) como retorno que é enviado ao Kafka junto do valor e a data da transação.

## Acesso ao Projeto
***  **Iniciando a aplicação**  ***
  
- Faça o Download da aplicação e a descompacte;
- Abra a aplicação com a IDEA de sua preferência;
- Aguarde o Download dos plugis necessários;
- Inicie a Aplicação;
- Após a Inicialização acesse o link http://localhost:8082/swagger-ui.html#/
  

## Tecnologias utilizadas

<img align="center" alt="Rodrigo-Java" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg"> - Java 11;

<img align="center" alt="Rodrigo-Docker" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original-wordmark.svg"> - Docker;

<img align="center" alt="Rodrigo-Spring" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"> - Spring Boot;

<img align="center" alt="Rodrigo-Post" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original-wordmark.svg"> - PostgreSQL; 
 
<img align="center" alt="Rodrigo-Kafka" height="30" width="40" src="https://upload.wikimedia.org/wikipedia/commons/0/05/Apache_kafka.svg"> - Apache Kafka;  
  
## Pessoa Desenvolvedora do Projeto
| [<img src="https://avatars.githubusercontent.com/u/79177544?s=96&v=4" width=115><br><sub>Rodrigo Oliveira Sousa</sub>](https://www.linkedin.com/in/rodrigo-oliveira-sousa/) | 
| :---: |
 
 
 ## Conclusão
 
 Este é um serviço aplicado ao banco digital [Bankend](https://github.com/Rodrigo-osousa/bankend) podendo ser possível desenvolver mais aplicações de maneira descentralizada.
  
