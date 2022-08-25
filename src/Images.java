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
        // TODO
        return null;
    }

    public GImage rotateLeft(GImage source) {
        // TODO
        return null;
    }

    public GImage rotateRight(GImage source) {
        // TODO
        return null;
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
        // TODO
        return null;
    }

    public GImage blur(GImage source) {
        // TODO
        return null;
    }
}
