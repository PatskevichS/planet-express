package com.patskevich.planetexpress.converter;

public interface IDtoEntityConverter<T, B> {

    T convertToDto(final B dbo);

    B convertToEntity(final T dto);
}
