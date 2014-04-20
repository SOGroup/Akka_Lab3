
import akka.actor.UntypedActor;

public class ActorTransacciones extends UntypedActor {

    private int operaciones[];
    private String persona;
    
    public ActorTransacciones(String persona, int operaciones[]) {
        super();
        this.persona = persona;        
        this.operaciones = operaciones;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            String s = (String) message;

            switch (s) {
                case "Operar": {
                    for (int i = 0; i < operaciones.length; i++) {
                        //SALDO += operaciones[i];
                        
                        //System.out.println(this.getPersona()+ i + ". Saldo despues de transaccion " + operaciones[i] + ": " + SALDO);
                    }
                    //System.out.println("Saldo despues de operaciones de "+this.getPersona()+": "+SALDO);
                    break;
                }
                default:
                    System.out.println("huu?");
            }
        } else {
            unhandled(message);
        }
    }

    public void setOperaciones(int op[]) {
        this.operaciones = op;
    }
    
    public void setPersona(String persona) {
        this.persona = persona;
    }
    
    public String getPersona() {
        return this.persona;
    }
}
