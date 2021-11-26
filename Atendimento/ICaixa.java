package Atendimento;

public interface ICaixa {
    public boolean encerraExpediente();
    public void sinalizaEncerramento(String usuario);
    public double exibeTotalCompras();
    public double exibeTotalComprasDinheiro();
    public double exibeTotalComprasCartaoCredito();
    public double exibeTotalDescontos();
    public int exibeTotalClientes();
}
