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
	public void iniciar(){		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SempreIT\\Documents\\Testes de Software\\chrome-driver\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.get("https://www.saucedemo.com/");
	}
	
	@After
	public void finalizar(){
		navegador.quit();
	}
	
	@Test
	//todo método de test tem que ser publico (public) e sem retorno (void)
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
		
		/*
		String mensagemFinal = loginPage
		.createChrome()
		.setRealizarlogin("standard_user", )
		.setEscolherUmProdutoAleatorio()
		.setClicarCarrinho()
		.setCheckoutResumoCompra()
		.setCheckoutInformacoesUsuario("teste", "001", "09020000")
		.setClicarFinish()
		.getMensagemOrdemComprada();
		
		Assert.assertEquals("THANK YOU FOR YOUR ORDER",mensagemFinal);
		//ScreenShot.tirarFoto();*/

		//loginPage.setSair();
		
	}
}
