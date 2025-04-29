package Agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
// import jade.domain.introspection.ACLMessage;

public class Ag2 extends Agent{

    //Configuración inicial agente 
    @Override
    protected void setup() {

        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {
        
        //No llamar al metodo (programación orientada a agentes)
        @Override
        public void action() {

            //Mantiene al agente en espera
            jade.lang.acl.ACLMessage acl = blockingReceive();

            System.out.println(acl);

        }

    

    }
}
