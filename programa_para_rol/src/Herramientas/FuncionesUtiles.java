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

    public StringBuilder tirar_percepcion_gui(ArrayList<PersonajeJugador> personajesJugadores,int dificultad){
        StringBuilder resultado = new StringBuilder();
        for (PersonajeJugador personaje : personajesJugadores) {
            int resultado_tirada_total = 0;
            int resultado_tirada = 0;
            resultado.append(personaje.getNombre_personaje()).append(" ha sacado un ");
            resultado_tirada = personaje.tirar_percepcion();
            resultado_tirada_total = resultado_tirada + personaje.getPercepcion();
            if (resultado_tirada == 20){
                resultado.append("20 Natural en la tirada de percepcion");
            } else if (resultado_tirada == 1){
                resultado.append("1 Natural en la tirada de percepcion");
            }else {
                if (resultado_tirada_total >= dificultad) {
                    resultado.append(resultado_tirada_total).append("\n") .append(" Ha superado la tirada de percepcion");
                } else {
                    resultado.append(resultado_tirada_total).append("\n") .append(" No ha superado la tirada de percepcion");
                }
            }
            resultado.append("\n").append("---------------------------------").append("\n");
        }
        return resultado;
    }
    public StringBuilder tirar_tasacion_gui (ArrayList<PersonajeJugador> personajesJugadores, int dificultad){
        StringBuilder resultado = new StringBuilder();
        for (PersonajeJugador personaje : personajesJugadores) {
            int resultado_tirada_total = 0;
            int resultado_tirada = 0;
            resultado.append(personaje.getNombre_personaje()).append(" ha sacado un ");
            resultado_tirada = personaje.tirar_tasacion();
            resultado_tirada_total = resultado_tirada + personaje.getTasacion();
            if (resultado_tirada == 20){
                resultado.append("20 Natural en la tirada de tasacion");
            } else if (resultado_tirada == 1){
                resultado.append("1 Natural en la tirada de tasacion");
            }else{
                if(resultado_tirada_total >= dificultad + 5){
                    resultado.append(resultado_tirada_total).append(" Ha superado la tirada de tasacion y puedes saber si es magico o no");
                }else if(resultado_tirada_total >= dificultad) {
                    resultado.append(resultado_tirada_total).append(" Ha superado la tirada de tasacion");
                }else{
                    if (resultado_tirada_total >= dificultad - 5) {
                        resultado.append(resultado_tirada_total).append(" No ha superado la tirada de tasacion").append(" y tiene un 20% de fallo al valor original");
                    }else if(resultado_tirada_total < dificultad - 5){
                        resultado.append(resultado_tirada_total).append(" No ha superado la tirada de tasacion").append(" y tiene un valor aleatorio para el objeto");
                    }else {
                        resultado.append(resultado_tirada_total).append("soy un error");
                    }
                }

            }
            resultado.append("\n") .append("---------------------------------").append("\n");
        }
        return resultado;
    }
    public StringBuilder tirar_fortaleza_gui(ArrayList<PersonajeNoJugador> personajeNoJugadors,int dificultad){
        StringBuilder resultado = new StringBuilder();
        for (PersonajeNoJugador personaje : personajeNoJugadors) {
            int resultado_tirada = 0;
            int resultado_tirada_total = 0;
            resultado.append(personaje.getNombre_personaje()).append(" ").append(personaje.getNumero_npc()).append(" ha sacado un ");
            resultado_tirada = personaje.tirar_salvacion_fortaleza();
            resultado_tirada_total = resultado_tirada + personaje.getSalvacion_fortaleza();
            if (resultado_tirada == 20) {
                resultado.append("20 Natural en la tirada de salvacion de fortaleza");
            } else if (resultado_tirada == 1) {
                resultado.append("1 Natural en la tirada de salvacion de fortaleza");
            } else {
                if (resultado_tirada_total >= dificultad) {
                    resultado.append(resultado_tirada_total).append(" Ha superado la tirada de salvacion de fortaleza");
                } else {
                    resultado.append(resultado_tirada_total).append(" No ha superado la tirada de salvacion de fortaleza").append(" y recibe el daño completo");
                }
            }
            resultado.append("\n") .append("---------------------------------").append("\n");
        }
        return resultado;
    }
    public StringBuilder tirar_reflejos_gui(ArrayList<PersonajeNoJugador> personajeNoJugadors,int dificultad){
        StringBuilder resultado = new StringBuilder();
        for (PersonajeNoJugador personaje : personajeNoJugadors) {
            int resultado_tirada = 0;
            int resultado_tirada_total = 0;
            resultado.append(personaje.getNombre_personaje()).append(" ").append(personaje.getNumero_npc()).append(" ha sacado un ");
            resultado_tirada = personaje.tirar_salvacion_reflejo();
            resultado_tirada_total = resultado_tirada + personaje.getSalvacion_reflejos();
            if (resultado_tirada == 20){
                resultado.append("20 Natural en la tirada de salvacion de reflejos");
            } else if (resultado_tirada == 1) {
                resultado.append("1 Natural en la tirada de salvacion de reflejos");
            }else {
                if(resultado_tirada_total >= dificultad){
                    resultado.append(resultado_tirada_total).append(" Ha superado la tirada de salvacion de reflejos");
                }else{
                    resultado.append(resultado_tirada_total).append(" No ha superado la tirada de salvacion de reflejos").append(" y recibe el daño completo");
                }
            }
            resultado.append("\n") .append("---------------------------------").append("\n");
        }
        return resultado;
    }
    public StringBuilder tirar_voluntad_gui(ArrayList<PersonajeNoJugador> personajeNoJugadors,int dificultad){
        StringBuilder resultado = new StringBuilder();
        for (PersonajeNoJugador personaje : personajeNoJugadors) {
            int resultado_tirada = 0;
            int resultado_tirada_total = 0;
            resultado.append(personaje.getNombre_personaje()).append(" ").append(personaje.getNumero_npc()).append(" ha sacado un ");
            resultado_tirada = personaje.tirar_salvacion_voluntad();
            resultado_tirada_total = resultado_tirada + personaje.getSalvacion_voluntad();
            if (resultado_tirada == 20){
                resultado.append("20 Natural en la tirada de salvacion de voluntad");
            } else if (resultado_tirada == 1) {
                resultado.append("1 Natural en la tirada de salvacion de voluntad");
            }else{
                if(resultado_tirada >= dificultad){
                    resultado.append(resultado_tirada_total).append(" Ha superado la tirada de salvacion de voluntad");
                }else{
                    resultado.append(resultado_tirada_total).append(" No ha superado la tirada de salvacion de voluntad con un resultado de: ").append(" y recibe el daño completo");
                }
            }
            resultado.append("\n") .append("---------------------------------").append("\n");
        }
        return resultado;
    }
}
