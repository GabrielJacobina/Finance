package com.br.finance.controller;

import com.br.finance.model.Revenue;
import com.br.finance.requests.RevenueRequestBody;
import com.br.finance.responses.RevenuesResponseBody;
import com.br.finance.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/revenue")
public class RevenueController {

    private final RevenueService revenueService;

    @GetMapping
    public ResponseEntity<RevenuesResponseBody> findAll() {
        return new ResponseEntity<>(revenueService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Revenue> save(@RequestBody RevenueRequestBody revenueRequestBody) {
        return new ResponseEntity<>(revenueService.save(revenueRequestBody), HttpStatus.CREATED);
    }

    @PostMapping("/calculate")
    public ResponseEntity<RevenuesResponseBody> calculateExpenses(@RequestBody List<Revenue> revenues) {
        return new ResponseEntity<>(revenueService.calculateRevenues(revenues), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        revenueService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
