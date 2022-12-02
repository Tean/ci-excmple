package com.example.demo.entity;

import lombok.Data;

@Data
public class Request<T> {
    String operate;
    T param;
}
