package Personaje;

public abstract class Personaje {
    private String nombre_personaje;
    private int modificador_iniciativa;
    private int percepcion;
    private int iniciativa_actual;

    public Personaje(String nombre_personaje, int iniciativa, int percepcion) {
        this.nombre_personaje = nombre_personaje;
        this.modificador_iniciativa = iniciativa;
        this.percepcion = percepcion;
    }

    public String getNombre_personaje() {
        return nombre_personaje;
    }

    public void setNombre_personaje(String nombre_personaje) {
        this.nombre_personaje = nombre_personaje;
    }

    public int getModificador_iniciativa() {
        return modificador_iniciativa;
    }

    public void setModificador_iniciativa(int modificador_iniciativa) {
        this.modificador_iniciativa = modificador_iniciativa;
    }

    public int getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }

    public int getIniciativa_actual() {
        return iniciativa_actual;
    }

    public void setIniciativa_actual(int iniciativa_actual) {
        this.iniciativa_actual = iniciativa_actual;
    }
}
