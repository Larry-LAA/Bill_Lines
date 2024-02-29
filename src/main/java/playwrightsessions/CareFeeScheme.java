package playwrightsessions;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;




public class CareFeeScheme{
	public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://portal.stg.legalservices.gov.uk/oam/server/obrareq.cgi?encquery%3D8hY3CSnwcjHNxpX222OXS6DlLVW9WJmy%2FiMh4W3NXnqm4Ux%2FBEuBqmI4hISf%2BTrQQof7umYUajiWR7ntMa3S4LfzGf%2FpFw0TY%2FGqIbwRIyA8tW07znSMVFhLrjRjScUAP7AIY7td%2BYBceU%2F%2FPG3tNH%2BBJvgyOR41%2FQjWrat31yIZ%2FS5uQ80XEZ7moCko6YMhvUzokClZa2LmL8gnGcUY23DtqqGEsAZZscP6ICqb%2Br%2FPABDLWEM34zMz1M9NjDaDKvp6WzhrIGAeWEeYMJSW9LzawhWXUVvBP9iKphqOqsDuf2VMszRpCuPtCcXagrSIyxKPIbs6B4mAi1lULGIMNMA77ozHK9X%2F7FqWG0FDQ3Y%3D%20agentid%3DWebgateAgent11g_1%20ver%3D1%20crmethod%3D2%26cksum%3Dddf7b2dd14142328c129334bb0e27587a6512f4c&ECID-Context=1.00638fz9OAnEOPc5PjO5yd0004Gv0000yf%3BkXjE");
		      
		      page.getByLabel("Username:").fill("penny.wall@switalskis.com");
		      page.getByLabel("Password:").click();
		      page.getByLabel("Password:").fill("Digital123");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
		      
		      Page page1 = page.waitForPopup(() -> {
		        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Client and Cost Management System").setExact(true)).click();
		      });
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cases and Applications")).click();
		      page1.locator("#searchCase_lscCaseReference").click();
		      
		      page1.locator("#searchCase_lscCaseReference").click();
		      page1.locator("#searchCase_lscCaseReference").fill("300001601684");
		      //page1.selectOption("#searchCase_officeKeyDisplayValue", "85391|SWITALSKI'S SOLICITORS LTD-0P322F");
		      page1.locator("#searchCase_lscCaseReference").fill("300001601684");
		      //Locator providerOffice = page1.locator("#searchCase_officeKeyDisplayValue");
		      //providerOffice.selectOption("1");
		      
		      page1.selectOption("#searchCase_actualStatus", "LIVE");
		      
		      //ClickSearchForCase
		      page1.locator("input[name='RoofAction_action=searchCase#save=true#validate=true']").click();
		      
		      //OpenCaseRefNumber
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("300001601684")).click();
		      
		      //selectBilling
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Billing")).click();
		      
		      //DeleteDraftBill
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Delete")).click();
		      page1.getByText("Confirm", new Page.GetByTextOptions().setExact(true)).click();
		      
		      //CreateNewBill
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create Bill")).click();
		      
		      //clickIntoBillDetails
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bill details")).click();
		      

		      //selectBillType
		      page1.selectOption("#opmCtl0", "Solicitor Final");
		      page1.locator(".opa-submit").click();
		      
		      //Payment On Account (POA) Recoupment
		      //page1.locator(".opa-submit").click();
		      
		      //Client Has A Financial Interest
		      page1.locator("(//div[@role='radio'])[2]").click();		      
		      page1.locator(".opa-submit").click();

		      //Court Assessed Bills
		      page1.locator("(//div[@role='radio'])[2]").click();
		      page1.locator("(//div[@role='radio'])[3]").click();
		      page1.locator(".opa-submit").click();
		      
		      //Multiple Fee Scheme Bills
		      page1.locator("(//div[@role='radio'])[2]").click();
		      page1.locator("(//div[@role='radio'])[4]").click();
		      page1.locator(".opa-submit").click();
		      
		      //Court Type
		      page1.getByLabel("Court type").selectOption("High court");
		      page1.locator(".opa-submit").click();
		      
		      //Work in Lower & Higher courts
		      page1.locator("(//div[@role='radio'])[2]").click();
		      page1.locator(".opa-submit").click();
		      
		   
		

	          //Care Hourly Rate Bill Line
	            
	            page1.locator("//input").nth(0).fill("20/02/2024");
			    page1.locator("//select").nth(0).selectOption("Attendance upon solicitor (Time)");
			    page1.waitForTimeout(3000);
	            page1.locator("//input").nth(1).fill("01:00");
	            page1.locator("//select").nth(1).selectOption("20%");
	            page1.locator("//input").nth(3).fill("LG1");
	            
	            
	 		   // Define the number of iterations for the loop
	 	       

	 	       for (int i = 0; i <= 200; i++) {
	 	  
	 	    	   page1.locator(".opa-row-add").click();	
	 	    	   page1.locator("//input").nth(4 * i).fill("20/02/2024");
	 	    	   page1.locator("//select").nth(2 * i).selectOption("Attendance upon solicitor (Time)");
	 	    	   page1.waitForTimeout(6000);
	 	    	   page1.locator("//input").nth((4 * i)+ 1).fill("01:00");
	 	    	   page1.locator("//select").nth((2 * i) + 1).selectOption("20%");
	 	    	   page1.locator("//input").nth((4 * i) + 3).fill("LG" + i);
	 	    	
	 	    	  

	                // Example: Waiting for some time
	 	    	   //page1.waitForTimeout(50000);


	                //System.out.println("Iteration " + (i + 1) + " completed.");
	            
	           }
 
		      
		      
	 	       page1.waitForTimeout(15000);
		      
	 	       page1.locator(".opa-submit").click();
		      
	 	       page1.waitForTimeout(15000);
		      
	 	       browser.close();
		      
	 	       playwright.close();
		      
		      
		    }

	}

}
