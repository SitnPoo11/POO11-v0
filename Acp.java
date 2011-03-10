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
	reduit = b1;
	centre = b2;
	ponderation = pd;

	// centrage et réduction des données si spécifié
	if (centre)
	    donnee = donnee.centrerP(ponderation);
	if (reduit)
	    donnee = donnee.reduire();
	// calcul des valeurs propres et vecteurs propres

	correlation = donnee.XtX();
	vecteurPropre = new MatR(donnee.n(),donnee.p(),0);
	valeurPropre = new MatR(1,donnee.p(),0);

	propre(vecteurPropre,valeurPropre);

	//correlation = donnee.XtX();
	
	composantes = vecteurPropre.getProjectionOrth(correlation);

	MatR temp=valeurPropre.vectToDiag();
	MatR temp2=temp.sqrt().inverse();
	MatR comp2=composantes.multMat(temp2);
	 variable=donnee.transpose().multMat(comp2);


    }

    public void propre(MatR m1,MatR m2) {
	correlation.diag(m1,m2);
       
    }
    

    public static void main (String [] args) throws Exception {
	MatR donnee=new MatR (args[0]);
	Acp acp=new Acp (donnee,false,false,new MatR(1,donnee.n(),1));
	(acp.valeurPropre).afficheSimple("toto");
    }	
}
