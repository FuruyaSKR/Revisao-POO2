import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int ano = 0, mes = 0, dia = 0;
		Scanner entrada = new Scanner(System.in);

		user user = new user();
		official off = new official();
		/**/
		off.setUsuario("victor");
		off.setSenha("victor1");
		off.setNome("Victor H");
		off.setEmail("victor.hugo@gmail.com.br");
		off.setSexo("Masculino");
		
		List<Integer> horaTrab = Arrays.asList(1, 200,30, 400, 50, 60, 700, 80, 900, 10, 11, 12, 13, 14, 15, 16, 17, 18, 18);
        ArrayList<Float> valorHor = new ArrayList<>(Arrays.asList(100.33f,20000f,300f,40000f,500f,100.33f,20000f,300f,40000f,500f,100.33f,20000f,300f,40000f,500f,500f,500f,500f,500f));
		off.setHoraTrab(horaTrab);
		off.setValorHor(valorHor);

		Calendar c = Calendar.getInstance();

		System.out.print("Digite sua Data de nascimento:\nDia:");
		dia = entrada.nextInt();
		System.out.print("Digite sua Data de nascimento:\nMes:");
		mes = entrada.nextInt() - 1;
		System.out.print("Digite sua Data de nascimento:\nAno:");
		ano = entrada.nextInt();

		c.set(ano, mes, dia);
		off.setDataNascimento(c);
		System.out.println("----------------------------------------\nSaida:");
		off.calcMes();
		off.totalSalar();
		off.mediaSalar();
		off.maioresSalar(3);
		off.menoresSalar(3);
		off.mesesTrab();
		off.anosTrab();
		off.Aposentadoria();
		System.out.println(off.getDataNascimento());
		System.out.println(off);
	
	}
}