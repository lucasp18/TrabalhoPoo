
abstract class Pessoa {
	
	private String nome;
	private String rg;
	private String cpf;
	private String sexo;
	
	public Pessoa(String nome, String rg, String cpf,String sexo) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo=sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getsexo(){
		return sexo;
	}
	
	public abstract void qualsexo();

}
