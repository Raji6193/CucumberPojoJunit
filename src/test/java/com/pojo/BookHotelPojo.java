package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class BookHotelPojo extends LibGlobal {
	public BookHotelPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[@class='login_title'])[2]")
	private WebElement hdgBookHotel;	
	@FindBy(id="first_name")
	private WebElement txtFirstname;
	@FindBy(id="last_name")
	private WebElement txtLastname;
	@FindBy(id="address")
	private WebElement txtAddress;
	@FindBy(id="cc_num")
	private WebElement txtCreditCardNum;
	@FindBy(id="cc_type")
	private WebElement dropDownCreditCardType;
	@FindBy(id="cc_exp_month")
	private WebElement dropDownExpiryMonth;
	@FindBy(id="cc_exp_year")
	private WebElement dropDownExpiryYear;
	@FindBy(id="cc_cvv")
	private WebElement txtCvvNum;
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
	public WebElement getTxtFirstname() {
		return txtFirstname;
	}
	public WebElement getTxtLastname() {
		return txtLastname;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getTxtCreditCardNum() {
		return txtCreditCardNum;
	}
	public WebElement getDropDownCreditCardType() {
		return dropDownCreditCardType;
	}
	public WebElement getDropDownExpiryMonth() {
		return dropDownExpiryMonth;
	}
	public WebElement getDropDownExpiryYear() {
		return dropDownExpiryYear;
	}
	public WebElement getTxtCvvNum() {
		return txtCvvNum;
	}
	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	public WebElement getHdgBookHotel() {
		return hdgBookHotel;
	}


}
