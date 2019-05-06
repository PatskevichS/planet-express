package com.patskevich.planetexpress.utils;

import com.patskevich.planetexpress.entity.Delivery;
import com.patskevich.planetexpress.exception.impl.StatusException;

public enum Status {
    Pending("Pending"), InfoReceived("InfoReceived"),
    Transit("Transit"), Delivered("Delivered"),
    Exception("Exception");

    private final String text;

    Status(final String status) {
        this.text = status;
    }

    @Override
    public String toString() {
        return text;
    }

    public static void setPendingStatus(final Delivery delivery) throws StatusException {
        if (delivery.getStatus() != null && !delivery.getStatus().equals(Status.Exception.toString())) {
            throw new StatusException("Delivery status is incorrect");
        } else {
            delivery.setStatus(Status.Pending.toString());
        }
    }

    public static void setInfoReceivedStatus(final Delivery delivery) {
        delivery.setStatus(Status.InfoReceived.toString());
    }

    public static void setInTransitStatus(final Delivery delivery) throws StatusException {
        if (!delivery.getStatus().equals(Status.InfoReceived.toString())
                && !delivery.getStatus().equals(Status.Exception.toString())) {
            throw new StatusException("Delivery status is incorrect");
        } else {
            delivery.setStatus(Status.Transit.toString());
        }
    }

    public static void setDeliveredStatus(final Delivery delivery) throws StatusException {
        if (!delivery.getStatus().equals(Status.Transit.toString())
                && !delivery.getStatus().equals(Status.Exception.toString())) {
            throw new StatusException("Delivery status is incorrect");
        } else {
            delivery.setStatus(Status.Delivered.toString());
        }
    }

    public static void setExceptionStatus(final Delivery delivery) {
        delivery.setStatus(Status.Exception.toString());
    }
}
