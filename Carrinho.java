import java.util.ArrayList;


public class Carrinho {

	private ArrayList <Produto> carrinhoDeProdutos;


	public Carrinho () {
		carrinhoDeProdutos = new ArrayList<Produto>();
		
	}
	
	public void addProduto(Produto x) {
		carrinhoDeProdutos.add(x);
	
	}
	
	public void delProduto(Produto x) {
		carrinhoDeProdutos.remove(x);
	}

	
	public ArrayList<Produto> getCarrinhoDeProdutos() {
		return carrinhoDeProdutos;
	}

	public void setCarrinhoDeProdutos (ArrayList<Produto> carinhoDeProdutos) {
		this.carrinhoDeProdutos= carinhoDeProdutos;
	}
	
	public void listarProdutosNoCarrinho(){
		for (Produto produto : carrinhoDeProdutos) {
			System.out.println("Produto: " + produto.getNome());
			System.out.println("Quantidade: "+ produto.getQuantidade());
			System.out.println("Preco: "+produto.getPreco());
		}
	}
}
