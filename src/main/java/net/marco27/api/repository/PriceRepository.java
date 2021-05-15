package net.marco27.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.marco27.api.domain.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    Optional<List<Price>> findByInstrument(String instrument);

    Optional<List<Price>> findBySource(String source);
}
