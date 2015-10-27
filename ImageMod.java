import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.*;
import javax.imageio.ImageIO;
import java.io.*;


public class ImageMod
{

	BufferedImage image1;
	
	BufferedImage imagefin;
	
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
		input=new File("img.png");
		
		image1=ImageIO.read(input);	
		imagefin=ImageIO.read(input);
		
		System.out.println(imagefin.getRGB(2,2));
		
		h=image1.getHeight();
		w=image1.getWidth();
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
		
		FastRGB frgb=new FastRGB(image1);
		int i=1;
		int j=1;
		
	
		
		try
		{
			for(i=0;i<h;i++)
			{
				for(j=0;j<w;j++)
				{
					
					pixels[i][j]=frgb.getRGB(j,i);
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
			
			for(i=0;i<h;i++)
			{
				for(j=0;j<w;j++)
				{
					
					
					//System.out.print(imagefin.getRGB(j,i));
					System.out.print(conn[i][j]);
					
				}
				System.out.println();
			}
			
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
	
	public void floodfill()
	{
		int floodfillconn[h][j];
		for(i=0;i<h;i++)
		{
			for(j=0;j<w;j++)
			{
				
					
		
	}
	
	public static void main(String [] args) throws IOException
	{	
		
		ImageMod m=new ImageMod();		
		m.regions();			
	}
	
}
	
	
	
	
