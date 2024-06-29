package GUI;

import javax.swing.*;
import Herramientas.*;
import Personaje.*;

import java.util.ArrayList;

public class Menu {
    private JPanel panel1;
    private JButton button1; // Crear un personaje jugador
    private JButton button2; // Crear un personaje no jugador
    private JButton button3; // Tirar iniciativa
    private JButton button4; // Tirar percepción
    private JButton button5; // Tirar tasación
    private JButton button6; // Tirar salvación de reflejos
    private JButton button7; // Tirar salvación de voluntad
    private JButton button8; // Tirar salvación de fortaleza
    private JButton button9; //// Salir


    private ArrayList<Personaje> personajesJugadores;
    private ArrayList<PersonajeNoJugador> personajesNoJugadores;
    private FuncionesUtiles funciones;

    public Menu(ArrayList<Personaje> personajesJugadores, ArrayList<PersonajeNoJugador> personajesNoJugadores, FuncionesUtiles funciones) {
        this.personajesJugadores = personajesJugadores;
        this.personajesNoJugadores = personajesNoJugadores;
        this.funciones = funciones;
    }
}
