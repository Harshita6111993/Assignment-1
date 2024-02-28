package FunctionalProgramming;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RetrieveLinks {

	public static void main(String[] args) 
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.flipkart.com/");
	    
		
	    List<WebElement> alllinks = driver.findElements(By.tagName("a"));
	    System.out.println("Total links are : " +alllinks.size());

	    //1. Using for loop
	    
	    for (int i=0; i<alllinks.size(); i++) 
	    {
	    //Actual link
	    	System.out.println("Links on page are : " +alllinks.get(i).getAttribute("href"));
	    	
	    //Visible text if any
	    	System.out.println("Links on page are : " +alllinks.get(i).getText());
	    }
 
	    
	    //2. Using for each loop
	    for (WebElement li : alllinks)
	    {
	    	System.out.println(li.getText()+" - "+li.getAttribute("href"));
	    }

	    
	    //3. Using lambda expression
	    
	    alllinks.forEach(ele -> System.out.println(ele.getText()));
	    
	    //4. Using streams
	    
	    List<String> collectList = alllinks
	    		.stream()
	    		.filter(ele -> !ele.getText().equals(""))
	    		.map(ele -> ele.getText())
	    		.collect(Collectors.toList());
	    
	    collectList.forEach(ele -> System.out.println(ele));
	    
	    //5. Using parallel streams
	    
	    alllinks.stream().map(ele -> ele.getAttribute("href")).forEach(System.out::println);
	    	    
	    driver.quit();
	    
	}

}
