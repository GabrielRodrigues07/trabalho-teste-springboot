package com.exampleteste.trabalhoteste.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exampleteste.trabalhoteste.entities.Item;
import com.exampleteste.trabalhoteste.entities.Venda;
import com.exampleteste.trabalhoteste.repositories.VendaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		
		Venda venda = new Venda(null, Instant.now());
		
		Item item1 = new Item(null, "Pastel", 10.0);
		Item item2 = new Item(null, "Refrigerante", 5.0);
		Item item3 = new Item(null, "Agua", 2.0);
		
		venda.getItens().addAll(Arrays.asList(item1, item2, item3));
		
		vendaRepository.save(venda);
	}
}
