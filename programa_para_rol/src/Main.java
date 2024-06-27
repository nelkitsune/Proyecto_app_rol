import Herramientas.CrearNPC;
import Herramientas.CrearObjetosPj;
import Personaje.*;
import Herramientas.FuncionesUtiles;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //iniciamos el programa y creamos los objetos necesarios
        Scanner sc = new Scanner(System.in);
        CrearObjetosPj seteo_pj = new CrearObjetosPj();
        ArrayList<Personaje> personajesJugadores = new ArrayList<>(seteo_pj.listaDePj());
        ArrayList<PersonajeNoJugador> personajesNoJugadores = new ArrayList<>();
        FuncionesUtiles funciones = new FuncionesUtiles();

        //menu de opciones para el usuario
        while(true){
            System.out.println("1. Crear un personaje no jugador");
            System.out.println("2. tirar iniciativa");
            System.out.println("3. tirar percepcion");
            System.out.println("4. tirar tasación");
            System.out.println("5. tirar salvacion de reflejos");
            System.out.println("6. tirar salvacion de voluntad");
            System.out.println("7. tirar salvacion de fortaleza");
            System.out.println("8. Salir");

            int opcion;

            //validamos que la opcion sea un numero entero
            try {
                System.out.print("Introduce una opción: ");
                String input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La salvación de reflejos del personaje no puede estar vacía");
                }
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido (sin coma)");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            switch (opcion){//segun la opcion que elija el usuario se ejecutara una funcion
                case 1://creamos un npc
                    CrearNPC crear_npc = new CrearNPC();
                    personajesNoJugadores.add(crear_npc.crearNPC());
                    System.out.println("se creo correctamente el npc");
                    break;
                case 2://lanzamos la iniciativa y mostramos el orden de los personajes
                    ArrayList<Personaje> lista_combate = new ArrayList<>();
                    lista_combate.addAll(personajesJugadores);
                    lista_combate.addAll(personajesNoJugadores);
                    funciones.lanzar_iniciativa(lista_combate);
                    ArrayList<Personaje> lista_combate_ordenada = funciones.ordenar_iniciativa(lista_combate);
                    funciones.mostrar_iniciativa(lista_combate_ordenada);
                    break;
                case 3://lanzamos la percepcion de los personajes
                    funciones.tirar_percepcion(personajesJugadores);
                    break;

                case 4://lanzamos la tasacion de los personajes
                    funciones.tirar_tasacion(personajesJugadores);
                    break;
                case 5://lanzamos la salvacion de reflejos de los personajes
                    funciones.tirada_reflejos(personajesNoJugadores);
                    break;
                case 6://lanzamos la salvacion de voluntad de los personajes
                    funciones.tirada_voluntad(personajesNoJugadores);
                    break;
                case 7://lanzamos la salvacion de fortaleza de los personajes
                    funciones.tirada_fortaleza(personajesNoJugadores);
                    break;
                case 8://salimos del programa
                    System.exit(0);
                    break;
                default://opcion no valida
                    System.out.println("Opción no válida");
            }
        }


    }
}