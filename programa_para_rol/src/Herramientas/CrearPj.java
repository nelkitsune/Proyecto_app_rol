package Herramientas;

import Personaje.PersonajeJugador;

import java.util.Scanner;

public class CrearPj {
    public PersonajeJugador crearPj() {
        //atributos del personaje jugador
        String nombre_pj; //nombre del personaje
        String nombre_jugador; //nombre del jugador
        String input;  //variable para capturar la entrada del usuario
        int iniciativa_pj; //iniciativa del personaje
        int percepcion_pj; //percepcion del personaje
        int tasacion_pj; //tasacion del personaje
        Scanner sc = new Scanner(System.in);

        while (true) {  //validamos que el nombre del personaje no este vacio
            try {
                System.out.print("Introduce el nombre del personaje: ");
                nombre_pj = sc.nextLine();

                if (nombre_pj.trim().isEmpty()) {
                    throw new IllegalArgumentException("El nombre del personaje no puede estar vacío");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        while (true) { //validamos que la iniciativa del personaje no este vacia
            try {
                System.out.print("Introduce la iniciativa del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La iniciativa del personaje no puede estar vacia");
                }
                iniciativa_pj = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //validamos que la percepcion del personaje no este vacia
            try {
                System.out.print("Introduce la percepción del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La percepción del personaje no puede estar vacía");
                }
                percepcion_pj = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) { //validamos que el nombre del jugador no este vacio
            try {
                System.out.print("Introduce el nombre del jugador: ");
                nombre_jugador = sc.nextLine();
                if (nombre_jugador.trim().isEmpty()) {
                    throw new IllegalArgumentException("El nombre del jugador no puede estar vacío");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) { //validamos que la tasacion del personaje no este vacia
            try {
                System.out.print("Introduce la tasación del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La tasación del personaje no puede estar vacía");
                }
                tasacion_pj = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        //retornamos un nuevo personaje jugador
        return new PersonajeJugador(nombre_pj, iniciativa_pj, percepcion_pj, nombre_jugador, tasacion_pj);
    }
}
