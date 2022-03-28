
//Passive Klasse, da diese Klasse nur die Simulation beinhaltet

public class Simulation {

    public static void main(String args[]) throws InterruptedException{

        //neues Parkhaus mit Kapazitaet fuer 10 Autos
        Parkhaus parkhaus = new Parkhaus(10);
        for(int i = 1; i <= 20; i++){
            new Thread(new Auto("R-FH-" + i, parkhaus)).start();
        }
        Thread.sleep(30000);
        System.out.println("Ende der Simulation");
    }
}
