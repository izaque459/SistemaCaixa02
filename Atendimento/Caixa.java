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
    private double totalPagar = 0.0;
    private double totalDesconto = 0.0;
    private int totalClientes = 0;
    private String produtoDesignado ;

    Map<Integer,RegistroItem> items = new HashMap<>();
    Map<Integer,RegistroProduto> produtos = new HashMap<>();
    
    public Caixa(String nome){
        this.nome=nome;

        items.put(100, new RegistroItem(new Item("Cerveja Brahma duplo malte lata 350 ml","2.87"), 89));
        items.put(101, new RegistroItem(new Item("Vinho Concha y Toro reservado 750 ml","29.98"), 27));
        items.put(102, new RegistroItem(new Item("Suco de uva Alianca 100% uva 1,5 L", "11.98"), 32));
        items.put(103, new RegistroItem(new Item("File de Merluza Noronha Pescados 500 g", "19.55"), 34));
        items.put(104, new RegistroItem(new Item("Flocao nao transgenico Sao Braz 500 g", "2.98"),56));
        items.put(105, new RegistroItem(new Item("Manteiga Valedourado", "7.48"),67));
        items.put(106, new RegistroItem(new Item("Tapioca Verdao 700 g", "3.98"), 19));
        items.put(107, new RegistroItem(new Item("Biscoito Salgado Piraque Gergelim 240 g", "3.49"), 45));
        items.put(108, new RegistroItem(new Item("Granola Sao Braz Tradicional, sem gluten ou banana 250 g", "7.98"), 12));
        items.put(109, new RegistroItem(new Item("Uva passa Verdao 200 g", "3.88"), 70));
        items.put(110 ,new RegistroItem(new Item("Amendoim Torrado Verdao 250 g", "3.98"), 53));
        items.put(111, new RegistroItem(new Item("Milho doce Verdao 500 g", "4.88"), 9));
        items.put(112, new RegistroItem(new Item("Pasta de amendoim integral Santa Helena 450 g", "9.97"), 12));
        items.put(113, new RegistroItem(new Item("Biscoito recheado Treloso 130 g", "1.59"), 69));
        items.put(114, new RegistroItem(new Item("Papel Higienico Personal Vip folha dupla 20 m LV 12 PG 11", "13.98"), 23));
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
            produtoDesignado = registroItem.retornaDescricaoItem()+" | "+registroItem.retornaPrecoItem()+" | "+qte;
            totalPagar = totalPagar + qte*Double.parseDouble(registroItem.retornaPrecoItem());
            return true;
        }else{
            return false;
        }
    
    }

    public String designaProduto(){
        return produtoDesignado;
    }

    public double exibeTotalPagar(){
        return totalPagar;
    }

    public double exibeTotalDesconto(){
        return totalDesconto;
    }

    public void aceitaPagamento(boolean resposta){
        totalCompras = totalCompras + totalPagar;
        if(resposta){
            totalDesconto = totalPagar*0.05;
            totalPagar = totalPagar - totalDesconto;
            totalDescontos = totalDescontos + totalDesconto;
            totalComprasDinheiro = totalComprasDinheiro + totalPagar;
        }else{
            totalComprasCartaoCredito = totalComprasCartaoCredito + totalPagar;
        }

        totalClientes++;

    }

    public void verificaNovoCliente(){
        totalPagar=0.0;
        totalDesconto=0.0;
    }
}
