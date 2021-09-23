package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreencherInformacoesUsuario extends BasePage{

	public PreencherInformacoesUsuario(WebDriver navegador) {
		super(navegador);
	}
	
	public ResumoPedido setCheckoutInformacoesUsuario(String nome, String sobreNome, String caixaPostal){
		navegador.findElement(By.id("first-name")).sendKeys(nome);
		navegador.findElement(By.id("last-name")).sendKeys(sobreNome);
		navegador.findElement(By.id("postal-code")).sendKeys(caixaPostal);
		
		navegador.findElement(By.id("continue")).click();
		
		return new ResumoPedido(navegador);
	}
}