package Produtos;

public class Produto implements IProduto{
    private String nome = new String();
    private double preco = 0.0;
    
    public Produto(String nome,double preco){
        this.nome=nome;
        this.preco=preco;
    }

    public String Descricao(){
        return nome;
    }

    public double PrecoUnitario(){
        return preco;
    }

}
