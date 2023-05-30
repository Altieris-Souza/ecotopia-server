package projetoEco;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	public conexao(){
		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
			
			System.out.println("Conexão realizada!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}