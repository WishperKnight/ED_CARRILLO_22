package com.testJnunit.com.testJnunit5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
public class PersonaTest 
{
    @Test
    @DisplayName("Mayor de Edad")
    public void testEdad() {
    	Persona per1=new Persona();
    	per1.setEdad(18);
    	
    	assertTrue(per1.esMayorDeEdad());
    	
    }
    @Test
    @DisplayName("Menor de Edad")
    public void testEdad1() {
    	Persona per2=new Persona();
    	per2.setEdad(17);
    	
    	assertFalse(per2.esMayorDeEdad());
    	
    }
    @Test
    @DisplayName("Muy viejo")
    public void testEdad2() {
    	Persona per3=new Persona();
    	per3.setEdad(1800);
    	
    	assertTrue(per3.esMayorDeEdad());
    	
    }
    @Test
    @DisplayName("IMC-Infra")
    public void testIMC() {
    	Persona per1=new Persona();
    	per1.setAltura(100);
    	per1.setPeso(100);
    	
    	assertEquals(-1, per1.calcularIMC());
    	
    }
    @Test
    @DisplayName("IMC-sobre")
    public void testIMC2() {
    	
	    Persona per2=new Persona();
	    per2.setAltura(1.40);
	    per2.setPeso(50);
    
	    assertEquals(1, per2.calcularIMC());
    }
    @Test
    @DisplayName("IMC-norm")
    public void testIMC3() {
    	Persona per3=new Persona();
    	per3.setAltura(1.85);
    	per3.setPeso(85);
    	
    	assertEquals(0, per3.calcularIMC());
    }
    @Test
    @DisplayName("IMC-dif")
    public void testIMC4() {
    	Persona per3=new Persona();
    	per3.setAltura(1);
    	per3.setPeso(0);
    	
    	Persona per4=new Persona();
    	per4.setAltura(1);
    	per4.setPeso(0);
    	
    	assertEquals(per3.calcularIMC(), per4.calcularIMC());
    }
}
