package net.marco27.api.service;

import java.util.List;

import net.marco27.api.domain.Price;
import net.marco27.api.exception.DocumentNotFoundException;

public interface PriceService {

    Price create(Price bookmarks);

    Price read(long id) throws DocumentNotFoundException;

    List<Price> readAll();

    List<Price> readBySource(String source);

    List<Price> readByInstrument(String instrument);

    Price update(Price price);

    void delete(Price price);

}
