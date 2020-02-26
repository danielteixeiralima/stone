//classe que faz a conexão do java com o banco de dados mysql
package stone;

import java.sql.*;

public class Conexao {
    
    String db = "db4free.net";
    String user = "user_stone";
    String pass = "stonestone";
    String url = "jdbc:mysql://db4free.net:3306/db_stone";
    Connection conexao;
    
    Conexao() throws SQLException{
        conexao = DriverManager.getConnection(url, user, pass);
    }

}
 
  
