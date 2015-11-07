import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;

public class ImageMod
{

	BufferedImage image1;
	
	BufferedImage imageFin;
	
	File input;
	
	int w;
	int h;
	int pixels[][];
	
	
	//Builds a connection matrix out of the pixels.
	int conn[][];
	
	
	// Code in void did not execute..		
	ImageMod()throws IOException
	{
	
		//input=new File("c.png");
		input=new File("./SpinalCordImages/C7.jpg");
		
		image1=ImageIO.read(input);	
		imageFin=ImageIO.read(input);
		
		System.out.println(imageFin.getRGB(2,2));
		
		h=image1.getHeight();
		w=image1.getWidth();
		
		System.out.println("The height and width are "+h+" and "+w);
		
		/*
		if(input.exists())
		{
			System.out.println("The mercury file exists");
		}
		else
		{
			System.out.println("The mercury file does not exist");
		}
		*/
		
	}

	ImageMod(String s)throws IOException
	{
		input=new File(s);
		image1=ImageIO.read(input);	
		h=image1.getHeight();
		w=image1.getWidth();	
	}
	
	void regions()throws IOException
	{
		/*
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<h;j++)
			{				
			}
		}
		*/			
		//System.out.println("It is not a null thankfully");	
		
		
		pixels=new int[h][w];
		conn = new int[h][w];
		
		//FastRGB frgb=new FastRGB(image1);
		int i=1;
		int j=1;
		
	
		
		try
		{
			for(i=0;i<h;i++)
			{
				for(j=0;j<w;j++)
				{
					
					pixels[i][j]=image1.getRGB(j,i);
					//System.out.println(pixels[i][j]);
					if(pixels[i][j]==-1)
					{
						conn[i][j]=1;
					}
					else
					{
						conn[i][j]=0;
					}
					// By this stage we have a connectivity matrix that show the connected components.
					
				}
			}
			
			//Flooding just the outer white region..
			//flood(2,2,2);
			
			
			
			
			

			
			/*for(i=0;i<h;i++)
			{
				for(j=0;j<w;j++)
				{
					
					
					if(conn[i][j]==1)
					imagefin.setRGB(i,j,16777215);
					else
					imagefin.setRGB(i,j,0);
					
				}
			
			}
			

			File outputfile = new File("bim.jpg");
			ImageIO.write(imagefin, "jpg", outputfile);
			*/

		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Some issue with your thingy ");
		}
			
		//System.out.println(frgb.getRGB(4,4));
	}
	
	
	private void floodfill() throws IOException
	{
	
		
		
		int col=2;
		
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				if(conn[i][j]==1)
				flood(i,j,col++);
			}
		}
		

	}
	
	private void flood(int x,int y,int no_of_colour) throws IOException
	{		
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//String s=br.readLine();
	
		conn[x][y]=no_of_colour;
		
  		Deque<Integer> xq = new LinkedList<Integer>();
  		Deque<Integer> yq = new LinkedList<Integer>();
  		
  		xq.addFirst(x);
  		yq.addFirst(y);
  		
		while (  xq.peekFirst()!=null )
		{
		
			//s=br.readLine();
		
			//System.out.println(xq.size());
		
      			int x1 = xq.removeLast();
       			int y1 = yq.removeLast();
		
			if(x1+1<h)
			{
       				if(conn[x1+1][y1]==1)
            			{
            				//System.out.println((x1+1)+" "+y1);
            				xq.addFirst(x1+1);
            				yq.addFirst(y1);
            				conn[x1+1][y1]=no_of_colour;
            				//System.out.println("Here1");
            			}
            		}
            	
			if(x1-1>=0)
			{            	
       				if(conn[x1-1][y1]==1)
            			{
            				//System.out.println((x1-1)+" "+y1);
            				xq.addFirst(x1-1);
            				yq.addFirst(y1);
            				conn[x1-1][y1]=no_of_colour;
            				//System.out.println("Here2");
            			}
            		}
            		
            		if(y1+1<w)
            		{
            			
       				if(conn[x1][y1+1]==1)
            			{
            				//System.out.println(x1+" "+(y1+1));
            				xq.addFirst(x1);
            				yq.addFirst(y1+1);
            				conn[x1][y1+1]=no_of_colour;
            				//System.out.println("Here3");
            			}
            		}
            		
            		if(y1-1>=0)
            		{
       				if (conn[x1][y1-1]==1)
            			{
            				//System.out.println(x1+" "+(y1-1));
            				xq.addFirst(x1);
            				yq.addFirst(y1-1);
            				conn[x1][y1-1]=no_of_colour;
            				//System.out.println("Here4");
            			}
			}
		}
		//display();				
	}
	
	private void display()
	{
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				System.out.print(conn[i][j]);
			}
			System.out.println();
		}
	}
	
	private void colourRegions() throws IOException
	{
		for (int i = 0; i < h; i++)
    		{    			
    			
        		for (int j = 0; j < w; j++)
        		 {
        		 	int val=conn[i][j];
        		 	Color myWhite = new Color(val%230, val%230, val%230); // Color white
				int rgb = myWhite.getRGB();
            			imageFin.setRGB(j, i, rgb);
       			}
       		}
        	// retrieve image
		File outputfile = new File("saved.png");
    		ImageIO.write(imageFin, "png", outputfile);	
	}
	
	
	public static void main(String [] args) throws IOException
	{	
		ImageMod m=new ImageMod();		
		m.regions();
		m.floodfill();
		m.colourRegions();		
	}
	
}
	
	
	
	
