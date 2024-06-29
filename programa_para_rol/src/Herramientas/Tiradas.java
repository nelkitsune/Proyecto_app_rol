package Herramientas;

public interface Tiradas extends Dados {
    public default int  tirar_iniciativa(int modificador_iniciativa){//metodo para tirar la iniciativa
        int resultado = Dados.d20() + modificador_iniciativa;//lanzamos el dado y sumamos el modificador
        return resultado;//devolvemos el resultado
    }

    public default int tirar_salvacion_reflejo(){//metodo para tirar la salvacion de reflejos
        int resultado = Dados.d20();//lanzamos el dado
        return resultado;//devolvemos el resultado
    }

    public default int tirar_salvacion_voluntad(){//metodo para tirar la salvacion de voluntad
        int resultado = Dados.d20();
        return resultado;
    }

    public default int tirar_salvacion_fortaleza(){//metodo para tirar la salvacion de fortaleza
        int resultado = Dados.d20();
        return resultado;
    }

    public default int tirar_percepcion(){//metodo para tirar la percepcion
        int resultado= Dados.d20();
        return resultado;
    }

    public default int tirar_tasacion(){//metodo para tirar la tasacion
        int resultado = Dados.d20();
        return resultado;
    }

}
