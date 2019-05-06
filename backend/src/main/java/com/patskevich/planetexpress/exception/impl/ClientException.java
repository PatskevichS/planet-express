package com.patskevich.planetexpress.exception.impl;

import com.patskevich.planetexpress.exception.InternalServerException;

public class ClientException extends InternalServerException {

    public ClientException() {
        super();
    }

    public ClientException(final String message) {
        super(message);
    }

    public ClientException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ClientException(final Throwable cause) {
        super(cause);
    }
}
