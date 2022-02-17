package com.br.finance.service.impl;

import com.br.finance.requests.RevenueRequestBody;
import com.br.finance.responses.RevenuesResponseBody;
import com.br.finance.model.Revenue;
import com.br.finance.repository.RevenueRepository;
import com.br.finance.service.RevenueService;
import com.br.finance.service.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.br.finance.mapper.RevenueMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;

    @Override
    public RevenuesResponseBody findAll() {
        return this.calculateRevenues(revenueRepository.findAll());
    }

    private Revenue findById(Long id) {
        return revenueRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Revenue not found"));
    }

    @Override
    public Revenue save(RevenueRequestBody expenseRequestBody) {
        Revenue revenue = INSTANCE.revenueRequestBodytoRevenue(expenseRequestBody);
        return revenueRepository.save(revenue);
    }

    @Override
    public void delete(Long id) {
        revenueRepository.delete(findById(id));
    }

    @Override
    public RevenuesResponseBody calculateRevenues(List<Revenue> revenues) {
        RevenuesResponseBody revenuesResponseBody = new RevenuesResponseBody(new ArrayList<>(), 0D);
        for (Revenue revenue: revenues) {
            revenuesResponseBody.setTotal(revenuesResponseBody.getTotal() + revenue.getValue());
            revenuesResponseBody.getRevenues().add(INSTANCE.revenuetoRevenueRequestBody(revenue));
        }
        return revenuesResponseBody;
    }

}
