package Atendimento;

public class Cliente implements ICliente{
    public String descricao = new String("Descricao Preco Quantidade "); 

    public void compra(String linha){
        descricao = descricao + "\n "+linha;
    }

    public String exibeCompras(){
        return descricao;
    }

    public boolean adicionaItens(){
        return false;
    }

    public void proximaCompra(boolean resposta){
        
    }
}
