package entity;

public class User {
	private int id;
	private String name;
	private String email;
	private String senha;
	
	public User() {}
	
	public User(String name, String email, String senha) {
		super();
		this.id = (int) (Math.random() * 999) + 1;
		this.name = name;
		this.email = email;
		this.senha = senha;
	}
	
	public User(int id, String name, String email, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return  id + ";" + name + ";" + email + ";" + senha;
	}	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
