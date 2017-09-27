import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Gerente extends Funcionario implements IGerente,Iestoquista,Icaixa {
	
	private String curso ;

	public Gerente(String nome, String rg, String cpf, String nomeDaFuncaoDoFuncionario, String sexo,String curso,int anoExperiencia) {

		super(nome, rg, cpf, nomeDaFuncaoDoFuncionario,sexo,anoExperiencia);
		this.curso = curso;
	} 
	
	public String getCurso (){
	return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String qualificacaoGerente(){
		return "nome: "+super.getNome()+" formando no curso: "+curso+" anos de experiencia: "+super.getAnoExperiencia();
		
	}

	public void arrumarSessao(ArrayList<Sessao> sessoes,Estoque estoque){
		int z=0;
		for (int i = 0; i < sessoes.size(); i++) {
			for (int j = 0; j < sessoes.get(i).getprodutos().size(); j++) {
				sessoes.get(i).getprodutos().get(j);	
				estoque.getprodutos().contains(sessoes.get(i).getprodutos().get(j));
				z =	estoque.getprodutos().indexOf(sessoes.get(i).getprodutos().get(j));
				if(estoque.getprodutos().get(z).getQuantidade()> 0)
					if(estoque.getprodutos().get(z).getQuantidade() > 30){
						sessoes.get(i).getprodutos().get(j).setQuantidade(sessoes.get(i).getprodutos().get(j).getQuantidade()+30);
						estoque.subtrairProdutos(z,30);
					}else{
						sessoes.get(i).getprodutos().get(j).setQuantidade(sessoes.get(i).getprodutos().get(j).getQuantidade()+estoque.getprodutos().get(z).getQuantidade());
						estoque.getprodutos().get(z).setQuantidade(0);
					}
				
			}	
		}	
	}

	public void efetuarCompra(Cliente cliente){
		DecimalFormat df = new DecimalFormat("0.##");
		float totalDaCompra=0,pag=0;
		for (Produto jump : cliente.getCarrinho().getCarrinhoDeProdutos()) {
			System.out.print("Produto: "+ jump.getNome());
			System.out.print(" Quantidade: "+jump.getQuantidade());
			System.out.println(" Preco por unidade: "+jump.getPreco());
			totalDaCompra =jump.getQuantidade()*jump.getPreco() + totalDaCompra;
			
		}
		System.out.println("O valor da Compra é R$ "+ df.format(totalDaCompra) +" reais");
	
		do{
			System.out.println("Aguardando o pagamento...");
			pag=Keyboard.readFloat();
		}while(pag<totalDaCompra);
		System.out.println("o troco do senhor eh de R$ "+ df.format(pag-totalDaCompra)+" reais");
		System.out.println("volte sempre");
	}

}
