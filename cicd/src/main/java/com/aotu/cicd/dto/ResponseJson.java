package com.aotu.cicd.dto;

import lombok.Data;

@Data
public class ResponseJson<T> {

    private String code;

    private String message;

    private T data;

}
