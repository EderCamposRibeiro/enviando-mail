package enviando.mail;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest3 {
	

	
	@Test
	public void testeEmail() throws Exception{
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Você está recebendo este e-mail de teste de JavaMail com Html de Eder Campos Ribeiro! <br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso clique no link abaixo. <br/><br/>");
		
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"http://portfolioeder.com.br/\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border:3px solid green; background-color:#99DA39;\">Acessar Portal</a> <br/><br/>");
		
		stringBuilderTextoEmail.append("<span style=\"font-size:8px\" >Ass: Eder Campos Ribeiro - Analista de Sistemas</span>");
		
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("edercribeiro@gmail.com",
						             "Eder JDev - Treinamento",
						             "Testando e-mail com Java",
						             stringBuilderTextoEmail.toString());
		
		enviaEmail.enviarEmailAnexo(true);
					
			/*Caso o e-mail não esteja sendo enviado então 
			 *coloque um tempo de espera, mais isso só pode
			 *ser usado para testes.*/
			//Thread.sleep(10000);

		
	}
	
}
