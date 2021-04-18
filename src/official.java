import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class official extends user {

	private String nome;
	private String email;
	List<Integer> horaTrab = new ArrayList<Integer>();
	List<Float> valorHor = new ArrayList<Float>();
	private Calendar dataNascimento;
	private String sexo;

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		Scanner entrada = new Scanner(System.in);
		Boolean aux = true;

		do {
			if ((sexo.length() > 0) && (sexo.equals("Feminino") || (sexo.equals("Masculino")))) {
				aux = false;
			} else {
				System.out.print("Sexo incorreta \nDigite novamente o sexo (Feminino e Masculino): ");
				sexo = entrada.nextLine();
			}

		} while (aux);
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() > 0) {
			this.nome = nome;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() > 0) {

			this.email = email;
		}
	}

	public String getDataNascimento() {
		String format = (dataNascimento.get(Calendar.DAY_OF_MONTH) + "/" + (dataNascimento.get(Calendar.MONTH) + 1)
				+ "/" + (dataNascimento.get(Calendar.YEAR)));
		return format;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		if (dataNascimento != null) {
			this.dataNascimento = dataNascimento;
		}
	}

	public List<Integer> getHoraTrab() {
		return horaTrab;
	}

	public void setHoraTrab(List<Integer> horaTrab) {
		if (horaTrab != null) {
			this.horaTrab = horaTrab;
		}
	}

	public List<Float> getValorHor() {
		return valorHor;
	}

	public void setValorHor(List<Float> valorHor) {
		if (valorHor != null) {
			this.valorHor = valorHor;
		}
	}

	public void calcMes() {
		for (int i = 0; i < horaTrab.size(); i++) {
			float salar = valorHor.get(i) * horaTrab.get(i);
			System.out.print("\nSalario " + (i + 1) + ": R$ " + salar);
		}
	}

	public void totalSalar() {
		float salarTotal = 0;
		for (int i = 0; i < horaTrab.size(); i++) {
			salarTotal += (valorHor.get(i) * horaTrab.get(i));
		}
		System.out.print("\nSalario Total: R$ " + salarTotal);
	}

	public void mediaSalar() {
		float salarTotal = 0, mediaSalar = 0;

		for (int i = 0; i < horaTrab.size(); i++) {
			salarTotal += (valorHor.get(i) * horaTrab.get(i));
			mediaSalar = salarTotal / horaTrab.size();
		}
		System.out.println("\nMedia Salario: R$ " + mediaSalar);
	}

	public void maioresSalar(int aux) {
		List<Float> maiores = new ArrayList<Float>();
		for (int i = 0; i < horaTrab.size(); i++) {
			maiores.add((float) (valorHor.get(i) * horaTrab.get(i)));
			Collections.sort(maiores);
			Collections.reverse(maiores);
		}
		System.out.println(" \n--- Maiores Salarios ---");
		for (int j = 0; j < aux; j++) {
			System.out.println("Salario " + j + ": R$" + maiores.get(j));
		}

	}

	public void menoresSalar(int aux) {
		List<Float> menores = new ArrayList<Float>();
		for (int i = 0; i < horaTrab.size(); i++) {
			menores.add((float) (valorHor.get(i) * horaTrab.get(i)));
			Collections.sort(menores);
		}
		System.out.println(" \n--- Menores Salarios ---");
		for (int j = 0; j < aux; j++) {
			System.out.println("Salario " + j + ": R$" + menores.get(j));
		}
	}

	public void mesesTrab() {
		System.out.println("\nMeses trabalhados: " + horaTrab.size());
	}
	public void anosTrab() {
		int meses = horaTrab.size();
		int ano = 0;

		if (meses > 12) {
			ano = meses / 12;
			meses = meses % 12;
		}
	
		System.out.println("Anos Trabalhados: " + ano);
		System.out.println("Fração (sobra) de Meses Trabalhados: "+ meses);
		System.out.println("Anos e Meses Trabalhados: "+ano+" Ano e " + meses+" Meses");
	}

	public int anosTrab2() {
		int meses = horaTrab.size();
		int ano = 0;

		if (meses > 12) {
			ano = meses / 12;
			meses = meses % 12;
		}
		return ano;

	}

	public void Aposentadoria() {
		int ano = anosTrab2();
		int prevano = 0, falta = 0, prevano2;

		if (getSexo().equals("Feminino")) {
			prevano = dataNascimento.get(Calendar.YEAR) + 62;
			falta = (0 > (35 - ano)) ? 0 : (35 - ano);
			prevano2 = 2021 + falta;
			System.out.println("Ano dos 35 anos de Contribuição:"+prevano2);
			System.out.println("Ano Idade Mínima (62 anos):"+prevano);
			System.out.println("Ano Nascimento: "+dataNascimento.get(Calendar.YEAR));
			System.out.println("Ano Aposentadoria:"+Math.max(prevano, prevano2));
			System.out.println("Idade Aposentadoria:"+(Math.max(prevano, prevano2) - dataNascimento.get(Calendar.YEAR)));
			System.out.println("Idade Atual: "+(2021 - dataNascimento.get(Calendar.YEAR)));
			System.out.println("Anos faltantes para se aposentar: "+(Math.max(prevano, prevano2) - 2021));

		} else if (getSexo().equals("Masculino")) {
			prevano = dataNascimento.get(Calendar.YEAR) + 65;
			falta = (0 > (35 - ano)) ? 0 : (35 - ano);
			prevano2 = 2021 + falta;
			System.out.println("Ano dos 35 anos de Contribuição:"+prevano2);
			System.out.println("Ano Idade Mínima (65 anos):"+prevano);
			System.out.println("Ano Nascimento: "+dataNascimento.get(Calendar.YEAR));
			System.out.println("Ano Aposentadoria:"+Math.max(prevano, prevano2));
			System.out.println("Idade Aposentadoria:"+(Math.max(prevano, prevano2) - dataNascimento.get(Calendar.YEAR)));
			System.out.println("Idade Atual: "+(2021 - dataNascimento.get(Calendar.YEAR)));
			System.out.println("Anos faltantes para se aposentar: "+(Math.max(prevano, prevano2) - 2021));	
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nUser: ");
		builder.append(getUsuario());
		builder.append("\nPass: ");
		builder.append(getSenha());
		builder.append("\nNome: ");
		builder.append(nome);
		builder.append("\nE-mail: ");
		builder.append(email);
		builder.append("\nHoras Trabalhadas: ");
		builder.append(horaTrab);
		builder.append("\nValor Hora: ");
		builder.append(valorHor);
		builder.append("\nData de Nascimento: ");
		builder.append(getDataNascimento());
		return builder.toString();
	}

	
	
}
