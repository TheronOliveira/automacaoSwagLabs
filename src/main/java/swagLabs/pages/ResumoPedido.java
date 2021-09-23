package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumoPedido extends BasePage{

	public ResumoPedido(WebDriver navegador) {
		super(navegador);
	}

	public PedidoCompleto setClicarFinish(){
		navegador.findElement(By.id("finish")).click();
		return new PedidoCompleto(navegador);
	}
}
