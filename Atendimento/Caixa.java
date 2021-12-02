package Atendimento;

public class Caixa implements ICaixa{
    private String nome = new String();
    private boolean sinal = false;
    private double totalCompras = 0.0;
    private double totalComprasCartaoCredito =0.0;
    private double totalComprasDinheiro = 0.0;
    private double totalDescontos =0.0;
    private int totalClientes = 0;
    
    public Caixa(String nome){
        this.nome=nome;
    }

    public boolean encerraExpediente(){
        return sinal;
    }

    public void sinalizaEncerramento(String usuario){
        if(nome.equals(usuario))
            sinal = true;
        else
            sinal = false;
    }
    
    public double exibeTotalCompras(){
        return totalCompras;
    }

    public double exibeTotalComprasCartaoCredito(){
        return totalComprasCartaoCredito;
    }

    public double exibeTotalComprasDinheiro(){
        return totalComprasDinheiro;
    }

    public double exibeTotalDescontos(){
        return totalDescontos;
    }

    public int exibeTotalClientes(){
        return totalClientes;
    }
}
