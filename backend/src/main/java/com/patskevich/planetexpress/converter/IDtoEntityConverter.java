package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.exception.InternalServerException;

public interface IDtoEntityConverter<T, B> {

    T convertToDto(final B dbo) throws InternalServerException;

    B convertToEntity(final T dto);
}
