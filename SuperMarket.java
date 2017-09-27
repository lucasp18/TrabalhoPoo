
public interface SuperMarket {

	public int AberturaDoMercado(boolean AbrirMercado);
	
	public void criarSessao();
	
	public void mostrarFuncionarios();
		
	public int contratarFuncionario();
	
	public int contratarOperadorDeCaixa();

	public int contratarEstoquista();

	public int contratarGerente();

	public int cadastrarProduto(int op);

	public void realizarCompras (Cliente cliente);
	
}










