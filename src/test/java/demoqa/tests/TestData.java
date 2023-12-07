package demoqa.tests;

import demoqa.models.CredentialsModel;

public class TestData {
   public static final String isbn = "9781491904244";
    public static final String LOGIN = "LetMeIn",
            PASSWORD = "!Dunno321";

    public static CredentialsModel credentials = new CredentialsModel(LOGIN, PASSWORD);
}