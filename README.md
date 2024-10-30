# 🌟 Interface de Dados: Smart Stylist

A **Interface de Dados: Smart Stylist** é uma aplicação inovadora que permite uma interação completa com diversas coleções de dados do mundo da moda. Com recursos como **gerenciamento de clientes**, **produtos**, **lookbooks**, **tendências de mercado**, e **histórico de compras**, a aplicação proporciona uma experiência personalizada e rica para os usuários.

---

## 📋 Funcionalidades

- **👤 Gerenciamento de Usuários**
  - Permite a criação, leitura, atualização e exclusão (CRUD) de perfis de usuários, proporcionando uma gestão completa dos dados de clientes.
  
- **🎨 Recomendações de Roupas**
  - Gera sugestões personalizadas de looks e produtos, baseadas nas preferências e histórico de compras dos usuários, usando algoritmos de recomendação.

- **🛍️ Experiência de Prova Virtual**
  - Oferece uma experiência interativa de prova virtual, permitindo que os usuários visualizem como as roupas ficariam antes de decidir pela compra.

- **💻 Interface Amigável e Responsiva**
  - Interface de usuário otimizada e responsiva, garantindo uma experiência fluida tanto em dispositivos móveis quanto em desktops.

- **🔍 Consultas e Filtros Avançados**
  - Ferramentas de busca e filtragem que permitem aos usuários explorar roupas e acessórios de acordo com critérios personalizados, como estilo, cor, tamanho, e faixa de preço.

- **📤 Importação de Dados**
  - Permite a importação de dados em formatos JSON ou CSV, facilitando a adição de informações sobre produtos, usuários e lookbooks à base de dados.

---

## 🚀 Tecnologias Utilizadas

- **☕ Java**: Linguagem de programação principal da aplicação, garantindo desempenho e robustez.
- **🚀 Spring Boot**: Framework que facilita o desenvolvimento rápido de aplicações web.
- **🐬 Spring Data MongoDB**: Integração fluida com o banco de dados MongoDB para gerenciamento de dados.
- **🧩 Thymeleaf**: Motor de templates para renderização dinâmica de páginas HTML.
- **⚙️ Lombok**: Biblioteca para simplificar o código, reduzindo a necessidade de código boilerplate.
- **☁️ MongoDB Atlas**: Banco de dados em nuvem para armazenamento seguro e escalável dos dados.

---

## 📦 Pré-requisitos

Para executar o projeto, você precisará de:

- **JDK 11 ou superior**: A versão do Java necessária para o projeto.
- **Maven**: Para gerenciamento de dependências e construção do projeto.
- **Conta no MongoDB Atlas**: Para configuração e armazenamento dos dados em nuvem.
- **IDE** (como IntelliJ IDEA ou Eclipse): Para desenvolvimento e execução do projeto.

---

## 🚀 Como Iniciar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/laiscrz/smart-stylist-interface.git
   cd smart-stylist
   ```

2. **Configuração do MongoDB Atlas**:
   - Configure o MongoDB Atlas e adicione a URI de conexão no arquivo `application.properties`:

     ```properties
     spring.data.mongodb.uri=mongodb+srv://<usuário>:<senha>@cluster.mongodb.net/smartstylist
     ```

3. **Compile o projeto com Maven**:
   ```bash
   mvn clean install
   ```

4. **Execute o projeto**:
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a aplicação**:
   - No navegador, vá para `http://localhost:8080` para acessar a interface.

---

## 🛠 Estrutura do Projeto

- **src/main/java**: Contém o código-fonte do backend, incluindo controladores, serviços e modelos.
- **src/main/resources**: Contém templates Thymeleaf e arquivos de configuração.
- **application.properties**: Configurações da aplicação, incluindo conexão com MongoDB.

---



> Este README oferece uma visão completa da **Interface de Dados: Smart Stylist**, ajudando a entenderem e interagirem com o projeto. Ele contém informações essenciais sobre funcionalidades, tecnologias utilizadas, pré-requisitos, instruções para iniciar o projeto, e diretrizes para contribuição, visando facilitar o envolvimento e a utilização eficaz da aplicação. A importação de dados em formatos JSON e CSV é uma funcionalidade que amplia a flexibilidade e a praticidade no gerenciamento de informações, permitindo que os usuários integrem facilmente novos dados ao sistema.
