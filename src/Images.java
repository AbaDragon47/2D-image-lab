/*
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 *
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

import acm.graphics.*;

public class Images implements ImageConversions {

    public GImage flipHorizontal(GImage source) {
    	
    	int[][] pixelArray = source.getPixelArray();
    	int[][] newPixelArray = new int[pixelArray.length][pixelArray[0].length];
    	int r = 0, b = 0, g = 0;
    	
    	for (int row = 0; row < pixelArray.length; row++) {
    		for (int col = 0; col < pixelArray[row].length; col++) {
    			
    			r= GImage.getRed(pixelArray[row][col]);
		   		g= GImage.getGreen(pixelArray[row][col]);
		   		b= GImage.getBlue(pixelArray[row][col]);
    			
		   		newPixelArray[row][(pixelArray[row].length-1)-col] = GImage.createRGBPixel(r, g, b);
    		}
    	}
    	
    	source.setPixelArray(newPixelArray);
    	return source;
    	
    }

    public GImage rotateLeft(GImage source) {
        // TODO
	int[][] ori=source.getPixelArray();
    	
    	int[][] a= new int[ori[0].length][ori.length];
    	for(int x=0; x<a.length;x++) {
    		for(int y=0;y<a[x].length;y++) {
		   	// a[x][y]=ori[a[0].length-y-1][x];
    			a[a[0].length-y-1][x]=ori[x][y];
		   		 
    		}
    	}
    	source.setPixelArray(a);

        return source;
    }

    public GImage rotateRight(GImage source) {
    	
        int[][] pixelArray = source.getPixelArray();
        int[][] newPixelArray = new int[pixelArray[0].length][pixelArray.length];
        int colIndex = 0;
        int rowIndex = 0;
        int r = 0, b = 0, g = 0;
        
        for (int row = 0; row < pixelArray.length; row++) {
        	for (int col = 0; col < pixelArray[row].length; col++) {
        		r= GImage.getRed(pixelArray[row][col]);
		   		g= GImage.getGreen(pixelArray[row][col]);
		   		b= GImage.getBlue(pixelArray[row][col]);
		   		
		   		newPixelArray[rowIndex][(pixelArray.length-1)-colIndex] = GImage.createRGBPixel(r, g, b);
		   		
		   		rowIndex++;
        	}
        	rowIndex = 0;
        	colIndex++;
        }
        source.setPixelArray(newPixelArray);
    	return source;
    }

    public GImage greenScreen(GImage source) {
        // TODO
    	int r=0,b=0,g=0;
    	int trans=0;
    	int[][] a= source.getPixelArray();
    	for(int x=0; x<a.length;x++) {
    		for(int y=0;y<a[x].length;y++) {
    			 r= GImage.getRed(a[x][y]);
		   		 g= GImage.getGreen(a[x][y]);
		   		 b= GImage.getBlue(a[x][y]);
		   		 
    			if(g>r*2||g>b*2) {
    				trans=GImage.createRGBPixel(r, g, b, 0);
    				a[x][y]=trans;
    			}
    				
    			else if(b>r*2||b>g*2) {
    				trans=GImage.createRGBPixel(r, g, b, 0);
    				a[x][y]=trans;
    			}
    			else
    				a[x][y]=a[x][y];
    				
    			
    			
    		}
    	}
    	source.setPixelArray(a);
    	
        return source;
    }

    public GImage equalize(GImage source) {
        // TODO
        return null;
    }

    public GImage negative(GImage source) {
    	int r=0,b=0,g=0;
    	int pix=0;
    	int[][] a= source.getPixelArray();
    	for(int x=0; x<a.length;x++) {
    		for(int y=0;y<a[x].length;y++) {
    		 r= 255-GImage.getRed(a[x][y]);
    		 g= 255-GImage.getGreen(a[x][y]);
    		 b= 255-GImage.getBlue(a[x][y]);
    		 pix= GImage.createRGBPixel(r, g, b);
    		 a[x][y]=pix;
    		}
    	}
    	
    	source.setPixelArray(a);
    		

        return source;
    }

    public GImage translate(GImage source, int dx, int dy) {
    	int TX = 0;
    	int TY = 0;
    	int [][] pixelArray = source.getPixelArray();	
    	int[][] newPixelArray = source.getPixelArray();
    	
    	for (int row = 0; row < pixelArray.length; row++) {
         	for (int col = 0; col < pixelArray[row].length; col++) {
         		
         		if(dx>0) {
         			TX=(col+dx) >pixelArray.length-1? (col+dx)%pixelArray[0].length : dx+col;
         		}
         		else

         			TX=dx+col<0?pixelArray[0].length-(int)(Math.abs(col+dx)): col+dx;

         		if(dy>0) {
         			TY=(row+dy) >pixelArray.length-1? (row+dy)%pixelArray.length : dy+row;
         		}
         		else
         			TY=dy+row<0?pixelArray.length-(int)(Math.abs(row+dy)):dy+row;

         		newPixelArray[TY][TX]= pixelArray[row][col]; 
         	}
    	 }

    	 source.setPixelArray(newPixelArray);
    	 return source ;
    }

    public GImage blur(GImage source) {
    	
        int [][] pixelArray = source.getPixelArray();
        int[][] newPixelArray = new int[pixelArray.length][pixelArray[0].length];
        int [] indexPoints = {-1,0,1};
        int blurFactor = 9;
        int r = 0, b = 0, g = 0;
        
        for (int row = 0; row < pixelArray.length; row++) {
        	for (int col = 0; col < pixelArray[row].length; col++) {
        		
        		double rTotal = 0;
        		double gTotal = 0;
        		double bTotal = 0;
        		
        		for (int i = 0; i < indexPoints.length; i++) {
        			for (int j = 0; j < indexPoints.length; j++) {
        				if (((row+indexPoints[i] >= 0) && (col+indexPoints[j] >= 0)) && (((col+indexPoints[j]) < pixelArray[row].length) && (row+indexPoints[i] < pixelArray.length))) {
        					
        					r= GImage.getRed(pixelArray[row+indexPoints[i]][col+indexPoints[j]]);
        			   		g= GImage.getGreen(pixelArray[row+indexPoints[i]][col+indexPoints[j]]);
        			   		b= GImage.getBlue(pixelArray[row+indexPoints[i]][col+indexPoints[j]]);
        			   		
        			   		rTotal = rTotal + r;
        			   		gTotal = gTotal + g;
        			   		bTotal = bTotal + b;
        				}
        			}
        		}
        		
        		int rValue = (int) Math.floor(rTotal/blurFactor);
        		int gValue = (int) Math.floor(gTotal/blurFactor);
        		int bValue = (int) Math.floor(bTotal/blurFactor);
        		
        		newPixelArray[row][col] = GImage.createRGBPixel(rValue, gValue, bValue);
        		rTotal = 0;
        		gTotal = 0;
        		bTotal = 0;
        		
        	}
        }
        
        source.setPixelArray(newPixelArray);
    	return source;
    }
}
