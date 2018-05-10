package io.naraplatform.share.exception.store;

import io.naraplatform.share.exception.NaraException;

public class NaraStoreException extends NaraException {
	//
	private static final long serialVersionUID = -6526220734800910988L;
	
    public NaraStoreException(String message) {
        super(message);
    }

    public NaraStoreException(String message, Throwable t) {
        super(message, t);
    }

    public NaraStoreException(Throwable t) {
        super(t);
    }
}
