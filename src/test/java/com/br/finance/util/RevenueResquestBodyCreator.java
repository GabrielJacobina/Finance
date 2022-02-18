package com.br.finance.util;

import com.br.finance.requests.RevenueRequestBody;

import java.time.LocalDate;

public class RevenueResquestBodyCreator {

    public static RevenueRequestBody createRevenueRequestBody() {
        return RevenueRequestBody.builder()
                .name("Global")
                .value(8054D)
                .date(LocalDate.now())
                .build();
    }
}
