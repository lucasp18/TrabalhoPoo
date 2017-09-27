import java.util.ArrayList;


public class SuperMercado implements SuperMarket {
String nome;
String endereco;
String cnpj;
private ArrayList<Caixa> caixas;
private ArrayList<Estoquista> estoquistas;
private ArrayList<Gerente> gerentes;
private ArrayList<Funcionario> funcionarios;
private Estoque estoque;
private ArrayList<Sessao> sessoes;
private ArrayList<Cliente> clientes;


public void chamandoQuemVaiArrumarASessao(){
	int u;
	for (int i = 0; i < estoquistas.size(); i++) 
		System.out.println("Indice: "+ i+" Nome: "+estoquistas.get(i).getNome());
	do{
		System.out.println("Digite o indice para que um estoquista se encarregue de repor a sessao");
		u=Keyboard.readInt();
	}while(u>estoquistas.size());
	estoquistas.get(u).arrumarSessao(sessoes, estoque);
}


public void chamandoQuemVaiArrumarASessaoG(){
	int u;
	for (int i = 0; i < gerentes.size(); i++) 
	System.out.println("Indice: "+ i+" Nome: "+gerentes.get(i).getNome());
	do{
		System.out.println("Digite o indice para que um gerente se encarregue de repor a sessao");
		u=Keyboard.readInt();
	}while(u>gerentes.size());
	gerentes.get(u).arrumarSessao(sessoes, estoque);
}




public ArrayList<Caixa> getCaixas() {
	return caixas;
}


public void setCaixas(ArrayList<Caixa> caixas) {
	this.caixas = caixas;
}


public ArrayList<Estoquista> getEstoquistas() {
	return estoquistas;
}


public void setEstoquistas(ArrayList<Estoquista> estoquistas) {
	this.estoquistas = estoquistas;
}


public ArrayList<Gerente> getGerentes() {
	return gerentes;
}


public void setGerentes(ArrayList<Gerente> gerentes) {
	this.gerentes = gerentes;
}


public ArrayList<Funcionario> getFuncionarios() {
	return funcionarios;
}


public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}


public ArrayList<Sessao> getSessoes() {
	return sessoes;
}


public void setSessoes(ArrayList<Sessao> sessoes) {
	this.sessoes = sessoes;
}


public SuperMercado(String nome, String endereco, String cnpj) {
	
	this.nome = nome;
	this.endereco = endereco;
	this.cnpj = cnpj;
	funcionarios = new ArrayList<Funcionario>();
	caixas = new ArrayList<Caixa>();
	estoquistas = new ArrayList<Estoquista>();
	sessoes= new ArrayList<Sessao>();
	estoque= new Estoque();
	clientes= new ArrayList<Cliente>();
	gerentes= new ArrayList<Gerente>();
}
	

public int AberturaDoMercado(boolean AbrirMercado){	
	int op,i;	
	char r;
	char r2;
	do{
		if(estoquistas.size()!=0){		
			for(i=0;i<estoquistas.size();i++)
				System.out.println("indice: "+i + " nome do estoquista: "+estoquistas.get(i).getNome());
			System.out.println("Selecione o indice do estoquista");
			op=Keyboard.readInt();
			criarSessao();
			//System.out.println("Abrir mercado1 "+ AbrirMercado);
			AbrirMercado=true;	
			//System.out.println("Abrir mercado2 "+ AbrirMercado);
		}
		else{
			System.out.println("Nao temos nenhum funcionario estoquista, favor contratar");
			if(getGerentes().isEmpty()){
				System.out.println("Infelizmente nao temos nenhum funcionario gerente para auxiliar");
			return 0;
			}else
				System.out.println("Deseja que nosso Gerente faca o atendimento?<S/N>");
				r2=Keyboard.readChar();
				if(r2=='S'){
					//System.out.println("Abrir mercado3 "+ AbrirMercado);
					AbrirMercado=true;
					//System.out.println("Abrir mercado4 "+ AbrirMercado);
					criarSessao();
					}
				}
				System.out.println("Deseja continuar arrumando a sessao para a abertura do mercado? <S/N> ");
				r=Keyboard.readChar();
		}while(r!='N');
	return 1;
}


public void criarSessao(){
Sessao sessao;
Produto prod=new Produto();
int p;
estoque.imprimirTodosProdutos();
	if(!estoque.getprodutos().isEmpty()){
		System.out.println("Digite o indice do produto que deseja disponibilizar na sessao");	
		p=Keyboard.readInt();
		prod.setNome(estoque.getprodutos().get(p).getNome());
		prod.setCodigodoProduto(estoque.getprodutos().get(p).getCodigodoProduto());
		prod.setPreco(estoque.getprodutos().get(p).getPreco());
		prod.setQuantidade(estoque.getprodutos().get(p).getQuantidade());
		if(!sessoes.isEmpty()){
			sessao = sessoes.get(sessoes.size()-1);
			if(sessao.getTamsessao()> 30){
				sessao= new Sessao();
				sessoes.add(sessao);
			}
		}else{
			sessao = new Sessao();
			sessoes.add(sessao);
		}
		if(sessao.getprodutosDaSessao().size() < 30){
			sessao.addprodutosDaSessaoAoEstoque(prod,estoque,p);	
		}else{
			sessao.addprodutosDaSessaoAoEstoque(prod,estoque,p);
			
		}
	}
}


public void listandoInformaçõesParticularesDeCadaFuncionarios(){
Gerente g;	
Caixa c;
Estoquista e;
Administrador a;
	for (Funcionario f : funcionarios) {
		if(f instanceof Gerente){
			g= (Gerente)f;
			System.out.println("As informações do Gerente sao: "+ g.qualificacaoGerente());
		}else
			if(f instanceof Caixa){
				c= (Caixa)f;
				System.out.println("As informações do Caixa sao: "+ c.infcaixa());
			}else
				if(f instanceof Estoquista){
					e= (Estoquista)f;
					System.out.println("As informações do Estoquista sao: "+ e.informacoesEstoquista());
				
				}else{
						a=(Administrador)f;
						System.out.println("As informações do Administrador sao: "+ a.dadosAdmininstrador());
				}
				}
}



public void mostrarFuncionarios(){
	for (Funcionario fun : funcionarios) {
		System.out.println("o nome do funcionario eh: "+ fun.getNome());
		System.out.println("a funcao do funcioario eh: "+ fun.getNomeDaFuncaoDoFuncionario());
		}	
	}

public int contratarFuncionario(){
	int op;	
	do{	
		System.out.println("Digite uma das opcoes do menu abaixo");		
		System.out.println("1- Para contratar Gerente");
		System.out.println("2- Para contratar Operadora de Caixa");
		System.out.println("3- Para contratar Estoquista");
		System.out.println("4- Para voltar ao menu principal");
		System.out.println("0- Para finalizar");
		op=Keyboard.readInt();
		switch(op){
		case 1:
			contratarGerente();				
			break;
		case 2:
			contratarOperadorDeCaixa();
			break;
		case 3:
			contratarEstoquista();
			break;
		case 4:	
			return 4;
			
		}
	}while(op!=0);
	
	return 0;
}





public int contratarOperadorDeCaixa(){
Caixa caixa;
String nome,rg,cpf,sexo;
int numcaixa;
int anoExperiencia;
System.out.println("Digite seu nome");
nome=Keyboard.readString();
System.out.println("Digite seu rg");
rg=Keyboard.readString();
System.out.println("Digite seu cpf");
cpf=Keyboard.readString();
System.out.println("Digite o numero do caixa que vai operar");
numcaixa=Keyboard.readInt();
System.out.println("Digite seu sexo");
sexo=Keyboard.readString();
System.out.println("Digite quantos anos voce tem de experiencia na funcao");
anoExperiencia=Keyboard.readInt();
caixa = new Caixa(nome,rg,cpf,numcaixa,sexo,anoExperiencia);
funcionarios.add(caixa);
caixas.add(caixa);
return 1;
}

public int contratarEstoquista(){
Estoquista estoquista;
Caixa caixa;
String nome,rg,cpf,sexo;
int numcaixa;
int anoExperiencia;
System.out.println("Digite seu nome");
nome=Keyboard.readString();
System.out.println("Digite seu rg");
rg=Keyboard.readString();
System.out.println("Digite seu cpf");
cpf=Keyboard.readString();
System.out.println("Digite quantos anos voce tem na funcao");
anoExperiencia=Keyboard.readInt();
System.out.println("Digite seu sexo");
sexo=Keyboard.readString();
estoquista = new Estoquista(nome, rg, cpf,sexo,anoExperiencia );
funcionarios.add(estoquista);
estoquistas.add(estoquista);
return 1;	
}


public int contratarGerente(){
Gerente  gerente;
String nome,rg,cpf,sexo,curso;
int anoExperiencia;
System.out.println("Digite seu nome");
nome=Keyboard.readString();
System.out.println("Digite seu rg");
rg=Keyboard.readString();
System.out.println("Digite seu cpf");
cpf=Keyboard.readString();
System.out.println("Digite seu sexo");
sexo=Keyboard.readString();
System.out.println ("Digite seu curso");
curso=Keyboard.readString();
System.out.println("Digite sua experiencia na funcao");
anoExperiencia=Keyboard.readInt();
gerente = new Gerente (nome,rg,cpf,"Gerente",sexo,curso,anoExperiencia);
gerentes.add(gerente);
funcionarios.add(gerente); 
return 1;	

}

public int cadastrarProduto(int op){
Produto  produto;
String nomeproduto;
int quantidade;
float precoProduto;	
System.out.println("Digite o Nome do Produto ");
nomeproduto= Keyboard.readString();
System.out.println("Digite o preco do produto");
precoProduto=Keyboard.readFloat();
if(op==2){
	System.out.println("Digite a quantidade");
	quantidade=Keyboard.readInt();
	produto= new Produto (nomeproduto, quantidade, precoProduto);
}else
	produto= new Produto (nomeproduto,precoProduto);
	estoque.addProdutosAoEstoque(produto);
	//System.out.println(estoque.getprodutos().get(0));
	return 1;

	
}


public Cliente criarCliente(){
	Cliente cliente;
	String c;
	String nome,rg,cpf,sexo;
	int i;
	char k;
	do{	
		System.out.println("Interrompeu as compras por algum motivo e quer recomecar?");
		System.out.println("Para isso basta digitar o nome do cliente que esteve fazendo a compra ou digite N para fazer uma nova compra");
		c=Keyboard.readString();
		if(c.equals("N")){
			System.out.println("digite o nome do cliente");
			nome=Keyboard.readString();
			System.out.println("digite o numero do rg do cliente");
			rg=Keyboard.readString();
			System.out.println("digte o numero do cpf do cliente");
			cpf=Keyboard.readString();
			System.out.println("digite o sexo do cliente");
			sexo=Keyboard.readString();
			cliente =new Cliente(nome,rg,sexo,cpf);
			clientes.add(cliente);
			return cliente;
		}else{
			for ( i = 0; i < clientes.size(); i++) {
				if(clientes.get(i).getNome().equals(c))
					break ;
			}		
		}
	}while(i >= clientes.size());
System.out.println("Os produtos que o cliente "+ clientes.get(i).getNome()+" tem no carrinho sao: ");
clientes.get(i).getCarrinho().listarProdutosNoCarrinho();
System.out.println("Deseja finalizar a compra <S> ou adicionar produtos ao carrinho <N>? <S/N>");
k=Keyboard.readChar();
if(k=='S'){
	passarNoCaixa(clientes.get(i));
	return null;
	}else
		return clientes.get(i);		
}


//**********************
public void realizarCompras (Cliente cliente){
String nomeProd;
int quantidade;
int i;
Produto prod1=null,prod2;
prod2 = new Produto();
char op;

if(!sessoes.isEmpty()){
do{
System.out.println("Temos os seguintes produtos: ");
	for(i=0; i< sessoes.size();i++)
		sessoes.get(i).imprimirTodoProdutos();
		do{
			System.out.println("Digite o Nome do Produto que deseja comprar ");
			nomeProd = Keyboard.readString();
			System.out.println("Digite a quantidade que deseja do produto ");
			quantidade= Keyboard.readInt();
			for(i=0; i< sessoes.size();i++)
				if(sessoes.get(i).pesquisarprodutosDaSessaoNoEstoque(nomeProd)!=null){
				prod1 = sessoes.get(i).pesquisarprodutosDaSessaoNoEstoque(nomeProd);
				if(prod1!=null){
				prod2.setCodigodoProduto(prod1.getCodigodoProduto());
				prod2.setNome(prod1.getNome());
				prod2.setPreco(prod1.getPreco());
				}break;
				}
		}while(prod1.getQuantidade() < quantidade || quantidade <= 0);
		
		prod2.setQuantidade(quantidade);
		prod1.setQuantidade(prod1.getQuantidade()-prod2.getQuantidade());
		cliente.getCarrinho().addProduto(prod2);

System.out.println("deseja colocar mais algum produto no carrinho de compras <S/N>?");
op=Keyboard.readChar();
}while(op!='N');
passarNoCaixa(cliente);
}else
	System.out.println("Não temos nenhum produto disponivel na sessao");
}


public void passarNoCaixa(Cliente cliente){
int caixa,i,z;
char r2;
	if(!caixas.isEmpty()){
		for (i = 0; i < caixas.size(); i++) {
			System.out.println("o caixa numero " + caixas.get(i).getNumCaixaQueTrabalha()+" esta live");
		}
		System.out.println("Digite o numero do caixa livre ");
		caixa = Keyboard.readInt();
		for (i=0; i < caixas.size(); i++) {
			if(caixas.get(i).getNumCaixaQueTrabalha()==caixa)
				break;
		}
		caixas.get(i).efetuarCompra(cliente);			
	}
	else
		System.out.println("Nao temos nenhum funcionario para a funcao de caixa");
		if(gerentes.isEmpty())
			System.out.println("Infelizmente não temos nenhum Gerente disponivel que possa ajudar");
		else{
			System.out.println("Deseja que o gerente faça o atendimento?<S/N>");
		r2= Keyboard.readChar();
		if(r2=='S')
			System.out.println("temos os seguintes gerentes disponiveis: ");
			for(i=0;i<gerentes.size();i++)
			System.out.println("indice: "+ i+ " nome: "+ gerentes.get(i).getNome());
				System.out.println("digite um dos indices dos gerentes disponiveis para efetuar o atendimento");	
				z=Keyboard.readInt();
				gerentes.get(z).efetuarCompra(cliente);

		}

	}
}


