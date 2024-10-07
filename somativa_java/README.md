# Sistema de Gerenciamento de Tarefas

- Projeto de Gerenciamento de Tarefas: O objetivo deste projeto é desenvolver uma aplicação que permita aos usuários organizar, monitorar e priorizar suas atividades diárias de forma eficiente. A ferramenta deverá fornecer uma interface amigável e intuitiva, permitindo que os usuários adicionem, editem, excluam e categorizar tarefas, além de oferecer recursos como lembretes, datas de vencimento e priorização.

# Análise de Requisitos
__Requisitos Funcionais__
1. Cadastro de Usuários: O sistema deve permitir o registro e autenticação de usuários.
2. Gerenciamento de Tarefas:
Adição de novas tarefas.
Edição de tarefas existentes.
Exclusão de tarefas.
Marcação de tarefas como concluídas.
Visualização de Tarefas: Em lista.

# Requisitos Não Funcionais
1. Usabilidade: Interface intuitiva e fácil de usar.
2. Desempenho: O sistema deve ser capaz de processar até 1000 tarefas sem degradação de performance.
3. Segurança: Proteção de dados pessoais dos usuários e informações das tarefas.

# Escopo
__Inclusões__

- Desenvolvimento da interface do usuário.
- Implementação do banco de dados para armazenamento de dados das tarefas e usuários.
- Funcionalidades básicas de gerenciamento de tarefas.
- Testes de usabilidade e performance.
- Exclusões

__Entregáveis__

- Documento de requisitos.
- Protótipos da interface do usuário.
- Versão funcional da aplicação.
- Documentação técnica e manual do usuário.

### Diagrama de Classe em Formato de Tabela

| Classe       | Atributos                                                                 | Métodos                                      |
|--------------|---------------------------------------------------------------------------|----------------------------------------------|
| **Usuário**  | - `id: int`<br>- `nome: String`<br>- `email: String`<br>- `senha: String` | - `registrar()`<br>- `autenticar()`         |
| **Tarefa**   | - `id: int`<br>- `titulo: String`<br>- `descricao: String`<br>- `dataVencimento: Date`<br>- `prioridade: String`<br>- `status: String` | - `adicionar()`<br>- `editar()`<br>- `excluir()`<br>- `marcarComoConcluída()` |
| **Categoria**| - `id: int`<br>- `nome: String` | - `filtrar() `                                      | - 
### Relacionamentos

- **Usuário** (1:N) → **Tarefa**: Um usuário pode ter várias tarefas.
- **Tarefa** (N:1) → **Categoria**: Uma tarefa pode pertencer a uma categoria.
- **Tarefa** (1:N) → **Notificação**: Uma tarefa pode gerar várias notificações.

# Manual do Usuário
`Ao abrir o programa:`
- Você vai se deparar com a tela principal do programa, onde tudo acontece. 

`Do lado esquerdo`

 __Na parte superior__

  - É onde fica a lista das tarefas pendentes. 
  
__Na parte inferior__

  - Aqui você pode adicionar, cancelar, editar e concluír suas tarefas, basta digitar o titulo(nome) da tarefa no campo de texto, e clicar em um botao, para tal ação.

`Do lado direito`

__Na parte superior__

- Aqui temos um botão para limpar o seu histórico.

__Na parte inferior__

- Fica a lista do seu histórico.


# Faltando
- Aspecto Visual
- Documentação Técnica
- Testes e Validação 
- Vídeo