package hello;

public class Voluntario {
	private int id;
	private String nome;
	private int rg;
	private int cpf;
	private String email;
	private int local;
	private String telefone;
	
	
	public Voluntario(int id, String nome, int rg, int cpf, String email, int local, String telefone){
		this.id = id;
		this.nome= nome;
		this.rg=rg;
		this.cpf=cpf;
		this.email=email;
		this.local = local;
		this.telefone = telefone;
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

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	
	//delegacao da comparacao de marca, modelo e cor do carro para a classe Especificacao, pois ela eh a dona dos atributos
	public boolean compararv(Voluntario vol){
		if(id==vol.id && nome.equals(vol.nome) && rg==vol.rg && cpf==vol.cpf && email.equals(vol.email)){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean compararvn(String nome){
		if(this.nome.equalsIgnoreCase(nome)){
			return true;
		} else {
			return false;
		}
	}

}
