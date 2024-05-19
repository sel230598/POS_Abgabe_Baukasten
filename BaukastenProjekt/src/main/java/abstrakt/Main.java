package abstrakt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        testSortiungen();
    }

    public static void test(){
        Bauklotz kugel1 = new Kugel("Kugel;rosa;Eichenholz;3.6");
        System.out.println(kugel1.getClass().getSimpleName());
    }
    public static void getGewicht(){
        Baukasten baukasten = new Baukasten();
        Bauklotz kugel1 = new Kugel("Kugel;rosa;Eichenholz;3.6");
        Bauklotz kugel2 = new Kugel("Kugel;rosa;Eichenholz;3.6");
        Bauklotz Quader0 = new Kugel("Quader;schwarz;Eichenholz;6.62;2.71;5.27");
        Bauklotz Quader1 = new Kugel("Quader;schwarz;Eichenholz;6.62;2.71;5.27");
        Bauklotz kugel0 = new Kugel("Kugel;rosa;Eichenholz;2.62");
        Bauklotz Würfel0 = new Kugel("Würfel;rosa;Buchenholz;2.29");
        Bauklotz Würfel1 = new Kugel("Würfel;rosa;Buchenholz;2.29");
        Bauklotz Zylinder0 = new Kugel("Zylinder;gelb;Kiefernholz;3.41;4.36");
        Bauklotz Zylinder1 = new Kugel("Zylinder;gelb;Kiefernholz;3.41;4.36");

        baukasten.einordnen(Quader1, "Quader");
        baukasten.einordnen(Quader0, "Quader");
        baukasten.einordnen(Würfel0, "Würfel");
        baukasten.einordnen(Würfel1, "Würfel");
        baukasten.einordnen(Zylinder0, "Zylinder");
        baukasten.einordnen(Zylinder1, "Zylinder");
        baukasten.einordnen(kugel0, "Kugel");
        baukasten.einordnen(kugel1, "Kugel");


        System.out.println(baukasten);

    }
    public static void testeinordnen(){
        Baukasten baukasten = new Baukasten();
        Bauklotz kugel1 = new Kugel("Kugel;rosa;Eichenholz;3.6");
        Bauklotz kugel2 = new Kugel("Kugel;rosa;Eichenholz;3.6");
        Bauklotz Quader0 = new Kugel("Quader;schwarz;Eichenholz;6.62;2.71;5.27");
        Bauklotz Quader1 = new Kugel("Quader;schwarz;Eichenholz;6.62;2.71;5.27");
        Bauklotz kugel0 = new Kugel("Kugel;rosa;Eichenholz;2.62");
        Bauklotz Würfel0 = new Kugel("Würfel;rosa;Buchenholz;2.29");
        Bauklotz Würfel1 = new Kugel("Würfel;rosa;Buchenholz;2.29");
        Bauklotz Zylinder0 = new Kugel("Zylinder;gelb;Kiefernholz;3.41;4.36");
        Bauklotz Zylinder1 = new Kugel("Zylinder;gelb;Kiefernholz;3.41;4.36");

        baukasten.einordnen(Quader1, "Quader");
        baukasten.einordnen(Quader0, "Quader");
        baukasten.einordnen(Würfel0, "Würfel");
        baukasten.einordnen(Würfel1, "Würfel");
        baukasten.einordnen(Zylinder0, "Zylinder");
        baukasten.einordnen(Zylinder1, "Zylinder");
        baukasten.einordnen(kugel0, "Kugel");
        baukasten.einordnen(kugel1, "Kugel");

//        baukasten.einordnen(kugel2, "Zylinder");
        System.out.println(baukasten);

    }
    public static void testSortiungen(){
        Baukasten baukasten = new Baukasten();
        baukasten.importCSV("C:\\Users\\Sellner\\OneDrive - HTL Spengergasse\\01 POS\\POS Praxis\\02Semester\\Graf\\BaukastenProjekt\\src\\main\\java\\abstrakt\\geschenke.csv");
        //baukasten.sortierenNachFarbeUndGewicht();
        baukasten.sortierenNachMaterial();

        System.out.println(baukasten);
    }
    public static void testImportCsv(){
        Baukasten baukasten = new Baukasten();
        baukasten.importCSV("C:\\Users\\Sellner\\OneDrive - HTL Spengergasse\\01 POS\\POS Praxis\\02Semester\\Graf\\BaukastenProjekt\\src\\main\\java\\abstrakt\\geschenke.csv");
        System.out.println(baukasten);
    }

    public static void testSplit(){
        Bauklotz kugel = new Kugel("Kugel;rosa;Eichenholz;2.62");
        Bauklotz  Quader= new Quader("Quader;weiß;Eichenholz;6.42;5.91;4.90");
        Bauklotz Wuerfel= new Wuerfel("Würfel;grün;Eichenholz;2.99");
        Bauklotz Zylinder = new Zylinder("Zylinder;gelb;Kiefernholz;3.50;4.59");
        System.out.println(kugel);
        System.out.println(Quader);
        System.out.println(Wuerfel);
        System.out.println(Zylinder);
    }
}

