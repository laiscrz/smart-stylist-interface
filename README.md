# 🌟 Interface de Dados: Smart Stylist

A **🌟 Interface de Dados: Smart Stylist** é uma aplicação inovadora que permite uma interação completa com diversas coleções de dados do mundo da moda. Com recursos como **👤 gerenciamento de clientes**, **👗 produtos**, **📸 lookbooks**, **📈 tendências de mercado**, e **🛒 histórico de compras**, a aplicação proporciona uma experiência personalizada e rica para os usuários.

---

## 📋 Funcionalidades

- **👤 Gerenciamento de Usuários**
  - Realiza operações de criação, leitura, atualização e exclusão (CRUD) em perfis de usuários, proporcionando uma gestão completa dos dados de clientes.

- **💻 Interface Amigável e Responsiva**
  - Interface de usuário otimizada e responsiva, garantindo uma experiência fluida tanto em dispositivos móveis quanto em desktops.

- **🔍 Consultas e Filtros Avançados**
  - Ferramentas de busca e filtragem que permitem aos usuários explorar roupas e acessórios de acordo com critérios personalizados, como nome, idade, categoria e faixa de preço.

- **📤 Importação de Dados**
  - Permite a importação de dados em formatos JSON ou CSV, facilitando a adição de informações sobre produtos, usuários e lookbooks à base de dados.

---
## 📋 Exemplos de CRUD

### 👗 Produto

- **🆕 Create Produto**
  - Para criar um novo produto, preencha o formulário com os seguintes dados:
  ```json
  {
    "nome": "Camisa do Corinthians",
    "categoria": "CAMISA",
    "preco": 199.90,
    "estoque": 30,
    "tamanhosDisponiveis": ["P", "M", "G", "GG"],
    "coresDisponiveis": ["Preto", "Branco"],
    "dataAdicao": "2024-11-02",
    "sazonalidade": "VERÃO",
    "imagemUrl": "https://abrir.link/QslhR",
    "marca": "Nike",
    "padrao": "ESTAMPADO"
  }
  ```

- **📖 Read**
  - Para visualizar as informações de um produto, clique no nome do produto na lista de produtos.

- **🔄 Update Produto**
  - Para atualizar um produto, clique em "Editar" ao lado do produto desejado, faça as alterações no formulário e salve.
  ```json
  {
    "nome": "Camisa do Corinthians",
    "categoria": "CAMISA",
    "preco": 179.90, 
    "estoque": 25, 
    "tamanhosDisponiveis": ["P", "M", "G", "GG", "XG"],  
    "coresDisponiveis": ["Preto", "Branco"],
    "dataAdicao": "2024-11-02",
    "sazonalidade": "VERÃO",
    "imagemUrl": "https://abrir.link/QslhR",
    "marca": "Nike",
    "padrao": "ESTAMPADO"
  }
  ```

- **🗑️ Delete Produto**
  - Para excluir um produto, clique em "Excluir" ao lado do produto desejado e confirme a ação.

---

### 👤 Cliente

- **🆕 Create**
  - Para criar um novo cliente, preencha o formulário com os seguintes dados:
  ```json
  {
    "nome": "Roberta Oliveira",
    "email": "roberta.oliveira@example.com",
    "preferenciasEstilo": ["Moderno", "Elegante"],
    "dataCadastro": "2024-11-02",
    "idade": 28,
    "genero": "Feminino",
    "telefone": "11998765432",
    "endereco": {
        "rua": "Avenida das Américas",
        "cidade": "Rio de Janeiro",
        "estado": "RJ",
        "pais": "Brasil"
    }
  }
  ```

- **📖 Read**
  - Para visualizar as informações de um cliente, clique no nome do cliente na lista de clientes.

- **🔄 Update**
  - Para atualizar um cliente, clique em "Editar" ao lado do cliente desejado, faça as alterações no formulário e salve.
  ```json
  {
    "nome": "Roberta Oliveira Santos",
    "email": "roberta.santos@example.com",
    "preferenciasEstilo": ["Moderno", "Casual"],
    "dataCadastro": "2024-11-02",
    "idade": 29,
    "genero": "Feminino",
    "telefone": "11998765432",
    "endereco": {
        "rua": "Avenida das Américas",
        "cidade": "Rio de Janeiro",
        "estado": "RJ",
        "pais": "Brasil"
    }
  }
  ```

- **🗑️ Delete**
  - Para excluir um cliente, clique em "Excluir" ao lado do cliente desejado e confirme a ação.
---

## 📊 Exportação de Dados

A aplicação permite a **exportação de dados** em formatos CSV e JSON para várias categorias, facilitando a análise e compartilhamento de informações. Confira as opções disponíveis:

### 📤 **Como Exportar Dados**

1. **📋 Clientes**: 
   - **CSV**: Exportar a lista de clientes como um arquivo CSV. 
     - Acesse em: ``/export/clients/csv``
   - **📄 JSON**: Exportar a lista de clientes como um arquivo JSON. 
     - Acesse em: ``/export/clients/json``

2. **🛍️ Produtos**: 
   - **CSV**: Exportar a lista de produtos em CSV. 
     - Acesse em: ``/export/products/csv``
   - **📄 JSON**: Exportar a lista de produtos em JSON. 
     - Acesse em: ``/export/products/json``

3. **👗 Tendências de Moda**: 
   - **CSV**: Exportar as tendências de moda em CSV.  
     - Acesse em: ``/export/fashionTrends/csv``
   - **📄 JSON**: Exportar as tendências de moda em JSON. 
     - Acesse em: ``/export/fashionTrends/json``

4. **📚 Lookbooks**: 
   - **CSV**: Exportar os lookbooks em CSV. 
     - Acesse em: ``/export/lookbooks/csv``
   - **📄 JSON**: Exportar os lookbooks em JSON. 
     - Acesse em: ``/export/lookbooks/json``

5. **🛒 Histórico de Compras**: 
   - **CSV**: Exportar o histórico de compras em CSV. 
     - Acesse em: ``/export/purchaseHistory/csv``
   - **📄 JSON**: Exportar o histórico de compras em JSON. 
     - Acesse em: ``/export/purchaseHistory/json``

6. **🧥 Virtual Try-On**: 
   - **CSV**: Exportar dados de Virtual Try-On em CSV. 
     - Acesse em: ``/export/virtualTryOn/csv``
   - **📄 JSON**: Exportar dados de Virtual Try-On em JSON. 
     - Acesse em: ``/export/virtualTryOn/json``

Ao acessar esses endpoints, você irá baixar automaticamente os arquivos para análise e uso! 📥✨

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

- **☕ JDK 11 ou superior**: A versão do Java necessária para o projeto.
- **📦 Maven**: Para gerenciamento de dependências e construção do projeto.
- **☁️ Conta no MongoDB Atlas**: Para configuração e armazenamento dos dados em nuvem.
- **💻 IDE** (como IntelliJ IDEA ou Eclipse): Para desenvolvimento e execução do projeto.

---

## 🚀 Como Iniciar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/laiscrz/smart-stylist-interface.git
   cd smart-stylist-interface
   ```

2. **🛠️ Configuração do MongoDB Atlas**:
   - Configure o MongoDB Atlas e adicione a URI de conexão no arquivo `application.properties`:

     ```properties
     spring.data.mongodb.uri=mongodb+srv://<usuário>:<senha>@cluster.mongodb.net/LeadtechEstilistaDB?retryWrites=true&w=majority&appName=<nomeCluster>
     ```
   - **Substitua `<usuário>`, `<senha>` e `<nomeCluster>`** com suas informações específicas.

3. **🔧 Compile o projeto com Maven**:
   ```bash
   mvn clean install
   ```

4. **🚀 Execute o projeto**:
   ```bash
   mvn spring-boot:run
   ```

5. **🌐 Acesse a aplicação**:
   - No navegador, vá para `http://localhost:8080` para acessar a interface.

6. **💻 IDEs**:
   - Você pode utilizar a IDE de sua preferência, como IntelliJ IDEA, Eclipse, ou qualquer outra que suporte projetos Maven.
     
---

## 🫂 Integrantes

Aqui estão os membros do grupo que participaram durante desenvolvimento desta SPRINT.

* **RM 552258 - Laís Alves da Silva Cruz**
  - Turma: 2TDSPH

* **RM 552267 - Bianca Leticia Román Caldeira**
  - Turma: 2TDSPH

* **RM 552252 – Charlene Aparecida Estevam Mendes Fialho**
  - Turma: 2TDSPH

* **RM 97916 – Fabricio Torres Antonio**
  - Turma: 2TDSPH

* **RM 99675 – Lucca Raphael Pereira dos Santos**
  - Turma: 2TDSPZ
    
<table>
  <tr>
      <td align="center">
      <a href="https://github.com/laiscrz">
        <img src="https://avatars.githubusercontent.com/u/133046134?v=4" width="100px;" alt="Lais Alves's photo on GitHub"/><br>
        <sub>
          <b>Lais Alves</b>
        </sub>
      </a>
      </td>
      <td align="center">
      <a href="https://github.com/biancaroman">
        <img src="https://avatars.githubusercontent.com/u/128830935?v=4" width="100px;" border-radius='50%' alt="Bianca Román's photo on GitHub"/><br>
        <sub>
          <b>Bianca Román</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/charlenefialho">
        <img src="https://avatars.githubusercontent.com/u/94643076?v=4" width="100px;" border-radius='50%' alt="Charlene Aparecida's photo on GitHub"/><br>
        <sub>
          <b>Charlene Aparecida</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Fabs0602">
        <img src="https://avatars.githubusercontent.com/u/111320639?v=4" width="100px;" border-radius='50%' alt="Fabricio Torres's photo on GitHub"/><br>
        <sub>
          <b>Fabricio Torres</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/LuccaRaphael">
        <img src="https://avatars.githubusercontent.com/u/127765063?v=4" width="100px;" border-radius='50%' alt="Lucca Raphael's photo on GitHub"/><br>
        <sub>
          <b>Lucca Raphael</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

---
> O README da Interface de Dados: Smart Stylist oferece uma visão geral do projeto, incluindo funcionalidades, tecnologias, pré-requisitos e instruções de inicialização. Também aborda a possibilidade de importar dados em JSON e CSV, facilitando a integração de informações ao sistema. 📚
