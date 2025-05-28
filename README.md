Este projeto foi desenvolvido como parte da **Missão Prática RPG0017 - Vamos Integrar Sistemas**, do curso de Desenvolvimento FullStack.

## 🎯 Objetivo

Construir um sistema de cadastro de produtos com interface web, utilizando a plataforma **Java EE**, com foco em:
- Persistência com **JPA**
- Regras de negócio com **EJB**
- Controle de fluxo com **Servlets**
- Interface com **JSP**
- Estilo visual com **Bootstrap**

## 🛠️ Tecnologias Utilizadas

- Java 11+
- Jakarta EE 8 (Java EE)
- GlassFish Server 6.2.1
- NetBeans IDE
- SQL Server
- Bootstrap 5 (via CDN)

## 📁 Estrutura do Projeto
CadastroEE/
├── CadastroEE-ejb/ # Camada de persistência e lógica (JPA + EJB)
│ └── src/
│ └── cadastroee/
│ ├── model/ # Entidades JPA (Produto.java)
│ └── controller/ # EJBs (ProdutoFacade, ProdutoFacadeLocal)
│ └── META-INF/
│ └── persistence.xml
├── CadastroEE-war/ # Camada web (Servlets + JSPs)
│ └── src/
│ └── cadastroee/
│ └── servlets/ # ServletProdutoFC.java
│ └── web/
│ ├── ProdutoLista.jsp
│ └── ProdutoDados.jsp

## 📌 Funcionalidades

- ✅ Cadastro de produtos
- ✅ Listagem de produtos
- ✅ Alteração de produtos
- ✅ Exclusão de produtos
- ✅ Interface responsiva com Bootstrap

## 📚 Autor

**Moniza de Oliveira Silva Santos Pelegrini**  
RA: 202401190829  
Campus: Polo Cruzeiro-SP  
