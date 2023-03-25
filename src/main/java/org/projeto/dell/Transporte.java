package org.projeto.dell;
import java.util.*;


/**
 * Classe que representa cada transporte, sendo o conjunto de trechos.
 *
 * @author Tiago M. Schaeffer S.
 */
public class Transporte {

    /**
     * Atributo com a lista das quantidades de cada item.
     */
    public List<List<String>> itens;
    /**
     * Atributo com o peso total dos itens.
     */
    public double pesoTotal;

    /**
     * Atributo com a lista de trechos do transporte.
     */
    public List<Trecho> trechos;
    /**
     * Atributo com a distância total.
     */
    public double distanciaTotal;
    /**
     * Atributo com o custo total.
     */
    public double custoTotal;
    /**
     * Atributo custo total por tipo caminhão.
     */
    public List<Double> custoTotalPCaminhao;


    /**
     * Construtor da classe Transporte.
     *
     * @param itens         Lista quantidade itens.
     * @param pesoTotal     double peso total dos itens.
     * @param trechos       Lista de trechos.
     */
    public Transporte(List<List<String>> itens, double pesoTotal, List<Trecho> trechos, double distanciaTotal, double custoTotal, List<Double> custoTotalPCaminhao) {
        this.itens = itens;
        this.pesoTotal = pesoTotal;
        this.trechos = trechos;
        this.distanciaTotal = distanciaTotal;
        this.custoTotal = custoTotal;
        this.custoTotalPCaminhao = custoTotalPCaminhao;
    }

    /**
     * get da lista de itens.
     *
     * @return Retorna a lista com as quantidades de cada item.
     */
    public List<List<String>> getItens() {
        return itens;
    }

    /**
     * get do peso total dos itens.
     *
     * @return Retorna double do peso total dos itens.
     */
    public double getPesoTotal() {
        return pesoTotal;
    }

    /**
     * get da lista de trechos.
     *
     * @return Retorna List<Trecho> com todos os trechos do transporte.
     */
    public List<Trecho> getTrechos() {
        return trechos;
    }

    /**
     * get da distância total do transporte.
     *
     * @return Retorna a distânia total realizada pelo transporte.
     */
    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    /**
     * get do custo total do transporte.
     *
     * @return Retorna o custo total do transporte.
     */
    public double getCustoTotal() {
        return custoTotal;
    }

    /**
     * get do custo total por caminhão.
     *
     * @return Retorna o custo total por caminhão.
     */
    public List<Double> getCustoTotalPCaminhao() {
        return custoTotalPCaminhao;
    }
}
