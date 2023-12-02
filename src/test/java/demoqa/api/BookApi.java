package demoqa.api;

import demoqa.models.AddBookModel;
import demoqa.models.DeleteBookModel;
import demoqa.models.IsbnModel;
import demoqa.models.LoginResponseModel;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static demoqa.specs.BooksSpecs.bookRequestSpecs;
import static demoqa.specs.BooksSpecs.bookResponseSpecs;

public class BookApi {
    public void deleteAllBooks(LoginResponseModel loginResponse) {
        given(bookRequestSpecs)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(bookResponseSpecs)
                .statusCode(204);
    }

    public void addBook(LoginResponseModel loginResponse, AddBookModel bookList) {
        IsbnModel isbn = new IsbnModel("9781491904244");
        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbn);

        bookList.setUserId(loginResponse.getUserId());
        bookList.setCollectionOfIsbns(isbnList);

        given(bookRequestSpecs)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(bookList)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(bookResponseSpecs)
                .statusCode(201);
    }

    public void deleteBook(LoginResponseModel loginResponse, String isbn) {
        DeleteBookModel deleteBook = new DeleteBookModel();
        deleteBook.setUserId(loginResponse.getUserId());
        deleteBook.setIsbn(isbn);

        given(bookRequestSpecs)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(deleteBook)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(bookResponseSpecs)
                .statusCode(204);
    }
}