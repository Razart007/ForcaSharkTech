package entidades;

public class Cliente {
	
	private int id;
	private String nome;
	private boolean fisico;
	private int documento; //CPF ou CNPJ
	private String telefone;
	private String email;
	private Endereco endereco;
	private int inscricaoEstadual;
	private boolean isentoIcms;
	
	
	public Cliente() {
		this(-1, "", false, -1, "", "", new Endereco(), -1, false);
	}


	public Cliente(int id, String nome, boolean fisico, int documento, String telefone, String email, Endereco endereco,
			int inscricaoEstadual, boolean isentoIcms) {
		
		this.id = id;
		this.nome = nome;
		this.fisico = fisico;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.inscricaoEstadual = inscricaoEstadual;
		this.isentoIcms = isentoIcms;
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


	public boolean isFisico() {
		return fisico;
	}


	public void setFisico(boolean fisico) {
		this.fisico = fisico;
	}


	public Integer getDocumento() {
		return documento;
	}


	public void setDocumento(int documento) {
		this.documento = documento;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}


	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}


	public boolean isIsentoIcms() {
		return isentoIcms;
	}


	public void setIsentoIcms(boolean isentoIcms) {
		this.isentoIcms = isentoIcms;
	}
	
	@Override
	public String toString() {
		return "Documento: " + documento + ", Nome: " + nome + ", Endereco: " + endereco ;
	}
	
}