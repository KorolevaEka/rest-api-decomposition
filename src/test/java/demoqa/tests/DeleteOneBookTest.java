package demoqa.tests;

import demoqa.models.AddBookModel;
import demoqa.models.LoginResponseModel;
import org.junit.jupiter.api.Test;

import static demoqa.tests.TestData.credentials;
import static demoqa.tests.TestData.isbn;
import static io.qameta.allure.Allure.step;

public class DeleteOneBookTest extends BaseTest {

    @Test
    void deleteBook() {

        LoginResponseModel loginResponse = authorizationApi.login(credentials);

        step("Удалить все книги из корзины", () ->
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