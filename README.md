# Sistema de Controle de Fila de Atendimento

Este projeto é um **sistema de gerenciamento de filas de atendimento** com suporte a **guichês** e **prioridade por idade**.  
Ele simula o funcionamento de um sistema real de atendimento (como em bancos, hospitais, etc.), onde pessoas com maior idade têm prioridade no atendimento.

---

## Funcionalidades

Cadastro de pessoas na fila, com prioridade baseada na idade:
- **80 anos ou mais:** prioridade máxima  
- **65 a 79 anos:** prioridade intermediária  
- **Abaixo de 65 anos:** sem prioridade  

Controle de múltiplos **guichês de atendimento**

Regras de prioridade:
- São atendidas **duas pessoas prioritárias** seguidas de **uma sem prioridade**  
- O sistema exibe qual pessoa deve ir a qual guichê  

Exibição da fila atual e do status dos guichês

Liberação de guichês após atendimento

Menu interativo no terminal

---

## Estrutura do Projeto

```
app/
├── Guiche.java        # Representa um guichê de atendimento
├── Pessoa.java        # Representa uma pessoa com nome e idade
├── SistemaFila.java   # Gerencia as filas com prioridade e atendimento
└── Main.java          # Classe principal com menu interativo
```

---

## Funcionamento

### Cadastro de Pessoa
O usuário informa o nome e a idade.  
O sistema insere a pessoa na fila correspondente (80+, 65+, ou sem prioridade).

### Atendimento
Ao escolher a opção de atendimento:
- São chamados primeiro os clientes **80+**, depois **65+**, e a cada dois atendimentos prioritários, uma pessoa **sem prioridade**.

### Guichês
- Cada guichê pode atender uma pessoa por vez.
- Guichês podem ser liberados para atender o próximo pessoa da fila.

---

## Menu de Opções

```
==Menu de opções==
1 - Cadastrar uma nova pessoa na fila
2 - Liberar guichês
3 - Atender pessoas
4 - Exibir guichês
5 - Exibir fila
6 - Encerrar
```

---




## Exemplo de Execução

```
Informe o número de guichês:
2
Sistema de controle de fila de atendimento
==Menu de opções==
1-Cadastrar uma nova pessoa na fila
...

Digite o nome:
Maria
Digite a idade:
82
Maria foi adicionada à fila

3-Atender pessoas
---> Maria(82 anos) dirija-se ao guichê 1
```

---

