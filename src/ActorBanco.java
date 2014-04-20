import akka.actor.UntypedActor;

public class ActorBanco extends UntypedActor {
    public static int SALDO = 0;
      
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer) {
            int transaccion = (Integer) message;

            SALDO += transaccion;
            System.out.println("Saldo despues de "+transaccion+": "+SALDO);
            
        } else {
            unhandled(message);
        }
    }
}
