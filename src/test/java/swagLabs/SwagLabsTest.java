package swagLabs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import swagLabs.pages.LoginPage;


public class SwagLabsTest {
	
	private WebDriver navegador;

	@Test
	//todo método de test tem que ser publico (public) e sem retorno (void)
	public void testOrdemPedidoRealizadacomSucesso(){
		
		LoginPage loginPage = new LoginPage(navegador);
		
		String mensagemFinal =	loginPage
		.createChrome()
		.setRealizarlogin("standard_user", "secret_sauce")
		.setEscolherUmProdutoAleatorio()
		.setClicarCarrinho()
		.setCheckoutResumoCompra()
		.setCheckoutInformacoesUsuario("teste", "001", "09020000")
		.setClicarFinish()
		.getMensagemOrdemComprada();
		
		Assert.assertEquals("THANK YOU FOR YOUR ORDER",mensagemFinal);	

		loginPage.setSair();
		
	}
}
