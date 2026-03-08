# 💱 Conversor de Moedas - Oracle Next Education + Alura

Desenvolvido como parte do programa **Oracle Next Education (ONE)** em parceria com a **Alura**, este projeto é um conversor de moedas interativo via console que consome taxas de câmbio em tempo real através de uma API externa.

---

## 🚀 Objetivo do Projeto

Desenvolver um **Conversor de Moedas** com interação textual via console, oferecendo no mínimo **6 opções distintas de conversão**, com taxas de câmbio obtidas dinamicamente via API — garantindo dados precisos e atualizados.

---

## 🛠️ Tecnologias Utilizadas

- ☕ Java
- Spring Boot
- Maven
- API de Taxas de Câmbio (ExchangeRate-API)
- Manipulação de JSON (Jackson)
- Console para interação com o usuário

---

## 📌 Funcionalidades

O sistema oferece interação via console com as seguintes opções:

1. 💵 Dólar americano (USD) → Real brasileiro (BRL)
2. 💴 Real brasileiro (BRL) → Dólar americano (USD)
3. 🇦🇷 Peso argentino (ARS) → Real brasileiro (BRL)
4. 💴 Real brasileiro (BRL) → Peso argentino (ARS)
5. 🌎 Mais opções — conversão livre entre quaisquer moedas usando código ISO 4217
6. 🚪 Sair

> Em "Mais opções" o usuário digita o código ISO 4217 de três letras de qualquer moeda. Alguns exemplos suportados: BOB, CLP, COP, entre outros.
> As taxas são obtidas em tempo real a cada conversão.

---

## 🔄 Etapas de Desenvolvimento

### 1️⃣ Configuração do Ambiente Java
- Instalação do JDK
- Configuração do Maven
- Estruturação inicial do projeto

### 2️⃣ Criação do Projeto
- Organização dos pacotes
- Configuração do Spring Boot

### 3️⃣ Consumo da API
- Requisições HTTP para a API de câmbio
- Tratamento de respostas em tempo real

### 4️⃣ Análise da Resposta JSON
- Desserialização dos dados com Jackson
- Mapeamento para objetos Java

### 5️⃣ Filtro de Moedas
- Seleção das moedas de interesse
- Validação das entradas do usuário

### 6️⃣ Exibição de Resultados
- Menu interativo no console
- Exibição formatada dos resultados

---

## 💡 Como Executar

1. Clone o repositório
2. Configure sua chave da API no `application.properties`
```
api.key=SUA_CHAVE_AQUI
```
3. Execute a aplicação e interaja com o menu via console

---

## 🎯 Aprendizados

- Consumo de APIs REST externas
- Desserialização de JSON
- Boas práticas em Java
- Interação com usuário via console
- Organização de projetos com Maven

---

## 🏁 Conclusão

O Conversor de Moedas foi uma experiência prática para consolidar o consumo de APIs externas, manipulação de JSON e desenvolvimento de aplicações interativas com Java. 🚀
