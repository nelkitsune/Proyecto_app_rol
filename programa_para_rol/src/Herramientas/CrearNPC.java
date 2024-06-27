package Herramientas;

import Personaje.PersonajeNoJugador;

import java.util.Scanner;

public class CrearNPC { //clase para crear un personaje no jugador
    public PersonajeNoJugador crearNPC() {
        //atributos del personaje no jugador
        String nombre_npc; //nombre del personaje
        String input;  //variable para capturar la entrada del usuario
        int iniciativa_npc; //iniciativa del personaje
        int percepcion_npc; //percepcion del personaje
        int numero_npc_npc; //numero del personaje
        int salvacion_reflejos_npc; //salvacion de reflejos del personaje
        int salvacion_voluntad_npc; //salvacion de voluntad del personaje
        int salvacion_fortaleza_npc; //salvacion de fortaleza del personaje
        Scanner sc = new Scanner(System.in);

        while (true) {  //validamos que el nombre del personaje no este vacio
            try {
                System.out.print("Introduce el nombre del personaje: ");
                nombre_npc = sc.nextLine();

                if (nombre_npc.trim().isEmpty()) {
                    throw new IllegalArgumentException("El nombre del personaje no puede estar vacío");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        while (true){ //validamos que la iniciativa del personaje no este vacia
            try {
                System.out.print("Introduce la iniciativa del personaje: ");
                input = sc.nextLine();
                if(input.trim().isEmpty()){
                    throw new IllegalArgumentException("La iniciativa del personaje no puede estar vacia");
                }
                iniciativa_npc = Integer.parseInt(input);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido (sin coma)");
                continue;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
        }



        while (true) { //validamos que la percepcion del personaje no este vacia
            try {
                System.out.print("Introduce la percepción del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La percepción del personaje no puede estar vacía");
                }
                percepcion_npc = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) { //validamos que el numero del personaje no este vacio
            try {
                System.out.print("Introduce el número del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("El número del personaje no puede estar vacío");
                }
                numero_npc_npc = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) { //validamos que la salvacion de reflejos del personaje no este vacia
            try {
                System.out.print("Introduce la salvación de reflejos del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La salvación de reflejos del personaje no puede estar vacía");
                }
                salvacion_reflejos_npc = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) { //validamos que la salvacion de voluntad del personaje no este vacia
            try {
                System.out.print("Introduce la salvación de voluntad del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La salvación de voluntad del personaje no puede estar vacía");
                }
                salvacion_voluntad_npc = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) { //validamos que la salvacion de fortaleza del personaje no este vacia
            try {
                System.out.print("Introduce la salvación de fortaleza del personaje: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La salvación de fortaleza del personaje no puede estar vacía");
                }
                salvacion_fortaleza_npc = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido (sin coma)");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //retornamos un nuevo personaje no jugador
        return new PersonajeNoJugador(nombre_npc, iniciativa_npc, percepcion_npc, numero_npc_npc, salvacion_reflejos_npc, salvacion_voluntad_npc, salvacion_fortaleza_npc);
    }
}
