package com.patskevich.planetexpress.exception.impl;

import com.patskevich.planetexpress.exception.InternalServerException;

public class DeliveryException extends InternalServerException {

    public DeliveryException() {
        super();
    }

    public DeliveryException(final String message) {
        super(message);
    }

    public DeliveryException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DeliveryException(final Throwable cause) {
        super(cause);
    }
}
