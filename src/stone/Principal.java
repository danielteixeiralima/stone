// classe main que executa as operações do banco de dados
package stone;

import java.sql.*;
import java.util.Scanner;
import stone.Banco;
import static stone.Banco.atualizar;
import static stone.Banco.consultar;
import static stone.Banco.inserir;
import static stone.Banco.remover;
import stone.Conexao;

public class Principal {
    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
        int opcao = 1;
        
        while(opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4 ){
            System.out.println("Bem vindo(a) a Stone!");
            System.out.println("Escolha a operação: ");
            System.out.println("1 - Consultar todos os funcionários");
            System.out.println("2 - Inserir um novo funcionário");
            System.out.println("3 - Atualizar os dados de um funcionário");
            System.out.println("4 - Remover um funcionário\n");
            System.out.println("0 - Finalizar o programa");
            System.out.println("_____________________________________________________________");

            opcao = teclado.nextInt();
            System.out.println("");




            switch(opcao){
                case 1:
                    consultar();
                    break;

                case 2:
                    inserir();
                    break;

                case 3:
                    consultar();
                    atualizar();
                    break;

                case 4:
                    consultar();
                    remover();
                    break;

                case 0:
                    System.out.println("Programa finalizado!");
                    break;

                default:
                    System.out.println("Digite uma opção válida! \n");
                    opcao = 1;

            }
        }
    }
}
