package br.com.caelum.argentum.testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

	@Test
	public void mesmoMilissegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}

	@Test
	public void comHorariosDiferentesEhNoMesmoDia(){
		Calendar manha = new GregorianCalendar(2011,10,20,8,30);
		Calendar tarde = new GregorianCalendar(2011,10,20,15,30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
		Calendar manha = new GregorianCalendar(2011,10,20,8,30);
		Calendar tarde = new GregorianCalendar(2011,10,20,15,30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertFalse(negociacao.isMesmoDia(tarde));
	}

	@Test
	public void mesmoDiaEMesmasAnosDiferentesNaoSaoDoMesmoDia(){
		Calendar manha = new GregorianCalendar(2012,10,20,8,30);
		Calendar tarde = new GregorianCalendar(2011,10,20,8,30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
}
