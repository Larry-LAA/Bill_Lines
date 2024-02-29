package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class InterimBilling {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://portal.stg.legalservices.gov.uk/oam/server/obrareq.cgi?encquery%3DFfowvz2Wkp5G4UVl4N34SuPT2SwXYXzWh3BUE5hqki30QUVaJUxAvIz9P0qj4zdCgt76iiI%2BZjodn8XtHUjFidGrOCGCXDNRqGQnbjSR2nFccGx4Lj9uB8sqXaijtcE7mm%2FG9kY8N2rRXMv%2FrjIhosYnZwC41ZvUINNl3QTbZFFX4pLOt1JZULCAQ3XW5tUWmy4GJgiQJBg8oIuj3uRiU6uejBkRTids2R9pxbqDAYeTg4rAQFuTaxDTNhNpIK0n3xkizEPstqb1cZTHes%2BM%2B%2B%2FrA52Jay8XugbBLy0Fe3jUe2a8jAmHmhp%2BuNrkQdafItLx8D9qYBJVjcIo2gb5RJqo8ynpZtUQqMta6LqGc5E%3D%20agentid%3DWebgateAgent11g_1%20ver%3D1%20crmethod%3D2%26cksum%3D3c53d719feecbacb3bec6c7ac98c6eaedda35a83&ECID-Context=1.0062nK3C7daEOPc5PjO5yd0004Gv0000s8%3BkXjE");
      page.getByLabel("Username:").click();
      page.getByLabel("Username:").fill("penny.wall@switalskis.com");
      page.getByLabel("Password:").click();
      page.getByLabel("Password:").fill("Digital123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
      Page page1 = page.waitForPopup(() -> {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Client and Cost Management System").setExact(true)).click();
      });
      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cases and Applications")).click();

      page1.locator("#searchCase_lscCaseReference").click();
      page1.locator("#searchCase_lscCaseReference").fill("300000618566");
      page1.getByText("Search", new Page.GetByTextOptions().setExact(true)).click();

      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("300000618566")).click();
      page1.locator("//*[text() = 'Billing']").check();
      
      
      
      page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create Bill")).click();
      page1.navigate("https://ccmspui.stg.legalservices.gov.uk/civil/renderOWD?ezgov_private_hiddenData_uniqueId=PX754YF55DF8M845WE9EQ75PT6TY5XC4&invokedFrom=CCMS_CB03&assessmentType=billing");
      page1.getByLabel("What type of claim are you submitting?").selectOption("Solicitor Interim");
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();

      page1.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).click();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).click();
      page1.getByLabel("Does your claim qualify for assessment by the court but you are volunteering for assessment by LAA?").getByRole(AriaRole.RADIO, new Locator.GetByRoleOptions().setName("Yes")).click();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByLabel("Would you like to bill for Disbursements?").getByRole(AriaRole.RADIO, new Locator.GetByRoleOptions().setName("No")).click();
      page1.getByLabel("Would you like to bill for Codified Barrister Rates?").getByRole(AriaRole.RADIO, new Locator.GetByRoleOptions().setName("No")).click();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByLabel("Court type").selectOption("High court");
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("No")).click();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByLabel("Activity Date").click();
      page1.getByLabel("Activity Date").fill("28/11/2023");
      page1.getByLabel("Activity Type").selectOption("Attendance upon court (Time)");
      page1.getByLabel("Activity Time (optional)").click();
      page1.getByLabel("Activity Time (optional)").fill("01:00");
      page1.getByLabel("VAT %").selectOption("20%");
      page1.getByLabel("Fee Earner").click();
      page1.getByLabel("Fee Earner").fill("LG");
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Activity Date").click();
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Activity Date").fill("25/11/2023");
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Activity Type").selectOption("Routine Telephone Call (Quantity)");
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Amount of Items (optional)").click();
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Amount of Items (optional)").fill("1");
      page1.getByLabel("the Non Family HR bill line2").getByLabel("VAT %").selectOption("20%");
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Fee Earner").click();
      page1.getByLabel("the Non Family HR bill line2").getByLabel("Fee Earner").fill("LG");
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();
      page1.navigate("https://ccmspui.stg.legalservices.gov.uk/civil/CCMS_CB01.form?RoofAction_action%3Dbill%23save%3Dfalse%23validate%3Dfalse%23ezgov_private_hiddenData_uniqueId%3D2QB2B8L55AE2HL6PC7J26AX5ZF2CD7BT%23billAction%3DeditBill%23case_id%3D300000618566%23to_retrieve%3DAPP_UNSUBMITTED");
      Page page2 = page1.waitForPopup(() -> {
        page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bill Summary")).click();
      });
      page2.navigate("https://ccmspui.stg.legalservices.gov.uk/civil/CCMS_GN05.form?RoofAction_action%3DpollDocument%23save%3Dfalse%23validate%3Dfalse%23ezgov_private_hiddenData_uniqueId%3DTJ8ZJ7UW4M4W285BP7BP8R8H4L7BP3GQ%23ebsDocumentWorkId%3DBILL%20REPORT-300000618566-91f80437-bb43-4f57-a74c-694638dd064a%23ebsDocumentDisplayPage%3DCCMS_CB05%23ebsDocumentPollCount%3D0");
      page1.navigate("https://ccmspui.stg.legalservices.gov.uk/civil/CCMS_CB03.form");
    }
  }
}