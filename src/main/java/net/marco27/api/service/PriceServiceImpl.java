package net.marco27.api.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import net.marco27.api.domain.Price;
import net.marco27.api.exception.DocumentNotFoundException;
import net.marco27.api.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price create(final Price bookmarks) {
        return priceRepository.save(bookmarks);
    }

    @Override
    public Price read(long id) throws DocumentNotFoundException {
        return priceRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException(String.format("id not found: %s", id)));
    }

    @Override
    public List<Price> readAll() {
        return StreamSupport.stream(priceRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Price> readBySource(final String source) {
        return priceRepository.findBySource(source).orElse(Collections.emptyList());
    }

    @Override
    public List<Price> readByInstrument(String instrument) {
        return priceRepository.findByInstrument(instrument).orElse(Collections.emptyList());
    }

    @Override
    public Price update(final Price price) {
        return priceRepository.save(price);
    }

    @Override
    public void delete(final Price price) {
        priceRepository.deleteById(price.getId());
    }

}
