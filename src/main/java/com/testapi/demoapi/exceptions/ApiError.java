package com.testapi.demoapi.exceptions;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiError {

    private String message;
    private int code;
    private LocalDateTime dateTime;
    private Map<String, String> errors;
}
