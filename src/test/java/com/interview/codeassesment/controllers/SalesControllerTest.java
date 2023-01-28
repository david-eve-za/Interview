package com.interview.codeassesment.controllers;

import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.models.Sales;
import com.interview.codeassesment.services.ISalesService;
import com.interview.codeassesment.utils.MockData;
import com.interview.codeassesment.utils.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesController.class)
class SalesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISalesService salesService;

    @Test
    void newSales() throws Exception {
        Client client = MockData.getClient();
        client.getSales().add(MockData.getSales());
        List<Client> salesList = new ArrayList<>();
        salesList.add(client);
        when(salesService.saveSales(anyLong(), anyDouble()))
                .thenReturn(ResponseEntity.ok(new Response<>(salesList, "Sales saved successfully", true)));

        mockMvc.perform(post("/api/v1/sales/addSale")
                .param("sales", "100")
                .param("client", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sales saved successfully")))
                .andReturn();
    }
}