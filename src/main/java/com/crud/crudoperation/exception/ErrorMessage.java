package com.crud.crudoperation.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorMessage {
    Date date;
    String message;
    String detail;

    public ErrorMessage(Date date, String message, String detail) {
        super();
        this.date = date;
        this.message = message;
        this.detail = detail;
    }
}
