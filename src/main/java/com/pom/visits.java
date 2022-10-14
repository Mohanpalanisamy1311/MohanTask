package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BaseClass;

public class visits extends BaseClass {

	public visits() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=' Attachments']")
	private WebElement attachement;
	public WebElement getAttachement() {
		return attachement;
	}
	
	@FindBy(xpath="//a[@id='referenceapplication.realTime.vitals']")
	private WebElement capturevitals;
	public WebElement getCapturevitals() {
		return capturevitals;
	} 
	

	
	public  void clickvitals() {
		clickElement(capturevitals);

	}
	
}
