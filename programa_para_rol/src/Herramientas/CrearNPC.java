package Herramientas;

import Personaje.PersonajeNoJugador;

import java.util.Scanner;

public class CrearNPC {
    public PersonajeNoJugador crearNPC() {
        String nombre_npc;
        String input;
        int iniciativa_npc;
        int percepcion_npc;
        int numero_npc_npc;
        int salvacion_reflejos_npc;
        int salvacion_voluntad_npc;
        int salvacion_fortaleza_npc;
        Scanner sc = new Scanner(System.in);

        while (true) {
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

        while (true){
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



        while (true) {
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


        while (true) {
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


        while (true) {
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


        while (true) {
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


        while (true) {
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


        return new PersonajeNoJugador(nombre_npc, iniciativa_npc, percepcion_npc, numero_npc_npc, salvacion_reflejos_npc, salvacion_voluntad_npc, salvacion_fortaleza_npc);
    }
}
