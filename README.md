# POI-inc

[![License](https://img.shields.io/github/license/caiocampos/POI-inc.svg)](LICENSE)

Software de gerência de Pontos de Interesse

## Como rodar:

### Pré-requisitos
- JDK 25 instalado
- MongoDB local rodando em `localhost:27017` (perfil `dev`) — ou acesso ao Atlas (perfil `prod`)

### Gerar o Gradle Wrapper

Por restrição do ambiente onde este código foi gerado, **o binário `gradle-wrapper.jar` não pôde ser baixado** (sem acesso à rede do Gradle). O arquivo `gradle/wrapper/gradle-wrapper.properties` já está configurado para o Gradle 9.6.1 (compatível com Java 25). Para gerar o wrapper completo, rode uma vez (com um Gradle local instalado, ex: via SDKMAN `sdk install gradle`):

```bash
gradle wrapper --gradle-version 9.6.1
```

Ou simplesmente abra o projeto no IntelliJ IDEA — ele detecta o `gradle-wrapper.properties` e baixa a distribuição automaticamente.

### Build e testes

```bash
./gradlew build
```

### Rodar localmente (perfil dev, Mongo local)

```bash
./gradlew bootRun
```

### Rodar em produção (perfil prod, Atlas)

```bash
SPRING_PROFILES_ACTIVE=prod mongoUser=<usuario> mongoUserP=<senha> ./gradlew bootRun
```


* ### Serviço de cadastrar Ponto de Interesse:

Méthodo: POST /
Endereço:
> {{ localhost || IP }}:{{ PORTA }}

Tipo:
> Content-Type: application/json

Dados:
```
{
    "name": "Lanchonete",
    "x": 27,
    "y": 12
}
```

* Exemplo:
```
POST / HTTP/1.1
Host: localhost:8085
Content-Type: application/json
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0
Accept: */*
Cache-Control: no-cache
Host: localhost:8085
accept-encoding: gzip, deflate
content-length: 45
Connection: keep-alive
cache-control: no-cache

{
    "name": "Lanchonete",
    "x": 27,
    "y": 12
}
```

* ### Serviço de listar todos os Pontos de Interesse:

Méthodo: GET /
Endereço:
> {{ localhost || IP }}:{{ PORTA }}

* Exemplo:
```
GET / HTTP/1.1
Host: localhost:8085
Content-Type: application/json
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0
Accept: */*
Cache-Control: no-cache
Host: localhost:8085
accept-encoding: gzip, deflate
Connection: keep-alive
cache-control: no-cache
```

* ### Serviço de listar todos os Pontos de Interesse:

Méthodo: GET /near
Endereço:
> {{ localhost || IP }}:{{ PORTA }}

Tipo:
> Content-Type: application/json

Dados:
```
{
	"x": 20,
	"y": 10,
	"distance": 10
}
```

* Exemplo:
```
GET /near HTTP/1.1
Host: localhost:8085
Content-Type: application/json
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0
Accept: */*
Cache-Control: no-cache
Host: localhost:8085
accept-encoding: gzip, deflate
content-length: 39
Connection: keep-alive
cache-control: no-cache

{
	"x": 20,
	"y": 10,
	"distance": 10
}
```
