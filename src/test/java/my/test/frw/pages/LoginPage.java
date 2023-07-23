package my.test.frw.pages;

import io.qameta.allure.Step;

public class LoginPage {
    @Step("Type {user} / {user}")
    public void doLogin(String user, String password){
        System.out.println("User : " +user);
        System.out.println("Password : " +password);
    }

    @Step("Type {user} / {user}")
    public void doLogout(String user, String password){
        System.out.println("User : " +user);
        System.out.println("Password : " +password);
    }
}
