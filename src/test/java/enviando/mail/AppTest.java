package enviando.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
			properties.put("mail.smtp.ssl.trust", "*");/*Autenticação SSL*/
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
			
			/*Podemos mandar para um ou para vários (essa classe aceita Array)*/
			Address[] toUser = InternetAddress.parse("edercribeiro@gmail.com, ederjavateste@gmail.com");
			
			/*Menssagem a ser enviada*/
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, "Eder JDev - Treinamento"));
			message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
			message.setSubject("Chegou o e-mail enviado com java");/*Assunto do e-mail*/
			message.setText("Que Maravilha!!! Você acaba de receber um E-mail enviado com JavaMail!!!!!!!!!! Parabéns!!!!!");
			
			Transport.send(message);
			
			/*Caso o e-mail não esteja sendo enviado então 
			 *coloque um tempo de espera, mais isso só pode
			 *ser usado para testes.*/
			//Thread.sleep(10000);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
}
