
//Passive Klasse, da auf die Klasse zugegriffen wird aber die Klasse nicht aktiv auf etwas zugreifen möchte

public class Parkhaus {

    int kapazitaet_autos_im_parkhaus = 0;
    int autos_im_parkhaus = 0;

    public Parkhaus(int anzahl_Parkplaetze) {
        this.kapazitaet_autos_im_parkhaus = anzahl_Parkplaetze;
    }

    public synchronized void add(){
        autos_im_parkhaus++;
    }

    public synchronized void sub(){
        autos_im_parkhaus--;
    }

}
