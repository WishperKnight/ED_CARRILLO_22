package boletin;

public class Carta_ej5 {
	private String palo;
    private String figura;
    
    public Carta(String palo, String figura) {
        this.palo = palo;
        this.figura = figura;
    }
    
    public String getPalo() {
        return palo;
    }
    
    public String getFigura() {
        return figura;
    }
    
    @Override
    public String toString() {
        return figura + " de " + palo;
    }
}
