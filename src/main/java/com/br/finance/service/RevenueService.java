package com.br.finance.service;

import com.br.finance.model.Revenue;
import com.br.finance.requests.RevenueRequestBody;
import com.br.finance.responses.RevenuesResponseBody;

import java.time.LocalDate;
import java.util.List;

public interface RevenueService {

    RevenuesResponseBody findAll();

    Revenue save(RevenueRequestBody revenueRequestBody);

    RevenuesResponseBody calculateRevenues(List<Revenue> revenues);

    void delete(Long id);

    RevenuesResponseBody findAllByMonth(LocalDate date);
}
