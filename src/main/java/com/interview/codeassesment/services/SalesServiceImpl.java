package com.interview.codeassesment.services;

import com.interview.codeassesment.dto.IClientRepository;
import com.interview.codeassesment.dto.ISalesRepository;
import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.models.Sales;
import com.interview.codeassesment.utils.Calculation;
import com.interview.codeassesment.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements ISalesService {

    private final IClientRepository clientRepository;

    public SalesServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<Response<Client>> saveSales(Long client, Double sales) {
        Client client1 = clientRepository.findById(client).orElse(null);
        if (client1 == null) {
            return ResponseEntity.badRequest().body(new Response<Client>(null, "Client not found",false));
        }
        List<Client> salesList = new ArrayList<>();
        Sales sales1 = new Sales();
        sales1.setAmount(sales);
        sales1.setPoints(Calculation.calculatePoints(sales));
        sales1.setDate(new Date());
        sales1.setClient(client1);
        try {
            client1.getSales().add(sales1);
            clientRepository.save(client1);
            salesList.add(client1);
            return ResponseEntity.ok().body(new Response<Client>(salesList, "Sales saved successfully",true));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<Client>(null, "Sales not saved",false));
        }
    }

    @Override
    public ResponseEntity<Response<Client>> listSales() {
        List<Client> salesList = clientRepository.findAll();
        if (salesList.isEmpty()) {
            return ResponseEntity.badRequest().body(new Response<Client>(null, "Sales not found",false));
        }
        return ResponseEntity.ok().body(new Response<Client>(salesList, "Sales found successfully",true));
    }

    @Override
    public ResponseEntity<Response<Client>> listSalesByClient(Long client) {
        Client client1 = clientRepository.findById(client).orElse(null);
        if (client1 == null) {
            return ResponseEntity.badRequest().body(new Response<Client>(null, "Client not found",false));
        }
        List<Client> salesList = new ArrayList<>();
        salesList.add(client1);
        return ResponseEntity.ok().body(new Response<Client>(salesList, "Sales found successfully",true));
    }
}

