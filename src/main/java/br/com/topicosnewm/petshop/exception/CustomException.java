package br.com.topicosnewm.petshop.exception;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 4657491283614755649L;


	public CustomException(String message) {
            super(message);
        }

	public CustomException(String message, Throwable t) {
            super(message, t);
        }

}
