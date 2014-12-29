package poc_batch_sequence.model;

public class Empresa {
	private int id;
	private String nome;
	private boolean temImagem;
	private double saldo;

	public Empresa(int id, String nome, boolean temImagem, double saldo) {
		this.id = id;
		this.nome = nome;
		this.temImagem = temImagem;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public boolean isTemImagem() {
		return temImagem;
	}

	public double getSaldo() {
		return saldo;
	}

}
