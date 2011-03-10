import java.* ;
// import java MatR aussi!!!

class Acp {

    MatR donnee ; // matrice des données

    boolean reduit ; // si la matrice doit être réduite ou pas
    boolean centre ; // si la matrice doit être centree ou pas

    MatR correlation ; // matrice des corrélations 
    MatR valeurPropre ; // vecteur des valeurs propres

    MatR vecteurPropre ; // Matrice des vecteurs propres

    MatR ponderation ; // pondération des individus

    MatR composantes ;

    MatR variable;

    public Acp() {} 

    public Acp(MatR m,boolean b1,boolean b2,MatR pd) {
	donnee = m;
	reduit = b2;
	centre = b1;
	ponderation = pd;

	// centrage et réduction des données si spécifié
	if (centre)
	    donnee = donnee.centrerP(ponderation);
	if (reduit)
	    donnee = donnee.reduire();
	
	// calcul des corrélations 
	correlation = donnee.XtX().multCste( (double)1.0 / ( (double) donnee.n() ) );;

	// calcul des valeurs propres et vecteurs propres
	vecteurPropre = new MatR(donnee.n(),donnee.p(),0);
	valeurPropre = new MatR(donnee.p(),1,0);
	correlation.diag(vecteurPropre,valeurPropre);
	
	// 
	composantes = vecteurPropre.getProjectionOrth(correlation);
	variable = donnee.multMat( composantes.multMat( valeurPropre.vectToDiag().sqrt().inverse() ).transpose() );

    }

    public static void main (String [] args) throws Exception {
	MatR donnee=new MatR (args[0]);
	Acp acp=new Acp (donnee,true,true,new MatR(1,donnee.n(),1));
	System.out.print("\n");
	acp.correlation.afficheSimple(" Corrélation :");
	acp.valeurPropre.afficheSimple(" Valeurs Propres :");
	acp.vecteurPropre.afficheSimple(" Vecteurs Propres :");
    }	
}
