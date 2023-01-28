package com.interview.codeassesment.services;

import com.interview.codeassesment.dto.IClientRepository;
import com.interview.codeassesment.dto.ISalesRepository;
import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.models.Sales;
import com.interview.codeassesment.utils.MockData;
import com.interview.codeassesment.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class SalesServiceImplTest {
    @Mock
    private IClientRepository clientRepository;
    @InjectMocks
    private SalesServiceImpl salesService;

    @Test
    void saveSales() {
        Client client = MockData.getClient();
        client.getSales().add(MockData.getSales());
        when(clientRepository.findById(any())).thenReturn(java.util.Optional.of(client));
        when(clientRepository.findById(any())).thenReturn(java.util.Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        ResponseEntity<Response<Client>> responseResponseEntity = salesService.saveSales(1L, 100.0);

        log.info("Response: {}", responseResponseEntity);
        log.info("Response body: {}", responseResponseEntity.getBody());
        assertEquals(200, responseResponseEntity.getStatusCodeValue());
        assertEquals("Sales saved successfully", responseResponseEntity.getBody().getMessage());
        assertEquals(1, responseResponseEntity.getBody().getData().size());
        assertEquals(100.0, responseResponseEntity.getBody().getData().get(0).getSales().get(0).getAmount());
        assertEquals(50, responseResponseEntity.getBody().getData().get(0).getSales().get(0).getPoints());

    }

    @Test
    void listSales() {
        Client client = MockData.getClient();
        client.getSales().add(MockData.getSales());
        when(clientRepository.findAll()).thenReturn(java.util.Collections.singletonList(client));

        ResponseEntity<Response<Client>> responseResponseEntity = salesService.listSales();

        log.info("Response: {}", responseResponseEntity);
        log.info("Response body: {}", responseResponseEntity.getBody());
        assertEquals(200, responseResponseEntity.getStatusCodeValue());
        assertEquals("Sales found successfully", responseResponseEntity.getBody().getMessage());
        assertEquals(1, responseResponseEntity.getBody().getData().size());
        assertEquals(100.0, responseResponseEntity.getBody().getData().get(0).getSales().get(0).getAmount());
        assertEquals(50, responseResponseEntity.getBody().getData().get(0).getSales().get(0).getPoints());
    }

    //Fail test cases
    @Test
    void listSalesByClientFail() {
        Client client = MockData.getClient();
        client.getSales().add(MockData.getSales());
        when(clientRepository.findById(any())).thenReturn(java.util.Optional.empty());

        ResponseEntity<Response<Client>> responseResponseEntity = salesService.listSalesByClient(1L);

        log.info("Response: {}", responseResponseEntity);
        log.info("Response body: {}", responseResponseEntity.getBody());
        assertEquals(400, responseResponseEntity.getStatusCodeValue());
        assertEquals("Client not found", responseResponseEntity.getBody().getMessage());
        assertEquals(null, responseResponseEntity.getBody().getData());
    }

    @Test
    void listSalesByClient() {
        Client client = MockData.getClient();
        client.getSales().add(MockData.getSales());
        when(clientRepository.findById(any())).thenReturn(java.util.Optional.of(client));

        ResponseEntity<Response<Client>> responseResponseEntity = salesService.listSalesByClient(1L);

        log.info("Response: {}", responseResponseEntity);
        log.info("Response body: {}", responseResponseEntity.getBody());
        assertEquals(200, responseResponseEntity.getStatusCodeValue());
        assertEquals("Sales found successfully", responseResponseEntity.getBody().getMessage());
        assertEquals(1, responseResponseEntity.getBody().getData().size());
        assertEquals(100.0, responseResponseEntity.getBody().getData().get(0).getSales().get(0).getAmount());
        assertEquals(50, responseResponseEntity.getBody().getData().get(0).getSales().get(0).getPoints());
    }
}