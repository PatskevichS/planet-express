package com.patskevich.planetexpress.exception.impl;

import com.patskevich.planetexpress.exception.InternalServerException;

public class StatusException extends InternalServerException {

    public StatusException() {
        super();
    }

    public StatusException(final String message) {
        super(message);
    }

    public StatusException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public StatusException(final Throwable cause) {
        super(cause);
    }
}
