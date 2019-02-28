package model;
/**
 * This class is in charge of creating a magic square
 * @author rdgz
 *
 */
public class MagicSquare {
	//----------------------------------------------------
	//ATRIBUTES
	//----------------------------------------------------
	private int[][] ms;
	
	//CONSTRUCTOR
	/**
	 * This method creates a magic square
	 */
	public MagicSquare() {
	}
	
	//METHODS
	/**
	 * This method evaluates if the order is an odd number 
	 * @param order the order of the magic square
	 * @return a boolean that represent if the order is odd or not
	 */
	public boolean isValid(int order) {
		boolean valid;
		if(order%2==0) {
			valid = false;
		}else {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * This method creates a empty square
	 * @param order the order for the square
	 * @return an empty square s
	 */
	public int[][] createSquare(int order) {
		ms = new int[order][order];
		return ms;
	}
	
	/**
	 * This method fills the magic square in any direction
	 * @param direction the direction for the filling 
	 * @param start the start point
	 * @param order the order of the square
	 * @param ms and empty square
	 */
	public void fillSquare(int direction, int start, int order, int[][] ms) {
		int llenar = 1; 
		int fila = 0;
		int column = 0;
		
	
		if(start==1) {
			//up
			//the user choose to start the filling of the square 
			 fila = 0;
			 column = (int)Math.floor(order/2);
			 if(direction==1) {
			 //NO
				 for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila-1)<0) {
						 if((fila-1)<0 && (column-1) <0) {
							 fila+=1;
						 }else {
							 fila = ms.length-1;
							 column-=1;
						 }
						 
					 }else if((column-1)< 0) {
						 fila -= 1;
						 column = ms.length-1;
						 if((fila-1)<0 && (column-1)<0) {
							 fila+=1;
						 }
					 }else if(ms[fila-1][column-1] == 0 ) {
						fila-=1;
						column-=1;
					 }else {
						 fila+=1;
					 }
				 }
			 }else if(direction ==2) {
				 //NE
		 		for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila-1)<0) {
						 if((fila-1)<0 && (column+1) == ms.length) {
							 fila+=1;
						 }else {
							 fila = ms.length-1;
							 column+=1;
						 }
					 }else if((column+1)==ms.length) {
						 if((fila-1)<0 && (column+1)==ms.length) {
							 fila+=1;
						 }else {
							 fila -= 1;
							 column = 0;
						 }
					 }else if(ms[fila-1][column+1] == 0 ) {
							fila-=1;
							column+=1;
					 }else {
						 fila+=1;
					 }
				 }
			}
		}else if(start==2) {
			//left
			fila =(int)Math.floor(order/2);
			column = 0;
			llenar =1;
			if(direction==1) {
				 //NO
				for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila-1)<0) {
						 if((fila-1)<0 && (column-1) <0) {
							 column+=1;
						 }else {
							 fila = ms.length-1;
							 column-=1;
						 }
						 
					 }else if((column-1)< 0) {
						 fila -= 1;
						 column = ms.length-1;
						 if((fila-1)<0 && (column-1)<0) {
							 column+=1;
						 }
					 }else if(ms[fila-1][column-1] == 0 ) {
						fila-=1;
						column-=1;
					 }else {
						 column+=1;
					 }
				 }
			}else if(direction == 4) {
				 //SO
				for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila+1)== ms.length) {
						 if((fila+1)==(ms.length) && (column-1) <0) {
							 column+=1;
						 }else {
							 fila = 0;
							 column-=1;
						 }
					 }else if((column-1)< 0) {
						 if((fila+1)==ms.length && (column-1)<0) {
							 column+=1;
						 }else {
							 fila += 1;
							 column = ms.length-1;
						 }
					 }else if(ms[fila+1][column-1] == 0 ) {
						fila+=1;
						column-=1;
					 }else {
						 column+=1;
					 }
				 }
			}	 
		}else if (start == 3) {
			//Down
			column =(order-1)/2;
			fila = ms.length-1;
			if(direction==3) {
				 //SE
				for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila+1)==ms.length) {
						 if((fila+1)==ms.length && (column+1)==ms.length) {
							 fila-=1;
						 }else {
							 fila = 0;
							 column+=1;
						 }
					 }else if((column+1)==ms.length) {
						 fila += 1;
						 column = 0;
						 if((fila+1)==ms.length && (column+1)==ms.length) {
							 fila-=1;
						 }
					 }else if(ms[fila+1][column+1] == 0 ) {
						fila+=1;
						column+=1;
					 }else {
						 fila-=1;
					 }
				 }
			}else if(direction ==4) {
				//SO
				for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila+1)==ms.length) {
						 if((fila+1)==ms.length && (column-1) <0) {
							 fila-=1;
						 }else {
							 fila = 0;
							 column-=1;
						 }
					 }else if((column-1)< 0) {
						 fila += 1;
						 column = ms.length-1;
						 if((fila+1)==ms.length && (column-1)<0) {
							 fila-=1;
						 }
					 }else if(ms[fila+1][column-1] == 0 ) {
						fila+=1;
						column-=1;
					 }else {
						 fila-=1;
					 }
				 }
			}
		}else if(start ==4) {
			//Right
			fila = (int)Math.floor(order/2);
			column = ms.length-1;
			
			if(direction==3) {
			//SE
				for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila+1) == ms.length) {
						 if((fila+1) == ms.length && (column+1) == ms.length) {
							 column-=1;
						 }else {
							 fila = 0;
							 column+=1;
						 }
					 }else if((column+1)==ms.length) {
						 if((fila+1)==ms.length && (column+1)==ms.length) {
							 column-=1;
						 }else {
						 fila += 1;
						 column = 0;
						 }
					 }else if(ms[fila+1][column+1] == 0 ) {
						fila+=1;
						column+=1;
					 }else {
						 column-=1;
					 }
				 }
			}else if(direction==2) {
				//NE
				for(int i = 0 ; i<ms.length*ms.length ; i++) {
					 ms[fila][column] = llenar++;
					 if((fila-1)<0) {
						 if((fila-1)<0 && (column+1) == ms.length) {
							 column-=1;
						 }else {
							 fila = ms.length-1;
							 column+=1;
						 }
					 }else if((column+1)==ms.length) {
						 if((fila-1)<0 && (column+1)==ms.length) {
							 column-=1;
						 }else {
							 fila -= 1;
							 column = 0;
						 }
					 }else if(ms[fila-1][column+1] == 0 ) {
							fila-=1;
							column+=1;
					 }else {
						 column-=1;
					 }
				 }
			}
		}
	}
	
}
