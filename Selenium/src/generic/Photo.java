package generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photo implements Auto_constant {
	
	public void pics(WebDriver driver) throws IOException  {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest = new File(photopath);
		FileUtils.copyFile(src, dest);
		}
	
}
