package Herramientas;
import Personaje.PersonajeNoJugador;
import Personaje.Personaje;
import Personaje.PersonajeJugador;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesUtiles {
    public ArrayList<Personaje> lanzar_iniciativa(ArrayList<Personaje> personajes) {
        for (Personaje personaje : personajes) {
            if (personaje instanceof PersonajeJugador) {
                PersonajeJugador pj = (PersonajeJugador) personaje;
                pj.tirar_iniciativa(pj.getModificador_iniciativa());
            } else if (personaje instanceof PersonajeNoJugador) {
                PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
                pnj.tirar_iniciativa(pnj.getModificador_iniciativa());
            }
        }
        return personajes;
    }

    public ArrayList<Personaje> ordenar_iniciativa(ArrayList<Personaje> personajes) {
        ArrayList<Personaje> personajesOrdenados = new ArrayList<>(personajes);
        personajesOrdenados.sort((Personaje p1, Personaje p2) -> p2.getIniciativa_actual() - p1.getIniciativa_actual());
        return personajesOrdenados;
    }

    public void tirar_percepcion(ArrayList<Personaje> personajes) {
        Scanner sc = new Scanner(System.in);
        String input;
        int dificultad;
        while (true) {
            try {
                System.out.print("Introdusca la dificultad de la percepcion: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La dificultad de la percepcion no puede estar vacia");
                }
                dificultad = Integer.parseInt(input);
                if (dificultad < 2) {
                    throw new IllegalArgumentException("La dificultad de la percepcion no puede ser negativa ni menor a 2");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido (sin coma)");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

        }
        for (Personaje personaje : personajes) {
            int resultado_tirada = 0;
            if (personaje instanceof PersonajeJugador) {
                PersonajeJugador pj = (PersonajeJugador) personaje;
                resultado_tirada = pj.tirar_percepcion(pj.getPercepcion());
                if (resultado_tirada >= dificultad) {
                    System.out.println(pj.getNombre_personaje() + " ha superado la tirada de percepcion con un resultado de: " + resultado_tirada);
                } else if (personaje instanceof PersonajeNoJugador) {
                    PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
                    pnj.tirar_percepcion(pnj.getPercepcion());
                }
            }
        }
    }
}
