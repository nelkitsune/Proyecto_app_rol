package Personaje;

public class PersonajeJugador extends Personaje implements Tiradas{
    private String nombre_jugador;
    private int tasacion;

    public PersonajeJugador(String nombre_personaje, int iniciativa, int percepcion, String nombre_jugador, int tasacion) {
        super(nombre_personaje, iniciativa, percepcion);
        this.nombre_jugador = nombre_jugador;
        this.tasacion = tasacion;
    }

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

    @Override
    public int tirar_iniciativa(int modificador_iniciativa) {
        setIniciativa_actual(Tiradas.super.tirar_iniciativa(modificador_iniciativa));
        return getIniciativa_actual();
    }

    @Override
    public int tirar_percepcion(int modificador_percepcion) {
        return Tiradas.super.tirar_percepcion(modificador_percepcion);
    }

    @Override
    public int tirar_tasacion(int modificador_tasacion) {
        return Tiradas.super.tirar_tasacion(modificador_tasacion);
    }
}
