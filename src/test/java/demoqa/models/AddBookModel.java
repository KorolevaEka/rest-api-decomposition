package demoqa.models;

import lombok.Data;

import java.util.List;

@Data
public class AddBookModel {
    String userId;
    List<IsbnModel> collectionOfIsbns;
}