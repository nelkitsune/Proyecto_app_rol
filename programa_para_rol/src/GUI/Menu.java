package GUI;

import javax.swing.*;
import Herramientas.*;
import Personaje.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CrearPj crearPj = new CrearPj();
                personajesJugadores.add(crearPj.crearPj());
                JOptionPane.showMessageDialog(panel1, "Se creó correctamente el personaje");
            }
        });

        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CrearNPC crear_npc = new CrearNPC();
                personajesNoJugadores.add(crear_npc.crearNPC());
                JOptionPane.showMessageDialog(panel1,"Se creó correctamente el NPC");
            }
        });

        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<Personaje> lista_combate = new ArrayList<>();
                lista_combate.addAll(personajesJugadores);
                lista_combate.addAll(personajesNoJugadores);
                funciones.lanzar_iniciativa(lista_combate);
                ArrayList<Personaje> lista_combate_ordenada = funciones.ordenar_iniciativa(lista_combate);
                funciones.mostrar_iniciativa(lista_combate_ordenada);
            }
        });

    }

}
