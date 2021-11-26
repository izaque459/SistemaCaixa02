package Registros;

import Produtos.Produto;

public class RegistroProduto implements IRegistro {
    
    private Produto produto= new Produto("vazio",0.0);
    private int quantidade = 0;

    public RegistroProduto(Produto produto,int n){
        this.produto=produto;
        this.quantidade=n;
    }

    public int quantidadeAtual(){
        return quantidade;
    }

    public void incrementa(int n){
        if(n>=0){
            quantidade = quantidade + n;
        }
    }
}
