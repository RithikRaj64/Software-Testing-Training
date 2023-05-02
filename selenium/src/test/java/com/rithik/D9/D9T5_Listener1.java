package com.rithik.D9;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class D9T5_Listener1 implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started : Method name => " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success : Method name => " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped : Method name => " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage : Method name => " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test Failed with timeout : Method name => " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started : Context name => " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished : Context name => " + context.getName());
    }

    // On test failure print the method name
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed : Method name => " + result.getName());
    }

}
