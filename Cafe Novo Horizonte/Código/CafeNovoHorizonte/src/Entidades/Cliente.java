package Entidades;

public class Cliente {
	private int id;
	private String NomeFantasia;
	
	public Cliente() { }
	
	public Cliente(int id, String NomeFantasia) {
		this.id = id;
		this.NomeFantasia = NomeFantasia;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return NomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}
}