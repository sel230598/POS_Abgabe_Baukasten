package abstrakt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Baukasten {

    private double eigengewicht;
    HashMap<String, ArrayList<Bauklotz>> abteilungen;

    public Baukasten() {
        eigengewicht = 1;
        //Baukasten erstellen und Abteilungen in den Baukasten legen.
        abteilungen = new HashMap<>();
        abteilungen.put("Kugel", new ArrayList<Bauklotz>());
        abteilungen.put("Würfel", new ArrayList<Bauklotz>());
        abteilungen.put("Quader", new ArrayList<Bauklotz>());
        abteilungen.put("Zylinder", new ArrayList<Bauklotz>());
    }

    //Getter Setter

    public void importCSV(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String zeile = br.readLine();
            int anzGuteZeilen = 0;
            int anzSchlechteZeilen = 0;
            while (zeile != null && !zeile.isEmpty()) {
                if (zeile.startsWith("Kugel") || zeile.startsWith("Quader") || zeile.startsWith("Würfel") || zeile.startsWith("Zylinder")) {
                    String [] teile = zeile.split(";");
                    String name = teile[0];
                    switch(name){
                        case "Kugel":
                            abteilungen.get("Kugel").add(new Kugel(zeile));
                            anzGuteZeilen++;
                            break;
                        case "Quader":
                            abteilungen.get("Quader").add(new Quader(zeile));
                            anzGuteZeilen++;
                            break;
                        case "Würfel":
                            abteilungen.get("Würfel").add(new Wuerfel(zeile));
                            anzGuteZeilen++;
                            break;
                        case "Zylinder":
                            abteilungen.get("Zylinder").add(new Zylinder(zeile));
                            anzGuteZeilen++;
                            break;
                    }
                } else {
                    anzSchlechteZeilen++;
                }
                zeile = br.readLine();
            }
            System.out.println("Anzahl der gültigen Zeilen: " + anzGuteZeilen);
            System.out.println("Anzahl der ungültigen Zeilen: " + anzSchlechteZeilen);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Datei nicht gefunden");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void einordnen(Bauklotz welchen, String abteilung) {
        String [] teile = welchen.toString().split(";");
        String name = teile[0];
        if (welchen.getBaukasten() == null) {
            if (welchen.getArt().equals(abteilung)) {
                switch (abteilung) {
                    case "Kugel":
                        abteilungen.get("Kugel").add(welchen);
                        break;
                    case "Quader":
                        abteilungen.get("Quader").add(welchen);
                        break;
                    case "Würfel":
                        abteilungen.get("Würfel").add(welchen);
                        break;
                    case "Zylinder":
                        abteilungen.get("Zylinder").add(welchen);
                        break;
                    default:
                        System.out.println("Es sind nur die Abteilungen Kugel, Quarder, Wuerfel, Zylinder erlaubt");
                }
            } else {
                System.out.println("Eine Bauklotzart stimmt nicht mit der Abteilung überein!: " + welchen.getArt() + " ungleich " + abteilung + "\n");
            }
        } else {
            System.out.println(("FEHLER: schon auf einem anderen Parkplatz!"));
        }
    }

    public String toString() {
        String str = "";
        String[] abteilungsnamen = {"Kugel", "Quader", "Würfel", "Zylinder"};
        for (String abteilungsname : abteilungsnamen) {
            str += "------------------------------ \n";
            str += "Abteilung " + abteilungsname + "\n";
            str += "------------------------------ \n";
            for (Bauklotz bauklotz : abteilungen.get(abteilungsname)) {
                str += bauklotz.toString() + "\n";
            }
        }
        return str;
    }


    public double gewichtsBerechnung(){
       double sum = 0;
        for(ArrayList<Bauklotz> abteilung : abteilungen.values()){
            for(Bauklotz bauklotz : abteilung){
                sum+= bauklotz.getGewicht();
            }
        }
        return sum + eigengewicht;

    }

    public void sortierenNachFarbeUndGewicht() {
        abteilungen.values().stream().forEach((e)->e.sort(null));
    }

    public void sortierenNachMaterial(){
        abteilungen.values().stream().forEach((e)->e.sort((x,y) -> x.getMaterial().compareTo(y.getMaterial())));
        //bei einfachen Arraylists: sammlung.sort((x,y) -> Math.round((float)(x.gewicht()-y.gewicht())));
    }

    public void getGewichteListe(){
        for (ArrayList<Bauklotz> element : abteilungen.values()){
            element.stream().forEach((e)-> System.out.println(e.getGewicht()));
        }
    }

    public double gesamtGewichtStream(){
        return abteilungen.values().stream().flatMap((e)->e.stream()).mapToDouble((k)->k.getGewicht()).sum()+this.eigengewicht;
        //bei einer einfachen Arraylist: sammlung.stream().mapToDouble((k) -> k.gewicht()).sum();
    }

}