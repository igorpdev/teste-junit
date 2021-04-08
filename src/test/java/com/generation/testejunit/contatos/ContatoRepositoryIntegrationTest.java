package com.generation.testejunit.contatos;

import java.util.List;

import com.generation.testejunit.model.ContatoModel;
import com.generation.testejunit.repository.ContatoRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContatoRepositoryIntegrationTest {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Before
	public void start() {
		
		ContatoModel contato = new ContatoModel("Chefe", "0y", "9xxxxxxx9");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new ContatoModel("Novo Chefe", "0y", "8xxxxxxx8");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new ContatoModel("chefe Mais Antigo", "0y", "7xxxxxxx7");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new ContatoModel("Amigo", "0z", "5xxxxxxx5");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
	}
	
	@Test
	public void findByNomeRetornaContato() throws Exception {
		ContatoModel contato = contatoRepository.findFirstByNome("Chefe");
		Assert.assertTrue(contato.getNome().equals("Chefe"));
	}
	
	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContato() {
		List<ContatoModel> contatos = contatoRepository.findAllByNomeContainingIgnoreCase("chefe");
		Assert.assertEquals(3, contatos.size());
	}
	
	@After
		public void end() {
		contatoRepository.deleteAll();
	}

}