package com.interview.codeassesment.dto;

import com.interview.codeassesment.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}

