package Gui;
import Herramientas.*;
import Personaje.*;

import Herramientas.CrearObjetosPj;
import Personaje.PersonajeJugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {
    private JPanel panel_principal;

    private JPanel panel_titulo;
    private JLabel label_titulo;

    private JPanel panel_personajeJugador;
    private JLabel label_personajeJugador;
    private JLabel label_nombrePersonaje;
    private JTextField textField_personajeJugador1;
    private JLabel label_nombreJugador;
    private JTextField textField_personajeJugador2;
    private JLabel label_iniciativa;
    private JTextField textField_personajeJugador3;
    private JLabel label_percepcion;
    private JTextField textField_personajeJugador4;
    private JLabel label_tasacion;
    private JTextField textField_personajeJugador5;
    private JButton button_agregarPersonajeJugador;

    private JPanel panel_personajeNoJugador;
    private JLabel label_personajeNoJugador;
    private JLabel label_nombreNpc;
    private JTextField textField_personajeNoJugador1;
    private JLabel label_numeroNpc;
    private JTextField textField_personajeNoJugador2;
    private JLabel iniciativaNpc;
    private JTextField textField_personajeNoJugador3;
    private JLabel percepcionNpc;
    private JTextField textField_personajeNoJugador4;
    private JLabel modFortaleza;
    private JTextField textField_personajeNoJugador5;
    private JLabel modReflejo;
    private JTextField textField_personajeNoJugador6;
    private JLabel modVoluntad;
    private JTextField textField_personajeNoJugador7;
    private JButton button_agregarPersonajeNoJugador;

    private JPanel panel_iniciativa;
    private JLabel label_tiradaIniciativa;
    private JTextArea textArea_iniciativa;
    private JButton botonTirarIniciativa;

    private JPanel panel_percepcion;
    private JLabel label_tiradaPercepcion;
    private JTextArea textAreaPercepcion;
    private JButton botonTirarPercepcion;
    private JTextField textFieldDificultadPercepcion;
    private JLabel labelDificultadPercepcion;

    private JPanel panel_tasacion;
    private JLabel label_tiradaTasacion;
    private JTextArea textAreaTasacion;
    private JButton botonTirarTasacion;
    private JTextField textFieldDificultadTasacion;
    private JLabel labelDificultadTasacion;

    private JPanel panel_tiradaFortaleza;
    private JLabel label_tiradaFotaleza;
    private JTextArea textAreaFortaleza;
    private JButton botonTirarFortaleza;
    private JTextField textFieldDificultadFortaleza;
    private JLabel labelDificultadFortaleza;

    private JPanel panel_tiradaReflejos;
    private JLabel label_tiradaReflejos;
    private JTextArea textAreaReflejo;
    private JButton botonTirarReflejo;
    private JTextField textFieldDificultadReflejos;
    private JLabel labelDificultadReflejos;

    private JPanel panel_tiradaVoluntad;
    private JLabel label_tiradaVoluntad;
    private JTextArea textAreaVoluntad;
    private JButton botonTirarVoluntad;
    private JTextField textFieldDificultadVoluntad;
    private JLabel labelDificultadVoluntad;

    public Menu() {
        initComponents();
    }

    private void initComponents() {
        CrearObjetosPj crearObjetosPj = new CrearObjetosPj();
        ArrayList<PersonajeJugador> personajesJugadores = new ArrayList<>(crearObjetosPj.listaDePj());
        ArrayList<PersonajeNoJugador> personajesNoJugadores = new ArrayList<>();
        FuncionesUtiles funciones = new FuncionesUtiles();

        setTitle("Primeras Pruebas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,800);
        setLayout(new BorderLayout());

        // Titulo
        panel_titulo = new JPanel();
        label_titulo = new JLabel("App para Rol");
        panel_titulo.add(label_titulo, BorderLayout.NORTH);


        // Personaje Jugador
        panel_personajeJugador = new JPanel();
        panel_personajeJugador.setLayout(new GridLayout(7, 2));
        label_personajeJugador = new JLabel("Crear Personaje Jugador");
        label_nombrePersonaje = new JLabel("Nombre Personaje: ");
        textField_personajeJugador1 = new JTextField(20);
        label_nombreJugador = new JLabel("Nombre Jugador: ");
        textField_personajeJugador2 = new JTextField(20);
        label_iniciativa = new JLabel("Iniciativa: ");
        textField_personajeJugador3 = new JTextField(20);
        label_percepcion = new JLabel("Percepción: ");
        textField_personajeJugador4 = new JTextField(20);
        label_tasacion = new JLabel("Tasación: ");
        textField_personajeJugador5 = new JTextField(20);
        button_agregarPersonajeJugador = new JButton("Agregar");

        panel_personajeJugador.add(label_personajeJugador);
        panel_personajeJugador.add(new JLabel()); // Espacio vacío
        panel_personajeJugador.add(label_nombrePersonaje);
        panel_personajeJugador.add(textField_personajeJugador1);
        panel_personajeJugador.add(label_nombreJugador);
        panel_personajeJugador.add(textField_personajeJugador2);
        panel_personajeJugador.add(label_iniciativa);
        panel_personajeJugador.add(textField_personajeJugador3);
        panel_personajeJugador.add(label_percepcion);
        panel_personajeJugador.add(textField_personajeJugador4);
        panel_personajeJugador.add(label_tasacion);
        panel_personajeJugador.add(textField_personajeJugador5);
        panel_personajeJugador.add(button_agregarPersonajeJugador);

        // Personaje No Jugador
        panel_personajeNoJugador = new JPanel();
        panel_personajeNoJugador.setLayout(new GridLayout(9, 2));
        label_personajeNoJugador = new JLabel("Crear Personaje No Jugador");
        label_nombreNpc = new JLabel("Nombre NPC: ");
        textField_personajeNoJugador1 = new JTextField(20);
        label_numeroNpc = new JLabel("Número NPC: ");
        textField_personajeNoJugador2 = new JTextField(20);
        iniciativaNpc = new JLabel("Iniciativa NPC: ");
        textField_personajeNoJugador3 = new JTextField(20);
        percepcionNpc = new JLabel("Percepción NPC: ");
        textField_personajeNoJugador4 = new JTextField(20);
        modFortaleza = new JLabel("Modificador Fortaleza: ");
        textField_personajeNoJugador5 = new JTextField(20);
        modReflejo = new JLabel("Modificador Reflejo: ");
        textField_personajeNoJugador6 = new JTextField(20);
        modVoluntad = new JLabel("Modificador Voluntad: ");
        textField_personajeNoJugador7 = new JTextField(20);
        button_agregarPersonajeNoJugador = new JButton("Agregar");

        panel_personajeNoJugador.add(label_personajeNoJugador);
        panel_personajeNoJugador.add(new JLabel()); // Espacio vacío
        panel_personajeNoJugador.add(label_nombreNpc);
        panel_personajeNoJugador.add(textField_personajeNoJugador1);
        panel_personajeNoJugador.add(label_numeroNpc);
        panel_personajeNoJugador.add(textField_personajeNoJugador2);
        panel_personajeNoJugador.add(iniciativaNpc);
        panel_personajeNoJugador.add(textField_personajeNoJugador3);
        panel_personajeNoJugador.add(percepcionNpc);
        panel_personajeNoJugador.add(textField_personajeNoJugador4);
        panel_personajeNoJugador.add(modFortaleza);
        panel_personajeNoJugador.add(textField_personajeNoJugador5);
        panel_personajeNoJugador.add(modReflejo);
        panel_personajeNoJugador.add(textField_personajeNoJugador6);
        panel_personajeNoJugador.add(modVoluntad);
        panel_personajeNoJugador.add(textField_personajeNoJugador7);
        panel_personajeNoJugador.add(button_agregarPersonajeNoJugador);

        // Iniciativa
        panel_iniciativa = new JPanel();
        panel_iniciativa.setLayout(new BorderLayout());
        label_tiradaIniciativa = new JLabel("Tirada de Iniciativa");
        textArea_iniciativa = new JTextArea(5, 20);
        textArea_iniciativa.setLineWrap(true);
        textArea_iniciativa.setWrapStyleWord(true);
        botonTirarIniciativa = new JButton("Tirar Iniciativa");
        panel_iniciativa.add(label_tiradaIniciativa, BorderLayout.NORTH);
        panel_iniciativa.add(new JScrollPane(textArea_iniciativa), BorderLayout.CENTER);
        panel_iniciativa.add(botonTirarIniciativa, BorderLayout.SOUTH);

        // Percepción
        panel_percepcion = new JPanel();
        panel_percepcion.setLayout(new BorderLayout());
        label_tiradaPercepcion = new JLabel("Tirada de Percepción");
        textAreaPercepcion = new JTextArea(5, 20);
        textAreaPercepcion.setLineWrap(true);
        textAreaPercepcion.setWrapStyleWord(true);
        textFieldDificultadPercepcion = new JTextField(10);
        labelDificultadPercepcion = new JLabel("Dificultad: ");
        botonTirarPercepcion = new JButton("Tirar Percepción");

        JPanel panel_percepcion_aux = new JPanel();
        panel_percepcion_aux.add(labelDificultadPercepcion, BorderLayout.WEST);
        panel_percepcion_aux.add(textFieldDificultadPercepcion, BorderLayout.CENTER);

        panel_percepcion.add(label_tiradaPercepcion, BorderLayout.NORTH);
        panel_percepcion.add(new JScrollPane(textAreaPercepcion), BorderLayout.CENTER);
        panel_percepcion.add(botonTirarPercepcion, BorderLayout.SOUTH);
        panel_percepcion.add(panel_percepcion_aux, BorderLayout.WEST);

        // Tasación
        panel_tasacion = new JPanel();
        panel_tasacion.setLayout(new BorderLayout());
        label_tiradaTasacion = new JLabel("Tirada de Tasación");
        textAreaTasacion = new JTextArea(5, 20);
        textAreaTasacion.setLineWrap(true);
        textAreaTasacion.setWrapStyleWord(true);
        textFieldDificultadTasacion = new JTextField(10);
        labelDificultadTasacion = new JLabel("Dificultad: ");
        botonTirarTasacion = new JButton("Tirar Tasación");

        JPanel panel_tasacion_aux = new JPanel();
        panel_tasacion_aux.add(labelDificultadTasacion, BorderLayout.WEST);
        panel_tasacion_aux.add(textFieldDificultadTasacion, BorderLayout.CENTER);

        panel_tasacion.add(panel_tasacion_aux, BorderLayout.WEST);
        panel_tasacion.add(label_tiradaTasacion, BorderLayout.NORTH);
        panel_tasacion.add(new JScrollPane(textAreaTasacion), BorderLayout.CENTER);
        panel_tasacion.add(botonTirarTasacion, BorderLayout.SOUTH);


        // Fortaleza
        panel_tiradaFortaleza = new JPanel();
        panel_tiradaFortaleza.setLayout(new BorderLayout());
        label_tiradaFotaleza = new JLabel("Tirada de Fortaleza");
        textAreaFortaleza = new JTextArea(5, 20);
        textAreaFortaleza.setLineWrap(true);
        textAreaFortaleza.setWrapStyleWord(true);
        textFieldDificultadFortaleza = new JTextField(10);
        labelDificultadFortaleza = new JLabel("Dificultad: ");
        botonTirarFortaleza = new JButton("Tirar Fortaleza");

        JPanel panel_tiradaFortaleza_aux = new JPanel();
        panel_tiradaFortaleza_aux.add(labelDificultadFortaleza, BorderLayout.WEST);
        panel_tiradaFortaleza_aux.add(textFieldDificultadFortaleza, BorderLayout.CENTER);

        panel_tiradaFortaleza.add(label_tiradaFotaleza, BorderLayout.NORTH);
        panel_tiradaFortaleza.add(new JScrollPane(textAreaFortaleza), BorderLayout.CENTER);
        panel_tiradaFortaleza.add(botonTirarFortaleza, BorderLayout.SOUTH);
        panel_tiradaFortaleza.add(panel_tiradaFortaleza_aux, BorderLayout.WEST);

        // Reflejos
        panel_tiradaReflejos = new JPanel();
        panel_tiradaReflejos.setLayout(new BorderLayout());
        label_tiradaReflejos = new JLabel("Tirada de Reflejos");
        textAreaReflejo = new JTextArea(5, 20);
        textAreaReflejo.setLineWrap(true);
        textAreaReflejo.setWrapStyleWord(true);
        textFieldDificultadReflejos = new JTextField(10);
        labelDificultadReflejos = new JLabel("Dificultad: ");
        botonTirarReflejo = new JButton("Tirar Reflejos");

        JPanel panel_tiradaRflejo_aux = new JPanel();
        panel_tiradaRflejo_aux.add(labelDificultadReflejos, BorderLayout.WEST);
        panel_tiradaRflejo_aux.add(textFieldDificultadReflejos, BorderLayout.CENTER);

        panel_tiradaReflejos.add(label_tiradaReflejos, BorderLayout.NORTH);
        panel_tiradaReflejos.add(new JScrollPane(textAreaReflejo), BorderLayout.CENTER);
        panel_tiradaReflejos.add(botonTirarReflejo, BorderLayout.SOUTH);
        panel_tiradaReflejos.add(panel_tiradaRflejo_aux, BorderLayout.WEST);

        // Voluntad
        panel_tiradaVoluntad = new JPanel();
        panel_tiradaVoluntad.setLayout(new BorderLayout());
        label_tiradaVoluntad = new JLabel("Tirada de Voluntad");
        textAreaVoluntad = new JTextArea(5, 20);
        textAreaVoluntad.setLineWrap(true);
        textAreaVoluntad.setWrapStyleWord(true);
        textFieldDificultadVoluntad = new JTextField(10);
        labelDificultadVoluntad = new JLabel("Dificultad: ");
        botonTirarVoluntad = new JButton("Tirar Voluntad");

        JPanel panel_tiradaVoluntad_aux = new JPanel();
        panel_tiradaVoluntad_aux.add(labelDificultadVoluntad, BorderLayout.WEST);
        panel_tiradaVoluntad_aux.add(textFieldDificultadVoluntad, BorderLayout.CENTER);

        panel_tiradaVoluntad.add(label_tiradaVoluntad, BorderLayout.NORTH);
        panel_tiradaVoluntad.add(new JScrollPane(textAreaVoluntad), BorderLayout.CENTER);
        panel_tiradaVoluntad.add(botonTirarVoluntad, BorderLayout.SOUTH);
        panel_tiradaVoluntad.add(panel_tiradaVoluntad_aux, BorderLayout.WEST);
        // Principal
        panel_principal = new JPanel();
        panel_principal.setLayout(new GridLayout(2, 4));



        panel_principal.add(panel_personajeJugador);
        panel_principal.add(panel_iniciativa);
        panel_principal.add(panel_percepcion);
        panel_principal.add(panel_tasacion);
        panel_principal.add(panel_personajeNoJugador);
        panel_principal.add(panel_tiradaFortaleza);
        panel_principal.add(panel_tiradaReflejos);
        panel_principal.add(panel_tiradaVoluntad);
        add(panel_titulo, BorderLayout.NORTH);
        add(panel_principal, BorderLayout.CENTER);
        setVisible(true);

        button_agregarPersonajeJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre_personaje;
                String nombre_jugador;
                int iniciativa;
                int percepcion;
                int tasacion;

                nombre_personaje = textField_personajeJugador1.getText();
                nombre_jugador = textField_personajeJugador2.getText();
                iniciativa = Integer.parseInt(textField_personajeJugador3.getText());
                percepcion = Integer.parseInt(textField_personajeJugador4.getText());
                tasacion = Integer.parseInt(textField_personajeJugador5.getText());

                PersonajeJugador nuevoPJ = new PersonajeJugador(nombre_personaje, iniciativa, percepcion, nombre_jugador, tasacion);
                personajesJugadores.add(nuevoPJ);
            }
        });

        button_agregarPersonajeNoJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre_personaje;
                int numero_npc;
                int iniciativa;
                int percepcion;
                int mod_fortaleza;
                int mod_reflejo;
                int mod_voluntad;

                nombre_personaje = textField_personajeNoJugador1.getText();
                numero_npc = Integer.parseInt(textField_personajeNoJugador2.getText());
                iniciativa = Integer.parseInt(textField_personajeNoJugador3.getText());
                percepcion = Integer.parseInt(textField_personajeNoJugador4.getText());
                mod_fortaleza = Integer.parseInt(textField_personajeNoJugador5.getText());
                mod_reflejo = Integer.parseInt(textField_personajeNoJugador6.getText());
                mod_voluntad = Integer.parseInt(textField_personajeNoJugador7.getText());

                PersonajeNoJugador nuevoPNJ = new PersonajeNoJugador(nombre_personaje, numero_npc, iniciativa, percepcion, mod_fortaleza, mod_reflejo, mod_voluntad);
                personajesNoJugadores.add(nuevoPNJ);
            }
        });


        botonTirarIniciativa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Personaje> lista_combate = new ArrayList<>();
                lista_combate.addAll(personajesJugadores);
                lista_combate.addAll(personajesNoJugadores);
                funciones.lanzar_iniciativa(lista_combate);
                ArrayList<Personaje> lista_combate_ordenada = funciones.ordenar_iniciativa(lista_combate);


                StringBuilder text = new StringBuilder();
                for (Personaje item : lista_combate_ordenada) {
                    text.append(item.getNombre_personaje())
                            .append(" ")
                            .append(item.getIniciativa_actual())
                            .append("\n");
                }
                textArea_iniciativa.setText(text.toString());
            }
        });

        botonTirarPercepcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder text = new StringBuilder();
                int dificultad = Integer.parseInt(textFieldDificultadPercepcion.getText());
                text = funciones.tirar_percepcion_gui(personajesJugadores, dificultad);
                textAreaPercepcion.setText(text.toString());
            }
        });

        botonTirarTasacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder text = new StringBuilder();
                int dificultad = Integer.parseInt(textFieldDificultadTasacion.getText());
                text = funciones.tirar_tasacion_gui(personajesJugadores, dificultad);
                textAreaTasacion.setText(text.toString());
            }
        });

        botonTirarFortaleza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder text = new StringBuilder();
                int dificultad = Integer.parseInt(textFieldDificultadFortaleza.getText());
                text = funciones.tirar_fortaleza_gui(personajesNoJugadores, dificultad);
                textAreaFortaleza.setText(text.toString());
            }
        });
        botonTirarReflejo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder text = new StringBuilder();
                int dificultad = Integer.parseInt(textFieldDificultadReflejos.getText());
                text = funciones.tirar_reflejos_gui(personajesNoJugadores, dificultad);
                textAreaReflejo.setText(text.toString());
            }
        });

        botonTirarVoluntad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder text = new StringBuilder();
                int dificultad = Integer.parseInt(textFieldDificultadVoluntad.getText());
                text = funciones.tirar_voluntad_gui(personajesNoJugadores, dificultad);
                textAreaVoluntad.setText(text.toString());
            }
        });
   }
}
