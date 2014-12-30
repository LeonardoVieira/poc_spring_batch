/**
 * 
 */
package poc_batch_sequence.model;

/**
 * @author Thiago Freitas
 *
 */
public class Oferta {

	private int id;
	private String nome;
	private boolean temImagem;
	private int lojaId;

	/**
	 * posição de campos do arquivo flat
	 */
	public static final String[] FLAT_FILE_ITEMS = new String[] { "id", "nome", "temImagem", "lojaId" };

	/**
	 * 
	 */
	public Oferta() {
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
	 * @return the lojaId
	 */
	public int getLojaId() {
		return lojaId;
	}

	/**
	 * @param lojaId
	 *            the lojaId to set
	 */
	public void setLojaId(int lojaId) {
		this.lojaId = lojaId;
	}

}
