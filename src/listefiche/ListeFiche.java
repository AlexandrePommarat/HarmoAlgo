package listefiche;


/**
 * Classe permettant de creer une liste de {@link FicheChaine} et de les manipuler, fiches indexées en commençant par 1.
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
	
	/**
	 * Cette methode permet d'ajouter une fiche
	 * @param f
	 * @return
	 */
	public void ajouterFiche(FicheChaine f){
		FicheChaine derniereFiche = this.getDerniereFiche();
		derniereFiche.setFicheSuivante(f);
		
	}
	
	/**
	 * Méthode permettant de retirer une fiche de la liste
	 * @param index de la fiche à enlever
	 */
	public void retirerFiche(int index){
		//si la fiche n'existe pas, la méthode s'arrête
		if(index <= this.getSize()) {
			FicheChaine supr = this.get(index);
			FicheChaine avant = this.get(index-1);
			avant.setFicheSuivante(supr.getFicheSuivante());
			
			//Suppression de la fiche
			supr = null;
		}
	}
	
	/**
	 * Trie la liste en fonction du nom de famille
	 */
	public void trier(){
		
	}
	
	public FicheChaine get(int index){
		return null;
	}
	
	/**
	 * Méthode permettant de calculer la taille de la liste de fiches
	 * @return le nombre de fiches contenues
	 */
	public int getSize(){
		if(this.isEmpty()) {
			return 0;
		}
		
		int size = 1;
		
		//Tant que la fiche suivante n'est pas la dernière fiche
		while(!this.fiche.getFicheSuivante().estDerniereFiche()){
			size++;
		}
		
		
		return size;
	}
	
	public boolean isEmpty(){
		return this.fiche != null;
	}
	
	/**
	 * Methode pour recuperer la derniere fiche
	 * @return
	 */
	public FicheChaine getDerniereFiche() {
		if(this.isEmpty()) {
			return null;
		}
		
		FicheChaine f = this.fiche;
		
		//Tant que f n'est pas la dernière fiche
		while (!f.estDerniereFiche()) {
			f = f.getFicheSuivante();
		}
		
		return f;
	}


	
}
