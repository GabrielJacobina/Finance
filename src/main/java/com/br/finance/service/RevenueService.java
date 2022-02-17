package com.br.finance.service;

import com.br.finance.dto.RevenueRequestBody;
import com.br.finance.model.Revenue;

import java.util.List;

public interface RevenueService {

    List<Revenue> findAll();

    Revenue save(RevenueRequestBody revenueRequestBody);
}
