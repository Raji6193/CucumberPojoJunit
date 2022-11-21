package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class OrderNumberPojo extends LibGlobal{
	
	public OrderNumberPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement txtOrderNo;
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement hdgConfirmation;

	public WebElement getHdgConfirmation() {
		return hdgConfirmation;
	}

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

}
