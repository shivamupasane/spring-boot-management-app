package com.school.management.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private List<String> message;
    private LocalDateTime timeStamp;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public LocalDateTime getTimestamp() {
        return timeStamp;
    }
    public void setTimestamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public ErrorResponse(List<String> message) {
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
