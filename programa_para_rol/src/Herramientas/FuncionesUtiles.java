package Herramientas;
import Personaje.PersonajeNoJugador;
import Personaje.Personaje;
import Personaje.PersonajeJugador;

import javax.swing.*;
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

    public void tirar_percepcion(ArrayList<Personaje> personajes, int dificultad, JTextArea textArea) {
        StringBuilder percepcionText = new StringBuilder();
        for (Personaje personaje : personajes) {
            int resultado_tirada;

            if (personaje instanceof PersonajeJugador) {
                PersonajeJugador pj = (PersonajeJugador) personaje;
                resultado_tirada = pj.tirar_percepcion(pj.getPercepcion());

                if (resultado_tirada >= dificultad) {
                    percepcionText.append(pj.getNombre_personaje())
                            .append(" ha superado la tirada de percepción con un resultado de: ")
                            .append(resultado_tirada)
                            .append("\n");
                } else {
                    percepcionText.append(pj.getNombre_personaje())
                            .append(" no ha superado la tirada de percepción con un resultado de: ")
                            .append(resultado_tirada)
                            .append("\n");
                }

            } else if (personaje instanceof PersonajeNoJugador) {
                PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
                resultado_tirada = pnj.tirar_percepcion(pnj.getPercepcion());

                if (resultado_tirada >= dificultad) {
                    percepcionText.append(pnj.getNombre_personaje())
                            .append(" ")
                            .append(pnj.getNumero_npc())
                            .append(" ha superado la tirada de percepción con un resultado de: ")
                            .append(resultado_tirada)
                            .append("\n");
                } else {
                    percepcionText.append(pnj.getNombre_personaje())
                            .append(" ")
                            .append(pnj.getNumero_npc())
                            .append(" no ha superado la tirada de percepción con un resultado de: ")
                            .append(resultado_tirada)
                            .append("\n");
                }
            }
        }

        textArea.setText(percepcionText.toString());
    }

    //metodo para lanzar la tasacion de los personajes
    public void tirar_tasacion(ArrayList<Personaje> personajes, int dificultad, JTextArea textArea) {
        StringBuilder tasacionText = new StringBuilder();
        for (Personaje personaje : personajes) {
            int resultado_tirada = 0;
            PersonajeJugador pj = (PersonajeJugador) personaje;
            resultado_tirada = pj.tirar_tasacion(pj.getTasacion());
            if (resultado_tirada >= dificultad) {
                if (resultado_tirada > dificultad + 5) {
                    tasacionText.append(pj.getNombre_personaje())
                            .append(" ha superado la tirada de tasación con un resultado de: ")
                            .append(resultado_tirada)
                            .append(" y puede determinar si es mágico\n");
                } else {
                    tasacionText.append(pj.getNombre_personaje())
                            .append(" ha superado la tirada de tasación con un resultado de: ")
                            .append(resultado_tirada)
                            .append("\n");
                }
            } else {
                if (resultado_tirada > dificultad - 5) {
                    tasacionText.append(pj.getNombre_personaje())
                            .append(" no ha superado la tirada de tasación con un resultado de: ")
                            .append(resultado_tirada)
                            .append(" y tiene un 20% de fallo al valor original\n");
                } else {
                    tasacionText.append(pj.getNombre_personaje())
                            .append(" no ha superado la tirada de tasación con un resultado de: ")
                            .append(resultado_tirada)
                            .append(" y tiene un valor aleatorio para el objeto\n");
                }
            }
        }
        textArea.setText(tasacionText.toString());
    }
    public void tirada_reflejos(ArrayList<PersonajeNoJugador> personajeNoJugador, int dificultad, JTextArea textArea) {
        StringBuilder reflejosText = new StringBuilder();
        for (PersonajeNoJugador personaje : personajeNoJugador) {
            int resultado_tirada = 0;
            resultado_tirada = personaje.tirar_salvacion_reflejo(personaje.getSalvacion_reflejos());
            if (resultado_tirada >= dificultad) {
                reflejosText.append(personaje.getNombre_personaje())
                        .append(" ")
                        .append(personaje.getNumero_npc())
                        .append(" ha superado la tirada de salvación de reflejos con un resultado de: ")
                        .append(resultado_tirada)
                        .append("\n");
            } else {
                reflejosText.append(personaje.getNombre_personaje())
                        .append(" ")
                        .append(personaje.getNumero_npc())
                        .append(" no ha superado la tirada de salvación de reflejos con un resultado de: ")
                        .append(resultado_tirada)
                        .append(" y recibe el daño completo\n");
            }
        }
        textArea.setText(reflejosText.toString());
    }

    public void tirada_fortaleza(ArrayList<PersonajeNoJugador> personajeNoJugador, int dificultad, JTextArea textArea) {
        StringBuilder fortalezaText = new StringBuilder();
        for (PersonajeNoJugador personaje : personajeNoJugador) {
            int resultado_tirada = 0;
            resultado_tirada = personaje.tirar_salvacion_fortaleza(personaje.getSalvacion_fortaleza());
            if (resultado_tirada >= dificultad) {
                fortalezaText.append(personaje.getNombre_personaje())
                        .append(" ")
                        .append(personaje.getNumero_npc())
                        .append(" ha superado la tirada de salvación de fortaleza con un resultado de: ")
                        .append(resultado_tirada)
                        .append("\n");
            } else {
                fortalezaText.append(personaje.getNombre_personaje())
                        .append(" ")
                        .append(personaje.getNumero_npc())
                        .append(" no ha superado la tirada de salvación de fortaleza con un resultado de: ")
                        .append(resultado_tirada)
                        .append(" y recibe el daño completo\n");
            }
        }
        textArea.setText(fortalezaText.toString());
    }


    public void tirada_voluntad(ArrayList<PersonajeNoJugador> personajeNoJugador, int dificultad, JTextArea textArea) {
        StringBuilder voluntadText = new StringBuilder();
        for (PersonajeNoJugador personaje : personajeNoJugador) {
            int resultado_tirada = 0;
            resultado_tirada = personaje.tirar_salvacion_voluntad(personaje.getSalvacion_voluntad());
            if (resultado_tirada >= dificultad) {
                voluntadText.append(personaje.getNombre_personaje())
                        .append(" ")
                        .append(personaje.getNumero_npc())
                        .append(" ha superado la tirada de salvación de voluntad con un resultado de: ")
                        .append(resultado_tirada)
                        .append("\n");
            } else {
                voluntadText.append(personaje.getNombre_personaje())
                        .append(" ")
                        .append(personaje.getNumero_npc())
                        .append(" no ha superado la tirada de salvación de voluntad con un resultado de: ")
                        .append(resultado_tirada)
                        .append(" y recibe el daño completo\n");
            }
        }
        textArea.setText(voluntadText.toString());
    }

}
