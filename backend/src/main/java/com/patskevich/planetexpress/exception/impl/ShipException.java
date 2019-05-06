package com.patskevich.planetexpress.exception.impl;

import com.patskevich.planetexpress.exception.InternalServerException;

public class ShipException extends InternalServerException {

    public ShipException() {
        super();
    }

    public ShipException(final String message) {
        super(message);
    }

    public ShipException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ShipException(final Throwable cause) {
        super(cause);
    }
}
