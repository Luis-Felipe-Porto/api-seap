# API SEAP
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Luis-Felipe-Porto/api-seap/blob/main/LICENSE) 

# Sobre o projeto

<p>Projeto como teste para vaga de desenvolvedor java</br>
contrução de uma
api com cadastro de servidores e Lotacão</p>
<h1 align="center">
  <img alt="estrutura" src="https://github.com/Luis-Felipe-Porto/Luis-Felipe-Porto/blob/master/assets/estrutura.PNG" width="550px"/>
</h1>

## 👨🏼‍💻 Luis Felipe 

- [Luis Felipe](https://github.com/Luis-Felipe-Porto)

## 🚀 Tecnologias

- Java — 11
- SpringBoot
- JPA / Hibernate
- Maven - 3.8.1 
- Actuator
- Swagger
- H2

## ✋🏻 Pré-requisitos

- [Java 11](https://www.java.com/pt-BR/)
- [Maven](https://maven.apache.org)

```bash
## clonar repositório
git clone https://github.com/Luis-Felipe-Porto/api-seap

## Executar o projeto
./mvnw spring-boot:run
```
## Executar os testes
```bash
./mvnw test
```
## ⚡️ Documentação do Projeto
A documentação foi feita com a ferramenta swagger e pode ser acesada pelo link
- http://localhost:8080/swagger-ui/index.html

## 💡 Requisitos e Funcionalidades
 - Cadastro Servidor 
 - Busca de servidor por matricula
 - Cadastro de lotação
 - Consulta de lotação por nome
 ### Adicionais
 - Remover lotação
 - Remover Servidor
 - Pesquisa por descrição
 - Matricula Unica
 - Busca Paginada de Lotacao
 ### Implementação de testes
 Os testes foram implementados para garantir a estabilidade da api
  - Controller
  - Service
 ### Validações
 Validações de Campos da Api com handle tratando Bad Request
 
 ### Banco
 <p> O banco usado foi o H2 em memoria para facilitar o ambiente de desenvolvimento</br>
 mas pode ser subistituido por outros bancos </p>
 
 ### Arquitetura Rest
 <p>Foi usado camadas da arquitetura rest com spring</br>
 obs: Não deu tempo para mudança dos DTOs no projeto porém foi criado para uso</br>
 prosterior de acesso a dados</p>
 
 ### Front-end
 <p> Como Front end foi opcional de implementar, foi escolhindo o monitoramento</br>
 com a ferramenta actuator para verificação do estado da api o <strong>Actuator</strong></p>
 
 ### Actuator
 Para acessar basta executar a aplicao secundaria de [Monitoramento]()
 em: http://localhost:8090/
 <h1 >
  <img alt="actuator" src="https://github.com/Luis-Felipe-Porto/Luis-Felipe-Porto/blob/master/assets/actuator.PNG"/>
</h1>
 
 
 

