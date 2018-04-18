package com.app.imovel.tabajaraimobiliaria.repositorios;

import java.util.Enumeration;

import com.app.imovel.tabajaraimobiliaria.basica.Imovel;
public class RepositorioImovelArray implements RepositorioImovel, Enumeration<Imovel> {
    private Imovel[] ims;
    private int pointer;
    private int pointerEnumeration;

    /**
     * Construtor que recebe um tamanho e adiciona ao vetor
     * @param tamanho - Valor do tamanho do vetor
     */
    public RepositorioImovelArray(int tamanho) {
        ims = new Imovel[tamanho];
        pointer = 0;
        pointerEnumeration = 0;
    }

    /**
     * Construtor que cria um valor de tamanho pré definido ao vetor(500000)
     */
    public RepositorioImovelArray() {
        this(500000);
    }

    /**
     * Procura o indice do imóvel no vetor
     * @param numero - Código do imóvel
     * @return - O indice da posição do imóvel no vetor ou -1 caso o imóvel não exista.
     * @throws IllegalArgumentException - Caso valor de código passado seja negativo
     */
    private int procurarIndice(String numero){
        int num=Integer.parseInt(numero);
        // Testa se o código passado é negativo
        if(num < 0) {
            throw new IllegalArgumentException("Número não pode ser menor que 0");
        }
        // Procura pelo vetor e retorna o indice direto se achar a instancia
        for(int j = 0; j < ims.length; j++){
            if(ims[j] !=null && num == ims[j].getCodigo()) {
                return j;
            }
        }
        return -1;
    }

    /**
     * Procura o imóvel no vetor e retorna uma instancia do mesmo caso exista.
     * @param numero - Código do imóvel
     * @return - Uma instancia do imóvel achado ou null caso o imóvel não exista
     * @throws IllegalArgumentException - Caso valor de código passado seja negativo
     */
    public Imovel procura(String numero) {
        // Usa o valor do indice para determinar o retorno
        int temp = procurarIndice(numero);
        if(temp < 0) {
            return null;
        }
        // Retorna a instancia do indice achado
        return ims[temp];
    }

    /**
     * Insere uma instacia do imóvel no vetor
     * @param i - Uma instancia de Imovel
     * @return - true caso a operação tenha sido bem sucedida, false caso o vetor esteja cheio ou caso o imóvel já exista
     * @throws NullPointerException - Caso a instancia de Imovel passado seja nula
     */
    public boolean inserir(Imovel i) {
        // Testa se o imóvel passado é nulo
        if(i == null) {
            throw new NullPointerException();
        }
        // Testa se o vetor já está cheio
        if(pointer == ims.length) {
            return false;
        }
        Imovel temp = procura(""+i.getCodigo());
        // Testa se o imóvel existe
        if(temp == null) {
            ims[pointer] = i;
            pointer++;
            return true;
        }
        // Caso o imóvel exista
        return false;
    }

    /**
     * Atualiza a instancia de um imóvel existente no vetor
     * @param i - Uma nova instância atualizada de Imovel
     * @return true caso a operação tenha sido bem sucedida, false caso o imóvel não exista
     * @throws NullPointerException - Caso a instancia de Imovel passado seja nula
     */
    public boolean atualizar(Imovel i){
        // Testa se o imóvel passado é nulo
        if(i == null) {
            throw new NullPointerException();
        }
        int temp=procurarIndice(""+i.getCodigo());
        // Testa se o imóvel existe
        if(temp>=0) {
            ims[temp] = i;
            return true;
        }
        // Caso não exista
        return false;
    }

    /**
     * Remove um imóvel do vetor
     * @param numero - Código do imóvel a ser removido
     * @return true caso o imóvel tenha sido removido com sucesso, false caso o imóvel não exista
     * @throws IllegalArgumentException - Caso valor de código passado seja negativo
     */
    public boolean remover(String numero){
        int temp = procurarIndice(numero);
        // Testa se o imóvel existe
        if(temp < 0) {
            return false;
        }
        // O imovel apontado pelo ponteiro assume o valor do removido na posição temp
        pointer--;
        ims[pointer] = ims[temp];
        return true;
    }

    /**
     * Testa se o imóvel existe
     * @param numero - Código do imóvel
     * @return true caso imóvel exista
     */
    public boolean existe(String numero) {
        return procura(numero) != null;
    }

    /**
     * Metódo implementado do Enumeration que retorna verdadeiro caso haja mais elementos no vetor a serem consultados
     * @return true caso haja mais elementos no vetor a serem consultados
     */
    @Override
    public boolean hasMoreElements() {
        return pointerEnumeration < pointer;
    }

    /**
     * Metódo implementado do Enumeration que retorna a próxima instancia de Imóvel do vetor caso haja mais
     * @return Uma instancia do próximo imóvel do vetor
     */
    @Override
    public Imovel nextElement() {
        pointerEnumeration = (hasMoreElements()) ? pointerEnumeration + 1 : pointerEnumeration;
        return ims[pointerEnumeration];
    }

    /**
     * Metódo não presente no Enumeration, mas criado com o intuito de retornar a instancia de imóvel anterior do vetor
     * @return Uma instancia do imóvel anterior do vetor
     */
    public Imovel previewElement() {
        pointerEnumeration = (pointerEnumeration > 0) ? pointerEnumeration-1 : 0;
        return ims[pointerEnumeration];
    }

    /**
     * Retorna todas as instancias de imóvel em uma Enumeration
     * @return Retorna uma Enumeration de imóveis
     */
    public Enumeration<Imovel> retornaTodos() {
        pointerEnumeration = 0;
        return this;
    }

    /**
     * Pega o primeiro imóvel do vetor
     * @return Uma instancia do primeiro imóvel do vetor
     */
    public Imovel getFirst() {
        pointerEnumeration = 0;
        return ims[0];
    }

    /**
     * Pega o último imóvel do vetor
     * @return Uma instancia do último imóvel do vetor
     */
    public Imovel getLast() {
        pointerEnumeration = pointer-1;
        return ims[pointer-1];
    }
}
