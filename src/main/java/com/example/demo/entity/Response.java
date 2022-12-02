package com.example.demo.entity;

import lombok.Data;

@Data
public class Response<T> {

    String msg;
    Integer code;
    T body;
}
