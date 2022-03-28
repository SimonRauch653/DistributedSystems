
//Aktive Klasse, da auf die Klasse auf die Klasse Parkhaus aktiv zugreifen möchte

import java.sql.SQLOutput;
import java.util.Random;

public class Auto extends Thread {

    //Def. and dek.
    private Object monitor = new Object();
    Parkhaus parkhaus;


    String kennzeichen = "";
    int zeit_fahren = new Random().nextInt(10);
    int zeit_parken = new Random().nextInt(10);

    //Constructor for the class
    public Auto(String kennzeichen, Parkhaus parkhaus) {

        this.kennzeichen = kennzeichen;
        this.parkhaus = parkhaus;
    }

    public void run() {
        synchronized (monitor) {
            while (parkhaus.autos_im_parkhaus > parkhaus.kapazitaet_autos_im_parkhaus) {
                try {
                    monitor.wait();
                    System.out.println("Warten auf Einfahrt; " + kennzeichen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (parkhaus.autos_im_parkhaus < parkhaus.kapazitaet_autos_im_parkhaus) {
                parkhaus.add();
                System.out.println(parkhaus.autos_im_parkhaus + " Autos im Parkhaus; " + kennzeichen + " eingefahren");
            } else {
                parkhaus.sub();
                System.out.println(parkhaus.autos_im_parkhaus + " Autos im Parkhaus; " + kennzeichen + " ausgefahren");
            }
        }
    }
}