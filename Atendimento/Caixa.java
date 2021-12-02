package Atendimento;

import java.util.HashMap;
import java.util.Map;

import Produtos.Item;
import Produtos.Produto;
import Registros.RegistroItem;
import Registros.RegistroProduto;

public class Caixa implements ICaixa{
    private String nome = new String();
    private boolean sinal = false;
    private double totalCompras = 0.0;
    private double totalComprasCartaoCredito =0.0;
    private double totalComprasDinheiro = 0.0;
    private double totalDescontos =0.0;
    private int totalClientes = 0;
    private RegistroProduto produtoDesignado ;

    Map<Integer,RegistroItem> items = new HashMap<>();
    Map<Integer,RegistroProduto> produtos = new HashMap<>();
    
    public Caixa(String nome){
        this.nome=nome;

        items.put(100, new RegistroItem(new Item("Cerveja Brahma duplo malte lata 350 ml","2.87"), 89));
        items.put(101, new RegistroItem(new Item("Vinho Concha y Toro reservado 750 ml","29.98"), 27));
        items.put(102, new RegistroItem(new Item("Suco de uva Alianca 100% uva 1,5 L", "11.98"), 32));
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

    public boolean adicionaProduto(Integer codigo, int qte){

        RegistroItem registroItem = items.get(codigo);
        RegistroProduto registroProduto = produtos.get(codigo) ;
        if((registroItem != null)&&(registroItem.quantidadeAtual()>0)&&(registroItem.quantidadeAtual()>=qte)){
            if (registroProduto!=null) {
                registroProduto.incrementa(qte);
                registroItem.decrementa(qte);
                produtos.put(codigo, registroProduto);
                items.put(codigo, registroItem);
            }else{
                produtos.put(codigo,new RegistroProduto(new Produto(registroItem.retornaDescricaoItem(), Double.parseDouble(registroItem.retornaPrecoItem())), qte));
                registroItem.decrementa(qte);
                items.put(codigo,registroItem);
            }
            produtoDesignado = registroProduto;
            return true;
        }else{
            return false;
        }
    
    }

    public String designaProduto(){
        return produtoDesignado.retornaDescricaoProduto()+Double.toString(produtoDesignado.retornaPrecoProduto())+Integer.toString(produtoDesignado.quantidadeAtual());
    }
}
