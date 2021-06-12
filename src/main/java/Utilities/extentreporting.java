package Utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentreporting {
	
	private static ExtentReports er;
	private static ExtentHtmlReporter html;
	private static ExtentTest test;
//	private static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	
//	public static ExtentReports getinstance()
//	{
//		ExtentHtmlReporter html = new ExtentHtmlReporter("./extentReports/report.html");
//		html.setAppendExisting(true);
//		ExtentReports er = new ExtentReports();
//		er.attachReporter(html);
//		return er;
//	}
	
	public static void create_test_report()
	{
		html = new ExtentHtmlReporter("./extentReports/report.html");
//		html.setAppendExisting(true);
		er = new ExtentReports();
		er.attachReporter(html);
		
	}
	
//	public static ExtentTest getTest()
//	{
//		System.out.println((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
//		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
//	}
	
	public static void startTest(String testName)
	{
		System.out.println(testName);
		er = getInstance();
		test = er.createTest(testName);
	}
	
	public static ExtentReports getInstance() {
        if (er == null)
        	create_test_report();
        return er;
    }
	
	public void getstatus(String status)
	{
		if(status.equals("pass"))
		{
			test.log(Status.PASS, "test case pass successfully");
		}
		else if (status.equals("fail"))
		{test.log(Status.FAIL, "test case fail successfully");}
		else if (status.equals("skip"))
		{test.log(Status.SKIP, "test case skip successfully");}
		else if (status.equals("warn"))
		{test.log(Status.WARNING, "test case warn successfully");}
	}
	
	public void reportend()
	{
		er.flush();
	}
	
}
