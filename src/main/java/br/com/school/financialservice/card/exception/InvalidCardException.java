package br.com.school.financialservice.card.exception;

public class InvalidCardException extends RuntimeException{
    public InvalidCardException(String message) {
        super(message);
    }
}
