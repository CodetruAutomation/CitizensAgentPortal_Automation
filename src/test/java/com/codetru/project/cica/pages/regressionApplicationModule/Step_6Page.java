package com.codetru.project.cica.pages.regressionApplicationModule;

import static com.codetru.keywords.WebUI.getTextElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codetru.keywords.WebUI;
import com.codetru.utils.DataGenerateUtils;

public class Step_6Page {

	private By NextStep6 = By.xpath("//h3[text()='Health Questions ']/following::ion-row/ion-col[@size='24' and @size-md='6']/ion-button");
	private By Error_HealthQuestions_1 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[1]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_2 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[2]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_3 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[3]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_4 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[4]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_5 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[5]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_6 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[6]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_7 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[7]/ion-row/ion-col[@class='md hydrated']");
	private By Error_HealthQuestions_8 = By.xpath("//div[@class='block-info-app' and @style='margin-top: 20px; margin-bottom: 20px;' ]/div[8]/ion-row/ion-col[@class='md hydrated']");
	

	
	private By no_physician = By.xpath("//ion-checkbox[@formcontrolname='PhysicianNameCheckbox']");
	private By Error_NoPhysicanCheckBox = By.xpath("//ion-input[@formcontrolname='PhysicianName']/parent::ion-item/parent::ion-col");
	private By Physician_textbox = By.xpath("//ion-input[@formcontrolname='PhysicianName']/input");
	private By Popup_Ok_Button = By.xpath("//span[text()='Ok']/parent::button");
	
	//In Case of Extra Health Question Radio Button
	private By HealthQuestions_No_RadioButtons = By.xpath("//h3[text()='Health Questions ']/following::div[@class='block-info-app']/div/ion-row/ion-col//ion-col/ion-item/ion-label[text()='No']/following-sibling::ion-radio");

	

	public void Predetermination_Questions() {

		String mandatoryError = "Please enter a value.";
		String physicianMaxChar = "qwertyuiop asdfghjkl zxcvbnm poiuytrewq lkjhgfdsa mnbvcxz zxcvbnm lkjhgfdsa qwertyuiop poiuytrewq asdfghjkl";
		String physicianMaxCharError = "The maximum number of characters is 90.";
		
		WebUI.sleep(1);
		WebUI.moveToElement(NextStep6);
		WebUI.sleep(0.2);
		WebUI.clickElement(NextStep6);

		WebUI.scrollToElementAtTop(Error_HealthQuestions_1);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_1);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_1), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_2);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_2);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_2), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_3);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_3);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_3), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_4);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_4);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_4), mandatoryError);

		WebUI.scrollToElementAtBottom(Error_HealthQuestions_5);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_5);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_5), mandatoryError);
		WebUI.sleep(0.2);
		
		WebUI.scrollToElementAtBottom(Error_HealthQuestions_6);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_6);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_6), mandatoryError);
		
		WebUI.scrollToElementAtBottom(Error_HealthQuestions_7);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_7);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_7), mandatoryError);
		
		WebUI.sleep(0.2);
		WebUI.scrollToElementAtBottom(no_physician);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(no_physician);
		
		WebUI.scrollToElementAtBottom(Error_HealthQuestions_8);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(Error_HealthQuestions_8);
		WebUI.verifyContains(WebUI.getTextElement(Error_HealthQuestions_8), mandatoryError);
		WebUI.sleep(1);
			
			List<WebElement> HQ_No_Buttons = WebUI.getWebElements(HealthQuestions_No_RadioButtons);
			for(WebElement HQ_No_Button : HQ_No_Buttons)
			{
				WebUI.scrollToElementAtBottom(HQ_No_Button);
				WebUI.sleep(0.2);
				HQ_No_Button.click();
			}
//		}
		

		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.verifyElementVisible(NextStep6);

		WebUI.verifyContains(getTextElement(Error_NoPhysicanCheckBox).trim(), mandatoryError);
		WebUI.setText(Physician_textbox, physicianMaxChar);
		WebUI.verifyElementVisible(Error_NoPhysicanCheckBox);
		WebUI.verifyContains(getTextElement(Error_NoPhysicanCheckBox), physicianMaxCharError);
		
		WebUI.clearAndFillText(Physician_textbox, DataGenerateUtils.randomFirstName()+" "+DataGenerateUtils.randomLastName()+" "+DataGenerateUtils.randomShortAddress());
		WebUI.sleep(0.5);
		WebUI.clickElement(no_physician);

		WebUI.scrollToElementAtBottom(NextStep6);
		WebUI.sleep(0.2);
		WebUI.moveToElement(NextStep6);
		WebUI.clickElement(NextStep6);
		WebUI.sleep(1);
		
/*		//Select 'Yes' in any of the HealthQuestions flow
		WebUI.sleep(1);
		WebUI.verifyElementVisible(Popup_Ok_Button);
		WebUI.clickElement(Popup_Ok_Button);
		WebUI.sleep(1);
		
		//Move to Step-1, select the plan, click on Calculate and click Next
		WebUI.verifyElementVisible(step_1_Page);
		WebUI.scrollToElementAtTop(plan);
		WebUI.selectOptionByIndex(plan, 1);
		WebUI.scrollToElementAtBottom(calculate);
		WebUI.sleep(0.2);
		WebUI.clickElement(calculate);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(Nextstep_1);
		WebUI.moveToElement(Nextstep_1);
		WebUI.clickElement(Nextstep_1);
//*/	

		
	}
}
