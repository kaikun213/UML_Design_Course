package model;

public class Authentification {
	
	private static final String username = "tester";
	private static final String password = "test";
	private boolean logged = false;
	
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
	public boolean authentificate(String username, String password){
		if (Authentification.username.equals(username) && Authentification.password.equals(password)){
			setLogged(true);
			return true;
		}
		else return false;
	}
	

}
