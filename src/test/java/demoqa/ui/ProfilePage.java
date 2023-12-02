package demoqa.ui;

import demoqa.models.LoginResponseModel;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfilePage {

    public ProfilePage setCookie(LoginResponseModel loginResponse) {

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
        return this;
    }

    public ProfilePage openProfile() {
        open("/profile");
        return this;
    }

    public void checkExistenceOfBook(String isbn) {
        $("[href='profile?book=" + isbn + "']").shouldNot(exist);
    }

}