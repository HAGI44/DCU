package com.sugangbk.rest.exception.exception;

public class NotAuthenticatedException extends RuntimeException{
    private static final long serialVersionUID = 1L;
	public NotAuthenticatedException(String string){
        super(string);
    }
    public NotAuthenticatedException(){
        super("접근 권한이 없습니다");
    }
}
