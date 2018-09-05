package listefiche;


/**
 * Classe permettant de créer une liste de {@link FicheChaine} et de les manipuler, fiches indexées en commençant par 1.
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
	 * Méthode pour récupérer la dernière fiche
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
