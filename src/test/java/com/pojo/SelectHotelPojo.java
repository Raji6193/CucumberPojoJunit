package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class SelectHotelPojo extends LibGlobal {
	
	public SelectHotelPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement searchPage;
	
	public WebElement getSearchPage() {
		return searchPage;
	}
	public WebElement getBtnRadio() {
		return btnRadio;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}


}
