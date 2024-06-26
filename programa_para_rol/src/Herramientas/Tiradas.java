package Herramientas;

public interface Tiradas extends Dados {
    public default int tirar_iniciativa(int modificador_iniciativa){
        int resultado = Dados.d20() + modificador_iniciativa;
        return resultado;
    }
    public default int tirar_salvacion_reflejo(int modificador_salvacion_reflejo){
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_salvacion_reflejo;

        return resultado;
    }
    public default int tirar_salvacion_voluntad(int modificador_salvacion_voluntad){
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_salvacion_voluntad;

        return resultado;
    }
    public default int tirar_salvacion_fortaleza(int modificador_salvacion_fortaleza){
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_salvacion_fortaleza;

        return resultado;
    }
    public default int tirar_percepcion(int modificador_percepcion){
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_percepcion;

        return resultado;
    }
    public default int tirar_tasacion( int modificador_tasacion){
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_tasacion;

        return resultado;
    }

}
