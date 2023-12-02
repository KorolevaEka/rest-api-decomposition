package demoqa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseModel {
    String userId, username, password, token, expires, isActive;

    @JsonProperty("created_date")
    String createdDate;
}