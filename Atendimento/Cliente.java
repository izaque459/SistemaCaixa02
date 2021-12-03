package Atendimento;

public class Cliente implements ICliente{
    private String descricao = new String("Descricao Preco Quantidade "); 
    private boolean adiciona = true;


    public void compra(String linha){
        descricao = descricao + "\n "+linha;
    }

    public String exibeCompras(){
        return descricao;
    }

    public boolean adicionaItens(){
        return adiciona;
    }

    public void proximaCompra(boolean resposta){
        this.adiciona = resposta;        
    }
}
