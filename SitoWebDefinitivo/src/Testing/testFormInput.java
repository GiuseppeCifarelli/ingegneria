package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllore.Registrazione;

class testFormInput {
	Registrazione object;
	
	@BeforeEach
	void setUp() throws Exception {
		object = new Registrazione();
	}

	@AfterEach
	void tearDown() throws Exception {
		object = null;
	}

	@Test
	final void testControlloFormattazioneCase1() {
		boolean oracolo = false;
		boolean result = object.controlloFormattazione("");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloFormattazioneCase2() {
		boolean oracolo = false;
		boolean result = object.controlloFormattazione("St##Prova/");
		assertEquals(oracolo,result);
	}

	@Test
	final void testControlloFormattazioneCase3() {
		boolean oracolo = true;
		boolean result = object.controlloFormattazione("stringa");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloFormattazioneCase4() {
		boolean oracolo = false;
		boolean result = object.controlloFormattazione(null);
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloFormattazioneConNumeriCase1() {
		boolean oracolo = false;
		boolean result = object.controlloFormattazioneConNumeri("");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloFormattazioneConNumeriCase2() {
		boolean oracolo = false;
		boolean result = object.controlloFormattazioneConNumeri("St##Prova/");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloFormattazioneConNumeriCase3() {
		boolean oracolo = true;
		boolean result = object.controlloFormattazioneConNumeri("Stringa123");
		assertEquals(oracolo,result);	
		}
	
	@Test
	final void testControlloFormattazioneConNumeriCase4() {
		boolean oracolo = false;
		boolean result = object.controlloFormattazioneConNumeri(null);
		assertEquals(oracolo,result);	
		}

	@Test
	final void testControlloNumeroCase1() {
		boolean oracolo = false;
		boolean result = object.controlloNumero("");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloNumeroCase2() {
		boolean oracolo = false;
		boolean result = object.controlloNumero("Stringa123");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloNumeroCase3() {
		boolean oracolo = true;
		boolean result = object.controlloNumero("1234567890");
		assertEquals(oracolo,result);
	}
	
	@Test
	final void testControlloNumeroCase4() {
		boolean oracolo = false;
		boolean result = object.controlloNumero(null);
		assertEquals(oracolo,result);
	}

}
