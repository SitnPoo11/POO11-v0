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

    // public void testTranspose(){
    // 	//    	MatR mat1 = new MatR(2,2,1);
    // 	//MatR mat2 = new MatR(2,2,1);

    // 	double[][] val1 = {{1,2,3},{2,1,3},{5,4,3}};
    // 	//MatR mat1 = new MatR(val1);
    // 	double[][] val2 = {{1,4,9},{4,1,9},{25,16,9}};
    // 	MatR mat2 = new MatR(val2);

    // 	Fonction f1 = new Fonction(val1);
    // 	Fonction f2 = new Fonction(val2);

    // 	double[] tab3 = f1.get(f1);
    // 	double[] tab4 = f2.get(f2);
	
    // 	assertArrayEquals(tab3,tab4,0.1);

    // 	//for (int i=1;i<=mat1.n();i++)
    // 	//for (int j=1;j<=mat1.p();j++)
    // 	//assertTrue(mat2.get(i,j) == mat1.transpose().get(j,i));
    // }

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

    // public void testMinimum(){
    // 	MatR mat3 = new MatR(3,3,1);
    // 	mat3.set(1,1,15);
    // 	mat3.set(1,3,2);
    // 	mat3.set(2,1,5);
    // 	mat3.set(3,3,20);
    // 	MatR mat4 = new MatR(1,3,1);

    // 	// double[][] tab3 = get(mat3);
    // 	// double[][] tab4 = get(mat4);
	
    // 	// assertEquals(tab3,tab4);

    // 	    //for (int i=1;i<=mat4.p();i++)
    // 	    //assertTrue(mat4.get(1,i)==mat3.minColonnes().get(1,i));
    // }

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

    // public void testCarre(){
    // 	double[][] val1 = {{1,2,3},{2,1,3},{5,4,3}};
    // 	MatR mat1 = new MatR(val1);
    // 	double[][] val2 = {{1,4,9},{4,1,9},{25,16,9}};
    // 	MatR mat2 = new MatR(val2);

    // 	// double[][] tab3 = get(mat1);
    // 	// double[][] tab4 = get(mat2);
	
    // 	// assertEquals(tab3,tab4);

    // 	//for (int i=1;i<=mat1.n();i++)
    // 	//  for (int j=1;j<=mat1.n();j++)
    // 	//	assertTrue(mat2.get(i,j) == mat1.carre().get(i,j));

    // }


}