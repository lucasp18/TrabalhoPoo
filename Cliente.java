
public class Cliente extends Pessoa {

		private Carrinho carrinho;

		public Cliente(String nome, String rg, String cpf,String sexo, Carrinho carrinho) {
			super(nome, rg, cpf,sexo);
			this.carrinho = carrinho;
		}
		
		public Cliente(String nome, String rg,String sexo, String cpf) {
			super(nome, rg, cpf,sexo);
			carrinho = new Carrinho();
		}
		
		public  void qualsexo(){
			System.out.println(super.getsexo());			
		}
		
		
		
		public Carrinho getCarrinho() {
			return carrinho;
		}

		public void setCarrinho(Carrinho carrinho) {
			this.carrinho = carrinho;
		}

		
		
		public void inserirnoCarrinho (Produto x, int y) {
			Produto prod;
			prod = x;
			prod.setQuantidade(y);
			carrinho.addProduto(prod);
			
					
		}
		
		public void deltarnoCarrinho (Produto x) {
			carrinho.delProduto(x);
		}
		
		
}
