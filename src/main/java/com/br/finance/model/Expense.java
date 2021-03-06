package com.br.finance.model;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double value;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TypeExpenseEnum type;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
