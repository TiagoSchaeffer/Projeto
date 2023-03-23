package org.projeto.dell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProgramaTest {

    private static Programa programa;

    @BeforeAll
    static void setup() {
        programa = new Programa();
    }
    @Test
    void pesquisarCidade() {
        Assertions.assertEquals(programa.buscarIndexCidade("BELEM"),1);
    }
}
