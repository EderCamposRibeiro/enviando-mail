package enviando.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ObjetoEnviaEmail {

	private String userName = "edertestejava@gmail.com";
	private String senha = "F2597185bb";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = ""; 
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	public void enviarEmail(boolean envioHtml) throws Exception{
		/* Olhe as configurações smtp do seu email */

		/* Propriedades SMTP para configuração específica do Gmail */
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");/* Autenticação SSL */
		properties.put("mail.smtp.auth", "true");/* Autorização */
		properties.put("mail.smtp.starttls", "true");/* Autenticação */
		properties.put("mail.smtp.host", "smtp.gmail.com");/* Servidor gmail Google */
		properties.put("mail.smtp.port", "465");/* Porta do servidor */
		properties.put("mail.smtp.socketFactory.port",
				"465");/* Especifica a Porta do servidor a ser conectada pelo socket */
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");/* Classe socket de conexão ao SMTP */

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
			}
		});

		/* Podemos mandar para um ou para vários (essa classe aceita Array) */
		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		/* Menssagem a ser enviada */
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente)); /*userName, "Eder JDev - Treinamento"*/
		message.setRecipients(Message.RecipientType.TO, toUser);/* Email de destino */
		message.setSubject(assuntoEmail);/* Assunto do e-mail */
		
		if (envioHtml) {
			message.setContent(textoEmail, "text/html; charset=utf-8" );
		} else {
			message.setText(textoEmail);
		}
		
		

		Transport.send(message);

	}
	
	/*
	 * Esse método simula o PDF ou qualquer arquivo que possa ser enviado por anexo no e-mail.
	 * Você pode pegar o arquivo no seu banco de dados base64, byte[], stream de Arquivos.
	 * Pode estar em um banco de dados, ou em uma pasta
	 * 
	 * Retorna um PDF em Branco com o texto do Parágrafo de exemplo.
	 * */
	private FileInputStream simuladorDePDF() throws Exception{
		Document document = new Document();
		File file = new File("Fileanexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("Conteúdo do PDF anexo com Java Mail!  Esse é o texto do PDF!"));
		document.close();
		
		return new FileInputStream(file);
	}

}
