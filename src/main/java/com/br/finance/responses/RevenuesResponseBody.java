package com.br.finance.responses;

import com.br.finance.requests.RevenueRequestBody;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RevenuesResponseBody {

    private List<RevenueRequestBody> revenues;
    private Double total;
}
