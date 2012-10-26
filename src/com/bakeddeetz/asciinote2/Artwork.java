package com.bakeddeetz.asciinote2;

//Here's the code for a command line  program that converts an image file to ASCII art in java



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

public class Artwork {
	
	private static Bitmap image;
	private static FileWriter fw;
	private static PrintWriter out;

	public int convertImage(String sourceFile, String outputFile) {
		
		
		//image = BitmapFactory.decodeFile("trollface_resampled.png");
		
		
		getImage(sourceFile);
		getWriter(outputFile);
		
		System.out.println("Starting to generate text field now. File will be output to " + outputFile);

		//Getting the image's height and width gives us a range to work with for the 
		int width = image.getWidth();
		int height = image.getHeight();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Get the color for each pixel
				int colorInt = image.getPixel(j, i);
				int red = Color.red(colorInt);
				int green = Color.green(colorInt);
				int blue = Color.blue(colorInt);
				// Use the luminance formula in the project outline to get each
				// pixel's luminance, aka "brightness"
				double luminance = (0.3 * red + 0.59 * green + 0.11 * blue) / 255;

				// Set the default output to " " so everything that's not dark
				// enough to be considered just turns up as blank space
				String output = " ";

				// For the lighter pixels, represent them with an "^"
				if (luminance <= 0.75 && luminance > 0.5)
					output = "^";
				// Second lightest pixels get a "G" assigned to them
				if (luminance <= 0.5 && luminance > 0.25)
					output = "G";
				// Darkest pixels get assigned the darkest ASCII character, "@"
				if (luminance <= 0.25)
					output = "@";

				// Print the line of pixels now converted to ASCII characters
				print(output + " ");
			}
			// Print out a new line for the next line of pixels to be checked
			out.println();
		}
		// Close the PrintWriter
		out.close();

		System.out.println("Done!");
		return 0;
	}

	//Helper method for getting the image read in from the text file
	public static void getImage(String sourceFile) {
		
			image = BitmapFactory.decodeFile(sourceFile);
		
	}

	//Helper method for getting the writer set up for writing to a file
	//(filename specified in the command line)
	public static void getWriter(String outputFile) {
		try {
			fw = new FileWriter(outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out = new PrintWriter(fw);
	}

	//Helper method for printing the ASCII characters to the text file. I made
	//a helper method this way because it made it easier to test with
	public static void print(String string) {
		out.print(string);
	}

}