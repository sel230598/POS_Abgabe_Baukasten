package abstrakt;

public class Wuerfel extends Quader{
    public Wuerfel(String art, String farbe, String material, double laenge) {
        super(art, farbe, material, laenge, laenge, laenge);
    }
    public Wuerfel(String zeile){
        super(zeile);
        //Quader;weiß;Eichenholz;6.42
        String[] eigenschaften = zeile.split(";");
        setLaenge(Double.valueOf(eigenschaften[3]));
        setBreite(Double.valueOf(eigenschaften[3]));
        setHoehe(Double.valueOf(eigenschaften[3]));
    }



    public String toString(){
        return super.toString();
    }
}
