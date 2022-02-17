package com.br.finance.service.impl;

import com.br.finance.dto.RevenueRequestBody;
import com.br.finance.model.Revenue;
import com.br.finance.repository.RevenueRepository;
import com.br.finance.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.br.finance.mapper.RevenueMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;

    @Override
    public List<Revenue> findAll() {
        return revenueRepository.findAll();
    }

    public Revenue save(RevenueRequestBody expenseRequestBody) {
        Revenue revenue = INSTANCE.revenueRequestBodytoRevenue(expenseRequestBody);
        return revenueRepository.save(revenue);
    }
}
