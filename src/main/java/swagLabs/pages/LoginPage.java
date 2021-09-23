package swagLabs.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage{
	
	private String url_login = "https://www.saucedemo.com/";
	
	public LoginPage(WebDriver navegador) {
		super(navegador);		
	}
	
	public LoginPage createChrome(){
		
		//definindo o local onde está o exe do chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SempreIT\\Documents\\Testes de Software\\chrome-driver\\chromedriver.exe");
		navegador = new ChromeDriver();
		
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		navegador.manage().window().maximize();
		navegador.get(url_login);
		
		return this;
	}
	
	public InventarioPage setRealizarlogin(String usuario, String senha){
		navegador.findElement(By.id("user-name")).sendKeys(usuario);
		navegador.findElement(By.id("password")).sendKeys(senha);
		navegador.findElement(By.id("login-button")).click();
		
		return new InventarioPage(navegador);
	}
	
	public boolean getPaginaProdutos(){
		return navegador.getPageSource().contains("Products");
	}
	
	public void setSair(){
		navegador.quit();
	}
}
