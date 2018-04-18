package com.app.imovel.tabajaraimobiliaria.basica;

public class Imovel {
    // Parametros de um imóvel
    private int codigo;
    private String tipoImovel;
    private String bairro;
    private double area;
    private int numQuartos;
    private int numBanheiros;
    private int numGaragens;
    private double preco;
    // Construtor de um imóvel
    public Imovel(int codigo, String tipo,String bairro,double area,int numQuartos,
                  int numBanheiros, int numGaragens, double preco) {
        this.codigo=codigo;
        this.tipoImovel=tipo;
        this.bairro=bairro;
        this.area=area;
        this.numQuartos=numQuartos;
        this.numBanheiros=numBanheiros;
        this.numGaragens=numGaragens;
        this.preco=preco;

    }
    // Getters e setters de todos os parametros do imóvel
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTipoImovel() {
        return tipoImovel;
    }
    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public int getNumQuartos() {
        return numQuartos;
    }
    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }
    public int getNumBanheiros() {
        return numBanheiros;
    }
    public void setNumBanheiros(int numBanheiros) {
        this.numBanheiros = numBanheiros;
    }
    public int getNumGaragens() {
        return numGaragens;
    }
    public void setNumGaragens(int numGaragens) {
        this.numGaragens = numGaragens;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}

