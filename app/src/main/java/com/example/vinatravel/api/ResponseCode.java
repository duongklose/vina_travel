package com.example.vinatravel.api;

public interface ResponseCode {
    String OK = "201";
    String CANNOT_CONNECT_TO_DB = "1001";
    String PARAMETER_IS_NOT_ENOUGH = "1002";
    String PARAMETER_TYPE_IS_INVALID = "1003";
    String PARAMETER_VALUE_IS_INVALID = "1004";
    String UNKNOWN_ERROR = "1005";

    String USER_IS_NOT_INVALID = "1010";
    String USER_EXISTED = "1011";
}
