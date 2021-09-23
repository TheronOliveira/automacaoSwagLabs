package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

	public CartPage(WebDriver navegador) {
		super(navegador);
	}
	
	public PreencherInformacoesUsuario setCheckoutResumoCompra(){
		navegador.findElement(By.id("checkout")).click();
		
		return new PreencherInformacoesUsuario(navegador);
	}

}
