package com.sugangbk.rest.exception.exception;

public class NoExistEntityException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public NoExistEntityException() {
        super("Entity를 찾을 수 없습니다");
    }
}
