package com.test;

import org.openqa.selenium.By;

import com.pom.Attachment;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.PatientDetailPage;
import com.pom.RegistrationPage;
import com.pom.Vitals;
import com.pom.visits;
import com.util.BaseClass;

import junit.framework.Assert;

public class Test extends BaseClass  {

	public static void main(String[] args) throws  Throwable {
		
		browserLaunch("https://qa-refapp.openmrs.org/openmrs/login.htm");
		LoginPage lp=new LoginPage();
		
		lp.logintoTheApplication();
		Assert.assertTrue(" Home Page is Launched", driver.getCurrentUrl().contains("home"));
		System.out.println("Homepage is successfully launched ");
		HomePage hp=new HomePage();
		
		hp.clickingtheRegisterpatient();
		RegistrationPage rp=new RegistrationPage();
		
		rp.completeregistration();
		rp.verifythepatientInfo();
		PatientDetailPage pp=new PatientDetailPage();
		
		pp.verifyAge();
		pp.startvisiting();
		visits v = new visits();
		v.getAttachement().click();
		Attachment ap=new Attachment();

		ap.getBtnupload().click();
		ap.uploadFileCheck();
		PatientDetailPage pp1=new PatientDetailPage();
		pp1.attachmentCheck();
		pp1.recentVisitCheck();
		pp1.clickEndVisit();
		pp.startvisiting();
		v.clickvitals();
		Vitals vital=new Vitals();
		vital.BMICheck();

		
		
		
		
		
		
	}

}
