package com.interview.codeassesment.services;

import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.utils.Response;
import org.springframework.http.ResponseEntity;

public interface ISalesService {

    ResponseEntity<Response<Client>> saveSales(Long client, Double sales);
    ResponseEntity<Response<Client>> listSales();
    ResponseEntity<Response<Client>> listSalesByClient(Long client);
}
