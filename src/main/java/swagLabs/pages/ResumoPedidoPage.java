package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumoPedidoPage extends BasePage{
	
	private By finalizarPedido = By.id("finish");
	public ResumoPedidoPage(WebDriver navegador) {
		super(navegador);
	}

	public void setClicarFinish(){
		navegador.findElement(finalizarPedido).click();
	}
}
