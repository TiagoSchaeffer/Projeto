package org.projeto.dell;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(indexRetornado,indexPrevisto);
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
        assertEquals(listaPrevista,listaRetornada);
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
        assertEquals(listaPrevista,listaRetornada);
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
                2824,
                81077.04000000001
        ));
        programa.cadastrarTransporte(new ArrayList<>(Arrays.asList("BELEM","BELO HORIZONTE")),new ArrayList<>(Arrays.asList(100,100,20,10,20,0)));
        assertEquals(programa.cadastrosTransportes.get(0).getQuantCaminhao(),cadastroEsperado.get(0).getQuantCaminhao());
        assertEquals(programa.cadastrosTransportes.get(0).getItens(),cadastroEsperado.get(0).getItens());
        assertEquals(programa.cadastrosTransportes.get(0).getPesoTotal(),cadastroEsperado.get(0).getPesoTotal());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCusto(),cadastroEsperado.get(0).getTrechos().get(0).getCusto());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getDistancia(),cadastroEsperado.get(0).getTrechos().get(0).getDistancia());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCidadeF(),cadastroEsperado.get(0).getTrechos().get(0).getCidadeF());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCidadeI(),cadastroEsperado.get(0).getTrechos().get(0).getCidadeI());
    }

    /**
     * Teste do método cadastrarTransporte com apenas dois trechos.
     */
    @Test
    void testeCadastroDoisTrechos() {
        List<Transporte> cadastroEsperado = new ArrayList<>();
        cadastroEsperado.add(new Transporte(
                new ArrayList<>(Arrays.asList(100,100,20,10,20,0)),
                8116,
                new ArrayList<>(Arrays.asList(1,2,0)),
                new ArrayList<>(Arrays.asList(
                        new Trecho("BELEM","BELO HORIZONTE",2824,81077.04000000001),
                        new Trecho("BELO HORIZONTE", "MACEIO", 1854, 53228.34)
                )),
                4678,
                134305.38000000001
        ));
        programa.cadastrarTransporte(new ArrayList<>(Arrays.asList("BELEM","BELO HORIZONTE", "MACEIO")),new ArrayList<>(Arrays.asList(100,100,20,10,20,0)));
        assertEquals(programa.cadastrosTransportes.get(0).getQuantCaminhao(),cadastroEsperado.get(0).getQuantCaminhao());
        assertEquals(programa.cadastrosTransportes.get(0).getItens(),cadastroEsperado.get(0).getItens());
        assertEquals(programa.cadastrosTransportes.get(0).getPesoTotal(),cadastroEsperado.get(0).getPesoTotal());

        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCusto(),cadastroEsperado.get(0).getTrechos().get(0).getCusto());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getDistancia(),cadastroEsperado.get(0).getTrechos().get(0).getDistancia());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCidadeF(),cadastroEsperado.get(0).getTrechos().get(0).getCidadeF());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(0).getCidadeI(),cadastroEsperado.get(0).getTrechos().get(0).getCidadeI());

        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(1).getCusto(),cadastroEsperado.get(0).getTrechos().get(1).getCusto());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(1).getDistancia(),cadastroEsperado.get(0).getTrechos().get(1).getDistancia());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(1).getCidadeF(),cadastroEsperado.get(0).getTrechos().get(1).getCidadeF());
        assertEquals(programa.cadastrosTransportes.get(0).getTrechos().get(1).getCidadeI(),cadastroEsperado.get(0).getTrechos().get(1).getCidadeI());
    }

    /**
     * Teste do método dadosEstatisticos.
     */
    @Test
    void testeDados() {
        List<Double> dadosEsperados = new ArrayList<>(Arrays.asList(28.71, 26861.076, 250.0));
        programa.cadastrarTransporte(new ArrayList<>(Arrays.asList("BELEM","BELO HORIZONTE", "MACEIO")),new ArrayList<>(Arrays.asList(100,100,20,10,20,0)));
        List<Double> dadosRetornados = programa.dadosEstatisticos(programa.cadastrosTransportes.get(0));
        assertEquals(dadosRetornados,dadosEsperados);
    }

}
