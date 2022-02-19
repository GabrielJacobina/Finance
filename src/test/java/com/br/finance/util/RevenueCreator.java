package com.br.finance.util;

import com.br.finance.model.Revenue;

import java.time.LocalDate;

public class RevenueCreator {

    public static Revenue createValidRevenue() {
        return Revenue.builder()
                .id(1L)
                .name("Global")
                .value(8054D)
                .date(LocalDate.now())
                .build();

    }
}
