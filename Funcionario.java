
public class Funcionario extends Pessoa {

	 static private int numFuncionario=0; 
	 private String nomeDaFuncaoDoFuncionario;
	 private int anoExperiencia;
	 
	public Funcionario(String nome, String rg,String cpf, String nomeDaFuncaoDoFuncionario,String sexo,int anoExperiencia)
	{
		super(nome,rg,cpf,sexo);
		numFuncionario++;
		this.nomeDaFuncaoDoFuncionario= nomeDaFuncaoDoFuncionario;
		this.anoExperiencia=anoExperiencia;
	}
	
	public int mostrarCodigoFuncionario(){
		return numFuncionario;	
	}

	
	public String getNomeDaFuncaoDoFuncionario() {
		return nomeDaFuncaoDoFuncionario;
	}

	public void setNomeDaFuncaoDoFuncionario(String nomeDaFuncaoDoFuncionario) {
		this.nomeDaFuncaoDoFuncionario = nomeDaFuncaoDoFuncionario;
	}
	
	public void experienciaNoServico(){
		System.out.println("A experiencia do funcionario eh de "+ anoExperiencia);
		
	}

	public int getAnoExperiencia() {
		return anoExperiencia;
	}

	public void setAnoExperiencia(int anoExperiencia) {
		this.anoExperiencia = anoExperiencia;
	}

	public String nomeDoFuncionario(){
		return super.getNome();
	}
	
	public void qualsexo(){
	System.out.println(super.getsexo());	
	}
	}

