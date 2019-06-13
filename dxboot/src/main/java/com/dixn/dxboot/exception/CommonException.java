package com.dixn.dxboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonException extends RuntimeException {

    String msg;

    String code;
}
