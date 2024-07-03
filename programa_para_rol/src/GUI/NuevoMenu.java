package GUI;

import Herramientas.CrearNPC;
import Herramientas.CrearPj;
import Herramientas.FuncionesUtiles;
import Personaje.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevoMenu {
    public JPanel panel1;
    private JButton botonMenuPrincipal1; //Tirar iniciativa
    private JButton botonMenuPrincipal2; //Tirar percepción
    private JButton botonMenuPrincipal3; //Tirar tasación
    private JButton botonMenuPrincipal4; //Tirar salvación de reflejos
    private JButton botonMenuPrincipal5; //Tirar salvación de voluntad
    private JButton botonMenuPrincipal6; //Tirar salvación de fortaleza
    private JTextArea textArea1;//iniciativa
    private JTextArea textArea2;//Percepcion
    private JTextArea textArea3;//Tasacion
    private JTextArea textArea4;//Fortaleza
    private JTextArea textArea5;//Reflejos
    private JTextArea textArea6;//Voluntad
    private JButton botonCrearPj;
    private JTextField textField1_pj;
    private JTextField textField2_pj;
    private JTextField textField3_pj;
    private JTextField textField4_pj;
    private JTextField textField5_pj;
    private JTextField textField1_npc;
    private JTextField textField2_npc;
    private JTextField textField3_npc;
    private JTextField textField4_npc;
    private JTextField textField5_npc;
    private JTextField textField6_npc;
    private JTextField textField7_npc;
    private JButton BotonCrearNpc;
    private JScrollPane scrollPane1_iniciativa;
    private JScrollPane scrollPane1_percepcion;
    private JScrollPane scrollPane1_tasacion;
    private JScrollPane scrollPane1_fortaleza;
    private JScrollPane scrollPane1_reflejos;
    private JScrollPane scrollPane1_voluntad;
    private JTextField textFieldDificultadPercepcion;
    private JTextField textFieldDificultadTasacion;
    private JTextField textFieldDificultadFortaleza;
    private JTextField textFieldDificultadReflejos;
    private JTextField textFieldDificultadVoluntad;

    // Constructor
    public NuevoMenu(ArrayList<Personaje> personajesJugadores, ArrayList<PersonajeNoJugador> personajesNoJugadores, FuncionesUtiles funciones) {
        initComponents();
        // Acción para crear PJ
        botonCrearPj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearPj crearPj = new CrearPj();
                personajesJugadores.add(crearPj.crearPj());
                JOptionPane.showMessageDialog(panel1, "Se creó correctamente el personaje.");
            }
        });
        // Acción para crear NPC
        BotonCrearNpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearNPC crear_npc = new CrearNPC();
                personajesNoJugadores.add(crear_npc.crearNPC());
                JOptionPane.showMessageDialog(panel1, "Se creó correctamente el NPC.");
            }
        });
        // Acción para tirar iniciativa
        botonMenuPrincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Personaje> lista_combate = new ArrayList<>();
                lista_combate.addAll(personajesJugadores);
                lista_combate.addAll(personajesNoJugadores);
                funciones.lanzar_iniciativa(lista_combate);
                ArrayList<Personaje> lista_combate_ordenada = funciones.ordenar_iniciativa(lista_combate);
                StringBuilder iniciativaText = new StringBuilder();
                for (Personaje personaje : lista_combate_ordenada) {
                    if (personaje instanceof PersonajeJugador) {
                        PersonajeJugador pj = (PersonajeJugador) personaje;
                        iniciativaText.append(pj.getNombre_personaje()).append(" tiene una iniciativa de: ").append(pj.getIniciativa_actual()).append("\n");
                    } else if (personaje instanceof PersonajeNoJugador) {
                        PersonajeNoJugador pnj = (PersonajeNoJugador) personaje;
                        iniciativaText.append(pnj.getNombre_personaje()).append(" ").append(pnj.getNumero_npc()).append(" tiene una iniciativa de: ").append(pnj.getIniciativa_actual()).append("\n");
                    }
                }
                textArea1.setText(iniciativaText.toString());
            }
        });
        // Acción para tirar percepción
        botonMenuPrincipal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int dificultad = Integer.parseInt(textFieldDificultadPercepcion.getText());
                    if (dificultad < 1) {
                        JOptionPane.showMessageDialog(panel1, "La dificultad debe ser un número entero positivo.");
                        return;
                    }
                    funciones.tirar_percepcion(personajesJugadores, dificultad, textArea2);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Introduce un número entero válido para la dificultad.");
                }
            }
        });
        // Acción para tirar tasación
        botonMenuPrincipal3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dificultad = Integer.parseInt(textFieldDificultadTasacion.getText());
                funciones.tirar_tasacion(personajesJugadores, dificultad, textArea3);
            }
        });
        // Acción para tirar fortaleza

        botonMenuPrincipal4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dificultad = Integer.parseInt(textFieldDificultadReflejos.getText());
                funciones.tirada_reflejos(personajesNoJugadores, dificultad, textArea5);
            }
        });
// Acción para tirar reflejos
        botonMenuPrincipal5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dificultad = Integer.parseInt(textFieldDificultadVoluntad.getText());
                funciones.tirada_voluntad(personajesNoJugadores, dificultad, textArea6);
            }
        });
        botonMenuPrincipal6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dificultad = Integer.parseInt(textFieldDificultadFortaleza.getText());
                funciones.tirada_fortaleza(personajesNoJugadores, dificultad, textArea4);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void initComponents() {
        // Crear el panel principal
        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Inicializar y configurar los componentes
        botonMenuPrincipal1 = new JButton("Tirar iniciativa");
        botonMenuPrincipal2 = new JButton("Tirar percepción");
        botonMenuPrincipal3 = new JButton("Tirar tasación");
        botonMenuPrincipal4 = new JButton("Tirar salvación de reflejos");
        botonMenuPrincipal5 = new JButton("Tirar salvación de voluntad");
        botonMenuPrincipal6 = new JButton("Tirar salvación de fortaleza");

        textArea1 = new JTextArea(5, 20);
        textArea2 = new JTextArea(5, 20);
        textArea3 = new JTextArea(5, 20);
        textArea4 = new JTextArea(5, 20);
        textArea5 = new JTextArea(5, 20);
        textArea6 = new JTextArea(5, 20);

        scrollPane1_iniciativa = new JScrollPane(textArea1);
        scrollPane1_percepcion = new JScrollPane(textArea2);
        scrollPane1_tasacion = new JScrollPane(textArea3);
        scrollPane1_fortaleza = new JScrollPane(textArea4);
        scrollPane1_reflejos = new JScrollPane(textArea5);
        scrollPane1_voluntad = new JScrollPane(textArea6);

        botonCrearPj = new JButton("Crear Personaje Jugador");
        BotonCrearNpc = new JButton("Crear Personaje No Jugador");

        textField1_pj = new JTextField(10);
        textField2_pj = new JTextField(10);
        textField3_pj = new JTextField(10);
        textField4_pj = new JTextField(10);
        textField5_pj = new JTextField(10);

        textField1_npc = new JTextField(10);
        textField2_npc = new JTextField(10);
        textField3_npc = new JTextField(10);
        textField4_npc = new JTextField(10);
        textField5_npc = new JTextField(10);
        textField6_npc = new JTextField(10);
        textField7_npc = new JTextField(10);

        // Añadir los componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(botonMenuPrincipal1, gbc);
        gbc.gridy = 1;
        panel1.add(scrollPane1_iniciativa, gbc);
        gbc.gridy = 2;
        panel1.add(botonMenuPrincipal2, gbc);
        gbc.gridy = 3;
        panel1.add(scrollPane1_percepcion, gbc);
        gbc.gridy = 4;
        panel1.add(botonMenuPrincipal3, gbc);
        gbc.gridy = 5;
        panel1.add(scrollPane1_tasacion, gbc);
        gbc.gridy = 6;
        panel1.add(botonMenuPrincipal4, gbc);
        gbc.gridy = 7;
        panel1.add(scrollPane1_fortaleza, gbc);
        gbc.gridy = 8;
        panel1.add(botonMenuPrincipal5, gbc);
        gbc.gridy = 9;
        panel1.add(scrollPane1_reflejos, gbc);
        gbc.gridy = 10;
        panel1.add(botonMenuPrincipal6, gbc);
        gbc.gridy = 11;
        panel1.add(scrollPane1_voluntad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel1.add(botonCrearPj, gbc);
        gbc.gridy = 1;
        panel1.add(new JLabel("Nombre del PJ"), gbc);
        gbc.gridx = 2;
        panel1.add(textField1_pj, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(new JLabel("Nombre del Jugador"), gbc);
        gbc.gridx = 2;
        panel1.add(textField2_pj, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel1.add(new JLabel("Modificador de iniciativa"), gbc);
        gbc.gridx = 2;
        panel1.add(textField3_pj, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel1.add(new JLabel("Modificador de percepción"), gbc);
        gbc.gridx = 2;
        panel1.add(textField4_pj, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel1.add(new JLabel("Modificador de tasación"), gbc);
        gbc.gridx = 2;
        panel1.add(textField5_pj, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        panel1.add(BotonCrearNpc, gbc);
        gbc.gridy = 1;
        panel1.add(new JLabel("Nombre NPC"), gbc);
        gbc.gridx = 4;
        panel1.add(textField1_npc, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel1.add(new JLabel("Número NPC"), gbc);
        gbc.gridx = 4;
        panel1.add(textField2_npc, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel1.add(new JLabel("Modificador de iniciativa"), gbc);
        gbc.gridx = 4;
        panel1.add(textField3_npc, gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel1.add(new JLabel("Modificador de percepción"), gbc);
        gbc.gridx = 4;
        panel1.add(textField4_npc, gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel1.add(new JLabel("Modificador de fortaleza"), gbc);
        gbc.gridx = 4;
        panel1.add(textField5_npc, gbc);
        gbc.gridx = 3;
        gbc.gridy = 6;
        panel1.add(new JLabel("Modificador de reflejos"), gbc);
        gbc.gridx = 4;
        panel1.add(textField6_npc, gbc);
        gbc.gridx = 3;
        gbc.gridy = 7;
        panel1.add(new JLabel("Modificador de voluntad"), gbc);
        gbc.gridx = 4;
        panel1.add(textField7_npc, gbc);
    }
    }
