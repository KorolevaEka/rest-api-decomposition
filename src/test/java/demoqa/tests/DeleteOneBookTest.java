package demoqa.tests;

import demoqa.models.AddBookModel;
import demoqa.models.LoginResponseModel;
import org.junit.jupiter.api.Test;

import static demoqa.tests.TestData.credentials;
import static io.qameta.allure.Allure.step;

public class DeleteOneBookTest extends BaseTest {

    @Test
    void deleteBook() {
        String isbn = "9781491904244";

        LoginResponseModel loginResponse = authorizationApi.login(credentials);

        step("Авторизоваться в профиле с пустой корзиной", () ->
                bookApi.deleteAllBooks(loginResponse));

        step("Добавить книгу в профиль", () ->
                bookApi.addBook(loginResponse, new AddBookModel()));

        step("Удалить книгу из профиля", () ->
                bookApi.deleteBook(loginResponse, isbn));

        step("Открыть UI и убедиться, что книга отсутствует", () -> {
            profile.setCookie(loginResponse)
                    .openProfile()
                    .checkExistenceOfBook(isbn);
        });
    }
}