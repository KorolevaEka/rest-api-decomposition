package demoqa.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static demoqa.helpers.CustomAllureListeners.withCustomTemplates;

public class BooksSpecs {
    public static final RequestSpecification bookRequestSpecs = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().uri()
            .log().method();

    public static final ResponseSpecification bookResponseSpecs = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}