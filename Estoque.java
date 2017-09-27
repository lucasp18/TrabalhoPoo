import java.util.ArrayList;


public class Estoque {
private ArrayList<Produto> produtos ;

public Estoque(){
produtos= new ArrayList<Produto>();	
	
}

public ArrayList<Produto> getprodutos(){
	return produtos;

}


public void addProdutosAoEstoque(Produto prod){
	produtos.add(prod);
	
}

public boolean pesquisarProdutosNoEstoque(String nomeproduto){
	if (!produtos.isEmpty()){
		for(Produto jump :produtos)	
			if(jump.getNome().equals(nomeproduto))
				return true;
	}
	return false;
}

public boolean pesquisarProdutosNoEstoque(Produto prod){
	if (!produtos.isEmpty()){
		for(Produto jump :produtos)	
			if(jump.getNome().equals(prod))
				return true;
	}
	return false;
}
	
public void imprimirTodosProdutos()
{
int i= 0;
if(!produtos.isEmpty()){	
	for (i=0;i<produtos.size();i++) {
	System.out.print("indice: "+i);
	System.out.print(" codigo do produto: " + produtos.get(i).getCodigodoProduto());
	System.out.print(" nome do produto: " + produtos.get(i).getNome());
	System.out.print(" quantidade do produto: " + produtos.get(i).getQuantidade());
	System.out.println(" preco do produto: "+ produtos.get(i).getPreco());
	}
}else
	System.out.println("Nao temos nenhum produto no estoque ");
}


public void subtrairProdutos (int i,int sub){	
	produtos.get(i).setQuantidade(produtos.get(i).getQuantidade()-sub);
}


}





