//classe que faz a conexão do java com o banco de dados mysql
package stone;

import java.sql.*;

public class Conexao {
    
    String db = "localhost";
    String user = "root";
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/stone";
    Connection conexao;
    
    Conexao() throws SQLException{
        conexao = DriverManager.getConnection(url, user, pass);
    }

}
