package Produtos;

public class Item implements IProduto {
    private String nome = new String();
    private String preco = new String();

    Item(String nome, String preco){
        this.nome=nome;
        this.preco=preco;
    }

    public String Descricao(){
        return nome;
    }

    public String PrecoUnitario() {
        return preco;
    }

}
