package com.patskevich.planetexpress.utils;

public final class IdWriter {

    public static String write(final long id, final String text) {
        return String.format("[%d] "+text, id);
    }
}
