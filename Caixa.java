
public class Caixa extends Funcionario implements Icaixa{

	private String nomeDaFuncaoDoFuncionario;
	private int numFuncionario;
	private int numCaixaQueTrabalha;
	private int numCompras;
	
	public Caixa(String nome,  String rg,String cpf,int numCaixaQueTrabalha,String sexo,int anoExperiencia )
	{
		super(nome, rg, cpf,"caixa",sexo,anoExperiencia);
		numFuncionario=super.mostrarCodigoFuncionario();
		this.numCaixaQueTrabalha= numCaixaQueTrabalha;
		this.nomeDaFuncaoDoFuncionario="caixa";
		numCompras=0;
	}

	public void efetuarCompra(Cliente cliente){
		numCompras++;
		float totalDaCompra=0,pag=0;
		for (Produto jump : cliente.getCarrinho().getCarrinhoDeProdutos()) {
			System.out.print("Produto: "+ jump.getNome());
			System.out.print(" Quantidade: "+jump.getQuantidade());
			System.out.println(" Preco por unidade: "+jump.getPreco());
			totalDaCompra =jump.getQuantidade()*jump.getPreco() + totalDaCompra;
			
		}
		System.out.println("O valor da Compra é R$ "+ totalDaCompra +" reais");
		do{
		System.out.println("Aguardando o pagamento...");
		pag=Keyboard.readFloat();
		}while(pag<totalDaCompra);
		System.out.println("o troco do senhor eh de R$ "+ (pag-totalDaCompra)+" reais");
		System.out.println("volte sempre");
	}
	
	
	public String getNomeDaFuncaoDoFuncionario() {
		return nomeDaFuncaoDoFuncionario;
	}

	public int getNumFuncionario() {
		return numFuncionario;
	}

	public void setNumFuncionario(int numFuncionario) {
		this.numFuncionario = numFuncionario;
	}

	public int getNumCaixaQueTrabalha() {
		return numCaixaQueTrabalha;
	}

	public void setNumCaixaQueTrabalha(int numCaixaQueTrabalha) {
		this.numCaixaQueTrabalha = numCaixaQueTrabalha;
	}

	public void setNomeDaFuncaoDoFuncionario(String nomeDaFuncaoDoFuncionario) {
		this.nomeDaFuncaoDoFuncionario = nomeDaFuncaoDoFuncionario;
	}

	
	public int getNumCompras() {
		return numCompras;
	}

	public String infcaixa(){
		return "Nome: "+super.getNome()+" quantas compras esse funcionario ja registrou: "+numCompras+" sexo do funcionario: "+super.getsexo(); 
		
		
	}
	
	


}
