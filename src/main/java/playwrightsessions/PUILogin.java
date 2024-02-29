package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PUILogin {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
   // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      page.navigate("https://portal.stg.legalservices.gov.uk");
      page.getByLabel("Username:").click();
      page.getByLabel("Username:").fill("mvn exec:java -e -D exec.mainClass=com.microsoft.playw");
      page.getByLabel("Username:").fill("penny.wall@switalskis.com");
      page.getByLabel("Password:").fill("Digital123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
   
      assertThat(page).hasTitle(Pattern.compile("LAA Online Portal"));
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
      
    }
  }
}
