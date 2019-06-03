package hello;

public class Crianca {
	
	private int id;
	private String nome;
	private int idade;
	private int local;
	private String endereco;

	public Crianca(int id, String nome, int idade, int local, String endereco){
		this.id=id;
		this.nome=nome;
		this.idade=idade;
		this.local = local;
		this.endereco = endereco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public boolean compararc(String nome){
		if(this.nome.equalsIgnoreCase(nome)){
			return true;
		} else {
			return false;
		}
	}
}
