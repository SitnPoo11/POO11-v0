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

    MatR variable; // coordonnées par rapport aux axes principaux

    MatR contributionAxes ; // par rapport a tous les axes
    MatR contributionAxe ; // par rapport a un seul axe

    MatR cos2 ;
    public Acp() {} 
    
    public Acp(MatR m,boolean b1,boolean b2){
	MatR pd=new MatR(1,donnee.n(),1);
	this(m,b1,b2,pd);
    }

    public Acp(MatR m){
	MatR pd=new MatR(1,donnee.n(),1);
	this(m,true,true,pd);
    }
    

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
	
	// calcul des coordonnées par rapport aux axes principaux
//	vecteurPropre.afficheSimple("");
	composantes = donnee.multMat(vecteurPropre.normer());
	variable = donnee.tr().multMat( composantes.multMat( valeurPropre.vectToDiag().sqrt().inverse() ) ).divCste((double) donnee.n());

	// calcul des contributions 
	contributionAxes = new MatR (donnee.n() , donnee.p() , 0  );	
	contributionAxe = new MatR (donnee.n() , donnee.p() , 0  );	
	MatR cont = composantes.sqr().tr().multMat( ponderation.vectToDiag() ).tr();
	contributionAxe = cont.multMat( valeurPropre.vectToDiag().inverse() ).multCste(100.0/(double)donnee.n());
	contributionAxes = cont.sommeLignes().divCste( valeurPropre.somme() ).multCste(100.0/(double)donnee.n());

	cos2 = ( composantes.sqr().tr().multMat( composantes.sqr().sommeLignes().vectToDiag().inverse() ) ).tr();
    }

    public static void main (String [] args) throws Exception {
	MatR donnee=new MatR (args[0]);
	Acp acp=new Acp (donnee,true,true,new MatR(1,donnee.n(),1));
	System.out.print("\n");
	//acp.correlation.afficheSimple("");
	//acp.valeurPropre.afficheSimple(" Valeurs Propres :");
	//acp.vecteurPropre.afficheSimple(" Vecteurs Propres :");
	//acp.composantes.afficheSimple(" Composantes :");
	//acp.variable.afficheSimple(" Variables :");
	//acp.contributionAxe.afficheSimple(" Contribution par rapport un axe :");
	//acp.contributionAxes.afficheSimple(" Contribution par rapport à tous les axes :");
	//acp.cos2.afficheSimple(" cos2 :");
	//acp.cos2.sommeLignes().afficheSimple("");
    }	
}
