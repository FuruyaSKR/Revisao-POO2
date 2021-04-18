import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class user {

	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if (usuario.length() > 0) {
			this.usuario = usuario;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		Scanner entrada = new Scanner(System.in);
		Boolean aux = true;

		do {
			if ((senha.length() == 0) || (usuario.equals(senha))) {
				System.out.print("Senha incorreta \nDigite novamente a senha: ");
				senha = entrada.nextLine();
			} else {
				aux = false;
			}
		} while (aux);
		
		try {
		    MessageDigest m = MessageDigest.getInstance("SHA-1");
		  
		    m.update( senha.getBytes(), 0 , senha.length() );
		              
		    byte[] digest = m.digest();
		          
		    String hexa = new BigInteger(1,digest).toString(16);
		    this.senha = hexa;
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		}	
	}
	
}

