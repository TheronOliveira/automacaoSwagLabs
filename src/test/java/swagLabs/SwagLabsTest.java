package swagLabs;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import swagLabs.pages.CestaProdutoPage;
import swagLabs.pages.InformacoesUsuarioPage;
import swagLabs.pages.LoginPage;
import swagLabs.pages.PedidoCompletoPage;
import swagLabs.pages.ProdutoPage;
import swagLabs.pages.ResumoPedidoPage;
import swagLabs.pages.ScreenShot;




public class SwagLabsTest {
	
	WebDriver navegador;
	
	@Before
	public void iniciar() {		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDriver/chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.get("https://www.saucedemo.com/");
	}
		
	@Test
	public void testOrdemPedidoRealizadacomSucesso() throws IOException{
		
		LoginPage loginPage = new LoginPage(navegador);
		ProdutoPage produto = new ProdutoPage(navegador);
		CestaProdutoPage produtoEscolhido = new CestaProdutoPage(navegador);
		InformacoesUsuarioPage infoUsuario = new InformacoesUsuarioPage(navegador);
		ResumoPedidoPage resumoPedido = new ResumoPedidoPage(navegador);
		PedidoCompletoPage pedidoCompleto = new PedidoCompletoPage(navegador);
		
		loginPage.setUsuario("standard_user");
		loginPage.setSenha("secret_sauce");
		loginPage.setClicarLogin();	
		
		produto.setEscolherUmProdutoAleatorio();
		produto.setClicarCarrinho();
		
		produtoEscolhido.setCheckoutResumoCompra();
		
		infoUsuario.cadastraNomeUsuario("teste");
		infoUsuario.cadastraSobreNomeUsuario("001");
		infoUsuario.cadastraCaixaPostalUsuario("00012920");
		infoUsuario.clicarContinuarUsuario();
		
		resumoPedido.setClicarFinish();	
		
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", pedidoCompleto.getMensagemOrdemComprada());
		
		ScreenShot.tirarFoto(navegador);
		
	}
	
	@After
	public void finalizar() {
		navegador.close();
		navegador.quit();
	}
}
