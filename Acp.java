import java.* ;
// import java MatR aussi!!!

class Acp {

    MatR donnee ; // matrice des données

    boolean reduit ; // si la matrice doit être réduite ou pas
    boolean centre ; // si la matrice doit être centree ou pas

    MatR correlation ; // matrice des corrélations 
    MatR [] valeurPropre ; // vecteur des valeurs propres

    MatR vecteurPropre ; // Matrice des vecteurs propres

    MatR ponderation ; // pondération des individus

    MatR composantes ;

    public Acp() {} 

    public Acp(MatR m,boolean b1,boolean b2,MatR pd) {
	donnee = m;
	reduit = b1;
	centre = b2;
	ponderation = pd;

	// centrage et réduction des données si spécifié
	if (centre)
	    donnee = donnee.centrer(ponderation);
	if (reduit)
	    donnee = donne.reduire();
	// calcul des valeurs propres et vecteurs propres
	propre(vecteurPropre,valeurPropre);

	correlation = donnee.XtX();
	
	composantes = donnee.getProjectionOrth(correlation);
	


    }

    public void correlation() {
	
    }

    public void propre() {
	MatR.diag(vecteurPropre,valeurPropre);
    }