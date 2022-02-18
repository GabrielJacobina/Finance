package com.br.finance.util;

import com.br.finance.responses.RevenuesResponseBody;

import java.util.List;

public class RevenueResponseBodyCreator {

    public static RevenuesResponseBody createRevenueReponseBody() {
        return RevenuesResponseBody.builder()
                .revenues(List.of(RevenueResquestBodyCreator.createRevenueRequestBody()))
                .total(42000D)
                .build();

    }
}
