package com.patskevich.planetexpress.utils;

public final class Comment {
    public static final String PENDING = "New shipments added that are pending to track.";
    public static final String INFO_RECEIVED = "Carrier has received request from shipper and is about to pick up the" +
            " shipment.";
    public static final String TRANSIT = "Carrier has accepted or picked up shipment from shipper. The " +
            "shipment is on the way.";
    public static final String DELIVERED = "The shipment was delivered sucessfully.";
    public static final String EXCEPTION = "Custom hold, undelivered, returned shipment to sender or any shipping exceptions.";
}
