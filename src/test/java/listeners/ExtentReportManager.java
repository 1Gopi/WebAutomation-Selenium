import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Define the report location
            String reportFilePath = System.getProperty("user.dir") + "/test-output/ExtentReports/report.html";

            // Create the HTML Reporter
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
            htmlReporter.config().setDocumentTitle("Automation Test Report");
            htmlReporter.config().setReportName("Selenium Test Results");
            htmlReporter.config().setTheme(Theme.STANDARD);

            // Create ExtentReports and attach the reporter(s)
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            // Optional: set system info
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Gopi");
        }
        return extent;
    }
}
