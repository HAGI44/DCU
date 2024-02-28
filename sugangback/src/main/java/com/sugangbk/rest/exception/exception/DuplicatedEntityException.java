package com.sugangbk.rest.exception.exception;

public class DuplicatedEntityException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public DuplicatedEntityException() {
        super("Entity가 중복입니다");
    }

    public DuplicatedEntityException(String msg){
        super(msg);
    }
}
