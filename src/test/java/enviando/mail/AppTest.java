package enviando.mail;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	

	
	@Test
	public void testeEmail() throws Exception{
		
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("edercribeiro@gmail.com, ederribeiro@bb.com.br",
						             "Eder JDev - Treinamento",
						             "Testando e-mail com Java",
						             "Esse texto é a descrição do meu e-mail");
		
		enviaEmail.enviarEmail();
					
			/*Caso o e-mail não esteja sendo enviado então 
			 *coloque um tempo de espera, mais isso só pode
			 *ser usado para testes.*/
			//Thread.sleep(10000);

		
	}
	
}
