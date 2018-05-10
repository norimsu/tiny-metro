package io.naraplatform.share.exception;

public class ValueOutOfBoundsException extends RuntimeException {
	//
	private static final long serialVersionUID = 4072200320855146954L;

	//
    public ValueOutOfBoundsException(String message) {
        super(message);
    }

    public ValueOutOfBoundsException(String message, Throwable t) {
        super(message, t);
    }

    public ValueOutOfBoundsException(Throwable t) {
        super(t);
    }
}