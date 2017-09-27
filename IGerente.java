import java.util.ArrayList;


public interface IGerente {

	public void efetuarCompra(Cliente cliente);
	public void arrumarSessao(ArrayList<Sessao> sessoes,Estoque estoque);

}
