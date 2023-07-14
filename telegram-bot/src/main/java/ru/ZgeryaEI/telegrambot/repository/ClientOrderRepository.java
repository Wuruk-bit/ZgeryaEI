package ru.ZgeryaEI.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ZgeryaEI.telegrambot.model.Client;
import ru.ZgeryaEI.telegrambot.model.ClientOrder;

import java.util.List;

@RepositoryRestResource(path = "clientOrders", collectionResourceRel="clientOrders", itemResourceRel="clientOrder")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

    List<ClientOrder> findByClient(Client client);

    List<ClientOrder> findByClientId(Long clientId);
}