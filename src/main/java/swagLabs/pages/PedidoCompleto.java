package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PedidoCompleto extends BasePage{

	public PedidoCompleto(WebDriver navegador) {
		super(navegador);
	}
	public String getMensagemOrdemComprada(){
		return navegador.findElement(By.className("complete-header")).getText();
	}
}
