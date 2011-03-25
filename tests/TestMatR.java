import junit.framework.*;
  
import java.util.Random ;
import java.util.Vector ;
import java.util.StringTokenizer ;
import java.io.*;

import static org.junit.Assert.*;


public class TestMatR extends TestCase{

    public TestMatR(String name){
	super(name);
    }


    public void testTranspose(){
	double[][] f1 = {{1,2,3},{4,5,6},{7,8,9}};  // génération d'un MatR à partir d'un tableau de double
    	MatR mat1 = new MatR(f1);
    	MatR mat2 = mat1.tr();  //Transposition
    	double[][] f2 = mat2.MatRToDouble();  //Passage de MatR à tableau de double
    	MatR mat3 = new MatR(f2);
    	MatR mat4 = mat3.extraireBloc(2,mat3.n(),2,mat3.p());  // Extraction d'un bloc

	double[][] f3 = {{1,4,7},{2,5,8},{3,6,9}};
    	Fonction f4 = new Fonction(f3);

 	double[] tab1 = Fonction.get(mat4);
 	double[] tab2 = Fonction.get(f4);
	assertArrayEquals(tab1,tab2,0.1);
    }


    public void testMaximum(){
	double[][] val1 = {{15,1,2},{5,1,1},{1,1,20}};
    	MatR f1 = new MatR(val1);
	MatR f1bis = f1.maxColonnes();

	double[][] val2 = {{15},{1},{20}};
    	Fonction f2 = new Fonction(val2);


 	double[] tab1 = Fonction.get(f1bis);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testMinimum(){
	MatR mat1 = new MatR(3,3,1);
	mat1.set(1,1,15);  
	mat1.set(1,3,-1);
	mat1.set(2,1,5);
	mat1.set(3,3,20);
	MatR mat1bis = mat1.minColonnes();

	double[][] val2 = {{1},{1},{-1}};
    	Fonction f2 = new Fonction(val2);

 	double[] tab1 = Fonction.get(mat1bis);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

 

    // public void testMatrice(){
    // 	MatR mat1 = new MatR(2,2,1);
    // 	MatR mat2 = new MatR(2,2,1);
    // 	assertTrue(mat1.n() == mat2.n());
    // 	assertTrue(mat1.p() == mat2.p());
	
    // 	// double[][] tab3 = get(mat1);
    // 	// double[][] tab4 = get(mat2);
	
    // 	// assertEquals(tab3,tab4);

    // 	//for (int i=1;i<=mat1.n();i++)
    // 	//for (int j=1;j<=mat1.n();j++)
    // 	//	assertTrue(mat1.get(i,j) == mat2.get(i,j));
    // }

    public void testTableau(){
    	double[] tab1 = {1,2,3};
    	double[] tab2 = {1,2,3};
	//    	assertEquals(tab1,tab2);
	assertArrayEquals(tab1,tab2,0.1);

    }

    public void testVectToDiag(){
	MatR mat1 = new MatR(1,3,1);
	mat1.set(1,3,-1);
	MatR mat11 = mat1.vectToDiag();

	double[][] val2 = {{1,0,0},{0,1,0},{0,0,-1}};
    	Fonction f2 = new Fonction(val2);

 	double[] tab1 = Fonction.get(mat11);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testSomme(){
	double[][] f1 = {{1,2,3},{4,5,6},{7,8,9}};  
    	MatR mat1 = new MatR(f1);
	double[][] f2 = {{-1,3,5},{0,5,4.5},{3,-8,-11}}; 
    	MatR mat2 = new MatR(f2);
	mat1.addMat(mat2);

	double[][] f3 = {{0,5,8},{4,10,10.5},{10,0,-2}};
   	Fonction f4 = new Fonction(f3);

 	double[] tab1 = Fonction.get(mat1);
 	double[] tab2 = Fonction.get(f4);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testProduitCste(){
	double[][] f1 = {{1,2,3},{4,5,6}};  
    	MatR mat1 = new MatR(f1);
	mat1.multCste(2.5);

	double[][] f3 = {{2.5,5,7.5},{10,12.5,15}};
   	Fonction f4 = new Fonction(f3);

 	double[] tab1 = Fonction.get(mat1);
 	double[] tab2 = Fonction.get(f4);
	assertArrayEquals(tab1,tab2,0.1);
    }

   public void testDivisionCste(){
	double[][] f3 = {{2.5,5,7.5},{10,12.5,15}};
    	MatR mat1 = new MatR(f3);
	mat1.divCste(2.5);

	double[][] f1 = {{1,2,3},{4,5,6}};  
   	Fonction f4 = new Fonction(f1);

 	double[] tab1 = Fonction.get(mat1);
 	double[] tab2 = Fonction.get(f4);
	assertArrayEquals(tab1,tab2,0.1);
    }


    public void testCarre(){
    	double[][] val1 = {{1,2,3},{-2,1,-3},{5,4,3}};
    	MatR mat1 = new MatR(val1);
	mat1.carre();

    	double[][] val2 = {{1,4,9},{4,1,9},{25,16,9}};
   	Fonction f2 = new Fonction(val2);

 	double[] tab1 = Fonction.get(mat1);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }


    public void testRacineCarree(){
	double[][] val1 = {{1,4,9},{4,1,9},{25,16,9}};
    	MatR mat1 = new MatR(val1);
	mat1.racineCarree();

    	double[][] val2 = {{1,2,3},{2,1,3},{5,4,3}};
   	Fonction f2 = new Fonction(val2);

 	double[] tab1 = Fonction.get(mat1);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testNormeColonne(){
	double[][] f1 = {{2,5,-7},{10,12,15}};
    	MatR mat1 = new MatR(f1);
	MatR mat1bis = mat1.normeColonnes();

	double[][] val2 = {{2*2+10*10,5*5+12*12,7*7+15*15}};
	MatR mat2 = new MatR(val2);
	mat2.racineCarree();
	double[][] val2bis = mat2.MatRToDouble();
	double[][] val2ter = {{val2bis[1][1],val2bis[1][2],val2bis[1][3]}};
   	Fonction f2 = new Fonction(val2ter);

 	double[] tab1 = Fonction.get(mat1bis);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testMoyenneColonne(){
	double[][] f1 = {{2,5,-7},{10,12,15}};
    	MatR mat1 = new MatR(f1);
	MatR mat1bis = mat1.moyenneColonnes();

	double[][] val2 = {{(mat1.get(1,1)+mat1.get(2,1))/2,(mat1.get(1,2)+mat1.get(2,2))/2,(mat1.get(1,3)+mat1.get(2,3))/2}};
   	Fonction f2 = new Fonction(val2);

 	double[] tab1 = Fonction.get(mat1bis);
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testVarianceColonne(){
	double[][] val1 = {{1,4,9},{4,1,9},{25,16,9}};
    	MatR mat7 = new MatR(val1);
	MatR mat14 = mat7.moyenneColonnes();

	double[][] val2 = {{((mat7.get(1,1)-mat14.get(1,1))*(mat7.get(1,1)-mat14.get(1,1))+(mat7.get(2,1)-mat14.get(1,1))*(mat7.get(2,1)-mat14.get(1,1))+(mat7.get(3,1)-mat14.get(1,1))*(mat7.get(3,1)-mat14.get(1,1)))/3,((mat7.get(1,2)-mat14.get(1,2))*(mat7.get(1,2)-mat14.get(1,2))+(mat7.get(2,2)-mat14.get(1,2))*(mat7.get(2,2)-mat14.get(1,2))+(mat7.get(3,2)-mat14.get(1,2))*(mat7.get(3,2)-mat14.get(1,2)))/3,((mat7.get(1,3)-mat14.get(1,3))*(mat7.get(1,3)-mat14.get(1,3))+(mat7.get(2,3)-mat14.get(1,3))*(mat7.get(2,3)-mat14.get(1,3))+(mat7.get(3,3)-mat14.get(1,3))*(mat7.get(3,3)-mat14.get(1,3)))/3}};
	Fonction f2 = new Fonction(val2);

 	double[] tab1 = Fonction.get(mat7.varianceColonnes());
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);

    }

    public void testCentrer(){
	double[][] val1 = {{1,4,9},{4,1,9},{25,16,9}};
    	MatR mat7 = new MatR(val1);
	MatR mat14 = mat7.moyenneColonnes();

	double[][] val2 = {{mat7.get(1,1)-mat14.get(1,1),mat7.get(1,2)-mat14.get(1,2),mat7.get(1,3)-mat14.get(1,3)},{mat7.get(2,1)-mat14.get(1,1),mat7.get(2,2)-mat14.get(1,2),mat7.get(2,3)-mat14.get(1,3)},{mat7.get(3,1)-mat14.get(1,1),mat7.get(3,2)-mat14.get(1,2),mat7.get(3,3)-mat14.get(1,3)}};
	Fonction f2 = new Fonction(val2);

	double[] tab1 = Fonction.get(mat7.centrer());
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);

    }

    public void testReduire(){
	double[][] val1 = {{1,4,9},{4,1,9},{25,16,9}};
    	MatR mat19 = new MatR(val1);
	MatR mat16 = mat19.varianceColonnes();
	mat16.racineCarree();

	double[][] tab10 = {{mat19.get(1,1)/mat16.get(1,1),mat19.get(1,2)/mat16.get(1,2),mat19.get(1,3)/mat16.get(1,3)},{mat19.get(2,1)/mat16.get(1,1),mat19.get(2,2)/mat16.get(1,2),mat19.get(2,3)/mat16.get(1,3)},{mat19.get(3,1)/mat16.get(1,1),mat19.get(3,2)/mat16.get(1,2),mat19.get(3,3)/mat16.get(1,3)}};
	Fonction f2 = new Fonction(tab10);

	double[] tab1 = Fonction.get(mat19.reduire());
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }

    public void testProduitTranspose(){
	MatR mat21 = new MatR(3,3,1);
	mat21.set(1,1,15);  
	mat21.set(1,3,-1);
	mat21.set(2,1,5);
	mat21.set(3,3,20);
	double[][] tab11 = {{251,21,10},{21,3,20},{10,20,402}};

	Fonction f2 = new Fonction(tab11);

	double[] tab1 = Fonction.get(mat21.XtX());
 	double[] tab2 = Fonction.get(f2);
	assertArrayEquals(tab1,tab2,0.1);
    }


    public void testDiag(){
	double[][] tab12 = {{5,2,9,-6},{2,5,-6,9},{9,-6,5,2},{-6,9,2,5}};  
    	MatR mat23 = new MatR(tab12);
	MatR q = new MatR();
	MatR lbd = new MatR();
	mat23.diag(q,lbd);
	mat23.afficheSimple("Matrice");
	q.afficheSimple("Vecteurs propres");
	lbd.afficheSimple("Valeurs propres");

	double[][] tab13 = {{18},{10},{4},{-12}};   
	Fonction f2 = new Fonction(tab13);

	double[][] tab14 = {{0.5,0.5,-0.5,0.5},{-0.5,0.5,-0.5,-0.5},{0.5,0.5,0.5,-0.5},{-0.5,0.5,0.5,0.5}};   
	Fonction f3 = new Fonction(tab14);


	double[] tab1 = Fonction.get(lbd);
 	double[] tab2 = Fonction.get(f2);
 	double[] tab3 = Fonction.get(f3);
 	double[] tab4 = Fonction.get(q);
	assertArrayEquals(tab1,tab2,0.1);
	assertArrayEquals(tab4,tab3,0.1);

    }

}