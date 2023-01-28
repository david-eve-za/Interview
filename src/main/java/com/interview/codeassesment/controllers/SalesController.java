package com.interview.codeassesment.controllers;

import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.services.ISalesService;
import com.interview.codeassesment.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    private final ISalesService salesService;

    public SalesController(ISalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/addSale")
    public ResponseEntity<Response<Client>> newSales(@RequestParam(name = "sales",required = true) Double sales,
                                                     @RequestParam(name = "client",required = true) Long client){


        return salesService.saveSales(client,sales);
    }

    @GetMapping("/listSales")
    public ResponseEntity<Response<Client>> listSales(){
        return salesService.listSales();
    }

    @GetMapping("/listSalesByClient/{client}")
    public ResponseEntity<Response<Client>> listSalesByClient(@PathVariable Long client){
        return salesService.listSalesByClient(client);
    }
}
