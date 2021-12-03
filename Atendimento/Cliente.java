package Atendimento;

public class Cliente implements ICliente{
    private String descricao = new String("        Descricao     Preco    Quantidade "); 
    private boolean adiciona = true;
    private boolean paga = false;
    private TipoPagamento pagamento;


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
    public boolean pagaCompra(){
        return paga;
    }

    public boolean informaPagamento(TipoPagamento pagamento){
        boolean retorno = false;
        this.pagamento=pagamento;
        switch(this.pagamento){
            case CartaoCredito:
                paga=true;
                break;
            case Dinheiro:
                paga=true;
                retorno = true;
                break;
            default:
                break;
        }

        return retorno;
    }

    public void proximo(){
        adiciona=true;
        paga=false;
        descricao = "         Descricao        Preco       Quantidade "; 
    }
}
