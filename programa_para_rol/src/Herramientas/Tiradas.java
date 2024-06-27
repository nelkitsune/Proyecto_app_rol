package Herramientas;

public interface Tiradas extends Dados {
    public default int tirar_iniciativa(int modificador_iniciativa){//metodo para tirar la iniciativa
        int resultado = Dados.d20() + modificador_iniciativa;//lanzamos el dado y sumamos el modificador
        return resultado;//devolvemos el resultado
    }
    public default int tirar_salvacion_reflejo(int modificador_salvacion_reflejo){//metodo para tirar la salvacion de reflejos
        int resultado_parcial = Dados.d20();//lanzamos el dado
        System.out.println("En el dado salio: " + resultado_parcial);//mostramos el resultado
        int resultado = resultado_parcial + modificador_salvacion_reflejo;//sumamos el modificador

        return resultado;//devolvemos el resultado
    }
    public default int tirar_salvacion_voluntad(int modificador_salvacion_voluntad){//metodo para tirar la salvacion de voluntad
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_salvacion_voluntad;

        return resultado;
    }
    public default int tirar_salvacion_fortaleza(int modificador_salvacion_fortaleza){//metodo para tirar la salvacion de fortaleza
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_salvacion_fortaleza;

        return resultado;
    }
    public default int tirar_percepcion(int modificador_percepcion){//metodo para tirar la percepcion
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_percepcion;

        return resultado;
    }
    public default int tirar_tasacion( int modificador_tasacion){//metodo para tirar la tasacion
        int resultado_parcial = Dados.d20();
        System.out.println("En el dado salio: " + resultado_parcial);
        int resultado = resultado_parcial + modificador_tasacion;

        return resultado;
    }

}
