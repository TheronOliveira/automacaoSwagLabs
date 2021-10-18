package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PedidoCompletoPage extends BasePage{
	
	private By msgOrdemCompleta = By.className("complete-header");

	public PedidoCompletoPage(WebDriver navegador) {
		super(navegador);
	}
	
	public String getMensagemOrdemComprada(){
		 return navegador.findElement(msgOrdemCompleta).getText();

		
	}
}
