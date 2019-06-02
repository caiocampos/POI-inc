# xy-inc

Software de gerência de Pontos de Interesse

## Executando:

Para executar o projeto é necessário o Maven instalado e configurado, siga as instruções do site a seguir para configurar:

http://luizricardo.org/2014/06/instalando-configurando-e-usando-o-maven-para-gerenciar-suas-dependencias-e-seus-projetos-java/

Com o Maven configurado basta executar o seguinte comando na pasta do projeto:

> mvn -Dmaven.test.skip=true install spring-boot:run

## Atenção:

Foi disponibilizado um usuário temporário para um Cluster no MongoDB Atlas para testes, o usuário terá acesso revogado depois de alguns dias, caso o projeto não execute por causa de autenticação no MongoDB por favor altere as configurações no arquivo:
> xy-inc/src/main/resources/application.properties

## Testando:

Para facilitar o teste, foi disponibilizado um arquivo de coleção do Postman para ser importado

https://github.com/caiocampos/xy-inc/blob/master/XY-inc.postman_collection.json

Para instalar o Postman e importar a coleção siga o tutoriai a seguir:

https://developer.ft.com/portal/docs-start-install-postman-and-import-request-collection

É possível fazer requisições diretamente por requisições HTTP


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
