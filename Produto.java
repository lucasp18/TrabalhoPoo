public class Produto {
	
	private String nome;
	private static  int codigoP =0;
	private int quantidade;
	private float  preco;
	private int codigodoProduto;
	
	public Produto(String nome, int quantidade, float preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		codigodoProduto=++codigoP;
	}

	public Produto(){
			
	}
		
	public Produto(String nome, float preco) {    // sorbecarga de protudo
		this.nome = nome;						  // adiciona um produto sem quantidade
		this.preco = preco;						  // no estoque.
		quantidade =1;
		codigodoProduto=++codigoP;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getCodigoP() {
		return codigoP;
	}

	public static void setCodigoP(int codigoP) {
		Produto.codigoP = codigoP;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


	public int getCodigodoProduto() {
		return codigodoProduto;
	}


	public void setCodigodoProduto(int codigodoProduto) {
		this.codigodoProduto = codigodoProduto;
	}

	
}
