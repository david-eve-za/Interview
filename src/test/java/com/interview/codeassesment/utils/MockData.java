package com.interview.codeassesment.utils;

import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.models.Sales;

public class MockData {

    public static Client getClient(){
        Client client = new Client();
        client.setId(1L);
        client.setName("John");
        client.setSurname("Doe");
        return client;
    }

    public static Sales getSales(){
        Sales sales = new Sales();
        sales.setAmount(100.0);
        sales.setPoints(50);
        sales.setClient(getClient());
        return sales;
    }
}
