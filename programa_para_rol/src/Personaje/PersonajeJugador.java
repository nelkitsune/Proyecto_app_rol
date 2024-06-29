package Personaje;

import Herramientas.Tiradas;
//clase que hereda de la clase personaje y de la interfaz tiradas
public class PersonajeJugador extends Personaje implements Tiradas {
    private String nombre_jugador; //nombre del jugador
    private int tasacion; //tasacion del personaje

    //constructor de la clase
    public PersonajeJugador(String nombre_personaje, int iniciativa, int percepcion, String nombre_jugador, int tasacion) {
        super(nombre_personaje, iniciativa, percepcion);
        this.nombre_jugador = nombre_jugador;
        this.tasacion = tasacion;
    }

    //metodos get y set de los atributos de la clase
    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador(String nombre_jugador) {
        this.nombre_jugador = nombre_jugador;
    }

    public int getTasacion() {
        return tasacion;
    }

    public void setTasacion(int tasacion) {
        this.tasacion = tasacion;
    }

    //metodos de la interfaz tiradas
    @Override
    public int tirar_iniciativa(int modificador_iniciativa) { //metodo para tirar la iniciativa
        setIniciativa_actual(Tiradas.super.tirar_iniciativa(modificador_iniciativa));
        return getIniciativa_actual();
    }
    @Override
    public int tirar_percepcion() { //metodo para tirar la percepcion
        return Tiradas.super.tirar_percepcion();
    }

    @Override
    public int tirar_tasacion() {//metodo para tirar la tasacion
        return Tiradas.super.tirar_tasacion();
    }
}
