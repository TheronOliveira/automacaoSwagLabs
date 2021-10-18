package swagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver navegador) {
		super(navegador);		
	}
		
	public void setUsuario(String usuario){
		navegador.findElement(By.id("user-name")).sendKeys(usuario)	;
	}
	
	public void setSenha(String senha){
		navegador.findElement(By.id("password")).sendKeys(senha);		
	}
	
	public void setClicarLogin(){
		navegador.findElement(By.id("login-button")).click();		
	}
	
	public boolean getPaginaProdutos(){
		return navegador.getPageSource().contains("Products");
	}
	
}
