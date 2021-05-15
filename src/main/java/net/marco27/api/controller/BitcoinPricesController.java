package net.marco27.api.controller;

import static net.marco27.api.domain.releasenotes.ReleaseNotes.VERSION_1;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.marco27.api.domain.Price;
import net.marco27.api.exception.DocumentNotFoundException;
import net.marco27.api.service.PriceService;

@RestController
@RequestMapping("/" + VERSION_1 + "/price")
public class BitcoinPricesController {

    private final PriceService priceService;

    @Autowired
    public BitcoinPricesController(final PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/create")
    public ResponseEntity<Price> create(@RequestBody final Price price) {
        final Price result = priceService.create(price);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/read/{id}")
    public Price read(@NotNull @PathVariable("id") final long id) throws DocumentNotFoundException {
        return priceService.read(id);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<Price>> readAll() {
        final List<Price> result = priceService.readAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Price>> readBy(@RequestParam(required = false) final String source,
            @RequestParam(required = false) final String instrument) {
        List<Price> result = Collections.emptyList();
        if (!isEmpty(source)) {
            result = priceService.readBySource(source);
        }
        if (!isEmpty(instrument)) {
            result = priceService.readByInstrument(instrument);
        }
        if (!isEmpty(source) && !isEmpty(instrument)) {
            result = priceService.readBySourceAndInstrument(source, instrument);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Price> update(@PathVariable(value = "id") final long id,
            @Valid @RequestBody final Price updatePrice) throws DocumentNotFoundException {
        final Price price = priceService.read(id);
        price.setSource(updatePrice.getSource());
        price.setInstrument(updatePrice.getInstrument());
        price.setAmount(updatePrice.getAmount());
        price.setCreated(updatePrice.getCreated());
        final Price result = priceService.update(price);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public Map<Long, Boolean> delete(@PathVariable(value = "id") final long id) throws DocumentNotFoundException {
        final Price price = priceService.read(id);
        priceService.delete(price);
        Map<Long, Boolean> response = new HashMap<>();
        response.put(id, Boolean.TRUE);
        return response;
    }

}
