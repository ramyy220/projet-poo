 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("| Entrez le nom : ");
        String nom = sc.nextLine();
        System.out.print("| Entrez le prenom : ");
        String prenom = sc.nextLine();
        System.out.print("| Entrez l'age : ");
        int age = sc.nextInt();
        System.out.print("| Entrez le matricule : ");
        int matricule = sc.nextInt();
        double[] notes = new double[3];
        System.out.print("| Entrez la note 1 : ");
        notes[0] = sc.nextDouble();
        System.out.print("| Entrez la note 2 : ");
        notes[1] = sc.nextDouble();
        System.out.print("| Entrez la note 3 : ");
        notes[2] = sc.nextDouble();

        Etudiant etudiant1 = new Etudiant(nom,prenom,age,matricule,notes);
        System.out.println("**************************************************************");
        etudiant1.afficher();
        System.out.println("| La moyenne est : "+etudiant1.calculMoyenne(notes));
        etudiant1.afficherType();


    }
}