package com.br.finance.mapper;

import com.br.finance.dto.RevenueRequestBody;
import com.br.finance.model.Revenue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class RevenueMapper {

    public static final RevenueMapper INSTANCE = Mappers.getMapper(RevenueMapper.class);

    public abstract Revenue revenueRequestBodytoRevenue(RevenueRequestBody revenueRequestBody);

    public abstract RevenueRequestBody revenuetoRevenueRequestBody(Revenue revenue);

}
