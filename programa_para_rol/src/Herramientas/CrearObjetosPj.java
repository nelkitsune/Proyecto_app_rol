package Herramientas;

import Personaje.PersonajeJugador;
import Personaje.PersonajeNoJugador;

import java.lang.reflect.Array;
import java.util.ArrayList;

//clase para crear los objetos de los personajes jugadores
public class CrearObjetosPj {
    //creamos los objetos de los personajes jugadores
    private PersonajeJugador faunra = new PersonajeJugador("Faunra",4,7,"Merce",0);
    private PersonajeJugador rodgar = new PersonajeJugador("Rodgar",2,6,"Rod",0);
    private PersonajeJugador elaren = new PersonajeJugador("Elaren",2,6,"Vale",-1);
    private PersonajeJugador alfastralio = new PersonajeJugador("Alfastralio",6,4,"Naza",3);
    private PersonajeJugador athroftis = new PersonajeJugador("Athroftis",1,9,"Piers",1);
    private PersonajeJugador gregory = new PersonajeJugador("Gregory",1,0,"Thomas",-2);
    private PersonajeJugador pj = new PersonajeJugador("pj",0,0,"",0);

    //metodo para devolver una lista con los personajes jugadores
    public ArrayList<PersonajeJugador> listaDePj (){
        ArrayList<PersonajeJugador> listaDePj = new ArrayList<>();
        listaDePj.add(faunra);
        listaDePj.add(rodgar);
        listaDePj.add(elaren);
        listaDePj.add(alfastralio);
        listaDePj.add(athroftis);
        listaDePj.add(gregory);
        listaDePj.add(pj);
        return listaDePj;
    }

}
