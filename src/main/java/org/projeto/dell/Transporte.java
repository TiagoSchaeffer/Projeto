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
     * Atributo com a lista quantidade de caminhões por tipo.
     */
    public List<Integer> quantCaminhao;
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
    public List<Double> custoTotalPCaminhao;


    /**
     * Construtor da classe Transporte.
     *
     * @param itens         Lista quantidade itens.
     * @param pesoTotal     double peso total dos itens.
     * @param quantCaminhao int quantidade de caminhão.
     * @param trechos       Lista de trechos.
     */
    public Transporte(List<List<String>> itens, double pesoTotal, List<Integer> quantCaminhao, List<Trecho> trechos, double distanciaTotal, double custoTotal, List<Double> custoTotalPCaminhao) {
        this.itens = itens;
        this.pesoTotal = pesoTotal;
        this.quantCaminhao = quantCaminhao;
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
     * set da lista de itens.
     *
     * @param itens Lista com as quantidades de cada item.
     */
    public void setItens(List<List<String>> itens) {
        this.itens = itens;
    }

    /**
     * get da quantidade de caminhão.
     *
     * @return Retorna List<Integer> da quantidade de caminhão.
     */
    public List<Integer> getQuantCaminhao() {
        return quantCaminhao;
    }

    /**
     * set da lista de caminhões.
     *
     * @param quantCaminhao quantidade de caminhão por tipo.
     */
    public void setQuantCaminhao(List<Integer> quantCaminhao) {
        this.quantCaminhao = quantCaminhao;
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
     * set do peso total dos itens.
     *
     * @param pesoTotal double do peso total dos itens.
     */
    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
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
     * set da lista de trechos.
     *
     * @param trechos Lista com todos os trechos do transporte.
     */
    public void setTrechos(List<Trecho> trechos) {
        this.trechos = trechos;
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
     * set da distância total do transporte.
     *
     * @param distanciaTotal double com a distânia total realizada pelo transporte.
     */
    public void setDistanciaTotal(double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
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
     * set do custo total do transporte.
     *
     * @param custoTotal double com o custo total do transporte.
     */
    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public List<Double> getCustoTotalPCaminhao() {
        return custoTotalPCaminhao;
    }

    public void setCustoTotalPCaminhao(List<Double> custoTotalPCaminhao) {
        this.custoTotalPCaminhao = custoTotalPCaminhao;
    }
}
