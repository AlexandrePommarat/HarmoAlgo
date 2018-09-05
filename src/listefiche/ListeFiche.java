package listefiche;


/**
 * Classe permettant de créer une liste de {@link FicheChaine} et de les manipuler
 * @author gael 
 *
 */
public class ListeFiche {
	
	/**
	 * La Première fiche
	 */
	private FicheChaine fiche;
	
	

	/**
	 * Constructeur de l'objet FicheChainee, il créé une nouvelle fiche chainee avec en paramètre la première fiche
	 * @param f la fiche qui deviendra la première fiche
	 */
	public ListeFiche(FicheChaine f){
		this.fiche = f;
	}
	
	public FicheChaine ajouterFiche(FicheChaine f){
		return f;
	}
	
	public void retirerFiche(){
		
	}
	
	public void trier(){
		
	}
	
	public FicheChaine get(int index){
		return null;
	}
	
	public int getSize(){
		return 0;
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	/**
	 * Méthode pour récupérer la dernière fiche
	 * @return
	 */
	public FicheChaine getDerniereFiche() {
		return null;
		
	}


	
}
