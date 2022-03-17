public class Etudiant extends Personne {
    public int matricule;
    public double[] notes = new double[3];

    public Etudiant(String nom, String prenom, int age, int matricule, double[] notes) {
        super(nom, prenom, age);
        this.matricule = matricule;
        this.notes = notes;
    }
    public double calculMoyenne(double[] notes){
        double sum = 0;
        for (int i=0; i < notes.length; i++) sum += notes[i];
        return sum/3;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("| Matricule : " +matricule);
        for (int i=0; i < notes.length; i++) System.out.println("| La note de module "+(i+1)+" :"+notes[i]);
    }

    @Override
    public void afficherType() {
        System.out.println("| Type : Etudiant");
    }
}
