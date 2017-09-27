import java.util.ArrayList;


public class Sessao extends Estoque {
 
	private int tamsessao;
	private ArrayList<Produto> produtosDaSessao ;

	public Sessao(){
		produtosDaSessao= new ArrayList<Produto>();	
		tamsessao=0;
		
	}

	
	
	
	public int getTamsessao() {
		return tamsessao;
	}




	public void addprodutosDaSessaoAoEstoque(Produto prod ,Estoque estoque,int op){
		int quant;
		
		int f,i;
		boolean bo=false;
		System.out.println();
		
			if(!produtosDaSessao.isEmpty()){
			for (i=0; i<produtosDaSessao.size(); i++)
			if(produtosDaSessao.get(i).getNome().equals(prod.getNome())){
		
			produtosDaSessao.get(i).setQuantidade(produtosDaSessao.get(i).getQuantidade()+prod.getQuantidade());
			bo=true;
			}if(bo==false)
				produtosDaSessao.add(prod);
		
			}else{
			produtosDaSessao.add(prod);
			tamsessao++;
			}
				
		do{
			System.out.println("digite a quantidade de produtos que deseja inserir na sessao");
			quant=Keyboard.readInt();
		}while(quant > estoque.getprodutos().get(op).getQuantidade());
		f=estoque.getprodutos().get(op).getQuantidade()-quant;
		estoque.getprodutos().get(op).setQuantidade(f);	
		prod.setQuantidade(quant);
		
	}

	public Produto pesquisarprodutosDaSessaoNoEstoque(String nomeproduto){
		int i;		
		if (!produtosDaSessao.isEmpty()){
			for(i=0;i<produtosDaSessao.size();i++)
				if(produtosDaSessao.get(i).getNome().equals(nomeproduto))
					return produtosDaSessao.get(i);
		
		}
		return null;
	}

	public Produto pesquisarprodutosDaSessaoNoEstoque(Produto prod){
		int i;
		if (!produtosDaSessao.isEmpty()){
			for(i=0;i<produtosDaSessao.size();i++)
				if(produtosDaSessao.get(i).equals(prod))
					return produtosDaSessao.get(i);
		}
		return null;
	}
		
	public void imprimirTodoProdutos()
	{
	if(!produtosDaSessao.isEmpty()){
		for (Produto jump : produtosDaSessao) {
		System.out.println("codigo do produto " + jump.getCodigodoProduto());
		System.out.println("nome do produto " + jump.getNome());
		System.out.println("quantidade do produto " + jump.getQuantidade());
		System.out.println("preco do produto "+ jump.getPreco());
	}
	}else
		System.out.println("Nao temos nenhum produto na sessao");
	}

	public ArrayList<Produto> getprodutosDaSessao(){
		return produtosDaSessao;
	}
	
	
	public Produto retirarProdutoDaSessao(){
		int op,quant;
		Produto prod1;
	    this.imprimirTodoProdutos();
		System.out.println("digite o indice do produto que deseja colocar no carrinho");
		op=Keyboard.readInt();
		do{
		System.out.println("digite a quantidade de produtos que deseja retirar da sessao e colocar no carrinho");
		quant=Keyboard.readInt();
		}while(quant > getprodutos().get(op).getQuantidade());
		getprodutos().get(op).setQuantidade(getprodutos().get(op).getQuantidade()-quant);	
		prod1=getprodutos().get(op);
		prod1.setQuantidade(quant);
		return prod1;
	}
}
