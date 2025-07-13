package com.example.aluminumexercise;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZimAutomationTest {
    @Test
    public void runAlumniumScript() throws Exception {
        ExtentSparkReporter reporter = new ExtentSparkReporter("build/reports/extent-report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest test = extent.createTest("Alumnium ZIM test");

        ProcessBuilder pb = new ProcessBuilder("python3", "scripts/zim_test.py");
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            test.info(line);
        }
        int exit = process.waitFor();
        if (exit == 0) {
            test.pass("Script executed successfully");
        } else {
            test.fail("Script failed with exit code " + exit);
        }
        extent.flush();
        assertEquals(0, exit);
    }
}
