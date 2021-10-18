package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InformacoesUsuarioPage extends BasePage{
	
	private By nomeCampo = By.id("first-name");
	private By sobreNomeCampo = By.id("last-name");
	private By caixaPostalCampo = By.id("postal-code");
	private By continuar = By.id("continue");
	
	public InformacoesUsuarioPage(WebDriver navegador) {
		super(navegador);
	}
	
	public void cadastraNomeUsuario(String nome){
		navegador.findElement(nomeCampo).sendKeys(nome);
	}
	
	public void cadastraSobreNomeUsuario(String sobreNome){
		navegador.findElement(sobreNomeCampo).sendKeys(sobreNome);
	}
	
	public void cadastraCaixaPostalUsuario(String caixaPostal){		
		navegador.findElement(caixaPostalCampo).sendKeys(caixaPostal);		
	}
	
	public void clicarContinuarUsuario(){		
		navegador.findElement(continuar).click();
	}
}