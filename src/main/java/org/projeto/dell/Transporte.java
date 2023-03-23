package org.projeto.dell;
import java.util.*;


/**
 * Classe que representa cada transporte, sendo o conjunto de trechos.
 *
 * @author Tiago M. Schaeffer S.
 */
public class Transporte {

    /**
     * Atributo com a lista dos nomes das cidades.
     */
    public List<String> cidades;
    /**
     * Atributo com a lista das quantidades de cada item.
     */
    public List<Integer> itens;
    /**
     * Atributo com o peso total dos itens.
     */
    public double pesoTotal;
    /**
     * Atributo com a quantidade de caminhões necessárias para o transporte.
     */
    public int quantCaminhao;


    /**
     * Construtor da classe Transporte.
     *
     * @param cidades       Lista nome das cidades.
     * @param itens         Lista quantidade itens.
     * @param pesoTotal     double peso total dos itens.
     * @param quantCaminhao int quantidade de caminhão.
     */
    public Transporte(List<String> cidades, List<Integer> itens, double pesoTotal, int quantCaminhao) {
        this.cidades = cidades;
        this.itens = itens;
        this.pesoTotal = pesoTotal;
        this.quantCaminhao = quantCaminhao;
    }

    /**
     * get da lista de cidades.
     *
     * @return Retorna a lista com as cidades.
     */
    public List<String> getCidades() {
        return cidades;
    }

    /**
     * set da lista de cidades.
     *
     * @param cidades Lista com os nomes das cidade.
     */
    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
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
     * @return Retorna int da quantidade de caminhão.
     */
    public int getQuantCaminhao() {
        return quantCaminhao;
    }

    /**
     * set da lista de itens.
     *
     * @param quantCaminhao quantidade de caminhão.
     */
    public void setQuantCaminhao(int quantCaminhao) {
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

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
}
