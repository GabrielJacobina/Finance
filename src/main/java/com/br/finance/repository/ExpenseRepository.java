package com.br.finance.repository;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByStatus(StatusEnum status);

    List<Expense> findAllByType(TypeExpenseEnum type);
}
