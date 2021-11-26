package Registros;

import Produtos.Item;

public class RegistroItem implements IRegistro{
    private Item item = new Item("vazio","nao informado");
    private int quantidade = 0;

    public RegistroItem(Item item,int qte){
        this.item=item;
        this.quantidade=qte;
    }

    public int quantidadeAtual(){
        return quantidade;
    }

    public void decrementa(int n){
        if (quantidade >= n){
            quantidade = quantidade - n;
        }
    }
}
