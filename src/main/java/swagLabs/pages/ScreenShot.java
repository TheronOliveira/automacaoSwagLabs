package swagLabs.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShot extends BasePage{
	WebDriver navegador;
	
	public ScreenShot(WebDriver navegador) {
		super(navegador);
	}
	
	public static void tirarFoto(WebDriver navegador) throws IOException {
		
		File scrFile = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
	
        FileUtils.copyFile(scrFile, new File("src/test/resources/scheenShot/image.png"));
		/*
		System.out.println(scrFile);
		
		try {
			FileUtils.copyFile(scrFile, new File("C:\\image.png"));
		} catch (IOException e) {
			System.out.println("Erro -> " + e.getMessage());
		}*/
	}
}
