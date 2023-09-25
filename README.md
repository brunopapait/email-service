<h1 align="center">
  Email Service
</h1>

Serviço de envio de email usando o Amazon Simple Email Service (SES).

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html)
- [Lombok](https://projectlombok.org/)
- [SES](https://docs.aws.amazon.com/ses/latest/dg/Welcome.html)

## Como Executar
- Clonar repositório git.
- Instalar as dependências do projeto usando o maven.

- Crie as chaves de configuração do SES na AWS.
- Adicione as chaves de configuração do SES no arquivo application.properties.
```
AWS_ACCESS_KEY=AKEARFIYZAKC6EQOPO6U (example key)
AWS_SECRET_KEY=bLl1ZAUablegle+Zi5rsXZS41Y2c8Q9RfZF7Js3B (example key)
```

- Executar a aplicação.


- Enviar uma email de teste usando o endpoint com o corpo da requisição em formato JSON:
```
POST - http://localhost:8080/api/email/sendEmail

{
	"to": "testeteste@gmail.com",
	"subject": "teste",
	"body": "Hello from teste"
}
```

- Visualizar mensagem de retorno:
```
Email sent successfully!