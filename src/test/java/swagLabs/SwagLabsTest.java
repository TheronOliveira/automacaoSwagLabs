package swagLabs;

import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;
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
	
	String USERNAME = System.getenv("USERNAME");
	String PASSWORD = System.getenv("PASSWORD");
	
	@Before
	public void iniciar() {		
		navegador = WebDriverManager.chromedriver().create();
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.get("https://www.saucedemo.com/");
	}

	@Test
	public void testAcessoAPaginaSauceDemo(){
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
		
		loginPage.setUsuario(USERNAME);
		loginPage.setSenha(PASSWORD);
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
