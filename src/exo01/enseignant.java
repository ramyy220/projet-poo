package exo1;

public class Enseignant extends Personne {
    public long ssc;
    String[] modules ;

    public Enseignant(String nom, String prenom, int age, long ssc, String[] modules) {
        super(nom, prenom, age);
        this.ssc = ssc;
        this.modules = modules;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("| Numero de Securite Sociale  : " +ssc);
        for (int i=0; i < modules.length; i++) System.out.println("| Module "+(i+1)+" :"+modules[i]);
    }

    @Override
    public void afficherType() {
        System.out.println("| Type : Enseignant");
    }
}
