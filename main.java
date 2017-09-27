import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		
		String nome,rg,cpf,cnpj,endereco;
		int op,ano;
		float inv;
		String sexo;
		Administrador admin;
		boolean AbrirMercado=false;
		System.out.println("Ola");
		System.out.println("Digite seu nome");
		nome=Keyboard.readString();
		System.out.println("Digite seu rg");
		rg=Keyboard.readString();
		System.out.println("Digite seu cpf");
		cpf=Keyboard.readString();
		System.out.println("Digite quantos anos tem de experiencia no serviço");
		ano=Keyboard.readInt();
		System.out.println("Digite o valor a ser investido no negocio");
		inv=Keyboard.readFloat();
		System.out.println("Digite qual eh o seu sexo");
		sexo=Keyboard.readString();
		admin = new Administrador(nome,rg,cpf,sexo,inv,ano);
		System.out.println("Parabens voce eh o novo adminstrador");
		System.out.println("Digite os dados abaixo para iniciar o seu negocio");
		System.out.println("Digite o nome do SuperMercado");
		nome=Keyboard.readString();
		System.out.println("Digite o endereco do SuperMercado");
		endereco=Keyboard.readString();
		System.out.println("Digite o cnpj do SuperMercado");
		cnpj=Keyboard.readString();
		admin.criarNegocio(nome, endereco, cnpj); 
		System.out.println("Parabens. Seu supermercado foi criado com sucesso");
	    admin.getsupermercado().getFuncionarios().add(admin);
		do{	
			System.out.println("Digite uma das opcoes do menu abaixo");		
			System.out.println("1- Para contratar funcionario");
			System.out.println("2- Para cadastrar Produtos");
			System.out.println("3- Para efetuar uma compra");
			System.out.println("4- Para mostrar todos os funcionarios");
			if(AbrirMercado==false){
				System.out.println("5- Para abrir o supermercado");
				
			}if(AbrirMercado==true)
				System.out.println("6- Atualizar as sessoes do supermercado");
			System.out.println("7- Para listar informações pessoais dos funcionarios");
			System.out.println("0- Para finalizar");
			op=Keyboard.readInt();
		switch(op){
		case 1:
			menuContratarFuncionario(admin);
			break;
		case 2:
			MenucadastrarProduto(admin);
			break;
		case 3:
			compras(admin);
			break;
		case 4:
			admin.getsupermercado().mostrarFuncionarios();
			break;
		case 5:
			if(AbrirMercado==false)
			if(admin.getsupermercado().AberturaDoMercado(AbrirMercado)==1)
			AbrirMercado=true;		
			break;
		case 6:
			if(AbrirMercado==true)
			arrumarSessao(admin);
			break;
		case 7:
			admin.getsupermercado().listandoInformaçõesParticularesDeCadaFuncionarios();
			break;
		}
	}while(op!=0);

	}
	
	static void compras(Administrador admin){
		Cliente cliente;
		cliente=admin.getsupermercado().criarCliente();
		admin.getsupermercado().realizarCompras(cliente);
		
	}
	
	static public int arrumarSessao(Administrador admin){
	char r;
		if(admin.getsupermercado().getEstoquistas().isEmpty()){
		System.out.println("Nao temos nenhum estoquista contratado");
		if(!admin.getsupermercado().getGerentes().isEmpty()){
		System.out.println("deseja ser atendido pelo Gerente?<S/N>");
		r=Keyboard.readChar();
		if(r=='S'){
			admin.getsupermercado().chamandoQuemVaiArrumarASessaoG();
		return 1; }
		}else
			System.out.println("Nao temos nenhum gerente contratado");
		return 0;
	}else
		admin.getsupermercado().chamandoQuemVaiArrumarASessao();
		return 1;
		
	}
	
	
	
	static public int menuContratarFuncionario(Administrador admin){
	
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
				admin.getsupermercado().contratarGerente();				
				break;
			case 2:
				admin.getsupermercado().contratarOperadorDeCaixa();
				break;
			case 3:
				admin.getsupermercado().contratarEstoquista();
				break;
			case 4:	
				return 4;
				
			}
		}while(op!=0);
		
		return 0;
	}
	

static public int MenucadastrarProduto(Administrador admin){
String nomeproduto;
int quantidade;
float precoProduto;
Produto  produto;
int op;

System.out.println("Digite uma das opções do menu abaixo");
System.out.println("1- Para cadastrar um produto com apenas uma unidade");
System.out.println("2- Para cadastrar um produto com mais de uma unidade");
op = Keyboard.readInt();
	if (op ==2) {
		admin.getsupermercado().cadastrarProduto(op);
	}
	else {
		admin.getsupermercado().cadastrarProduto(op);
	}	
	return 1;
} 



}
