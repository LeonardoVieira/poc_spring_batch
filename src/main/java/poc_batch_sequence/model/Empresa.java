package poc_batch_sequence.model;

/**
 * @author Thiago Freitas
 *
 */
public class Empresa {
	private int id;
	private String nome;
	private boolean temImagem;
	private double saldo;

	/**
	 * posição de campos do arquivo flat
	 */
	public static final String[] FLAT_FILE_ITEMS = new String[] { "id", "nome", "temImagem", "saldo" };

	/**
	 * 
	 */
	public Empresa() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the temImagem
	 */
	public boolean isTemImagem() {
		return temImagem;
	}

	/**
	 * @param temImagem
	 *            the temImagem to set
	 */
	public void setTemImagem(boolean temImagem) {
		this.temImagem = temImagem;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo
	 *            the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
