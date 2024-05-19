package abstrakt;

import java.util.Arrays;
import java.util.Objects;

public abstract class Bauklotz implements Comparable<Bauklotz>{

    private String art;
    private String farbe;
    private String material;
    private Baukasten baukasten;

    //konstructor
    public Bauklotz(String art, String farbe, String material) {
        setArt(art);
        setFarbe(farbe);
        setMaterial(material);
    }
    public Bauklotz(String zeile){
        //Quader;weiß;Eichenholz;6.42;5.91;4.90
        String[] eigenschaften = zeile.split(";");
        setArt(eigenschaften[0]);
        setFarbe(eigenschaften[1]);
        setMaterial(eigenschaften[2]);
    }

    //Getter
    public String getArt() {
        return art;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getMaterial() {
        return material;
    }

    public Baukasten getBaukasten() {
        return baukasten;
    }

    //Setter
    public void setArt(String art) {
        this.art = art;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setBaukasten(Baukasten baukasten) {
        this.baukasten = baukasten;
    }

    //Methoden
    public abstract double volumen();

    public double getDichte(){
        if (this.material.equals("Buchenholz")){
            return 0.68;
        } else if (this.material.equals("Eichenholz")){
            return 0.67;
        } else if (this.material.equals("Kieferholz")) {
            return 0.52;
        } else if (this.material.equals("Fichtenholz")) {
            return 0.46;
        }
        return 0;
    }

    public String toString(){
        return this.art + ";" + this.farbe + ";" + this.material;
    }

    public double getGewicht(){
        return volumen() * getDichte();
    }

    public int compareTo(Bauklotz o){

        if(Objects.equals(this.farbe, o.getFarbe())){
            return (int)Math.floor(o.getGewicht()- this.getGewicht());
        } else {
            return this.getFarbe().compareTo(o.getFarbe());
        }
    }

}