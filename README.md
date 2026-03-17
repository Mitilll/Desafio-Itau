# Itaú Challenge - Resolução :

Repositório com a resolução do desafio proposto pelo Itaú como teste tecnico para vaga junior. O objetivo deste desafio é avaliar habilidades em **desenvolvimento backend**, **Arquetetura de software**(Monolito/MVC) e dominio sobre o funcionamento e controle APIsRest . 

##  Link :
Repositorio original do ponto de partida e regras do desafio: **https://github.com/feltex/desafio-itau-backend?tab=readme-ov-file**

##  Tecnologias Utilizadas :

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)

## 📖 Descrição do Desafio :

O desafio consiste em criar uma **API REST** que receba transações financeiras e retorne **estatísticas sobre essas transações**.  
A API deve processar apenas as transações ocorridas nos últimos 60 segundos e fornecer informações agregadas como soma, média, mínimo, máximo e quantidade de transações.

O objetivo é avaliar:  
- Qualidade e organização do código  
- Boas práticas de programação  
- Estruturação do projeto  
- Testes e cobertura  
- Tratamento de erros  
- Documentação e facilidade de compreensão do código

> Observação: Não há uma única forma correta de resolver o desafio, o importante é a clareza, organização e qualidade do código.

---

## Regras e Restrições Técnicas
1. **Repositório**
   - Deve estar no **GitHub ou GitLab**  
   - Não é permitido **fork** de outros projetos  
   - Deve ter **pelo menos 1 commit por endpoint** (mínimo de 3 commits)  
   - Todos os commits devem ser feitos pelo **mesmo usuário**  

2. **API**
   - Endpoints devem seguir **exatamente** os nomes fornecidos (`/transacao`, `/estatistica`)  
   - Aceitar e retornar apenas **JSON**  
   - Todos os dados devem ser **armazenados em memória**, sem bancos de dados (H2, MySQL, PostgreSQL, etc.) ou caches externos (Redis, Memcached, Infinispan, etc.)  
   - Não enviar o projeto em arquivos; deve ser acessível publicamente para avaliação  

3. **Validação das Transações**
   - `valor` deve ser maior ou igual a 0  
   - `dataHora` não pode estar no futuro  
   - Campos obrigatórios: `valor` e `dataHora`  
   - Apenas transações válidas são aceitas  

---

## Endpoints da API

### 1. POST /transacao
Recebe uma transação com os campos:

```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

## ▶️ Como executar o projeto

Siga os passos abaixo para rodar a aplicação localmente:

### Pré-requisitos

Antes de começar, você precisa ter instalado em sua máquina:

* **Java 22**
* **Git**

---

### Clonando o repositório

Abra o terminal e execute:

```bash
git clone <URL_DO_SEU_REPOSITORIO>
```

Depois, entre na pasta do projeto:

```bash
cd <NOME_DO_PROJETO>
```

---

### Executando o projeto

#### Usando o terminal (Java puro ou Spring Boot)

Se o projeto usa **Spring Boot**, execute:

```bash
./mvnw spring-boot:run
```

ou, se estiver usando Maven instalado:

```bash
mvn spring-boot:run
```

Se for um projeto Java simples:

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

---

#### Usando uma IDE

Você também pode rodar pela sua IDE (IntelliJ, Eclipse, etc):

1. Abra o projeto
2. Aguarde o carregamento das dependências
3. Execute a classe principal (geralmente `Main` ou a classe com `@SpringBootApplication`)

---

### Pronto!

A aplicação estará rodando localmente.
Agora é só testar a solução do desafio 
