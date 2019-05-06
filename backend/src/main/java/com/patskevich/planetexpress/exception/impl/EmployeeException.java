package com.patskevich.planetexpress.exception.impl;

import com.patskevich.planetexpress.exception.InternalServerException;

public class EmployeeException extends InternalServerException {

    public EmployeeException() {
        super();
    }

    public EmployeeException(final String message) {
        super(message);
    }

    public EmployeeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmployeeException(final Throwable cause) {
        super(cause);
    }
}
