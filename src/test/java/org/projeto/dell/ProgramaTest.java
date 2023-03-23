package org.projeto.dell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ProgramaTest {

    private static Programa programa;

    @BeforeAll
    static void setup() {
        programa = new Programa();
    }

    @Test
    void pesquisarCidade() {
        int indexPrevisto = 1;
        int indexRetornado = programa.buscarIndexCidade("BELEM");
        Assertions.assertEquals(indexRetornado,indexPrevisto);
    }

    @Test
    void testeConsulta() {
        List<Double> listaPrevista = new ArrayList<>();
        listaPrevista.add(1453.0);
        listaPrevista.add(7076.110000000001);
        List<Double> listaRetornada = programa.consultarTrechosxModalidade("BELO HORIZONTE","CAMPO GRANDE", 0);
        Assertions.assertEquals(listaPrevista,listaRetornada);
    }


}
