import Herramientas.CrearNPC;
import Personaje.*;
import Herramientas.FuncionesUtiles;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonajeJugador jugador_prueba = new PersonajeJugador("Nel", 2, 3, "Ramiro", 4);
        PersonajeNoJugador npc_prueba1 = new PersonajeNoJugador("Goblin", 1, 2, 1, 2, 3, 4);
        PersonajeNoJugador npc_prueba2 = new PersonajeNoJugador("Orco", 1, 2, 2, 2, 3, 4);
        PersonajeNoJugador npc_prueba3 = new PersonajeNoJugador("Troll", 1, 2, 3, 2, 3, 4);
        ArrayList<PersonajeJugador> listaDePj = new ArrayList<>();
        FuncionesUtiles funciones = new FuncionesUtiles();
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(jugador_prueba);
        personajes.add(npc_prueba1);
        personajes.add(npc_prueba2);
        personajes.add(npc_prueba3);
        funciones.lanzar_iniciativa(personajes);
        for (Personaje personaje : personajes) {
            System.out.println(personaje.getNombre_personaje() + " tiene de iniciativa: " + personaje.getIniciativa_actual());
        }
        System.out.println("-------------------");
        ArrayList<Personaje> personajesOrdenado = new ArrayList<>(funciones.ordenar_iniciativa(personajes));
        for (Personaje personaje : personajesOrdenado) {
            System.out.println(personaje.getNombre_personaje() + " tiene de iniciativa: " + personaje.getIniciativa_actual());
        }
        CrearNPC jose = new CrearNPC();
        PersonajeNoJugador npc = jose.crearNPC();
        System.out.println("nombre: " +npc.getNombre_personaje());
        System.out.println("iniciativa: "+ npc.getModificador_iniciativa());
        System.out.println("Percepcion: " + npc.getPercepcion());
        System.out.println("numero_npc: " + npc.getNumero_npc());
        System.out.println("reflejo: " + npc.getSalvacion_reflejos());
        System.out.println("voluntad: " + npc.getSalvacion_voluntad());
        System.out.println("fortaleza: " + npc.getSalvacion_fortaleza());

    }
}