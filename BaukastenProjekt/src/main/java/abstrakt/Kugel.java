package abstrakt;

public class Kugel extends Bauklotz {
    private double radius;

    //konstruktoren
    public Kugel(String art, String farbe, String material, double radius) {
        super(art, farbe, material);
        setRadius(radius);
    }
    public Kugel(String zeile){
        super(zeile);
        //Kugel;lila;Fichtenholz;3.35
        String[] eigenschaften = zeile.split(";");
        if (eigenschaften.length-1 == 3){
            setRadius(Double.valueOf(eigenschaften[3]));
        }else {
            System.out.println("Eine Kugel hat zu viele oder zu wenig Werte: " + zeile);
        }
    }

    //getters setters

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //methoden
    @Override
    public double volumen() {
        return 4.0/3.0*radius*radius*radius*Math.PI;
    }

    public String toString(){
        return super.toString() + ";" + radius;
    }


}
