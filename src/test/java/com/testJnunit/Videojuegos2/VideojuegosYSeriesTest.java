package com.testJnunit.Videojuegos2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class VideojuegosYSeriesTest 
    
{
	private static final int Videojuego = 0;
	Serie s = new Serie("yo",4,"Drama","pepe");
	Serie a = new Serie("",0," ","Juan");
	Serie aA = new Serie("",0," ","Juan");
	
	Videojuego v = new Videojuego("x", 50,"XXX", "Sony");
	Videojuego w = new Videojuego("x", 50,"XXX", "Sony");
	private int IsEqual;
   @Test
   @DisplayName("Videojuego Igual")
   public void testVGI() {
	assertEquals(0,v.compareTo(w));   
   }
   @Test
   @DisplayName("Videojuego menor")
   public void testVGm() {
	   w.setHorasEstimadas(5);
	   assertEquals(-1, w.compareTo(v));
   }
   @Test
   @DisplayName("Videojuego Mayor")
   public void testVGM() {
	   w.setHorasEstimadas(500);
	   assertEquals(1, w.compareTo(v));
   }
   @Test
   @DisplayName("Son iguales dos  identicos")
   public void testVG() {
	   assertTrue(v.equals(w));   
   }
   @Test
   @DisplayName("misma compañia")
   public void testCompania () {
	    assertEquals("Sony", v.getcompania());
   }
   @Test
   @DisplayName("Entregado")
   public void testEntre(){
	   v.entregar();
	   assertTrue(v.isEntregado());
   }
   @Test
   @DisplayName("Devuelto")
   public void testDev(){
	   v.devolver();
	   assertFalse(v.isEntregado());
   }
   @Test
   @DisplayName("Devuelto S")
   public void testDev1(){
	   a.devolver();
	   assertFalse(a.isEntregado());
   }
   @Test
   @DisplayName("Entregado S")
   public void testEntre1(){
	   a.entregar();
	   assertTrue(a.isEntregado());
   }
   @Test
   @DisplayName("Son iguales dos series")
   public void testS() {
	   assertTrue(a.equals(aA));   
   }
   @Test
   @DisplayName("Serie Mayor")
   public void testSM() {
	   assertEquals(1, s.compareTo(aA));
   }
   @Test
   @DisplayName("Serie igual")
   public void testSE() {
	   assertEquals(0, a.compareTo(aA));
   }
   @Test
   @DisplayName("Serie menor")
   public void testSm() {
	   assertEquals(-1, aA.compareTo(s));
   }
   @Test
   public void testLengthOfTheUniqueKey() {
     String key = "unique_key";
     assertThat(key, hasLength(10));
   }

   @SuppressWarnings("rawtypes")
private Matcher hasLength(int i) {
	// TODO Auto-generated method stub
	return null;
}
@Test
   public void testStringEquality() {
     String s1 = "hello";
     String s2 = "hello";
     assertThat(s1, (equals(s2)));
   }

   @Test
   public void testListIsNotEmpty() {
     List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
     assertThat(numbers, is(not(empty())));
   }

   private void assertThat(List<Integer> numbers, Matcher hasKey) {
	// TODO Auto-generated method stub
	
}
private Matcher is(Object not) {
	// TODO Auto-generated method stub
	return null;
}
private Object not(Object empty) {
	// TODO Auto-generated method stub
	return null;
}
private Object empty() {
	// TODO Auto-generated method stub
	return null;
}
@Test
   public void testMapContainsKey() {
     Map<String, Integer> map = new HashMap<String, Integer>();
     map.put("A", 1);
     map.put("B", 2);
     assertThat(map, hasKey("A"));
   }

   private void assertThat(Map<String, Integer> map, @SuppressWarnings("rawtypes") Matcher hasKey) {
	// TODO Auto-generated method stub
	
}
@SuppressWarnings("rawtypes")
private void assertThat(String key, Matcher hasKey) {
	// TODO Auto-generated method stub
	
}
private Matcher hasKey(String string) {
	// TODO Auto-generated method stub
	return null;
}
@Test
   public void testMapContainsValue() {
     Map<String, Integer> map = new HashMap<String, Integer>();
     map.put("A", 1);
     map.put("B", 2);
     assertThat(map, hasValue(2));
   }

   private Matcher hasValue(int i) {
	// TODO Auto-generated method stub
	return null;
}
@Test
	  public void testGetTitulo() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setTitulo("Super Mario Bros");
	    assertThat(videojuego.getTitulo(), equals("Super Mario Bros"));
	  }

	  @Test
	  public void testGetHorasEstimadas() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setHorasEstimadas(10);
	    assertThat(videojuego.getHorasEstimadas(), equals(10));
	  }

	  private void assertThat(int horasEstimadas, boolean equals) {
		// TODO Auto-generated method stub
		
	}
	@Test
	  public void testGetGenero() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setGenero("Plataformas");
	    assertThat(videojuego.getGenero(), equals("Plataformas"));
	  }

	  private void assertThat(String genero, boolean equals) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	  public void testGetCompania() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.setcompania("Nintendo");
	    assertThat(videojuego.getcompania(), equals("Nintendo"));
	  }

	  @Test
	  public void testEntregar() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.entregar();
	    assertThat(videojuego.isEntregado(), equals(true));
	  }

	  private void assertThat(boolean entregado, boolean equals) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	  public void testDevolver() {
	    Videojuego videojuego = new Videojuego();
	    videojuego.entregar();
	    videojuego.devolver();
	    assertThat(videojuego.isEntregado(), equals(false));
	  }

	  @Test
	  public void testCompareTo() {
	    Videojuego videojuego1 = new Videojuego();
	    videojuego1.setHorasEstimadas(10);
	    Videojuego videojuego2 = new Videojuego();
	    videojuego2.setHorasEstimadas(20);
	    assertThat(videojuego1.compareTo(videojuego2), equals(-1));
	  }
}

