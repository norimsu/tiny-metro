package io.naraplatform.share.exception;

public class NaraException extends RuntimeException {
	//
	private static final long serialVersionUID = -4282248036332153322L;

	public NaraException(String message) {
        super(message);
    }
    
    public NaraException(String message, Throwable t) {
        super(message, t);
    }

    public NaraException(Throwable t) {
        super(t);
    }

}
