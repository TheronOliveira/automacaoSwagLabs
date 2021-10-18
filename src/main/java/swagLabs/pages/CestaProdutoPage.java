package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CestaProdutoPage extends BasePage{
	private By checkout = By.id("checkout");
	
	public CestaProdutoPage(WebDriver navegador) {
		super(navegador);
	}
	
	public void setCheckoutResumoCompra(){
		navegador.findElement(checkout).click();
		
	}

}
