package com.example.workspace1.error;

import com.example.workspace1.shared.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    @JsonView(Views.Base.class)
    private int status;
    @JsonView(Views.Base.class)
    private String message;
    @JsonView(Views.Base.class)
    private String path;
    @JsonView(Views.Base.class)
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
