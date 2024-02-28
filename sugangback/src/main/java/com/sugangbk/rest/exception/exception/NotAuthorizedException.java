package com.sugangbk.rest.exception.exception;

public class NotAuthorizedException extends RuntimeException{
    private static final long serialVersionUID = 1L;
	public NotAuthorizedException(String string){
        super(string);
    }
    public NotAuthorizedException(){
        super("권한이 없습니다");
    }
}
