import java.util.Scanner;

import Atendimento.Caixa;
import Atendimento.Cliente;
import Atendimento.TipoPagamento;

public class Apresentacao {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("------------SISTEMA DE CAIXA PARA MERCADINHO-----------");
        System.out.print("Digite o nome do usuario: ");
        String entradaUsuario = entrada.nextLine();
        Caixa caixa = new Caixa(entradaUsuario);
        Cliente cliente = new Cliente();
        Integer codigo;
        int qte;
        int pag;
        boolean resposta;



        while(!caixa.encerraExpediente()){

            System.out.println(" ---------------------------------------------------------------- ");
            while(cliente.adicionaItens()){
                System.out.print("Digite o codigo o produto: ");
                codigo = entrada.nextInt();
                System.out.print("Digite a quantidade: ");
                qte = entrada.nextInt();
                if(caixa.adicionaProduto(codigo, qte)){
                    
                    cliente.compra(caixa.designaProduto());
                    System.out.println(cliente.exibeCompras());
                    System.out.println("Produto adiconado com sucesso.");
                }else
                    System.out.println("Produto indisponivel ou quantidade errada ");

                entrada.nextLine();
                System.out.print("Existe mais produtos? ");
                resposta = entrada.nextBoolean();
                cliente.proximaCompra(resposta);
            }

            System.out.println(" ---------------------------------------------------------------- ");
            while(!cliente.pagaCompra()){
                System.out.print("Total de compras do cliente atual: ");
                System.out.println(Double.toString(caixa.exibeTotalPagar()));
                entrada.nextLine();
                System.out.println("Digite forma de pagamento 1 para Dinheiro ou 2 para Cartao: ");
                pag = entrada.nextInt();
                if(pag==1)
                    caixa.aceitaPagamento(cliente.informaPagamento(TipoPagamento.Dinheiro));
                else if(pag==2)
                    caixa.aceitaPagamento(cliente.informaPagamento(TipoPagamento.CartaoCredito));
                    else 
                        System.out.println("Digite opcao valida. ");
                if(cliente.pagaCompra()){
                    System.out.print("Total a pagar: ");
                    System.out.println(Double.toString(caixa.exibeTotalPagar()));
                    System.out.print("Total de descontos: ");
                    System.out.println(Double.toString(caixa.exibeTotalDesconto()));
                }

            }

            System.out.println(" ---------------------------------------------------------------- ");
            entrada.nextLine();
            System.out.print("Existe novo cliente? ");
            resposta=entrada.nextBoolean();
            if(resposta){
                System.out.println("Novo cliente: ");
                cliente.proximo();
                caixa.verificaNovoCliente();
            }else{
                entrada.nextLine();
                System.out.print("Digite nome de usuario para finalizar expediente: ");
                entradaUsuario = entrada.nextLine();
                caixa.sinalizaEncerramento(entradaUsuario);
            }
        }

        entrada.close();
        System.out.println(" ");
        System.out.println("----------------------Contabilizacao do sistema: ");
        System.out.print("Total de compras:");
        System.out.println(Double.toString(caixa.exibeTotalCompras()));
        System.out.print("Total de compras com cartao de credito: ");
        System.out.println(Double.toString(caixa.exibeTotalComprasCartaoCredito()));
        System.out.print("Total de compras com dinheiro: ");
        System.out.println(Double.toString(caixa.exibeTotalComprasDinheiro()));
        System.out.print("Total de descontos: ");
        System.out.println(Double.toString(caixa.exibeTotalDescontos()));
        System.out.print("Total de Clientes: ");
        System.out.println(Integer.toString(caixa.exibeTotalClientes()));


    }
    
}
