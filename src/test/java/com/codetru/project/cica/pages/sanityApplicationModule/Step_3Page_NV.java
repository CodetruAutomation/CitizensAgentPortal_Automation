package com.codetru.project.cica.pages.sanityApplicationModule;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class Step_3Page_NV extends CommonPageCICA {
	
	private By noRadioBtn = By.xpath("//ion-item/ion-label[.='No']/following-sibling::ion-radio[@value='false']");
	private By NextStep3 = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By step3_Yes = By.xpath("//h3[.='Policy Owner Information']/parent::div/descendant::ion-radio-group/ion-row/ion-col//ion-label[.='Yes']/following-sibling::ion-radio");
	private By step3_No = By.xpath("//h3[.='Policy Owner Information']/parent::div/descendant::ion-radio-group/ion-row/ion-col//ion-label[.='No']/following-sibling::ion-radio");
	private By policyPayor_No = By.xpath("//h3[.='Policy Payor Information']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By secondaryAddresseeDesg_No = By.xpath("//h3[.='Secondary Addressee Designation']/parent::div/descendant::ion-label[.='No']/following-sibling::ion-radio");
	private By step_1 = By.xpath("//span[.='Step 1: Product Information']");
	private By calculate = By.xpath("(//div/ion-row/ion-col/ion-button[starts-with(@class, md)])[2]");
	private By step_1_NextB = By.xpath("//p[.='Is Automatic Premium Loan Desired?']/parent::div/parent::ion-col/parent::ion-row/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By TableOfContent = By.xpath("//h3[.='Policy Owner Information']/parent::div/following-sibling::ion-row[@style='padding-left: 50px;']/ion-col[@size-md='18']/ion-button[.='Table of Contents']");
	private By impNotice_Popup = By.xpath("//ion-backdrop/following-sibling::div/div/following-sibling::div/button");
	private By NextStep2 = By.xpath("//h3[.='Contact Information']/parent::div/following-sibling::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	
	public void Policy_Owner_Information() {

		WebUI.sleep(2.5);
		WebUI.scrollToElementAtBottom(TableOfContent);
		WebUI.sleep(0.5);
		WebUI.moveToElement(TableOfContent);
		WebUI.clickElement(TableOfContent);
		WebUI.sleep(1);
		WebUI.clickElementWithJs(step_1);
		WebUI.sleep(1.5);
		// For Notice Popup
		try {
			DriverManager.getDriver().findElement(impNotice_Popup).isDisplayed();
			WebUI.sleep(0.5);
			WebUI.clickElement(impNotice_Popup);
 
		} catch (Exception ex) {
			System.out.println("Notice Popup Did Not Appear. " + ex.getMessage());
		}
 
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(calculate);
		WebUI.sleep(0.2);
		WebUI.clickElement(calculate);
		WebUI.sleep(0.2);
 
		WebUI.scrollToElementAtBottom(step_1_NextB);
		WebUI.sleep(0.2);
		WebUI.moveToElement(step_1_NextB);
		WebUI.clickElement(step_1_NextB);
		
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(NextStep2);
		WebUI.sleep(0.2);
		WebUI.moveToElement(NextStep2);
		WebUI.clickElement(NextStep2);
		WebUI.sleep(1);
		
//=======================================================================================================
		WebUI.sleep(1);
		WebUI.clickElement(step3_No);
		WebUI.sleep(0.5);

		try {

			DriverManager.getDriver().findElement(policyPayor_No).isDisplayed();
			WebUI.sleep(0.2);
			WebUI.clickElement(policyPayor_No);
			WebUI.sleep(0.5);

		} catch (Exception ex) {

			System.out.println("Policy Payor Information Not Available. " + ex.getMessage());

			try {
				DriverManager.getDriver().findElement(secondaryAddresseeDesg_No).isDisplayed();
				WebUI.sleep(0.2);
				WebUI.clickElement(secondaryAddresseeDesg_No);
				WebUI.sleep(0.5);
			} catch (Exception ex1) {
				System.out.println("Secondary Addressee Option Not Available.");
			}
		}

		WebUI.scrollToElementAtBottom(NextStep3);
		WebUI.sleep(0.5);
		WebUI.moveToElement(NextStep3);
		WebUI.clickElement(NextStep3);
		WebUI.sleep(2);

	}

}
