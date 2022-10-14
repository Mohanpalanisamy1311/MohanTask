package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BaseClass;

public class Attachment extends BaseClass{

	public Attachment() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='breadcrumbs']//li[2]")
	private WebElement patientName;
    @FindBy(xpath="//div[@class='att_file-name ng-hide']/following-sibling::p")
	private WebElement messageFile;
	
	@FindBy(xpath="//form[@id='visit-documents-dropzone']")
	private WebElement btnupload;

	@FindBy(xpath="//textarea[@placeHolder='Enter a caption']")
	private WebElement btncaption;

	@FindBy(xpath="//button[text()='Upload file']")
	private WebElement uploadbutton;
	
	public WebElement getBtnupload() {
		return btnupload;
	}
	
	
	
	public WebElement getBtncaption() {
		return btncaption;
	}


	



	public  void uploadFileCheck() throws InterruptedException, Throwable {
		
		uploadFile(System.getProperty("user.dir"+"\\uploadfile\\sampletoaster.txt"));
		enterText(btncaption, "SampleFile");
		uploadbutton.click();
		getMessageFile().click();
		patientName.click();
		System.out.println("Upload check is done ");
		
		
	}



	public WebElement getMessageFile() {
		return messageFile;
	}



	public WebElement getUploadbutton() {
		return uploadbutton;
	}
	
	
	
	
	
}
