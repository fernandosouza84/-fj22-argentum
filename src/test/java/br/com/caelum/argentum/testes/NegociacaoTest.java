package br.com.caelum.argentum.testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n  = new Negociacao(10, 5, c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nãoCriaNegociacaoComDataNula(){
		new Negociacao(10, 5, null);
	}

}
