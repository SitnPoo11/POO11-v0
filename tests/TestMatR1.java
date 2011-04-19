/** Avant de compiler ce fichier, taper dans le terminal :
    export CLASSPATH=..:.;
**/

/** 
 *  Cette classe de tests n'utilise pas jUnit.
 *  Elle n'est là que pour voir comment fonctionnent certaines
 *  fonctions de MatR, afin d'en donner une idée.
 **/

public class TestMatR1{

    public static void main (String [] args){
 
    	double[][] tab = {{1,2,3},{4,5,6},{7,8,9}};  // génération d'un MatR à partir d'un tableau de double
    	MatR mat1 = new MatR(tab);
    	mat1.afficheSimple("mat1");  // Affichage d'un MatR
    	MatR mat2 = mat1.tr();  //Transposition
    	double[][] tab2 = mat2.MatRToDouble();  //Passage de MatR à tableau de double
    	MatR mat3 = new MatR(tab2);
    	MatR mat4 = mat3.extraireBloc(2,mat3.n(),2,mat3.p());  // Extraction d'un bloc
    	mat3.afficheSimple("tr de mat1 avant extraction");
    	mat4.afficheSimple("tr de mat1 après extraction");

	double[][] tab3 = {{1,2,3},{4,5,6}};
	MatR mat5 = new MatR(tab3);
	mat5.afficheSimple("mat5");
	double[][] tab4 = mat5.tr().MatRToDouble();
	MatR mat6 = new MatR(tab4);
	mat6.supprimeLigne(1);
	mat6.supprimeColonne(1);
	mat6.afficheSimple("transpose");

	/**
	 * En ce qui concerne la transposition, si on utilise la fonction transpose,
	 * la seule chose qui se passe est que le booléen disant si la matrice est transposée ou non
	 * change, pas la matrice.
	 * La fonction tr crée elle une copie de la transposée. Le seul problème est que le nom
	 * des lignes est le nom des colonnes de la non transposée, et inversement.
	 * Pour changer celà, soit renommer les lignes et les colonnes, soit transformer 
	 * cette matrice en tableau, le retransformer en matrice puis supprimer la première
	 * ligne et le première colonne (mauvais indiçage du tableau).
	 **/

	MatR mat7 = new MatR(3,3,1);
	mat7.set(1,1,15);  // On met le coefficient ligne 1 colonne 1 à 15
	mat7.set(1,3,-1);
	mat7.set(2,1,5);
	mat7.set(3,3,20);
	mat7.afficheSimple("mat7");
	MatR mat9 = mat7.maxColonnes();  // Vecteur ligne contenant le maximum de toutes les colonnes
	mat9.afficheSimple("mat9");
	MatR mat8 = new MatR(1,3,1);
	mat8.set(1,1,15);
	mat8.set(1,3,20);
	mat8.afficheSimple("mat8");
	System.out.println(mat7.max());  // maximum de la matrice
	/**
	 * La fonction maxColonne retourne un MatR à 1 ligne et autant de colonnes
	 * que la matrice à laquelle il est appliqué contenant pour chaque colonne 
	 * son maximum.
	 * La fonction max retourne le maximum de la matrice.
	 **/

	System.out.println("Nom de mat9 : "+mat9.getName()+",  Nom de mat8 : "+mat8.getName());  // Vérification des noms
	System.out.println("Nbr lignes de mat9 : "+mat9.n()+",  Nbr lignes de mat8 : "+mat8.n());  // Vérification du nombre de lignes
	System.out.println("Nbr colonnes de mat9 : "+mat9.p()+",  Nbr colonnes de mat8 : "+mat8.p());  // Vérification du nombre de colonnes
	System.out.println("mat9 transposée ? : "+mat9.getTrans()+",  mat8 transposée ? : "+mat8.getTrans());  // Vérification de l'attribut tranposition
	System.out.println("noms lignes de mat9 : "+mat9.getNoml()+",  noms lignes de mat8 : "+mat8.getNoml());  // Vérification du nom des lignes
	System.out.println("noms colonnes de mat9 : "+mat9.getNomc()+",  noms colonnes de mat8 : "+mat8.getNomc());  // Vérification du nom des colonnes
	System.out.println("longueur des éléments de mat9 : "+mat9.lg()+",  longueur des éléments de mat8 : "+mat8.lg());  // Vérification de la longueur des éléments
	System.out.println("nombre de décimales de mat9 : "+mat9.dec()+",  nombre de décimales de mat8 : "+mat8.dec());  // Vérification du nombre de décimales des éléments
	System.out.println("notation exponentielle ? de mat9 : "+mat9.exp()+",  notation exponentielle ? de mat8 : "+mat8.exp());  // Les éléments sont-ils écrits en notation exponentielle ?
	System.out.println("espaces entre 2 valeurs de mat9 : "+mat9.sp()+",  espaces entre 2 valeurs de mat8 : "+mat8.sp());  // Vérification de l'espace entre 2 valeurs
	/** 
	 * Un MatR est un objet compliqué, muni de nombreux attributs. On peut presque tous les obtenir, 
	 * et bien évidemment on peut tous les modifier.
	 **/


	/** Vérification de quelques fonctions de MatR.
	 **/
	mat7.minColonnes().afficheSimple("Min colonnes de mat7");  // Vecteur ligne contenant pour chaque colonne de la matrice son minimum
	MatR mat10 = new MatR(1,3,1);
	mat10.set(1,3,-1);
	mat10.afficheSimple("mat10");
	System.out.println(mat9.min());  // Minimum de la matrice

	System.out.println("Elément [1,2] de mat7 : "+mat7.get(1,2));  // Affichage de l'élément en ligne 1 colonne 2 de mat7
	System.out.println("Elément [1,3] de mat7 : "+mat7.get(1,3));
	System.out.println("Elément [3,3] de mat7 : "+mat7.get(3,3));

	MatR mat11 = mat10.vectToDiag();
	mat11.afficheSimple("On transforme le vecteur des minima en une matrice diagonale");

	MatR mat12 = new MatR(4,4,0);
	mat12.initmemAlea(4,4);
	mat12.afficheSimple("Matrice aléatoire");

	mat7.addMat(mat7).afficheSimple("Somme de mat7 avec lui-même");
	mat7.afficheSimple("Nouvelle valeur de mat7");
	mat7.multCste(2).afficheSimple("2 x mat7");
	mat7.afficheSimple("Nouvelle valeur de mat7");
	mat7.divCste(2).afficheSimple("mat7 / 2");
	mat7.afficheSimple("Nouvelle valeur de mat7");

	mat7.normeColonnes().afficheSimple("Norme de chaque colonnes");
	double[][] tab5 = {{30*30+10*10+2*2,2*2+2*2+2*2,2*2+2*2+40*40}};
	MatR mat13 = new MatR(tab5);
	mat13.racineCarree();
	mat13.afficheSimple("Vérification");

	MatR mat14 = mat7.moyenneColonnes();
	mat14.afficheSimple("Moyenne de chaque colonnes");
	double[][] tab6 = {{(mat7.get(1,1)+mat7.get(2,1)+mat7.get(3,1))/3,(mat7.get(1,2)+mat7.get(2,2)+mat7.get(3,2))/3,(mat7.get(1,3)+mat7.get(2,3)+mat7.get(3,3))/3}};
	MatR mat15 = new MatR(tab6);
	mat15.afficheSimple("Vérification");

	mat7.varianceColonnes().afficheSimple("Variance des colonnes");
	double[][] tab7 = {{((mat7.get(1,1)-mat14.get(1,1))*(mat7.get(1,1)-mat14.get(1,1))+(mat7.get(2,1)-mat14.get(1,1))*(mat7.get(2,1)-mat14.get(1,1))+(mat7.get(3,1)-mat14.get(1,1))*(mat7.get(3,1)-mat14.get(1,1)))/3,((mat7.get(1,2)-mat14.get(1,2))*(mat7.get(1,2)-mat14.get(1,2))+(mat7.get(2,2)-mat14.get(1,2))*(mat7.get(2,2)-mat14.get(1,2))+(mat7.get(3,2)-mat14.get(1,2))*(mat7.get(3,2)-mat14.get(1,2)))/3,((mat7.get(1,3)-mat14.get(1,3))*(mat7.get(1,3)-mat14.get(1,3))+(mat7.get(2,3)-mat14.get(1,3))*(mat7.get(2,3)-mat14.get(1,3))+(mat7.get(3,3)-mat14.get(1,3))*(mat7.get(3,3)-mat14.get(1,3)))/3}};
	MatR mat16 = new MatR(tab7);
	mat16.afficheSimple("Vérification");

	double[][] tab8 = {{mat7.get(1,1)-mat14.get(1,1),mat7.get(1,2)-mat14.get(1,2),mat7.get(1,3)-mat14.get(1,3)},{mat7.get(2,1)-mat14.get(1,1),mat7.get(2,2)-mat14.get(1,2),mat7.get(2,3)-mat14.get(1,3)},{mat7.get(3,1)-mat14.get(1,1),mat7.get(3,2)-mat14.get(1,2),mat7.get(3,3)-mat14.get(1,3)}};
	MatR mat18 = new MatR(tab8);
	mat7.centrer().afficheSimple("Matrice centrée en colonnes");  // La fonction centrer() modifie la matrice !
	mat18.afficheSimple("Vérification");

	double[][] tab9 = {{mat7.get(1,1)+mat14.get(1,1),mat7.get(1,2)+mat14.get(1,2),mat7.get(1,3)+mat14.get(1,3)},{mat7.get(2,1)+mat14.get(1,1),mat7.get(2,2)+mat14.get(1,2),mat7.get(2,3)+mat14.get(1,3)},{mat7.get(3,1)+mat14.get(1,1),mat7.get(3,2)+mat14.get(1,2),mat7.get(3,3)+mat14.get(1,3)}};
	MatR mat19 = new MatR(tab9);
	mat19.afficheSimple("Vérification");

	mat16.racineCarree();  // On passe de la variance à l'écart-type
	double[][] tab10 = {{mat19.get(1,1)/mat16.get(1,1),mat19.get(1,2)/mat16.get(1,2),mat19.get(1,3)/mat16.get(1,3)},{mat19.get(2,1)/mat16.get(1,1),mat19.get(2,2)/mat16.get(1,2),mat19.get(2,3)/mat16.get(1,3)},{mat19.get(3,1)/mat16.get(1,1),mat19.get(3,2)/mat16.get(1,2),mat19.get(3,3)/mat16.get(1,3)}};
	MatR mat20 = new MatR(tab10);
	mat19.reduire().afficheSimple("Matrice réduite en colonnes");  // La fonction reduire() modifie la matrice !
	mat20.afficheSimple("Vérification");

	MatR mat21 = new MatR(3,3,1);
	mat21.set(1,1,15);  
	mat21.set(1,3,-1);
	mat21.set(2,1,5);
	mat21.set(3,3,20);
	mat21.afficheSimple("mat21");
	double[][] tab11 = {{251,21,10},{21,3,20},{10,20,402}};   // Matrice calculée à part
	MatR mat22 = new MatR(tab11);
	mat21.XtX().afficheSimple("Produit de la matrice transposée par elle-même");
	mat22.afficheSimple("Vérification");

	double[][] tab12 = {{5,2,9,-6},{2,5,-6,9},{9,-6,5,2},{-6,9,2,5}};  
    	MatR mat23 = new MatR(tab12);
	MatR q = new MatR();
	MatR lbd = new MatR();
	mat23.diag(q,lbd);
	mat23.afficheSimple("Matrice");
	q.afficheSimple("Vecteurs propres");
	lbd.afficheSimple("Valeurs propres");
	double[][] tab13 = {{18},{10},{4},{-12}};   
	MatR mat24 = new MatR(tab13);
	double[][] tab14 = {{0.5,0.5,-0.5,0.5},{-0.5,0.5,-0.5,-0.5},{0.5,0.5,0.5,-0.5},{-0.5,0.5,0.5,0.5}};
	MatR mat25 = new MatR(tab14);
        // Matrices calculées à part
	mat24.afficheSimple("Vérification des valeurs propres");
	mat25.afficheSimple("Vérification des vecteurs propres");
    }

}