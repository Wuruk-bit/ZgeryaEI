package ru.ZgeryaEI.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ZgeryaEI.telegrambot.model.Client;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", itemResourceRel = "clients", path = "clients")
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFullName(String name);
}