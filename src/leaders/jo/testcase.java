package leaders.jo;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void sutup() {
	//	driver.get("https://leaders.jo/en/lg/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@Test(enabled = false)
	public void onerandomitem () throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://leaders.jo/en/shop/?");
//	WebElement farmclose=driver.findElement(By.cssSelector(".attachment-large.size-large.wp-image-231968"))	;
//	WebElement close=driver.findElement(By.xpath("//span[@class=\"motta-svg-icon motta-svg-icon--close motta-popup__close\"]//*[name()=\"svg\"]"));
//		close.click();
		Thread.sleep(3000);
		WebElement allItem=driver.findElement(By.className("products"));
	List<WebElement >item=driver.findElements(By.className("product-inner"));
	Random rand=new Random();
		int RandomitemToSelect = rand.nextInt(item.size());
		item.get(RandomitemToSelect).click();
//		WebElement farmclose1=driver.findElement(By.cssSelector(".attachment-large.size-large.wp-image-231968"));
//		WebElement close1=driver.findElement(By.xpath("//span[@class=\"motta-svg-icon motta-svg-icon--close motta-popup__close\"]//*[name()=\"svg\"]"));
//			close1.click();
			Thread.sleep(3000);
		
		WebElement quantity =driver.findElement(By.className("input-text"));
        WebElement increaseQuantityButton = driver.findElement(By.cssSelector("form[class=\"cart\"] span[class=\"motta-svg-icon motta-svg-icon--plus motta-qty-button increase\"]"));
       // increaseQuantityButton.click();
        quantity.click();
CharSequence[] number= {"1","2","3"};
		int Randomqunatity = rand.nextInt(3);
		quantity.sendKeys(number);
		WebElement addtocart=driver.findElement(By.xpath("//button[@name=\"add-to-cart\"]"));
		addtocart.click();
		WebElement cart=driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div[1]/div/div[2]/div[2]/a")) ;
		cart.click();
		WebElement itemAdd=driver.findElement(By.className("widget_shopping_cart_subtotal"));
		String acual=itemAdd.getText();
		String acpextrd="add";
		Assert.assertEquals(acual, acpextrd);
	
	
	}
@Test(enabled = false)
public void singup ()
{driver.get("https://leaders.jo/en/my-account/#register");
WebElement email=driver.findElement(By.cssSelector("#reg_email"));
email.sendKeys("batool1@gmail.com");
WebElement password=driver.findElement(By.cssSelector("#reg_password"));
password.sendKeys("batool");
WebElement register=driver.findElement(By.cssSelector("button[value=\"Register\"]"));
register.click();
	WebElement Acual=driver.findElement(By.className("page-header__title"));
	String Acualtext=Acual.getText();
	String expected="my account";
Assert.assertEquals(Acualtext, expected);
driver.get("https://leaders.jo/en/my-account/edit-account/");

}

@Test(enabled = false)
public void screensectoin ()	{
	
//	select the screens section 
//	3- fillter the items based on the price from high to low 
//	4- make one assertion that the price of the first item is higher than the price of the last item 
	driver.get("https://leaders.jo/en/?s=samsung+screen&post_type=product&dgwt_wcas=1&lang=en");
	WebElement FILTER=driver.findElement(By.cssSelector("select[name=\"orderby\"]"));
	FILTER.click();
	WebElement HightoLow=driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/form/select/option[6]"));
	HightoLow.click();

	List<WebElement> Prices = driver.findElements(By.className("price"));

	int LowestPrice = 0;
	int HighestPrice = 0;

	for (int i1 = 0; i1 < Prices.size(); i1++) {

		LowestPrice = Integer.parseInt(Prices.get(0).getText());
		HighestPrice = Integer.parseInt(Prices.get(Prices.size() - 1).getText());

		Assert.assertEquals(HighestPrice > LowestPrice, true);
		

	}
	System.out.println(LowestPrice + " this is the lowest price ");
	System.out.println(HighestPrice + " this is the highest price ");


}
@Test(enabled = false)
public void login ()
{driver.get("https://leaders.jo/en/my-account/");
WebElement email=driver.findElement(By.cssSelector("#username"));
email.sendKeys("batool1@gmail.com");
WebElement password=driver.findElement(By.cssSelector("#password"));
password.sendKeys("batool");
WebElement register=driver.findElement(By.cssSelector("button[name=\"login\"]"));
register.click();}
@Test(priority = 2)
public void  signupprocess() throws IOException	{
	WebElement logout=driver.findElement(By.cssSelector("li[class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout\"] a"));
logout.click();
Date currentdate= new Date(0);
String thenae=currentdate.toString().replace(":", "");
TakesScreenshot src=((TakesScreenshot)driver);
File srcfile=src.getScreenshotAs(OutputType.FILE);
File destnation=new File("src/sreen/"+thenae+".png");
FileUtils.copyFile(srcfile, destnation);


}

@Test(priority = 1)

public void randomIphone()
{//	 go this website https://leaders.jo/en/buy-apple-products-online/
//		 2- select any random iphone ( must be random at each run ) 
//		 3- do one assertion that the color is matched with the color on the iphones page 
//		 4- add the item to the cart with one of the following quantity (1,3,6) 
//		 5- do one assetion that the item is added 
//		 6- take screenshout of the cart 
driver.get("https://leaders.jo/en/Brands/apple/");

List<WebElement> iphones = driver.findElements(By.cssSelector("product-inner")); // Update your_iphone_selector_here accordingly
Random rand = new Random();
WebElement selectedIphone = iphones.get(rand.nextInt(iphones.size()));
String expectedColor = "expected_color_attribute"; // Determine how you can get the color attribute or text
selectedIphone.click();
String actualColor = "actual_color_from_product_page"; // You need to fetch this from the product page
assert expectedColor.equals(actualColor) : "Color does not match";
int[] possibleQuantities = {1, 3, 6};
int selectedQuantity = possibleQuantities[rand.nextInt(possibleQuantities.length)];

WebElement quantityDropdown = driver.findElement(By.cssSelector("#quantity_660082bcadc6c")); 
Select quantitySelect = new Select(quantityDropdown);
quantitySelect.selectByValue(String.valueOf(selectedQuantity));

WebElement addToCartButton = driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt")); 
addToCartButton.click();


}
	@AfterTest
	public void enftest() {
	}}

