package com.stepdefinition;

import org.junit.Assert;

import com.base.LibGlobal;
import com.pojo.BookHotelPojo;
import com.pojo.LoginPojo;
import com.pojo.OrderNumberPojo;
import com.pojo.SearchHotelPojo;
import com.pojo.SelectHotelPojo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends LibGlobal{
	
	LoginPojo lp=new LoginPojo();
	SearchHotelPojo searchHp = new SearchHotelPojo();
	SelectHotelPojo selectHp = new SelectHotelPojo();
	BookHotelPojo bookHp=new BookHotelPojo();
	OrderNumberPojo onp=new OrderNumberPojo();
	
	@Given("User launches Adactin Web Application")
	public void user_launches_Adactin_Web_Application() {
		launchUrl("http://adactinhotelapp.com/");
	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {
		sendkeys(lp.getUsername(), "Raji6193");
		sendkeys(lp.getPassword(), "Raji6193");
	}

	@And("User clicks Login button")
	public void user_clicks_Login_button() {
		btnClick(lp.getLoginBtn());
	}

	@Then("User verify Home page is displayed")
	public void user_verify_Home_page_is_displayed() {
		String headingHome = lp.getHdgHome().getText();
		System.out.println(headingHome);
		Assert.assertTrue(headingHome.contains("Search Hotel"));
	}

	@When("User enters valid location, Hotel, Room Type, Number of Rooms, check in date, check out date, Adults count and children count")
	public void user_enters_valid_location_Hotel_Room_Type_Number_of_Rooms_check_in_date_check_out_date_Adults_count_and_children_count() {
		selectByVisibleTextDropDown(searchHp.getDropdownLocation(), "New York");
		selectByVisibleTextDropDown(searchHp.getDropdownHotel(), "Hotel Sunshine");
		selectByVisibleTextDropDown(searchHp.getDropdownRoomType(), "Deluxe");
		selectByVisibleTextDropDown(searchHp.getDropdownRoomNos(), "3 - Three");
		sendkeys(searchHp.getTxtCheckInDate(), "10/20/2022");
		sendkeys(searchHp.getTxtCheckOutDate(), "10/25/2022");
		selectByVisibleTextDropDown(searchHp.getDropdownAdultCount(), "2 - Two");
		selectByVisibleTextDropDown(searchHp.getDropdownChildCount(), "2 - Two");
	}

	@And("User clicks search")
	public void user_clicks_search() {
		btnClick(searchHp.getBtnSearch());
	}

	@Then("User verify Select hotel page is displayed")
	public void user_verify_Select_hotel_page_is_displayed() {
		String headingSelect = selectHp.getSearchPage().getText();
		System.out.println(headingSelect);
		Assert.assertTrue(headingSelect.contains("Select Hotel"));
	}

	@And("User clicks Select button")
	public void user_clicks_Select_button() {
		btnClick(selectHp.getBtnRadio());
	}

	@And("User clicks Continue button")
	public void user_clicks_Continue_button() {
		btnClick(selectHp.getBtnContinue());
	}

	@When("User enters FirstName, LastName, BillingAddress, CreditCardNumber, CreditCardType, ExpiryDate and CVV number")
	public void user_enters_FirstName_LastName_BillingAddress_CreditCardNumber_CreditCardType_ExpiryDate_and_CVV_number() {

		scrollDownUsingJs(bookHp.getTxtCvvNum());
		sendkeys(bookHp.getTxtFirstname(), "abc");
		sendkeys(bookHp.getTxtLastname(), "def");
		sendkeys(bookHp.getTxtAddress(), "xyz,123");
		sendkeys(bookHp.getTxtCreditCardNum(), "1234567812345678");
		selectByVisibleTextDropDown(bookHp.getDropDownCreditCardType(), "Master Card");
		selectByVisibleTextDropDown(bookHp.getDropDownExpiryMonth(), "December");
		selectByVisibleTextDropDown(bookHp.getDropDownExpiryYear(), "2022");
		sendkeys(bookHp.getTxtCvvNum(), "123");
	}

	@And("User clicks Book now button")
	public void user_clicks_Book_now_button() {
		btnClick(bookHp.getBtnBookNow());
	}

	@Then("User verify Booking confirmation page is displayed")
	public void user_verify_Booking_confirmation_page_is_displayed() throws InterruptedException {
//		By txtOrderNo = By.id("order_no");
//		explicitWait(txtOrderNo);
		Thread.sleep(10000);
		String headingConfirm = onp.getHdgConfirmation().getText();
		System.out.println(headingConfirm);
		Assert.assertTrue(headingConfirm.contains("Booking Confirmation"));
	}

	@Then("User verify Order number is displayed")
	public void user_verify_Order_number_is_displayed() {		
		explicitWait(onp.getTxtOrderNo());
		scrollDownUsingJs(onp.getTxtOrderNo());
		String textValue = getAttributeValue(onp.getTxtOrderNo(),"value");
		System.out.println(textValue);	
	}

	@Then("User verify Book Hotel page")
	public void user_verify_Book_Hotel_page() {
		String headingBook = bookHp.getHdgBookHotel().getText();
		System.out.println(headingBook);
		Assert.assertTrue(headingBook.contains("Book A Hotel"));
	}

	@When("User enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String userName, String password) {
		sendkeys(lp.getUsername(), userName);
		sendkeys(lp.getPassword(), password);
	}

	@When("User selects valid {string}, {string}, {string}, {string}, enters valid {string}, {string}, selects valid {string} and {string}")
	public void user_selects_valid_enters_valid_selects_valid_and(String location, String hotel, String roomType,
			String roomNos, String checkInDate, String checkOutDate, String adultCount, String childCount) {
		
		selectByVisibleTextDropDown(searchHp.getDropdownLocation(), location);
		selectByVisibleTextDropDown(searchHp.getDropdownHotel(), hotel);
		selectByVisibleTextDropDown(searchHp.getDropdownRoomType(), roomType);
		selectByVisibleTextDropDown(searchHp.getDropdownRoomNos(), roomNos);
		sendkeys(searchHp.getTxtCheckInDate(), checkInDate);
		sendkeys(searchHp.getTxtCheckOutDate(), checkOutDate);
		selectByVisibleTextDropDown(searchHp.getDropdownAdultCount(), adultCount);
		selectByVisibleTextDropDown(searchHp.getDropdownChildCount(), childCount);
	}

	@When("User enters {string}, {string}, {string}, {string} selects valid {string}, {string}, {string} and enters valid {string}")
	public void user_enters_selects_valid_and_enters_vali(String firstName, String lastName, String address,
			String creditCardNo, String creditcardType, String expiryMonth, String expiryYear, String cvvNumber) {
		
		scrollDownUsingJs(bookHp.getTxtCvvNum());
		sendkeys(bookHp.getTxtFirstname(), firstName);
		sendkeys(bookHp.getTxtLastname(), lastName);
		sendkeys(bookHp.getTxtAddress(), address);
		sendkeys(bookHp.getTxtCreditCardNum(), creditCardNo);
		selectByVisibleTextDropDown(bookHp.getDropDownCreditCardType(), creditcardType);
		selectByVisibleTextDropDown(bookHp.getDropDownExpiryMonth(), expiryMonth);
		selectByVisibleTextDropDown(bookHp.getDropDownExpiryYear(), expiryYear);
		sendkeys(bookHp.getTxtCvvNum(), cvvNumber);
	}


	

}
