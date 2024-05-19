package abstrakt;

public class Zylinder extends Bauklotz{
    private double radius;
    private double hoehe;


    //konstruktor
    public Zylinder(String art, String farbe, String material, double radius, double hoehe) {
        super(art, farbe, material);
        setHoehe(hoehe);
        setRadius(radius);

    }
    public Zylinder(String zeile){
        super(zeile);
        //Zylinder;blau;Eichenholz;3.54;6.78
        String[] eigenschaften = zeile.split(";");
        setRadius(Double.valueOf(eigenschaften[3]));
        setHoehe(Double.valueOf(eigenschaften[4]));
    }

    //getter setter

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getRadius() {
        return radius;
    }

    public double getHoehe() {
        return hoehe;
    }

    @Override
    public double volumen() {
        return radius * radius * Math.PI * hoehe;
    }
    public String toString(){
        return super.toString() + ";" + radius + ";" + hoehe;
    }

}