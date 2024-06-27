package Herramientas;

//clase para lanzar los dados
public interface Dados {
    public static int d20(){//metodo para lanzar un dado de 20 caras
        return (int) (Math.random() * 20) + 1;
    }
    public static int d12(){//metodo para lanzar un dado de 12 caras
        return (int) (Math.random() * 12) + 1;
    }
    public static int d10(){//metodo para lanzar un dado de 10 caras
        return (int) (Math.random() * 10) + 1;
    }
    public static int d8(){//metodo para lanzar un dado de 8 caras
        return (int) (Math.random() * 8) + 1;
    }
    public static int d6(){//metodo para lanzar un dado de 6 caras
        return (int) (Math.random() * 6) + 1;
    }
    public static int d4(){//metodo para lanzar un dado de 4 caras
        return (int) (Math.random() * 4) + 1;
    }
    public static int d2(){//metodo para lanzar un dado de 2 caras
        return (int) (Math.random() * 2) + 1;
    }
    public static int d100(){//metodo para lanzar un dado de 100 caras
        return (int) (Math.random() * 100) + 1;
    }
}
