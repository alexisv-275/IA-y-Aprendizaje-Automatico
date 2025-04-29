import Agentes.Ag1;
import Agentes.Ag2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Contenedor {

    public void contenedor() {

        /* 
        RUNTIME
        Instancia para controlar ciclo de vida de los contenedores 
        Es como el "motor" que gestiona la plataforma de agentes.
        Sirve para inicializar y gestionar los contenedores de agentes. 
        */

        jade.core.Runtime runtime = jade.core.Runtime.instance(); 

        /*
        PROFILE
        Crea perfil de configuración para el contenedor principal
        */ 
        Profile p = new ProfileImpl(null, 1099, null); 

        //Crear contenedor 
        AgentContainer agentContenedor = runtime.createMainContainer(p); 

        //Agregar agentes
        agregarAgentes(agentContenedor);
    }

    private void agregarAgentes( AgentContainer agentContenedor){
        try {
            //Alias, clase y conocimiento previo (archivo, red neuronal, etc)
            //Hilo o proceso -> start 

            //No hay control de concurrencia

            //Se debe crear primero el agente que va a recibir (RECEPTOR)
            agentContenedor.createNewAgent("Ag2", Ag2.class.getName(), null).start();  
            agentContenedor.createNewAgent("Ag1", Ag1.class.getName(), null).start();
            
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }

    }
}