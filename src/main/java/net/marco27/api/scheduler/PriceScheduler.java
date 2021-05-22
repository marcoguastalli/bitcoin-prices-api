package net.marco27.api.scheduler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.marco27.api.domain.Price;
import net.marco27.api.repository.PriceRepository;

@Component
public class PriceScheduler {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceScheduler(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Scheduled(cron = "*/1 * * * *")
    public List<Price> readPricesVariationsAscending() {
        return StreamSupport.stream(priceRepository.findAllByOrderByVariationAsc().spliterator(), false).collect(Collectors.toList());
    }

    @Scheduled(cron = "*/1 * * * *")
    public List<Price> readPricesVariationsDescending() {
        return StreamSupport.stream(priceRepository.findAllByOrderByVariationDesc().spliterator(), false).collect(Collectors.toList());
    }
}
