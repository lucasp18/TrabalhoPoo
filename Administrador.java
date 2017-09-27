import java.util.ArrayList;


public class Administrador extends Funcionario implements IGerente {

	private String tipoDoNegocio;
	private SuperMercado supermercado;
	private float investimento;
	
	public Administrador(String nome,String rg,String cpf,String sexo,float investimento,int anoExperiencia ){
		super(nome,rg,cpf,"Administrador/Dono",sexo,anoExperiencia);
		tipoDoNegocio="supermercado";	
		this.investimento=investimento;
	}

	
	public void criarNegocio(String nome, String endereco,String cnpj){
		supermercado = new SuperMercado(nome,endereco,cnpj);
		
	}
	
	public SuperMercado getsupermercado(){
		
		return supermercado;
	}
	
	public void investimentimentoNoSupermercado(){
		System.out.println("O Administrador/dono esta investindo R$ "+ investimento+" reais na criação do supermercado");		
	}
	
	
	public void qualsexo(){
		System.out.println(super.getsexo());	
	}
	
	public String dadosAdmininstrador(){
		return "Seu nome eh: "+super.getNome()+" fez um investimentode: "+ investimento+" tipo do negocio: "+"supermercado";
		
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
		
		float totalDaCompra=0;
		for (Produto jump : cliente.getCarrinho().getCarrinhoDeProdutos()) {
			totalDaCompra =jump.getQuantidade()*jump.getPreco() + totalDaCompra;
			
		}
		System.out.println("O valor da Compra é R$ "+ totalDaCompra +" reais");
	
	}




}
