import java.util.Scanner;

import Atendimento.Caixa;
import Atendimento.Cliente;

public class Apresentacao {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome do usuario: ");
        String entradaUsuario = entrada.nextLine();
        Caixa caixa = new Caixa(entradaUsuario);
        Cliente cliente = new Cliente();
        Integer codigo;
        int qte;


        while(!caixa.encerraExpediente()){
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
            System.out.print("Digite nome de usuario para finalizar expediente: ");
            entradaUsuario = entrada.nextLine();
            caixa.sinalizaEncerramento(entradaUsuario);
        }

        entrada.close();
    }
    
}
