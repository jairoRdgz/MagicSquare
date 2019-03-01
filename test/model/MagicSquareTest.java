package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MagicSquareTest {
	
	MagicSquare magic;
	
	void setupScennary1() {
		magic = new MagicSquare();
		magic.createSquare(3);
	}
	void setupScennary2() {
		magic = new MagicSquare();
		magic.createSquare(-3);
	}
	
	@Test
	void testNegativeArray() {
		setupScennary2();

		assertThrows(NegativeArraySizeException.class,()->{
			magic.createSquare(-3);
		});
	}
	
	@Test
	void testfills() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{0,0,0},{0,0,0},{0,0,0}};
		magic.fillSquare(2, 1, 3, matriz);
		for(int i = 0; i<prueba.length ; i++) {
			for(int j = 0; j<prueba[i].length; j++) {
				assertTrue(matriz[i][j]!=prueba[i][j]);
			}
		}
	}

	@Test
	void testUPNO() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{6,1,8},{7,5,3},{2,9,4}};
		magic.fillSquare(1,1,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	@Test
	void testUPNE() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{8,1,6},{3,5,7},{4,9,2}};
		magic.fillSquare(2,1,3,matriz);
		assertArrayEquals(matriz, prueba);
	}

	@Test
	void testRigthNE() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{2,7,6},{9,5,1},{4,3,8}};
		magic.fillSquare(2,4,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	@Test
	void testRigthSE() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{4,3,8},{9,5,1},{2,7,6}};
		magic.fillSquare(3,4,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	@Test
	void testDownSE() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{4,9,2},{3,5,7},{8,1,6}};
		magic.fillSquare(3,3,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	@Test
	void testDownNO() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{2,9,4},{7,5,3},{6,1,8}};
		magic.fillSquare(4,3,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	@Test
	void testLeftNO() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{8,3,4},{1,5,9},{6,7,2}};
		magic.fillSquare(4,2,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	@Test
	void testLeftSO() {
		setupScennary1();
		int [][] matriz = new int [3][3];
		int [][] prueba = {{6,7,2},{1,5,9},{8,3,4}};
		magic.fillSquare(1,2,3,matriz);
		assertArrayEquals(matriz, prueba);
	}
	
	
}
