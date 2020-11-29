package com.example.demo.Security;


public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="omar.bchir12@gmail.com";
    long EXPIRATION=1000*24*3600;
    String HEADER_PREFIX="Bearer ";
}

