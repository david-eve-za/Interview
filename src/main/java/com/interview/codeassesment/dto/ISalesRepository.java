package com.interview.codeassesment.dto;

import com.interview.codeassesment.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalesRepository extends JpaRepository<Sales, Long> {
}

