package enviando.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private String userName = "edertestejava@gmail.com";
	private String senha = "F2597185bb";
	
	@Test
	public void testeEmail() {
		
		/*Olhe as configurações smtp do seu email*/
		
		try {
			/*Propriedades SMTP para configuração específica do Gmail*/
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");/*Autorização*/
			properties.put("mail.smtp.starttls", "true");/*Autenticação*/
			properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail Google*/
			properties.put("mail.smtp.port", "465");/*Porta do servidor*/
			properties.put("mail.smtp.socketFactory.port", "465");/*Especifica a Porta do servidor a ser conectada pelo socket*/
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}
			});
			
			System.out.println(session);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
}
