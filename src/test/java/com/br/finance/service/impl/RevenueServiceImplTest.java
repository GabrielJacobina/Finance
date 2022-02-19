package com.br.finance.service.impl;

import com.br.finance.model.Revenue;
import com.br.finance.repository.RevenueRepository;
import com.br.finance.responses.RevenuesResponseBody;
import com.br.finance.exceptions.BadRequestException;
import com.br.finance.util.RevenueCreator;
import com.br.finance.util.RevenueResquestBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RevenueServiceImplTest {

    @InjectMocks
    private RevenueServiceImpl revenueService;

    @Mock
    private RevenueRepository revenueRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(revenueRepositoryMock.findAll())
                .thenReturn(List.of(RevenueCreator.createValidRevenue()));

        LocalDate date = LocalDate.now();
        BDDMockito.when(revenueRepositoryMock.findAllByDateBetween(LocalDate.of(date.getYear(), date.getMonth(),1),
                        LocalDate.of(date.getYear(), date.getMonth(),date.lengthOfMonth())))
                .thenReturn(List.of(RevenueCreator.createValidRevenue()));

        BDDMockito.when(revenueRepositoryMock.save(ArgumentMatchers.any(Revenue.class)))
                .thenReturn(RevenueCreator.createValidRevenue());

        BDDMockito.when(revenueRepositoryMock.findById(ArgumentMatchers.anyLong()))
                        .thenReturn(Optional.of(RevenueCreator.createValidRevenue()));

        BDDMockito.doNothing().when(revenueRepositoryMock).delete(ArgumentMatchers.any(Revenue.class));
    }

    @Test
    void findAll_returnListOfRevenues_WhenSuccessful() {
        String expectedName = RevenueResquestBodyCreator.createRevenueRequestBody().getName();

        RevenuesResponseBody revenues = revenueService.findAll();

        assertThat(revenues).isNotNull();

        assertThat(revenues.getRevenues())
                .isNotEmpty()
                .hasSize(1);

        assertThat(revenues.getRevenues().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    void findAllByMonth_returnListOfRevenues_WhenSuccessful() {
        LocalDate date = LocalDate.now();

        RevenuesResponseBody revenues = revenueService.findAllByMonth(LocalDate.of(2022,2,26));

        assertThat(revenues.getRevenues())
                .isNotEmpty()
                .hasSize(1);

        assertThat(revenues.getRevenues().get(0).getDate()).isEqualTo(date);
    }

    @Test
    void save_returnRevenue_WhenSuccessful() {
        Revenue expectedRevenue = RevenueCreator.createValidRevenue();
        Revenue revenue = revenueService.save(RevenueResquestBodyCreator.createRevenueRequestBody());

        assertThat(revenue)
                .isNotNull()
                .isEqualTo(expectedRevenue);
    }

    @Test
    void delete_deleteRevenue_WhenSuccessful() {
        assertThatCode(() -> revenueService.delete(1L))
                .doesNotThrowAnyException();
    }

    @Test
    void delete_ThrowsBadRequestException_whenRevenueNotFound() {
        BDDMockito.when(revenueRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(BadRequestException.class)
                .isThrownBy(() -> revenueService.delete(2L));
    }
}
