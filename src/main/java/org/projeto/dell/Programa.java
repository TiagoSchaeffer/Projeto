package org.projeto.dell;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que realiza as funcionalidades do programa da DELL
 *
 * @author Tiago M. Schaeffer S.
 */
public class Programa {

    /**
     *  Váriavel estática com o preço do caminhão pequeno
     */
    private static double CAMINHAO_PEQUENO = 4.87;
    /**
     *  Váriavel estática com o preço do caminhão médio
     */
    private static double CAMINHAO_MEDIO = 11.92;

    /**
     *  Váriavel estática com o preço do caminhão grande
     */
    private static double CAMINHAO_GRANDE = 27.44;
    /**
     * Variável estática com o peso do celular.
     */
    private static double CELULAR = 0.5;
    /**
     * Variável estática com o peso da geladeira.
     */
    private static double GELADEIRA = 60;
    /**
     * Variável estática com o peso do freezer.
     */
    private static double FREEZER = 100;
    /**
     * Variável estática com o peso da cadeira.
     */
    private static double CADEIRA = 5;
    /**
     * Variável estática com o peso do luminaria.
     */
    private static double LUMINARIA = 0.8;
    /**
     * Variável estática com o peso do lavadora.
     */
    private static double LAVADORA = 120;


    public void printLista() {
        List<List<String>> lista = criarMatrix();

        for (List<String> strings : lista) {
            for (String string : strings) System.out.print(string + " ");
            System.out.println();
        }
    }

    /**
     *  Método com a finalidade de criar a matrix com o csv, para manipular
     *  os dados.
     *
     * @return Retorna uma matrix de String, feita com List Collection.
     */
    public List<List<String>> criarMatrix() {
        String path = "src\\main\\resources\\DNIT-Distancias.csv";
        List<List<String>> lista = new ArrayList<>();
        String line;

        try (BufferedReader dataxls = new BufferedReader(new FileReader(path))) {

            while ((line = dataxls.readLine()) != null) {
                List<String> linha = new ArrayList<>();
                String[] line_split = line.split(";");

                Collections.addAll(linha, line_split);

                lista.add(linha);
            }
            return lista;
        }
        catch (IOException e) {
            e.printStackTrace();
            return lista;
        }
    }

    /**
     *  Método para procurar a index apartir do nome da cidade
     *
     * @return Retorna um int com o index da cidade
     */
    public int buscarIndexCidade(String cidade) {
        List<List<String>> lista = criarMatrix();
        for (int i = 0; i < lista.get(0).size(); i++) {
            if (lista.get(0).get(i).equalsIgnoreCase(cidade))
                return i;
        }
        return -1;
    }


    /**
     *  Método para consultar o preço e a distância entre duas cidades, com base
     *  no tipo de caminhão.
     *
     * @param cidadeI String cidade inicial
     * @param cidadeF String cidade final
     * @param modalidade int com o tipo de caminhão, sendo 0 - pequeno, 1 - médio e 2 - grande.
     * @return Retorna um double[2] com o valor [0] sendo a distância, e o [1] sendo o custo.
     */
    public List<Double> consultarTrechosxModalidade(String cidadeI, String cidadeF, int modalidade) {
        List<List<String>> lista = criarMatrix();
        int indexI = buscarIndexCidade(cidadeI);
        int indexF = buscarIndexCidade(cidadeF);

        int distancia =Integer.parseInt(lista.get(indexI+1).get(indexF));

        double custo = 0.0;
        if (modalidade == 0)
            custo = CAMINHAO_PEQUENO * distancia;
        else if (modalidade == 1)
            custo = CAMINHAO_MEDIO * distancia;
        else if (modalidade == 2)
            custo = CAMINHAO_GRANDE * distancia;

        Double distanciaD = (Double)(double) distancia;
        Double custoD = custo;
        List<Double> list = new ArrayList<>();
        list.add(distanciaD);
        list.add(custoD);

        return list;
    }

    public void cadastrarTransporte(List<String> cidades, List<Integer> itens) {
        int pesoTotal = 0;
        pesoTotal += itens.get(0)*CELULAR;
        pesoTotal += itens.get(1)*GELADEIRA;
        pesoTotal += itens.get(2)*FREEZER;
        pesoTotal += itens.get(3)*CADEIRA;
        pesoTotal += itens.get(4)*LUMINARIA;
        pesoTotal += itens.get(5)*LAVADORA;

        String cidadeAtual;
        String cidadeAnterior;
        for (int i = 0; i < cidades.size(); i++) {
            if (i == 0)
                cidadeAnterior = cidades.get(i);
            else {
                cidadeAtual = cidades.get(i);
            }
        }
    }

}
