import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://sug-server.mysql.database.azure.com:3306/sugflora?useSSL=true";
        String username = "fatecsugflora";
        String password = "ferraz@2024";

        Connection connection = null;
        try {
            // Estabelecer a conexão
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            
            // Agora você pode usar a conexão para executar consultas, etc.
            // Por exemplo:
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery("SELECT * FROM tabela");
            // ...
            
            // Não se esqueça de fechar a conexão quando terminar
            connection.close();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            // Certifique-se de fechar a conexão no caso de ocorrer um erro
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
    }
}
