import java.util.Scanner;

import Atendimento.Caixa;

public class Apresentacao {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome do usuario: ");
        String entradaUsuario = entrada.nextLine();
        Caixa caixa = new Caixa(entradaUsuario);


        while(!caixa.encerraExpediente()){

            System.out.print("Digite nome de usuario para finalizar expediente: ");
            entradaUsuario = entrada.nextLine();
            caixa.sinalizaEncerramento(entradaUsuario);
        }

        entrada.close();
    }
    
}
