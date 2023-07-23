package my.test.frw.suites;

import io.qameta.allure.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import my.test.frw.pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.lang.reflect.Method;

@Epic("Allure examples")
@Feature("TestNG support")
public class SampleSuiteITest {

    @Test(description = "Test Execution TC1")
    @Description("Description - Test Execution TC1")
    @Story("Basic login test")
    public void testLogin(ITestContext tCon) {
        LoginPage loginPage=new LoginPage();
        loginPage.doLogin("user","password");
        System.out.println("Executing TC1");
        Assert.assertTrue(true, tCon.getCurrentXmlTest().getName() + " : is failed");
    }
//    allure generate allure-results --clean -o allure-report


    @Test(description = "Test Jenkins Job details")
    @Attachment(value = "Page screenshot", type = "image/png")
    @Description("Description - Test Jenkins Job details")
    @Severity(SeverityLevel.CRITICAL)
    public void testJobDetails(ITestContext tCon) {

        System.out.println("Executing TC3");

        // Specify the base URL to the RESTful web service

        RestAssured.baseURI = "http://localhost:8080";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.auth().preemptive().basic("sanjaydub", "Cybage123");

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(io.restassured.http.Method.GET, "/job/CT/api/json");
//        httpRequest.request(io.restassured.http.Method.GET)

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response code is =>  " + response.getStatusCode());
        System.out.println("Response Body is =>  " + responseBody);

        System.out.println(response.print());
        Assert.assertTrue(response.getStatusCode() == 200, tCon.getCurrentXmlTest().getName() + " : is failed");
    }

    @Test(description = "Test 3")
    @Attachment
    @Description("Description of Test 3")
    @Link(name = "allure", type = "mylink")
    public void testJobDetails3(ITestContext tCon) {
        LoginPage loginPage=new LoginPage();
        loginPage.doLogout("user","password");
    }

    @Test(description = "Test 4")
    @Attachment
    @Description("Description of Test 4")
    @Link("https://example.org")
    @Issue("123")

    public void testTC4(ITestContext tCon) {
        LoginPage loginPage=new LoginPage();
        loginPage.doLogout("user","password");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method) {

        System.out.println("Currently run method was " + method.getName());

    }


}