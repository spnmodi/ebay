package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import TestBase.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.qa.testautomation.DummyTest;



public class SearchResultSteps extends TestBase {
	
	DummyTest dummytest;
	@After
	public void teardown()
	{
		driver.close();
	}
	
	@Given("^I am a non-registered customer$")
	public void I_am_non_registered_customer()
	{
		
	}
  
   @Given("^I navigate to www\\.ebay\\.co\\.uk$")
   public void I_navigate_to_www_ebay_co_uk()
   {
	   initialization();
   }

   @When("^I search for an item$") 
  public void I_Search_for_an_item()
{ 
	    dummytest = new DummyTest();
	    dummytest.Searchforanitem();
}



@Then("^I get a list of matching results$")
public void I_get_a_list_of_matching_results()
{ 
	     dummytest = new DummyTest();
	     dummytest.Verify_IgetListofmatchingresults();
}


@Then("^the resulting items cards show: postage price, No of bids, price or show BuyItNow tag$")
public void the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag()
{
	     dummytest = new DummyTest();
		 dummytest.Verify_the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag();
	}
	


@Then("^I can sort the results by Lowest Price$")
public void I_can_sort_the_results_by_Lowest_Price() throws InterruptedException
{
	     dummytest = new DummyTest();
	     dummytest.sort_results_by_Lowest_price();
}

@Then("^the results are listed in the page in the correct order$")
public void the_results_are_listed_in_the_page_in_the_correct_order()
{
	    dummytest = new DummyTest();
	    dummytest.results_are_listed_in_correct_order();
} 

@Then("^I can sort the results by Highest Price$")
public void I_can_sort_the_results_by_Highest_Price() throws InterruptedException
{

	dummytest = new DummyTest();
	dummytest.I_can_sort_the_results_by_Highest_Price();
} 

@Then("^the HighestPrice results are listed in the page in the correct order$")
public void the_HighestPrice_results_are_listed_in_the_page_in_correctorder()
{
	dummytest = new DummyTest();
	dummytest.HighestPrice_results_are_listed_in_the_page_in_the_correct_Highest_Price_order();
}

@Then("^I can filter the results by 'Buy it now'$")
public void I_can_filter_the_results_by_Buy_it_now()
{
	dummytest = new DummyTest();
	dummytest.I_can_filter_the_results_by_Buy_it_now();
}

   

@Then("^all the results shown in the page have the 'Buy it now' tag$")
public void all_the_results_shown_in_the_page_have_the_Buy_it_now_tag()
{
	dummytest = new DummyTest();
	dummytest.verify_all_results_shown_in_the_page_have_the_Buy_it_now_tag();
}

@When("^I enter a search term and select a specific Category$")
public void I_enter_a_search_term_and_select_a_specific_Category()
{
	dummytest = new DummyTest();
	dummytest.I_enter_a_search_term_and_select_a_specific_Category();
}

@When("^I get a matching list of matching results$")
public void I_get_a_matching_list_of_matching_resultst()
{
	dummytest = new DummyTest();
	dummytest.I_get_a_matching_list_of_matching_resultst();
}

@Then("^I can verify that the results shown as per the the selected category$")
public void I_can_verify_that_the_results_shown_as_per_the_the_selected_category()
{
	dummytest = new DummyTest();
	dummytest.I_can_verify_that_the_results_shown_as_per_the_the_selected_category();

}
@Then("^the results show more than one page$")
public void the_results_show_morethan_one_page()
{
	dummytest = new DummyTest();
	dummytest.the_results_show_morethan_one_page();
}

@Then("^the user can navigate through the pages to continue looking at the items$") 
public void Navigate_through_pages() throws InterruptedException
{
	dummytest = new DummyTest();
	dummytest.Navigate_through_pages();
}


	

}
