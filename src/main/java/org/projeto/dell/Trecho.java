package org.projeto.dell;

/**
 * Classe que representa cada trecho.
 *
 * @author Tiago M. Schaeffer S.
 */
public class Trecho {

    /**
     * Atributo com a cidade inicial.
     */
    public String cidadeI;
    /**
     * Atributo com a cidade final.
     */
    public String cidadeF;
    /**
     * Atributo com a distancia entre as cidades.
     */
    public double distancia;
    /**
     * Atributo com o custo de transporte.
     */
    public double custo;


    /**
     * Construtor da classe Transporte.
     *
     * @param cidadeI   Cidade inicial.
     * @param cidadeF   Cidade final.
     * @param distancia distancia entre as cidades.
     * @param custo     custo de transporte.
     */
    public Trecho(String cidadeI, String cidadeF, double distancia, double custo) {
        this.cidadeI = cidadeI;
        this.cidadeF = cidadeF;
        this.distancia = distancia;
        this.custo = custo;
    }

    /**
     * get da cidade inicial.
     *
     * @return Retorna string cidade inicial.
     */
    public String getCidadeI() {
        return cidadeI;
    }

    /**
     * set da cidade inicial.
     *
     * @param cidadeI Cidade inicial.
     */
    public void setCidadeI(String cidadeI) {
        this.cidadeI = cidadeI;
    }

    /**
     * get da cidade final.
     *
     * @return Retorna string cidade final.
     */
    public String getCidadeF() {
        return cidadeF;
    }
    /**
     * set da cidade final.
     *
     * @param cidadeF Cidade final.
     */
    public void setCidadeF(String cidadeF) {
        this.cidadeF = cidadeF;
    }

    /**
     * get da distancia entre as cidades.
     *
     * @return Retorna int das distancia entre as cidades.
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * set da distancia entre as cidades.
     *
     * @param distancia distancia entre as cidades.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * get do custo de transporte.
     *
     * @return Retorna int dos custo de transporte.
     */
    public double getCusto() {
        return custo;
    }

    /**
     * set do custo de transporte.
     *
     * @param custo custo de transporte.
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }
}
