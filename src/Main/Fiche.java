package Main;

public class Fiche {

	private String prenom;
	private String nom;
	private String adresse;
	private String tel;

	public Fiche(String prenom, String nom, String adresse, String tel) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setTel(tel);
	}

	public Fiche(String prenom, String nom) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.adresse = "";
		this.tel = "";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		if (prenom == null || prenom.equals("")) {
			throw new IllegalArgumentException();
		}
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (nom == null || nom.equals("")) {
			throw new IllegalArgumentException();
		}
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		if (adresse == null) {
			throw new IllegalArgumentException();
		}
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		if (tel == null) {
			throw new IllegalArgumentException("cela ne peut être null!");
		}
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Fiche [prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + "]";
	}
}
