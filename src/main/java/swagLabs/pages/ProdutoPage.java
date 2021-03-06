package swagLabs.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage extends BasePage{

	public ProdutoPage(WebDriver navegador) {
		super(navegador);
	}

	public void setEscolherUmProdutoAleatorio(){
		Random escolhido = new Random();
		
		List<WebElement> elements = navegador.findElements(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"]"));
		
		System.out.println("Total de itens -> " + elements.size());
		System.out.println("Index escolhido -> " + escolhido.nextInt(elements.size()));
		System.out.println("valor de item escolhido -> " + elements.get(escolhido.nextInt(elements.size())));
			
		//escolhendo um produto de forma aleatória
		elements.get(escolhido.nextInt(elements.size())).click();
	
	}
	
	public void setClicarCarrinho(){
		navegador.findElement(By.id("shopping_cart_container")).click();

	}
	
	
}
