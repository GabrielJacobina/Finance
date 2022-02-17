package com.br.finance.repository;

import com.br.finance.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    List<Revenue> findAllByDateBetween(LocalDate dateInit, LocalDate dateFinal);
}
