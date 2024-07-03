
import Personaje.Personaje;
import Personaje.PersonajeNoJugador;
import Herramientas.FuncionesUtiles;

import javax.swing.*;
import java.util.ArrayList;
import GUI.NuevoMenu;
public class MainApp {
    public static void main(String[] args) {
        ArrayList<Personaje> personajesJugadores = new ArrayList<>();
        ArrayList<PersonajeNoJugador> personajesNoJugadores = new ArrayList<>();
        FuncionesUtiles funciones = new FuncionesUtiles();

        JFrame frame = new JFrame("NuevoMenu");
        frame.setContentPane(new NuevoMenu(personajesJugadores, personajesNoJugadores, funciones).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
