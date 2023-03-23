package org.projeto.dell;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Programa p = new Programa();
//        p.printLista();
        List<Double> x= p.consultarTrechosxModalidade("BELO HORIZONTE","CAMPO GRANDE", 0);
        System.out.println(x.get(0)+ " "+ x.get(1));
    }
}