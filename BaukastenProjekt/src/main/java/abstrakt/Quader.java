package abstrakt;

public class Quader extends Bauklotz{
    private String name = "Quader";
    private double laenge;
    private double breite;
    private double hoehe;



    //Konstruktor
    public Quader(String art, String farbe, String material, double laenge, double breite, double hoehe) {
        super(art, farbe, material);
        setLaenge(laenge);
        setBreite(breite);
        setHoehe(hoehe);
    }

    public Quader(String zeile){
        super(zeile);
        //Quader;weiß;Eichenholz;6.42;5.91;4.90
        //würfel;weiß;Eichenholz;6.42;
        String[] eigenschaften = zeile.split(";");
        if (this.getClass().getSimpleName().equals("Quader")){
            setLaenge(Double.valueOf(eigenschaften[3]));
            setBreite(Double.valueOf(eigenschaften[4]));
            setHoehe(Double.valueOf(eigenschaften[5]));
        }

    }
    //getter und setter


    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getLaenge() {
        return laenge;
    }

    public double getBreite() {
        return breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public String getName() {
        return name;
    }

    //methoden
    @Override
    public double volumen() {
        return laenge*breite*hoehe;
    }

    @Override
    public String toString(){
        return super.toString() + ";" + laenge + ";" + breite + ";" + hoehe;
    }
}