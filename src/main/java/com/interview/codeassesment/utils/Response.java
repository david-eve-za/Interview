package com.interview.codeassesment.utils;

import java.util.List;

public class Response<T> {
    private List<T> data;
    private String message;
    private boolean success;

    public Response(List<T> data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public List<T> getData() {
        return this.data;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
