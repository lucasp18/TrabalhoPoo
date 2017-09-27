import java.util.ArrayList;


public class Estoquista extends Funcionario implements Iestoquista{

	private String nomeDaFuncaoDoFuncionario;
	private int numFuncionario;
	
	public Estoquista(String nome, String rg,String cpf,String sexo,int anoExperiencia) 
	{
		super(nome, cpf, rg,"estoquista",sexo,anoExperiencia);
		this.nomeDaFuncaoDoFuncionario = "Estoquista";
		this.numFuncionario =super.mostrarCodigoFuncionario();
	}

	public String getNomeDaFuncaoDoFuncionario() {
		return nomeDaFuncaoDoFuncionario;
	}

	public void setNomeDaFuncaoDoFuncionario(String nomeDaFuncaoDoFuncionario) {
		this.nomeDaFuncaoDoFuncionario = nomeDaFuncaoDoFuncionario;
	}
	
	
	public void arrumarSessao(ArrayList<Sessao> sessoes,Estoque estoque){
		int z=0;
		for (int i = 0; i < sessoes.size(); i++) {
			for (int j = 0; j < sessoes.get(i).getprodutosDaSessao().size(); j++) {
				if(estoque.getprodutos().get(i).getNome().equals(sessoes.get(i).getprodutosDaSessao().get(j).getNome())){
					z =	i;
					if(estoque.getprodutos().get(z).getQuantidade() > 0)
						if(estoque.getprodutos().get(z).getQuantidade() > 30){
							sessoes.get(i).getprodutosDaSessao().get(j).setQuantidade(sessoes.get(i).getprodutosDaSessao().get(j).getQuantidade()+30);
							estoque.subtrairProdutos(z,30);
						}else{
							sessoes.get(i).getprodutosDaSessao().get(j).setQuantidade(sessoes.get(i).getprodutosDaSessao().get(j).getQuantidade()+estoque.getprodutos().get(z).getQuantidade());
							estoque.getprodutos().get(z).setQuantidade(0);
						}
				
					}	
				}	
			}
		}


	public String informacoesEstoquista(){
		return "Nome: " +super.getNome()+" sexo do funcionario: "+super.getsexo()+" codigo do funcionario: "+numFuncionario;
	}
}
