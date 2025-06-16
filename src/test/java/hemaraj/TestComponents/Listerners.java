package hemaraj.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import hemaraj.resources.ExtentReporterNG;

public class Listerners implements ITestListener {
	
	
	    ExtentTest test;
	    ExtentReports extent= ExtentReporterNG.getReportObject();
	    @Override
	    public void onTestStart(ITestResult result) {
	    	
	      test=  extent.createTest(result.getMethod().getMethodName());

	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed");

	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	
	        test.log(Status.FAIL, result.getThrowable());

	    	
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    }

	    // Optional: you can leave these empty if not used
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {}
	}





