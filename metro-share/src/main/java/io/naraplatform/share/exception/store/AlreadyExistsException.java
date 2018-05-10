package io.naraplatform.share.exception.store;

public class AlreadyExistsException extends NaraStoreException {
	//
	private static final long serialVersionUID = 4853354610441888312L;

	public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, Throwable t) {
        super(message, t);
    }

    public AlreadyExistsException(Throwable t) {
        super(t);
    }

}
