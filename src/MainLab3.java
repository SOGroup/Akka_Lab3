
import akka.actor.ActorContext;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainLab3 {
    
    public static void main(String[] args) throws FileNotFoundException {
        int numA;
        int numB;
        
        // Lectura archivo
        File fichero = new File("src/Operaciones.txt");
        Scanner sc = new Scanner(fichero);
        numA = sc.nextInt();
        int[] operacionesA = new int[numA]; //Operaciones A
        numB = sc.nextInt();
        int operacionesB[] = new int[numB]; //Operaciones B

        for (int i = 0; i < numA; i++) {
            operacionesA[i] = sc.nextInt();
        }
        for (int i = 0; i < numB; i++) {
            operacionesB[i] = sc.nextInt();
        }
        
        // Creación actores
        ActorSystem system = ActorSystem.create("Banco");
        ActorRef actorA = system.actorOf(Props.create(ActorTransacciones.class,"A",operacionesA), "A");
        ActorRef actorB = system.actorOf(Props.create(ActorTransacciones.class,"B",operacionesB), "B");
        ActorRef actorBanco = system.actorOf(Props.create(ActorBanco.class), "Banco");
                
        actorBanco.tell(15, null);
        actorBanco.tell(-5, null);
        //actorA.tell("Operar", null);
        //actorB.tell("Operar", null);

        system.shutdown();
        system.awaitTermination(); //JOIN
    }
}
