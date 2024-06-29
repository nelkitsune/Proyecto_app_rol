package Herramientas;
import Personaje.PersonajeNoJugador;
import Personaje.Personaje;
import Personaje.PersonajeJugador;
import java.util.ArrayList;
import java.util.Scanner;

//clase con funciones utiles para el programa
public class FuncionesUtiles {
    public ArrayList<Personaje> lanzar_iniciativa(ArrayList<Personaje> personajes) { //metodo para lanzar la iniciativa de los personajes

        for (Personaje personaje : personajes) { //recorremos la lista de personajes

            if (personaje instanceof PersonajeJugador) { //si el personaje es un jugador

                PersonajeJugador pj = (PersonajeJugador) personaje; //casteamos el personaje a un personaje jugador

                pj.tirar_iniciativa(pj.getModificador_iniciativa());//lanzamos la iniciativa del personaje

            } else if (personaje instanceof PersonajeNoJugador) { //si el personaje es un npc

                PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;//casteamos el personaje a un personaje no jugador

                pnj.tirar_iniciativa(pnj.getModificador_iniciativa());//lanzamos la iniciativa del personaje
            }
        }
        return personajes;//devolvemos la lista de personajes con la iniciativa lanzada
    }

    public ArrayList<Personaje> ordenar_iniciativa(ArrayList<Personaje> personajes) { //metodo para ordenar la iniciativa de los personajes

        ArrayList<Personaje> personajesOrdenados = new ArrayList<>(personajes); //creamos una lista con los personajes

        personajesOrdenados.sort((Personaje p1, Personaje p2) -> p2.getIniciativa_actual() - p1.getIniciativa_actual());//ordenamos la lista de personajes segun su iniciativa

        return personajesOrdenados;//devolvemos la lista de personajes ordenada
    }

    public void mostrar_iniciativa(ArrayList<Personaje> personajes) { //metodo para mostrar la iniciativa de los personajes

        for (Personaje personaje : personajes) { //recorremos la lista de personajes

            if (personaje instanceof PersonajeJugador) {//si el personaje es un jugador

                PersonajeJugador pj = (PersonajeJugador) personaje;//casteamos el personaje a un personaje jugador

                System.out.println(pj.getNombre_personaje() + " tiene una iniciativa de: " + pj.getIniciativa_actual());//mostramos la iniciativa del personaje

            } else if (personaje instanceof PersonajeNoJugador) {//si el personaje es un npc

                PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;//casteamos el personaje a un personaje no jugador

                System.out.println(pnj.getNombre_personaje() + " " + pnj.getNumero_npc() +  " tiene una iniciativa de: " + pnj.getIniciativa_actual());//mostramos la iniciativa del personaje

            }

            System.out.println("---------------------------------------------------");//separador
        }
    }

    public void tirar_percepcion(ArrayList<Personaje> personajes) { //metodo para lanzar la percepcion de los personajes
        Scanner sc = new Scanner(System.in);
        String input; //variable para capturar la entrada del usuario
        int dificultad; //dificultad de la percepcion

        while (true) { //validamos que la dificultad de la percepcion no este vacia

            try {//validamos que la dificultad de la percepcion no sea negativa ni menor a 1
                System.out.print("Introdusca la dificultad de la percepcion: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La dificultad de la percepcion no puede estar vacia");
                }
                dificultad = Integer.parseInt(input);
                if (dificultad < 1) {
                    throw new IllegalArgumentException("La dificultad de la percepcion no puede ser negativa ni menor a 1");
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
        //recorremos la lista de personajes
        for (Personaje personaje : personajes) {
            System.out.println("****************************************");
            int resultado_tirada = 0;

            if (personaje instanceof PersonajeJugador) {

                PersonajeJugador pj = (PersonajeJugador) personaje;

                resultado_tirada = pj.tirar_percepcion(pj.getPercepcion());

                if (resultado_tirada >= dificultad) {

                    System.out.println(pj.getNombre_personaje() + " ha superado la tirada de percepcion con un resultado de: " + resultado_tirada);

                } else {

                    System.out.println(pj.getNombre_personaje() +  " no ha superado la tirada de percepcion con un resultado de: " + resultado_tirada);

                }

            }else if (personaje instanceof PersonajeNoJugador) {

                PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;

                resultado_tirada = pnj.tirar_percepcion(pnj.getPercepcion());

                if (resultado_tirada >= dificultad) {

                    System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() +  " ha superado la tirada de percepcion con un resultado de: " + resultado_tirada);

                } else {

                    System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() + " no ha superado la tirada de percepcion con un resultado de: " + resultado_tirada);

                }
            }
        }
    }
    //metodo para lanzar la tasacion de los personajes
    public void tirar_tasacion(ArrayList<Personaje> personajes) {
        Scanner sc = new Scanner(System.in);
        String input;
        int dificultad;
        while (true) {
            try {
                System.out.print("Introdusca la dificultad de la tasacion: ");
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
            System.out.println("****************************************");
            int resultado_tirada = 0;
            PersonajeJugador pj = (PersonajeJugador) personaje;
            resultado_tirada = pj.tirar_tasacion(pj.getTasacion());
            if(resultado_tirada >= dificultad){
                if (resultado_tirada > dificultad + 5){
                    System.out.println(pj.getNombre_personaje() + " ha superado la tirada de tasacion con un resultado de: " + resultado_tirada + " y pueded determinar si es magico");
                }else{
                    System.out.println(pj.getNombre_personaje() + " ha superado la tirada de tasacion con un resultado de: " + resultado_tirada);
                }

            }else{
                if (resultado_tirada > dificultad - 5) {
                    System.out.println(pj.getNombre_personaje() + " no ha superado la tirada de tasacion con un resultado de: " + resultado_tirada + " y tiene un 20% de fallo al valor original");
                }else if(resultado_tirada<= dificultad - 5){
                    System.out.println(pj.getNombre_personaje() + " no ha superado la tirada de tasacion con un resultado de: " + resultado_tirada + " y tiene un valor aleatorio para el objeto");
                }

            }
        }
    }
    public void tirada_reflejos(ArrayList<PersonajeNoJugador> personajeNoJugador){ //metodo para lanzar la salvacion de reflejos de los personajes
        Scanner sc = new Scanner(System.in);
        String input;
        int dificultad;
        while (true) {
            try {
                System.out.print("Introdusca la dificultad de la salvacion de reflejos: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La dificultad de la salvacion de reflejos no puede estar vacia");
                }
                dificultad = Integer.parseInt(input);
                if (dificultad < 2) {
                    throw new IllegalArgumentException("La dificultad de la salvacion de reflejos no puede ser negativa ni menor a 2");
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
        for (PersonajeNoJugador personaje : personajeNoJugador) {
            System.out.println("****************************************");
            int resultado_tirada = 0;
            PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
            resultado_tirada = pnj.tirar_salvacion_reflejo(pnj.getSalvacion_reflejos());
            if(resultado_tirada >= dificultad){
                System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() + " ha superado la tirada de salvacion de reflejos con un resultado de: " + resultado_tirada);
            }else{
                    System.out.println(pnj.getNombre_personaje() + " " + pnj.getNumero_npc() +  " no ha superado la tirada de salvacion de reflejos con un resultado de: " + resultado_tirada + " y recibe el daño completo");
            }
        }
    }

    public void tirada_fortaleza(ArrayList<PersonajeNoJugador> personajeNoJugador){ //metodo para lanzar la salvacion de fortaleza de los personajes
        Scanner sc = new Scanner(System.in);
        String input;
        int dificultad;
        while (true) {
            try {
                System.out.print("Introdusca la dificultad de la salvacion de fortaleza: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La dificultad de la salvacion de fortaleza no puede estar vacia");
                }
                dificultad = Integer.parseInt(input);
                if (dificultad < 2) {
                    throw new IllegalArgumentException("La dificultad de la salvacion de fortaleza no puede ser negativa ni menor a 2");
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
        for (PersonajeNoJugador personaje : personajeNoJugador) {
            System.out.println("****************************************");
            int resultado_tirada = 0;
            PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
            resultado_tirada = pnj.tirar_salvacion_fortaleza(pnj.getSalvacion_fortaleza());
            if(resultado_tirada >= dificultad){
                System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() + " ha superado la tirada de salvacion de fortaleza con un resultado de: " + resultado_tirada);
            }else{
                System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() + " no ha superado la tirada de salvacion de fortaleza con un resultado de: " + resultado_tirada + " y recibe el daño completo");
            }
        }
    }

    public void tirada_voluntad(ArrayList<PersonajeNoJugador> personajeNoJugador){ //metodo para lanzar la salvacion de voluntad de los personajes
        Scanner sc = new Scanner(System.in);
        String input;
        int dificultad;
        while (true) {
            try {
                System.out.print("Introdusca la dificultad de la salvacion de voluntad: ");
                input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("La dificultad de la salvacion de voluntad no puede estar vacia");
                }
                dificultad = Integer.parseInt(input);
                if (dificultad < 2) {
                    throw new IllegalArgumentException("La dificultad de la salvacion de voluntad no puede ser negativa ni menor a 2");
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
        for (PersonajeNoJugador personaje : personajeNoJugador) {
            System.out.println("****************************************");
            int resultado_tirada = 0;
            PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
            resultado_tirada = pnj.tirar_salvacion_voluntad(pnj.getSalvacion_voluntad());
            if(resultado_tirada >= dificultad){
                System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() + " ha superado la tirada de salvacion de voluntad con un resultado de: " + resultado_tirada);
            }else{
                System.out.println(pnj.getNombre_personaje() +  " " + pnj.getNumero_npc() + " no ha superado la tirada de salvacion de voluntad con un resultado de: " + resultado_tirada + " y recibe el daño completo");
            }
        }
    }
}
