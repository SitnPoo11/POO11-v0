import java.* ;
// import java MatR aussi!!!

class Acp {
    MatR donnee ; // matrice des données

    boolean reduit ; // si la matrice doit être réduite ou pas
    boolean centre ; // si la matrice doit être centree ou pas

    MatR correlation ; // matrice des corrélations 
    MatR [] valeurPropre ; // vecteur des valeurs propres

    MatR vecteurPropre ; // Matrice des vecteurs propres

    double [] ponderation ; // pondération des individus

    public Acp() {} 

    public Acp(MatR m,boolean b1,boolean b2) {
	donnee = m;
	reduit = b1;
	centre = b2;

	// centrage et réduction des données si spécifié
	if (centre)
	    donnee = MatR.centrer();
	if (reduit)
	    donnee = MatR.reduire();
	// calcul des valeurs propres et vecteurs propres
	propre(vecteurPropre,valeurPropre);

	correlation = donnee.XtX();
	
    }

    public void correlation() {
	
    }

    public void propre() {
	MatR.diag(vecteurPropre,valeurPropre);
    }