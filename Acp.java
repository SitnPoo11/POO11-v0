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
	// calcul des valeurs propres et vecteurs propres
	//System.out.println("nbr de lignes :"+donnee.n());
	correlation = donnee.XtX();
	//System.out.println(1.0/( (double) donnee.n() ) );
	double d = 1.0/( (double) donnee.n() ) ;
	//System.out.println(d);
	correlation = correlation.multCste(d);
	vecteurPropre = new MatR(donnee.n(),donnee.p(),0);
	valeurPropre = new MatR(donnee.p(),7,0);

	propre(vecteurPropre,valeurPropre);
	
	//valeurPropre.afficheSimple("");

	//correlation = donnee.XtX();
	
	composantes = vecteurPropre.getProjectionOrth(correlation);
	//composantes.afficheSimple("");

	MatR temp=valeurPropre.vectToDiag();
	//temp.afficheSimple("");

	MatR temp2=temp.sqrt().inverse();
	//temp2.afficheSimple("");

	MatR comp2=(composantes).multMat(temp2);
	//comp2.afficheSimple("");
	variable=donnee.multMat(comp2.transpose());


    }

    public void propre(MatR m1,MatR m2) {
	correlation.diag(m1,m2);
       
    }
    

    public static void main (String [] args) throws Exception {
	MatR donnee=new MatR (args[0]);
	//donnee.afficheSimple("");
	Acp acp=new Acp (donnee,true,true,new MatR(1,donnee.n(),1));
	(acp.valeurPropre).afficheSimple("toto");
    }	
}
