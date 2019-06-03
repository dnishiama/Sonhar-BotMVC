package hello;

public class Local {
	
	private int id;
	private String nome;
	private String instituicao;
	private String endereco;
	private String telefone;

	public Local(int id,String nome,String instituicao,String endereco,String telefone){
		this.id = id;
		this.nome = nome;
		this.instituicao = instituicao;
		this.endereco = endereco;
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
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//busca por id
	public boolean compararl(Local loc){
		if(id==loc.id && nome.equals(loc.nome) && endereco.equals(loc.endereco)){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean compararln(String nome){
		if(this.nome.equalsIgnoreCase(nome)){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean compararli(String instituicao){
		if(this.instituicao.equalsIgnoreCase(instituicao)){
			return true;
		} else {
			return false;
		}
	}

}
