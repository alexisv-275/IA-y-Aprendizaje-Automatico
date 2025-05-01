import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Agh extends Agent{
 @Override
 protected void setup() {
     addBehaviour(new Comportamiento());
 }

 @Override
 protected void takeDown() {
     System.out.println("nooo mami");

      //Obtener conocimiento --> getArguments()
      //getArguments() obtiene el arreglo que se le dio al usar createNewAgent
        AgentContainer contenedorAgentes = (AgentContainer)getArguments()[0];

        //Obtener ID del agente
        int i= (int)getArguments()[1];
        i++;

        //Darle a los agente hijos el contenedor de agentes y el ID del agente padre
        try {
            contenedorAgentes.createNewAgent("Agh" + i, Agh.class.getName(), new Object[]{contenedorAgentes, i}).start();
            System.out.println(i);
        } catch (StaleProxyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 }
    
 class Comportamiento extends Behaviour {
    //  private boolean done = false; 
     
     @Override
     public void action() {
         // Aquí puedes implementar la lógica que deseas ejecutar en el agente Agh
         System.out.println("Agente Agh está en funcionamiento." + getName());
         doDelete();
     }
 
     @Override
     public boolean done() {
         return true;
     }
 }
}
