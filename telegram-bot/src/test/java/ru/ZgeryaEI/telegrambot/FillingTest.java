package ru.ZgeryaEI.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ZgeryaEI.telegrambot.model.Client;
import ru.ZgeryaEI.telegrambot.repository.ClientRepository;

@SpringBootTest

public class FillingTest {
	@Autowired
	private ClientRepository clientRepository;

	@Test
	void createTwoClients() {
		Client client1 = new Client();
		client1.setAddress("address1");
		client1.setExternalId(1L);
		client1.setFullName("fullName1");
		client1.setPhoneNumber("+79789333021");
		clientRepository.save(client1);
		Client client2 = new Client();
		client2.setAddress("address1");
		client2.setExternalId(1L);
		client2.setFullName("fullName1");
		client2.setPhoneNumber("+79789333021");
		clientRepository.save(client2);
	}

}