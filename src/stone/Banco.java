//classe que realiza as operações do banco: consultar, inserir, atualizar e remover
package stone;

import java.sql.*;
import stone.Funcionarios;
import stone.Conexao;
import java.util.Scanner;

public class Banco {
    
    

    
    
    public static void consultar() throws SQLException{
        //consulta todos os funcionários atualmente cadastrados
        Conexao con = new Conexao ();
        Statement st = con.conexao.createStatement();
        
        st.executeQuery("Select * from funcionarios");
        ResultSet rs = st.getResultSet();
        
        System.out.println("TODOS OS FUNCIONÁRIOS");
        System.out.println("_______________________\n");
         
        while(rs.next()){
            System.out.println(rs.getInt("id") + "-" + rs.getString("nome") + " , " + rs.getInt("idade") + " anos" + " , " + rs.getString("cargo"));
        }
        System.out.println(""); 
    }
    
    public static void inserir() throws SQLException{
        //cadastra um novo funcionário
        String nome_insert;
        int idade_insert;
        String cargo_insert;
        Scanner teclado_insert = new Scanner(System.in);
        
        try{
            Conexao con = new Conexao ();
            
            System.out.println("Digite o nome do funcionário: \n");
            nome_insert = teclado_insert.next();
            System.out.println("");

            System.out.println("Digite a idade do funcionário: \n");
            idade_insert = teclado_insert.nextInt();
            System.out.println("");
            
            System.out.println("Digite o cargo do funcionário: \n");
            cargo_insert = teclado_insert.next();
            System.out.println("");

            String sql = "Insert Into funcionarios (nome, idade, cargo) Values (?,?,?)";

            PreparedStatement state = con.conexao.prepareStatement(sql);

            state.setString(1,nome_insert);
            state.setInt(2, idade_insert);
            state.setString(3, cargo_insert);

            state.execute();
            
            System.out.println("Funcionário cadastrado com sucesso!\n");
        } catch (Exception e){
            System.out.println("Erro: " +e);
        }      
    }
    
    public static void atualizar() throws SQLException{
        //atualiza os dados de um funcionário
        Scanner teclado_update = new Scanner (System.in);
        String nome_update;
        int idade_update;
        String cargo_update;
        int id_update;
        
        try{
            Conexao con = new Conexao();
            
            System.out.println("Digite o ID do funcionário que deseja atualizar: \n");
            id_update = teclado_update.nextInt();
            System.out.println("");
            
            System.out.println("Digite o nome do funcionário que deseja atualizar: \n");
            nome_update = teclado_update.next();
            System.out.println("");
            
            System.out.println("Digite a idade do funcionário que deseja atualizar: \n");
            idade_update = teclado_update.nextInt();
            System.out.println("");
            
            System.out.println("Digite o cargo do funcionário que deseja atualizar: \n");
            cargo_update = teclado_update.next();
            System.out.println("");
            
            String sql = "UPDATE funcionarios SET nome = ?, idade = ?, cargo = ? WHERE id  = ?";
            
            PreparedStatement state = con.conexao.prepareStatement(sql);
            
            
            state.setString(1, nome_update);
            state.setInt(2, idade_update);
            state.setString(3, cargo_update);
            state.setInt(4, id_update);
            
            state.execute();
            
            System.out.println("Funcionário atualizado com sucesso!\n");
            state.close();
            
        } catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
    public static void remover(){
        //remove as informações de um funcionário
        Scanner teclado_delete = new Scanner (System.in);
        String nome_delete;
        int idade_delete;
        String cargo_delete;
        int id_delete;
        
        try{
            Conexao con = new Conexao();
            
            System.out.println("Digite o ID do funcionário que deseja remover: \n");
            id_delete = teclado_delete.nextInt();
            System.out.println("");
            
            String sql = "DELETE FROM funcionarios WHERE id = ?";
            PreparedStatement state = con.conexao.prepareStatement(sql);
            
            
            state.setInt(1, id_delete);
          
            
            state.execute();
            
            System.out.println("Funcionário removido com sucesso!\n");
            state.close();
            
        } catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
}
