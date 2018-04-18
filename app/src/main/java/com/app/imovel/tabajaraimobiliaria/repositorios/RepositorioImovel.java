package com.app.imovel.tabajaraimobiliaria.repositorios;

import com.app.imovel.tabajaraimobiliaria.basica.Imovel;

public interface RepositorioImovel {
    public Imovel procura(String numero);
    public boolean inserir(Imovel i);
    public boolean atualizar(Imovel i);
    public boolean remover(String numero);
    public boolean existe(String numero);
}
