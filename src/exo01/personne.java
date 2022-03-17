package exo01;

public class personne {
	public String nom;
    public String prenom;
    public int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void afficher(){
        System.out.println("| Nom : " +nom);
        System.out.println("| Prenom : " +prenom);
        System.out.println("| Age : " +age);
    }
    public abstract void afficherType();
}

