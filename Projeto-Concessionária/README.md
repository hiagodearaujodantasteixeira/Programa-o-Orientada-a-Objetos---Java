# 🚗 Concessionária Dantas - Sistema de Gerenciamento

## 📖 Descrição
Este projeto consiste em um sistema completo de gerenciamento para uma concessionária de veículos, desenvolvido em **Java**. 

O projeto teve início como uma aplicação de console para estudo de **Programação Orientada a Objetos (POO)** e evoluiu para uma arquitetura profissional baseada no padrão **MVC (Model-View-Controller)**. Atualmente, o sistema conta com uma **Interface Gráfica (GUI)** robusta desenvolvida em **Swing** para todos os módulos de gerenciamento.

O código foi finalizado através de um esforço colaborativo, visando aplicar boas práticas de engenharia de software e usabilidade.

## ⚙️ Funcionalidades
O sistema oferece controle total (CRUD) sobre as operações da concessionária através de uma interface visual amigável:

* **Arquitetura MVC:** Separação clara entre a interface (`view`), a lógica de controle (`controller`) e os dados (`model`).
* **Interface Gráfica Completa:** Todas as interações são feitas via janelas (`JFrame`), eliminando o uso do terminal.
* **Menu Principal:** Painel centralizado para acesso rápido aos módulos.
* **Módulos Gerenciáveis:**
    * **Clientes:** Cadastro, consulta por CPF, alteração de dados e relatórios.
    * **Funcionários:** Gestão de equipe, cargos e qualificações.
    * **Veículos:** Controle de estoque, marcas e detalhes técnicos.
    * **Vendas:** Registro de transações vinculando clientes, funcionários e veículos.

## ✅ Status do Projeto
O desenvolvimento das interfaces gráficas e da lógica de negócios foi **concluído**.

* ✅ **Gerenciamento de Clientes:** Interface e Lógica Finalizadas.
* ✅ **Gerenciamento de Funcionários:** Interface e Lógica Finalizadas.
* ✅ **Gerenciamento de Veículos:** Interface e Lógica Finalizadas.
* ✅ **Gerenciamento de Vendas:** Interface e Lógica Finalizadas.

## 📂 Estrutura do Projeto (MVC)
A organização dos pacotes reflete a arquitetura adotada:

* `src/view`: Contém todas as telas (formulários, edições, menus e relatórios) construídas com Swing.
* `src/controller`: Contém a classe `Concessionaria`, responsável por orquestrar as ações entre as telas e os modelos de dados.
* `src/model`: Classes que representam as entidades do negócio (`Cliente`, `Veiculo`, `Venda`, `Funcionario`).
* `Interfaces`: Define o contrato `OperacoesConcessionaria` que padroniza as regras de negócio.

## 🛠 Tecnologias Utilizadas
* **Linguagem:** Java (JDK atualizado)
* **Interface Gráfica:** Java Swing (javax.swing)
* **IDE Recomendada:** NetBeans / IntelliJ / Eclipse
* **Controle de Versão:** Git & GitHub

## 🚀 Como Executar
1.  **Clonar o repositório:**
    ```bash
    git clone [https://github.com/hiagodearaujodantasteixeira/Programa-o-Orientada-a-Objetos---Java.git](https://github.com/hiagodearaujodantasteixeira/Programa-o-Orientada-a-Objetos---Java.git)
    ```
2.  **Importar na IDE:** Abra o projeto na sua IDE de preferência.
3.  **Executar:** Localize e rode a classe `view.MenuPrincipal`.

## 👥 Autores e Colaboradores
Este projeto foi desenvolvido e finalizado em equipe:

* **[Hiago de Araujo Dantas Teixeira](https://www.linkedin.com/in/hiago-teixeira-0b117028b/)** - *Desenvolvedor*
* **[Sivirino Sousa](https://www.linkedin.com/in/sivirino-sousa-955637324/)** - *Desenvolvedor*
