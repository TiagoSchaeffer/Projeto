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
    public List<Integer> itens;
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
     * Atributo com a distância Total.
     */
    public double distanciaTotal;


    /**
     * Construtor da classe Transporte.
     *
     * @param itens         Lista quantidade itens.
     * @param pesoTotal     double peso total dos itens.
     * @param quantCaminhao int quantidade de caminhão.
     * @param trechos       Lista de trechos.
     */
    public Transporte(List<Integer> itens, double pesoTotal, List<Integer> quantCaminhao, List<Trecho> trechos, double distanciaTotal) {
        this.itens = itens;
        this.pesoTotal = pesoTotal;
        this.quantCaminhao = quantCaminhao;
        this.trechos = trechos;
        this.distanciaTotal = distanciaTotal;
    }


    /**
     * get da lista de itens.
     *
     * @return Retorna a lista com as quantidades de cada item.
     */
    public List<Integer> getItens() {
        return itens;
    }

    /**
     * set da lista de itens.
     *
     * @param itens Lista com as quantidades de cada item.
     */
    public void setItens(List<Integer> itens) {
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
     * get da distância total de todos os trechos.
     *
     * @return Retorna a distânia total realizada pelo transporte.
     */
    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    /**
     * get da distância total de todos os trechos.
     *
     * @param distanciaTotal double com a distânia total realizada pelo transporte.
     */
    public void setDistanciaTotal(double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }
}
