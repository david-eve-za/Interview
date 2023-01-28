package com.interview.codeassesment.utils;

import com.github.javafaker.Faker;
import com.interview.codeassesment.dto.IClientRepository;
import com.interview.codeassesment.models.Client;
import com.interview.codeassesment.models.Sales;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class PrepareData implements CommandLineRunner {

    private final IClientRepository clientRepository;

    public PrepareData(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            for (int i = 0; i < Math.random() * 200; i++) {
                Client client = new Client();
                client.setName(faker.name().name());
                client.setSurname(faker.name().lastName());
                clients.add(client);
            }
            LocalDateTime start = LocalDateTime.now().minusMonths(3);
            LocalDateTime end = LocalDateTime.now();

            while (start.isBefore(end)) {
                for (Client client : clients) {
                    for (int i = 0; i < Math.random() * 10; i++) {
                        Sales sales = new Sales();
                        sales.setAmount(Math.random() * 500);
                        sales.setPoints(Calculation.calculatePoints(sales.getAmount()));
                        sales.setDate(getDate(start));
                        client.getSales().add(sales);
                    }
                }
                start = start.plusDays(1);
            }
            clientRepository.saveAll(clients);
        }
    }

    private Date getDate(LocalDateTime start) {
        return Timestamp.valueOf(start);
    }

}
