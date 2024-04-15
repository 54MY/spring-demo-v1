package com.example.demo.core.http;

import java.time.LocalDateTime;

/**
 * HealthMessage
 *
 * @author Samuel Veizaga
 * @since 1.0
 */
public class HealthMessage {

    private String message;

    private LocalDateTime dateTime;

    public HealthMessage(String message) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
