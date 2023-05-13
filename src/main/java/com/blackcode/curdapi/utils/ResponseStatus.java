package com.blackcode.curdapi.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseStatus<T> {
    public Boolean status;
    public HttpStatus statusCode;
    public List<String> message = new ArrayList<>();
    public T data;
}
