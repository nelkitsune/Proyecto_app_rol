package Personaje;

import Herramientas.Tiradas;

public class PersonajeNoJugador extends Personaje implements Tiradas {
    private int numero_npc;
    private int salvacion_reflejos;
    private int salvacion_voluntad;
    private int salvacion_fortaleza;


    public PersonajeNoJugador(String nombre_personaje, int iniciativa, int percepcion, int numero_npc, int salvacion_reflejos, int salvacion_voluntad, int salvacion_fortaleza) {
        super(nombre_personaje, iniciativa, percepcion);
        this.numero_npc = numero_npc;
        this.salvacion_reflejos = salvacion_reflejos;
        this.salvacion_voluntad = salvacion_voluntad;
        this.salvacion_fortaleza = salvacion_fortaleza;
    }

    public int getNumero_npc() {
        return numero_npc;
    }

    public void setNumero_npc(int numero_npc) {
        this.numero_npc = numero_npc;
    }

    public int getSalvacion_reflejos() {
        return salvacion_reflejos;
    }

    public void setSalvacion_reflejos(int salvacion_reflejos) {
        this.salvacion_reflejos = salvacion_reflejos;
    }

    public int getSalvacion_voluntad() {
        return salvacion_voluntad;
    }

    public void setSalvacion_voluntad(int salvacion_voluntad) {
        this.salvacion_voluntad = salvacion_voluntad;
    }

    public int getSalvacion_fortaleza() {
        return salvacion_fortaleza;
    }

    public void setSalvacion_fortaleza(int salvacion_fortaleza) {
        this.salvacion_fortaleza = salvacion_fortaleza;
    }


    @Override
    public int tirar_iniciativa(int modificador_iniciativa) {
        setIniciativa_actual(Tiradas.super.tirar_iniciativa(modificador_iniciativa));
        return getIniciativa_actual();
    }
    @Override
    public int tirar_salvacion_reflejo(int modificador_salvacion_reflejo) {
        return Tiradas.super.tirar_salvacion_reflejo(modificador_salvacion_reflejo);
    }

    @Override
    public int tirar_salvacion_voluntad(int modificador_salvacion_voluntad) {
        return Tiradas.super.tirar_salvacion_voluntad(modificador_salvacion_voluntad);
    }

    @Override
    public int tirar_salvacion_fortaleza(int modificador_salvacion_fortaleza) {
        return Tiradas.super.tirar_salvacion_fortaleza(modificador_salvacion_fortaleza);
    }

    @Override
    public int tirar_percepcion(int modificador_percepcion) {
        return Tiradas.super.tirar_percepcion(modificador_percepcion);
    }
}
