package swagLabs;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SwagLabs {
	
	private WebDriver navegador;
	
	@Before
	public void beforeLogin(){
		//definindo o local onde está o exe do chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SempreIT\\Documents\\Testes de Software\\chrome-driver\\chromedriver.exe");
		
		this.navegador = new ChromeDriver();
		
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		navegador.manage().window().maximize();
		
		navegador.get("https://www.saucedemo.com/");
	}
	
	@Test
	//todo método de test tem que ser publico (public) e sem retorno (void)
	public void testlogin(){

		navegador.findElement(By.id("user-name")).sendKeys("standard_user");
		navegador.findElement(By.id("password")).sendKeys("secret_sauce");
		navegador.findElement(By.id("login-button")).click();
		
		
		List<WebElement> elements = navegador.findElements(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"]"));
		
		Random escolhido = new Random();
		
		System.out.println();
		System.out.println(elements.size());
		System.out.println(escolhido.nextInt(elements.size()));
		
		
		System.out.println(elements.get(escolhido.nextInt(elements.size())));
		
		//escolhendo um produto de forma aleatória
		elements.get(escolhido.nextInt(elements.size())).click();
		
		//clicando no carrinho
		navegador.findElement(By.id("shopping_cart_container")).click();
		
		navegador.findElement(By.id("checkout")).click();
		
		//preenchendo as informações do usuario
		navegador.findElement(By.id("first-name")).sendKeys("teste");
		navegador.findElement(By.id("last-name")).sendKeys("automação");
		navegador.findElement(By.id("postal-code")).sendKeys("teste01");
		
		navegador.findElement(By.id("continue")).click();
		
		navegador.findElement(By.id("finish")).click();
		
		System.out.println(navegador.findElement(By.className("complete-header")).getText());
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", navegador.findElement(By.className("complete-header")).getText());
		
		
	//	for (WebElement element : elements){
			
	//		System.out.println(element);
	//}

	}

	@After
	public void afterLogin(){
		navegador.quit();
	}
}
