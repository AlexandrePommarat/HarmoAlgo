package listefiche;


/**
 * Classe permettant de creer une liste de {@link FicheChaine} et de les manipuler
 * @author gael 
 *
 */
public class ListeFiche {
	
	/**
	 * La Premiere fiche
	 */
	private FicheChaine fiche;
	
	

	/**
	 * Constructeur de l'objet FicheChainee, il cree une nouvelle fiche chainee avec en parametre la premiere fiche
	 * @param f la fiche qui deviendra la premiere fiche
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
	 * Methode pour recuperer la derniere fiche
	 * @return
	 */
	public FicheChaine getDerniereFiche() {
		return null;
		
	}


	
}
