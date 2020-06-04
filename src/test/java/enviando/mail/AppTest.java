package enviando.mail;

import java.util.Properties;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void testeEmail() {
		
		/*Olhe as configurações smtp do seu email*/
		
		/*Propriedades SMTP para configuração específica do Gmail*/
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");/*Autorização*/
		properties.put("mail.smtp.starttls", "true");/*Autenticação*/
		properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
		properties.put("mail.smtp.port", "465");/*Porta do servidor*/
		properties.put("mail.smtp.socketFactory.port", "465");/*Especifica a Porta do servidor a ser conectada pelo socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/
		
	}
	
}
