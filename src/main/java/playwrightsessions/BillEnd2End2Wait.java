package playwrightsessions;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BillEnd2End2Wait{
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
		      page1.locator("#searchCase_lscCaseReference").fill("300000618566");
		      page1.selectOption("#searchCase_officeKeyDisplayValue", "85391|SWITALSKI'S SOLICITORS LTD-0P322F");
		      page1.locator("#searchCase_lscCaseReference").fill("300000618566");
		      //Locator providerOffice = page1.locator("#searchCase_officeKeyDisplayValue");
		      //providerOffice.selectOption("1");
		      
		      page1.selectOption("#searchCase_actualStatus", "LIVE");
		      
		      //ClickSearchForCase
		      page1.locator("input[name='RoofAction_action=searchCase#save=true#validate=true']").click();
		      
		      //OpenCaseRefNumber
		      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("300000618566")).click();
		      
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
		      page1.selectOption("#opmCtl0", "Solicitor Interim");
		      page1.locator(".opa-submit").click();
		      
		      //Payment On Account (POA) Recoupment
		      page1.locator(".opa-submit").click();
		      
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
		      
		      
		      //Non Family Hourly Rate Bill Line
		      
		      page1.getByLabel("Activity Date").click();
		      page1.getByLabel("Activity Date").fill("1/05/2023");
		      page1.getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("Fee Earner").click();
		      page1.getByLabel("Fee Earner").fill("LG1");
		      page1.waitForTimeout(15000);
		   
		      //AddNewBillLine
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Activity Date").fill("02/05/2023");
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Activity Type").selectOption("Routine Telephone Call (Quantity)");
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Amount of Items (optional)").click();
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Amount of Items (optional)").fill("1");
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line2").getByLabel("Fee Earner").fill("LG2");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line3").getByLabel("Fee Earner").fill("LG3");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line4").getByLabel("Fee Earner").fill("LG4");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line5").getByLabel("Fee Earner").fill("LG5");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line6").getByLabel("Fee Earner").fill("LG6");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line7").getByLabel("Fee Earner").fill("LG7");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line8").getByLabel("Fee Earner").fill("LG8");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line9").getByLabel("Fee Earner").fill("LG9");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line10").getByLabel("Fee Earner").fill("LG10");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line11").getByLabel("Fee Earner").fill("LG11");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line12").getByLabel("Fee Earner").fill("LG12");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line13").getByLabel("Fee Earner").fill("LG13");
		      page1.waitForTimeout(15000);
		      
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line14").getByLabel("Fee Earner").fill("LG14");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line15").getByLabel("Fee Earner").fill("LG15");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line16").getByLabel("Fee Earner").fill("LG16");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line17").getByLabel("Fee Earner").fill("LG17");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line18").getByLabel("Fee Earner").fill("LG18");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line19").getByLabel("Fee Earner").fill("LG19");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line20").getByLabel("Fee Earner").fill("LG20");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line21").getByLabel("Fee Earner").fill("LG21");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line22").getByLabel("Fee Earner").fill("LG22");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line23").getByLabel("Fee Earner").fill("LG23");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line24").getByLabel("Fee Earner").fill("LG24");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line25").getByLabel("Fee Earner").fill("LG25");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line26").getByLabel("Fee Earner").fill("LG26");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line27").getByLabel("Fee Earner").fill("LG27");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line28").getByLabel("Fee Earner").fill("LG28");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line29").getByLabel("Fee Earner").fill("LG29");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line30").getByLabel("Fee Earner").fill("LG30");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line31").getByLabel("Fee Earner").fill("LG31");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line32").getByLabel("Fee Earner").fill("LG32");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line33").getByLabel("Fee Earner").fill("LG33");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line34").getByLabel("Fee Earner").fill("LG34");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line35").getByLabel("Fee Earner").fill("LG35");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line36").getByLabel("Fee Earner").fill("LG36");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line37").getByLabel("Fee Earner").fill("LG37");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line38").getByLabel("Fee Earner").fill("LG38");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line39").getByLabel("Fee Earner").fill("LG39");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line40").getByLabel("Fee Earner").fill("LG40");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line41").getByLabel("Fee Earner").fill("LG41");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line42").getByLabel("Fee Earner").fill("LG42");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line43").getByLabel("Fee Earner").fill("LG43");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line44").getByLabel("Fee Earner").fill("LG44");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line45").getByLabel("Fee Earner").fill("LG45");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line46").getByLabel("Fee Earner").fill("LG46");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line47").getByLabel("Fee Earner").fill("LG47");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line48").getByLabel("Fee Earner").fill("LG48");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line49").getByLabel("Fee Earner").fill("LG49");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line50").getByLabel("Fee Earner").fill("LG50");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line51").getByLabel("Fee Earner").fill("LG51");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line52").getByLabel("Fee Earner").fill("LG52");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line53").getByLabel("Fee Earner").fill("LG53");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line54").getByLabel("Fee Earner").fill("LG54");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line55").getByLabel("Fee Earner").fill("LG55");
		      page1.waitForTimeout(15000);
		      
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line56").getByLabel("Fee Earner").fill("LG56");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line57").getByLabel("Fee Earner").fill("LG57");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line58").getByLabel("Fee Earner").fill("LG58");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line59").getByLabel("Fee Earner").fill("LG59");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line60").getByLabel("Fee Earner").fill("LG60");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line61").getByLabel("Fee Earner").fill("LG61");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line62").getByLabel("Fee Earner").fill("LG62");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line63").getByLabel("Fee Earner").fill("LG63");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line64").getByLabel("Fee Earner").fill("LG64");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line65").getByLabel("Fee Earner").fill("LG65");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line66").getByLabel("Fee Earner").fill("LG66");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line67").getByLabel("Fee Earner").fill("LG67");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line68").getByLabel("Fee Earner").fill("LG68");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line69").getByLabel("Fee Earner").fill("LG69");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line70").getByLabel("Fee Earner").fill("LG70");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line71").getByLabel("Fee Earner").fill("LG71");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line72").getByLabel("Fee Earner").fill("LG72");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line73").getByLabel("Fee Earner").fill("LG73");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line74").getByLabel("Fee Earner").fill("LG74");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line75").getByLabel("Fee Earner").fill("LG75");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line76").getByLabel("Fee Earner").fill("LG76");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line77").getByLabel("Fee Earner").fill("LG77");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line78").getByLabel("Fee Earner").fill("LG78");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line79").getByLabel("Fee Earner").fill("LG79");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line80").getByLabel("Fee Earner").fill("LG80");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line81").getByLabel("Fee Earner").fill("LG81");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line82").getByLabel("Fee Earner").fill("LG82");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line83").getByLabel("Fee Earner").fill("LG83");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line84").getByLabel("Fee Earner").fill("LG84");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line85").getByLabel("Fee Earner").fill("LG85");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line86").getByLabel("Fee Earner").fill("LG86");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line87").getByLabel("Fee Earner").fill("LG87");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line88").getByLabel("Fee Earner").fill("LG88");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line89").getByLabel("Fee Earner").fill("LG89");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line90").getByLabel("Fee Earner").fill("LG90");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line91").getByLabel("Fee Earner").fill("LG91");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line92").getByLabel("Fee Earner").fill("LG92");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line93").getByLabel("Fee Earner").fill("LG93");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line94").getByLabel("Fee Earner").fill("LG94");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line95").getByLabel("Fee Earner").fill("LG95");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line96").getByLabel("Fee Earner").fill("LG96");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line97").getByLabel("Fee Earner").fill("LG97");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line98").getByLabel("Fee Earner").fill("LG98");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line99").getByLabel("Fee Earner").fill("LG99");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line100").getByLabel("Fee Earner").fill("LG100");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line101").getByLabel("Fee Earner").fill("LG101");
		      page1.waitForTimeout(15000);
		      
	
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Activity Date").fill("02/05/2023");
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Activity Type").selectOption("Routine Telephone Call (Quantity)");
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Amount of Items (optional)").click();
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Amount of Items (optional)").fill("1");
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line102").getByLabel("Fee Earner").fill("LG102");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line103").getByLabel("Fee Earner").fill("LG103");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line104").getByLabel("Fee Earner").fill("LG104");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line105").getByLabel("Fee Earner").fill("LG105");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line106").getByLabel("Fee Earner").fill("LG106");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line107").getByLabel("Fee Earner").fill("LG107");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line108").getByLabel("Fee Earner").fill("LG108");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line109").getByLabel("Fee Earner").fill("LG109");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line110").getByLabel("Fee Earner").fill("LG110");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line111").getByLabel("Fee Earner").fill("LG111");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line112").getByLabel("Fee Earner").fill("LG112");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line113").getByLabel("Fee Earner").fill("LG113");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line114").getByLabel("Fee Earner").fill("LG114");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line115").getByLabel("Fee Earner").fill("LG115");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line116").getByLabel("Fee Earner").fill("LG116");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line117").getByLabel("Fee Earner").fill("LG117");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line118").getByLabel("Fee Earner").fill("LG118");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line119").getByLabel("Fee Earner").fill("LG119");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line120").getByLabel("Fee Earner").fill("LG120");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line121").getByLabel("Fee Earner").fill("LG121");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line122").getByLabel("Fee Earner").fill("LG122");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line123").getByLabel("Fee Earner").fill("LG123");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line124").getByLabel("Fee Earner").fill("LG124");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line125").getByLabel("Fee Earner").fill("LG125");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line126").getByLabel("Fee Earner").fill("LG126");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line127").getByLabel("Fee Earner").fill("LG127");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line128").getByLabel("Fee Earner").fill("LG128");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line129").getByLabel("Fee Earner").fill("LG129");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line130").getByLabel("Fee Earner").fill("LG130");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line131").getByLabel("Fee Earner").fill("LG131");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line132").getByLabel("Fee Earner").fill("LG132");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line133").getByLabel("Fee Earner").fill("LG133");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line134").getByLabel("Fee Earner").fill("LG134");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line135").getByLabel("Fee Earner").fill("LG135");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line136").getByLabel("Fee Earner").fill("LG136");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line137").getByLabel("Fee Earner").fill("LG137");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line138").getByLabel("Fee Earner").fill("LG138");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line139").getByLabel("Fee Earner").fill("LG139");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line140").getByLabel("Fee Earner").fill("LG140");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line141").getByLabel("Fee Earner").fill("LG141");	      
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Fee Earner").fill("LG142");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line142").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line143").getByLabel("Fee Earner").fill("LG143");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line144").getByLabel("Fee Earner").fill("LG144");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line145").getByLabel("Fee Earner").fill("LG145");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line146").getByLabel("Fee Earner").fill("LG146");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line147").getByLabel("Fee Earner").fill("LG147");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line148").getByLabel("Fee Earner").fill("LG148");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line149").getByLabel("Fee Earner").fill("LG149");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line150").getByLabel("Fee Earner").fill("LG150");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line151").getByLabel("Fee Earner").fill("LG151");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line152").getByLabel("Fee Earner").fill("LG152");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line153").getByLabel("Fee Earner").fill("LG153");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line154").getByLabel("Fee Earner").fill("LG154");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		      
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Activity Date").fill("01/01/2024");
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line155").getByLabel("Fee Earner").fill("LG155");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line156").getByLabel("Fee Earner").fill("LG156");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Activity Date").fill("10/10/2023");
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line157").getByLabel("Fee Earner").fill("LG157");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Activity Date").fill("11/10/2023");
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Activity Type").selectOption("Attendance upon solicitor (Time)");
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line158").getByLabel("Fee Earner").fill("LG158");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line159").getByLabel("Fee Earner").fill("LG159");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Activity Date").fill("10/11/2023");
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line160").getByLabel("Fee Earner").fill("LG160");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Activity Date").fill("12/10/2023");
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line161").getByLabel("Fee Earner").fill("LG161");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line162").getByLabel("Fee Earner").fill("LG62");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line163").getByLabel("Fee Earner").fill("LG163");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line164").getByLabel("Fee Earner").fill("LG164");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line165").getByLabel("Fee Earner").fill("LG165");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line166").getByLabel("Fee Earner").fill("LG166");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line167").getByLabel("Fee Earner").fill("LG167");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line168").getByLabel("Fee Earner").fill("LG168");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line169").getByLabel("Fee Earner").fill("LG169");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line170").getByLabel("Fee Earner").fill("LG170");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line171").getByLabel("Fee Earner").fill("LG171");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line172").getByLabel("Fee Earner").fill("LG172");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line173").getByLabel("Fee Earner").fill("LG173");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line174").getByLabel("Fee Earner").fill("LG174");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line175").getByLabel("Fee Earner").fill("LG175");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line176").getByLabel("Fee Earner").fill("LG176");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line177").getByLabel("Fee Earner").fill("LG177");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line178").getByLabel("Fee Earner").fill("LG178");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line179").getByLabel("Fee Earner").fill("LG179");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line180").getByLabel("Fee Earner").fill("LG180");
		      page1.waitForTimeout(15000);
		      
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line181").getByLabel("Fee Earner").fill("LG181");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line182").getByLabel("Fee Earner").fill("LG182");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line183").getByLabel("Fee Earner").fill("LG183");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line184").getByLabel("Fee Earner").fill("LG184");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line185").getByLabel("Fee Earner").fill("LG185");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line186").getByLabel("Fee Earner").fill("LG186");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line187").getByLabel("Fee Earner").fill("LG187");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line188").getByLabel("Fee Earner").fill("LG188");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line189").getByLabel("Fee Earner").fill("LG189");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line190").getByLabel("Fee Earner").fill("LG190");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line191").getByLabel("Fee Earner").fill("LG191");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line192").getByLabel("Fee Earner").fill("LG192");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line193").getByLabel("Fee Earner").fill("LG193");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line194").getByLabel("Fee Earner").fill("LG194");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line195").getByLabel("Fee Earner").fill("LG195");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line196").getByLabel("Fee Earner").fill("LG96");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line197").getByLabel("Fee Earner").fill("LG197");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line198").getByLabel("Fee Earner").fill("LG198");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line199").getByLabel("Fee Earner").fill("LG199");
		      page1.waitForTimeout(15000);
		      
		      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Activity Date").click();
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Activity Date").fill("20/02/2024");
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Activity Type").selectOption("Attendance upon client (Time)");
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Activity Time (optional)").click();
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Activity Time (optional)").fill("01:00");
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("VAT %").selectOption("20%");
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Fee Earner").click();
		      page1.getByLabel("the Non Family HR bill line200").getByLabel("Fee Earner").fill("LG200");
		      page1.waitForTimeout(15000);

		      
		      page1.locator(".opa-submit").click();
		      
		      page1.waitForTimeout(15000);
		      
		      page1.locator(".opa-submit").click();
		      
		      page1.waitForTimeout(15000);
		      
		      browser.close();
		      
		      playwright.close();
		      
		      
		    }

	}

}
