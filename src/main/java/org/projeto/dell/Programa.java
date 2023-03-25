package org.projeto.dell;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classe que realiza as funcionalidades do programa da DELL.
 *
 * @author Tiago M. Schaeffer S.
 */
public class Programa {

    /**
     * Váriavel estática com o preço do caminhão pequeno
     */
    private static final double CAMINHAO_PEQUENO = 4.87;
    /**
     * Váriavel estática com o preço do caminhão médio
     */
    private static final double CAMINHAO_MEDIO = 11.92;
    /**
     * Váriavel estática com o preço do caminhão grande
     */
    private static final double CAMINHAO_GRANDE = 27.44;

    /**
     * Atributo com todos os cadastros feitos.
     */
    List<Transporte> cadastrosTransportes = new ArrayList<>();

    public void printLista() {
        List<List<String>> lista = criarMatrix();

        for (List<String> strings : lista) {
            for (String string : strings) System.out.print(string + " ");
            System.out.println();
        }
    }

    /**
     * Método com a finalidade de criar a matrix com o csv, para manipular
     * os dados.
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
        } catch (IOException e) {
            e.printStackTrace();
            return lista;
        }
    }

    /**
     * Método para procurar a index apartir do nome da cidade
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
     * Método para consultar o preço e a distância entre duas cidades, com base
     * no tipo de caminhão.
     *
     * @param cidadeI    String cidade inicial
     * @param cidadeF    String cidade final
     * @param modalidade int com o tipo de caminhão, sendo 0 - pequeno, 1 - médio e 2 - grande.
     * @return Retorna um double[2] com o valor [0] sendo a distância, e o [1] sendo o custo.
     */
    public List<Double> consultarTrechosxModalidade(String cidadeI, String cidadeF, int modalidade) {
        List<List<String>> lista = criarMatrix();
        int indexI = buscarIndexCidade(cidadeI);
        int indexF = buscarIndexCidade(cidadeF);

        int distancia = Integer.parseInt(lista.get(indexI + 1).get(indexF));

        double custo = 0.0;
        if (modalidade == 0)
            custo = CAMINHAO_PEQUENO * distancia;
        else if (modalidade == 1)
            custo = CAMINHAO_MEDIO * distancia;
        else if (modalidade == 2)
            custo = CAMINHAO_GRANDE * distancia;

        Double distanciaD = (Double) (double) distancia;
        Double custoD = custo;
        List<Double> list = new ArrayList<>();
        list.add(distanciaD);
        list.add(custoD);

        return list;
    }

    /**
     * Método para cadastrar o transporte na lista do programa.
     *
     * @param cidades Lista com as cidades.
     * @param itens   Lista dos itens.
     */
    public void cadastrarTransporte(@NotNull List<String> cidades, @NotNull List<List<String>> itens) {
        double pesoTotal = 0;
        for (List<String> item : itens) {
            int quantItem = Integer.parseInt(item.get(1));
            double pesoItem = Double.parseDouble(item.get(2));
            pesoTotal += quantItem * pesoItem;
        }

        List<Integer> quantCaminhao = calQuantCaminhao(pesoTotal);
        List<Trecho> listaTrechos = new ArrayList<>();
        double custoTotalCPequeno = 0;
        double custoTotalCGrande = 0;
        double custoTotalCMedio = 0;
        String cidadeAnterior = "";
        String cidadeAtual;
        double custoTotal = 0;
        double distanciaTotal = 0;
        for (int i = 0; i < cidades.size(); i++) {
            if (i == 0)
                cidadeAnterior = cidades.get(i);
            else {
                cidadeAtual = cidades.get(i);

                List<Double> custoC = calcCustoPCaminhao(quantCaminhao, cidadeAnterior, cidadeAtual);
                double custoTrecho = custoC.get(0) + custoC.get(1) + custoC.get(2);
                custoTotalCPequeno += custoC.get(0);
                custoTotalCMedio += custoC.get(1);
                custoTotalCGrande += custoC.get(2);

                double distancia = consultarTrechosxModalidade(cidadeAnterior, cidadeAtual, 1).get(0);
                distanciaTotal += distancia;
                custoTotal += custoTrecho;

                Trecho trechoAtual = new Trecho(cidadeAnterior, cidadeAtual, distancia, custoTrecho);
                listaTrechos.add(trechoAtual);

                cidadeAnterior = cidadeAtual;
            }
        }

        Transporte cadastro = new Transporte(itens, pesoTotal, quantCaminhao, listaTrechos, distanciaTotal, custoTotal, new ArrayList<>(Arrays.asList(custoTotalCPequeno,custoTotalCMedio,custoTotalCGrande)));
        cadastrosTransportes.add(cadastro);
    }

    public List<Double> calcCustoPCaminhao(@NotNull List<Integer> quantCaminhao, String cidadeI, String cidadeF) {
        double custoP = 0;
        double custoM = 0;
        double custoG = 0;
        if (quantCaminhao.get(0) > 0)
            custoP = quantCaminhao.get(0) * consultarTrechosxModalidade(cidadeI, cidadeF, 0).get(1);
        if (quantCaminhao.get(1) > 0)
            custoM = quantCaminhao.get(1) * consultarTrechosxModalidade(cidadeI, cidadeF, 1).get(1);
        if (quantCaminhao.get(2) > 0)
            custoG = quantCaminhao.get(2) * consultarTrechosxModalidade(cidadeI, cidadeF, 2).get(1);
        return new ArrayList<>(Arrays.asList(custoP, custoM, custoG));
    }

    /**
     * Método para calcular a melhor quantidade de caminhão de cada tipo,
     * para gastar menos.
     *
     * @param pesoTotal peso total dos produtos.
     * @return Retorna uma lista com as quantidades de cada caminhão.
     */
    public List<Integer> calQuantCaminhao(double pesoTotal) {
        List<Integer> quantCaminhao = new ArrayList<>();
        int quantPequeno = 0;
        int quantMedio = 0;
        int quantGrande = 0;
        while (pesoTotal > 0) {
            if (pesoTotal > 8000) {
                quantGrande += 1;
                pesoTotal -= 10000;
            } else if (pesoTotal > 2000) {
                quantMedio += 1;
                pesoTotal -= 4000;
            } else {
                quantPequeno += 1;
                pesoTotal -= 1000;
            }
        }
        quantCaminhao.add(quantPequeno);
        quantCaminhao.add(quantMedio);
        quantCaminhao.add(quantGrande);
        return quantCaminhao;
    }

    /**
     * Método para calcular a melhor quantidade de caminhão de cada tipo,
     * para gastar menos.
     *
     * @param t recebe um Transporte.
     * @return Retorna uma lista com os dados estatísticos pedidos, sendo 0 - custo médio por km, 1- custo médio por tipo, 2- quantidade total de itens.
     */
    public List<Double> dadosEstatisticos(@NotNull Transporte t) {
        double custoMKm = t.custoTotal / t.distanciaTotal;

        int quantTipo = 0;
        double totalItens = 0;
        for (int i = 0; i < t.getItens().size(); i++) {
            int quantItem = Integer.parseInt(t.getItens().get(i).get(1));
            if (quantItem > 0)
                quantTipo++;
            totalItens += quantItem;
        }
        double custoMTipo = t.custoTotal / quantTipo;

        return new ArrayList<>(Arrays.asList(custoMKm, custoMTipo, totalItens));
    }
}
