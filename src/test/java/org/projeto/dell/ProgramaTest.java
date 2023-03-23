package org.projeto.dell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Classe que realiza os teste das funcionalidades do programa.
 *
 * @author Tiago M. Schaeffer S.
 */
public class ProgramaTest {

    /**
     * Váriavel estática com o programa
     */
    private static Programa programa;

    /**
     * Inicializa a váriavel do projeto antes de qualquer teste.
     */
    @BeforeAll
    static void setup() {
        programa = new Programa();
    }

    /**
     * Teste do método buscarIndexCidade.
     */
    @Test
    void pesquisarCidade() {
        int indexPrevisto = 1;
        int indexRetornado = programa.buscarIndexCidade("BELEM");
        Assertions.assertEquals(indexRetornado,indexPrevisto);
    }

    /**
     * Teste do método consultarTrechosxModalidade.
     */
    @Test
    void testeConsulta() {
        List<Double> listaPrevista = new ArrayList<>();
        listaPrevista.add(1453.0);
        listaPrevista.add(7076.110000000001);
        List<Double> listaRetornada = programa.consultarTrechosxModalidade("BELO HORIZONTE","CAMPO GRANDE", 0);
        Assertions.assertEquals(listaPrevista,listaRetornada);
    }

    /**
     * Teste do método calQuantCaminhao.
     */
    @Test
    void testeCalQuantCaminhao() {
        List<Integer> listaPrevista = new ArrayList<>();
        listaPrevista.add(2);
        listaPrevista.add(1);
        listaPrevista.add(1);
        List<Integer> listaRetornada = programa.calQuantCaminhao(16000);
        Assertions.assertEquals(listaPrevista,listaRetornada);
    }

    /**
     * Teste do método cadastrarTransporte com apenas um trecho.
     */
    @Test
    void testeCadastro() {
        List<Transporte> cadastroEsperado = new ArrayList<>();
        cadastroEsperado.add(new Transporte(
                new ArrayList<>(Arrays.asList(100,100,20,10,20,0)),
                8116,
                new ArrayList<>(Arrays.asList(1,2,0)),
                new ArrayList<>(Arrays.asList(new Trecho("BELEM","BELO HORIZONTE",2824,81077.04000000001))),
                2824
        ));
        programa.cadastrarTransporte(new ArrayList<>(Arrays.asList("BELEM","BELO HORIZONTE")),new ArrayList<>(Arrays.asList(100,100,20,10,20,0)));
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getQuantCaminhao(),cadastroEsperado.get(0).getQuantCaminhao());
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getItens(),cadastroEsperado.get(0).getItens());
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getPesoTotal(),cadastroEsperado.get(0).getPesoTotal());
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCusto(),cadastroEsperado.get(0).getTrechos().get(0).getCusto());
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getDistancia(),cadastroEsperado.get(0).getTrechos().get(0).getDistancia());
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCidadeF(),cadastroEsperado.get(0).getTrechos().get(0).getCidadeF());
        Assertions.assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCidadeI(),cadastroEsperado.get(0).getTrechos().get(0).getCidadeI());
    }


}
