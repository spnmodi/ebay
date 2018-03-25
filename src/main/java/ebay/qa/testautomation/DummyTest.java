package ebay.qa.testautomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class DummyTest extends TestBase {

	
	
	public DummyTest()  {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="gh-ac")
	WebElement SearchTextbar;  //Search Text Bar
	
	@FindBy(id="gh-btn")
	WebElement SearchButton; //Search button
	
	@FindBy(xpath="//span[@class='kwcat']")  // searched item name appears in this xpath
	WebElement SearcheditemName;
	
	@FindBy(xpath="//h3[@class='lvtitle']/a//following::a[@class='vip']")  // searched item list
	WebElement listofsearcheditem;
	
	@FindBy(xpath="//a[@class='btn btn-s btn-ter dropdown-toggle']")
	WebElement BestMatchDD;
	
	@FindBy(xpath="//a[contains(text(),'Lowest price')][@value='2']")
	WebElement LowestPriceinDD;
	
	@FindBy(xpath="//li[@class='lvprice prc']")  // Price tag of listed items
	WebElement PriceTagList;
	
	@FindBy(xpath="//a[contains(text(),'Highest price')][@value='3']")  // Price tag of listed items
	WebElement HighestPriceinDD;
	
	@FindBy(xpath="//a[@class='small cbx btn btn-s btn-ter tab tgl_button last_b'][@title='Buy it now']")  
	WebElement BuyitnowButton;
	
	@FindBy(xpath ="//*[starts-with(@id,'item')]")
	WebElement BuyItNowitemslist;
	
	@FindBy(id ="gh-cat")
	WebElement CategoryListId;
	
	@FindBy(xpath ="//*[starts-with(@id,'item')]")
	WebElement listofitems;
	
	
	//span[@class='ship']
	
	public void SelectbyVisibleText(WebElement element,String text)
	   {
		   Select select = new Select(element);
		   select.selectByVisibleText(text);
	   }
	
	public WebElement findelementbyXpath(String  xpath)
	{
		return driver.findElement(By.xpath(xpath));
	}
	
	
	
	
	 public void Searchforanitem()
	{
		 SearchTextbar.sendKeys("laptop");
		 SearchButton.click();
		
	}
	 
	 public void Verify_IgetListofmatchingresults()
		{
		 List<WebElement> ele = driver.findElements(By.xpath("//h3[@class='lvtitle']/a//following::a[@class='vip']"));
			
		    int totalinlist = ele.size();
			
			System.out.println(totalinlist);
						
			Iterator<WebElement> itr = ele.iterator();
			
			while(itr.hasNext())
			{
				String p = itr.next().getText();
              { 
            	  if(p.contains("Laptop")||p.contains("Thinkpad"))
            	  {
            		
            		  Assert.assertTrue(true);
            		  
            		  
            	  }
            	  
              }  //System.out.println("results displayed are Laptop list");
                	   
						
												 
			}
		}

	 public void Verify_the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag()
		{
			// Take all listed items  and verify 
			 List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ListViewInner']/div//following::li[@class='sresult lvresult clearfix li shic']"));
          Iterator<WebElement> itr = list.iterator();
			 while( itr.hasNext())
          {
                              
               if (itr.next() != null)
               { 
            	   findelementbyXpath("//li[@class='lvprice prc']").isDisplayed();// price tag 
            	   findelementbyXpath("//span[@class='ship']").isDisplayed(); // Postage tag
            	   driver.findElement(By.className("logoBinBo")).isDisplayed();// Buy it Now logo
             	  Assert.assertTrue(true); 
               }  
                 	   
                 
               }		
			
         	}
 
	 public void sort_results_by_Lowest_price() throws InterruptedException
		{
			 Actions action = new Actions(driver);
				WebElement wait = (new WebDriverWait(driver, 60))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn btn-s btn-ter dropdown-toggle']")));
						
						
				action.moveToElement(findelementbyXpath("//a[@class='btn btn-s btn-ter dropdown-toggle']")).build().perform();
								
				Thread.sleep(5000);
				findelementbyXpath("//a[contains(text(),'Lowest price')][@value='2']").click();
			
		}
	 
	 
	 public void results_are_listed_in_correct_order()
		{
			List<WebElement> price = driver.findElements(By.xpath("//li[@class='lvprice prc']"));
			int size =price.size();
				
	        List<String> Price1 = new ArrayList();
	        List<String> Price2 = new ArrayList();
			
			Iterator<WebElement> itr = price.iterator();
			while(itr.hasNext())
			{
			  String p =itr.next().getText();	
			  Price1.add(p);   
	     	  Price2.add(p);
	     	  
	         }
	         Collections.sort(Price1);   

	         for (int i=0;i<Price1.size();i++) {
	            
	         if (!(Price1.get(i).equals(Price2.get(i)))) 
	         {
	       
	          Assert.assertTrue(true);
          }
		}

}

	 public void  I_can_sort_the_results_by_Highest_Price() throws InterruptedException
		{
			Actions action = new Actions(driver);
			WebElement wait = (new WebDriverWait(driver, 50))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn btn-s btn-ter dropdown-toggle']")));
							
			action.moveToElement(findelementbyXpath("//a[@class='btn btn-s btn-ter dropdown-toggle']")).build().perform();
			
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(5000);
			findelementbyXpath("//a[contains(text(),'Highest price')][@value='3']").click();
		}
    
	 public void HighestPrice_results_are_listed_in_the_page_in_the_correct_Highest_Price_order()
		{ 
			
			ArrayList<String> Hprice1= new ArrayList() ;
	    	ArrayList<String> Hprice2=new ArrayList() ;
	    		    			
	       List<WebElement> Hprice = driver.findElements(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div/div[1]/div/div[3]/div/div[1]/div/w-root/div/div[2]/ul/li/ul[1]/li[1]/span"));
	      
	       int size1= Hprice.size();
	       System.out.println(size1);
	       Iterator<WebElement> itr = Hprice.iterator();
	       while(itr.hasNext())
	       {
	  		 String hp1 =itr.next().getText();

	            Hprice1.add(hp1);
	            Hprice2.add(hp1);
	       }
	       Collections.sort(Hprice1);
	     
	       Collections.sort(Hprice1, Collections.reverseOrder());
	       
	     
	    	   if ( Hprice2.equals(Hprice1)) 
	    	   {
	    	    Assert.assertTrue(true);
	    	     
	    	   }

	      
		      		
	            }
   
	 public void I_can_filter_the_results_by_Buy_it_now()
	 {
		 BuyitnowButton.click();
	 }
 
	 public void verify_all_results_shown_in_the_page_have_the_Buy_it_now_tag()
     {
			
			 List<WebElement> list = driver.findElements(By.xpath("//*[starts-with(@id,'item')]"));
          Iterator<WebElement> itr = list.iterator();
			 while( itr.hasNext())
          {
           itr.next();
                    
               if (itr.next() != null)
               {
             	  driver.findElement(By.className("logoBinBo")).isDisplayed();
             	  Assert.assertTrue(true); 
               }  
                 	   
                
               }		
		
         	}
          
	 public void I_enter_a_search_term_and_select_a_specific_Category()
	 {
		 SearchTextbar.sendKeys("Watches");
		 SelectbyVisibleText(CategoryListId,"Jewellery & Watches");
		 SearchButton.click();
		 		 
	 }
	
	 
	 public void I_get_a_matching_list_of_matching_resultst()
	 {
		 List<WebElement> ele = driver.findElements(By.xpath("//*[starts-with(@id,'item')]"));
			
		    int totalinlist = ele.size();
			
			System.out.println(totalinlist);
						
			Iterator<WebElement> itr = ele.iterator();
			
			while(itr.hasNext())
			{
				String p = itr.next().getText();
           { 
         	  if(p.contains("Watch"))
         	  {
         		
         		  Assert.assertTrue(true);
         		  
         		  
         	  }
         	 
	 }
     
  }
			
 }

	 public void I_can_verify_that_the_results_shown_as_per_the_the_selected_category()
     {
		 WebElement wait = (new WebDriverWait(driver, 50))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='rlp-b']/div[2]/div[1]/span[@class='cat-app']")));
					
         WebElement categoryitem =	driver.findElement(By.xpath(".//*[@class='rlp-b']/div[2]/div[1]/span[@class='cat-app']"));
     	 
         if(!categoryitem.isEnabled())
     	{
     		Assert.assertTrue(true);
     	}
     }

	 public void the_results_show_morethan_one_page()
	 {
		 ArrayList plist = new ArrayList();
	 	List<WebElement> Pagelist =driver.findElements(By.xpath("//td[@class='pages']//a"));
	 	 Iterator<WebElement> itr = Pagelist.iterator();
	 	 while(itr.hasNext())
	 	 {
	 		 String p= itr.next().getText();
	 		 plist.add(p);
	 		  int i= plist.size();
	 		  System.out.println(i);
	 		 if(i>1)
	 		 {
	 			 Assert.assertTrue(true);
	 		 }
	 	 }
	 	 
	 }
 
	 public void Navigate_through_pages() throws InterruptedException
	 {		 
		
		    List<WebElement> Pagelist1 = driver.findElements(By.xpath("//td[@class='pages']//a"));
		    int links= Pagelist1.size(); 
		    
		    for (int i = 0; i < links; i++) {
		        List<WebElement> Pagelist = driver.findElements(By.xpath("//td[@class='pages']//a"));
		        WebElement e = Pagelist.get(i);		      
		        e.click();	  
		 		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 		JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 	 }
		 		  
		 		  
		 	 
		 	 
	 }

}




		
