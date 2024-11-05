package com.codetru.project.cica.testcases.sanityApplicationModule;
 
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import com.codetru.common.BaseTest;
import com.codetru.constants.FrameworkConstants;
import com.codetru.helpers.ExcelHelpers;

@Parameters({ "ROW_NUMBER" })
@Test
public class Login_NV extends BaseTest{
	@Parameters({ "ROW_NUMBER" })
	@Test
	public void TC_AppLogin(String rowNumber) throws Exception {
		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CICA_LOGIN, "Login");
		String row = rowNumber;
		int rowNum = Integer.parseInt(row);
		getLoginPage().loginSuccessWithAgentAccount(excel.getCellData(rowNum, "userid"),excel.getCellData(rowNum, "password"));
	}
}
