package com.interview.codeassesment.utils;

import com.interview.codeassesment.models.Sales;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ResponseTest {

    @Test
    void getData() {
        List<Sales> salesList = new ArrayList<>();
        Sales sales = new Sales();
        sales.setAmount(100.0);
        sales.setPoints(50);
        salesList.add(sales);
        log.info("Testing Response class");
        Response<Sales> response = new Response<Sales>(salesList, "message", true);
        log.info("Expecting data from response");
        assertEquals(sales, response.getData().get(0));
    }

    @Test
    void getMessage() {
        List<Sales> salesList = new ArrayList<>();
        Sales sales = new Sales();
        sales.setAmount(100.0);
        sales.setPoints(50);
        salesList.add(sales);
        log.info("Testing Response class");
        Response<Sales> response = new Response<Sales>(salesList, "message", true);
        log.info("Expecting message from response");
        assertEquals("message", response.getMessage());
    }

    @Test
    void isSuccess() {
        List<Sales> salesList = new ArrayList<>();
        Sales sales = new Sales();
        sales.setAmount(100.0);
        sales.setPoints(50);
        salesList.add(sales);
        log.info("Testing Response class");
        Response<Sales> response = new Response<Sales>(salesList, "message", true);
        log.info("Expecting success from response");
        assertTrue(response.isSuccess());
    }
}