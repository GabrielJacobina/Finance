package com.br.finance.repository;

import com.br.finance.model.Revenue;
import com.br.finance.util.RevenueCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RevenueRepositoryTest {

    @Autowired
    private RevenueRepository revenueRepository;

    private LocalDate dateNow;

    @BeforeEach
    void setUp() {
        revenueRepository.save(RevenueCreator.createRevenueToBeSaved());
        this.dateNow = LocalDate.now();
    }

    @Test
    void findAllByDateBetween_returnListRevenue_whenSuccesful() {
        List<Revenue> revenues = revenueRepository.findAllByDateBetween(LocalDate.of(dateNow.getYear(), dateNow.getMonth(), 1),
                LocalDate.of(dateNow.getYear(), dateNow.getMonth(), dateNow.lengthOfMonth()));

        assertThat(revenues).isNotEmpty();
    }
}
