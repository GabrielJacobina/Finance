package com.br.finance.service;

import com.br.finance.dto.RevenueRequestBody;
import com.br.finance.dto.RevenuesResponseBody;
import com.br.finance.model.Revenue;

public interface RevenueService {

    RevenuesResponseBody findAll();

    Revenue save(RevenueRequestBody revenueRequestBody);
}
