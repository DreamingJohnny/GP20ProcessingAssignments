import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Assignment01 extends PApplet {

String nameToPrint = "johan";
float topOfLetterY, bottomOfLetterY, widthOfLetterX, middleOfScreenOnX;

public void setup(){

  
  background(0xff390155);
  stroke(0);
  strokeWeight(3);
  noFill();

  //To ensure positioning and dimensions of letters is relative to screensize
  topOfLetterY = height/3;

  //Divide this in to more parts... but that means I have to increase the amount of x in each x of course hm...
  widthOfLetterX = width/(nameToPrint.length()+4);

}public void draw(){ 

//Todo: Do first ugly code in the draw function the letters.
//TODO: Make sure your able to open with processing and nothing wrong there.
//TODO: Send up to repository @ Github, see if that works, send link, promise improvment.
//TODO: Pull branch, make changes.

//TODO: Set float var as positioning for letters proportional to dimensions of screen.
//TODO: Set function for each letter that you may send float position to.
//TODO: fix thickness of letters

//TODO: Set better looking size of lettering
//TODO: Look into animating letters, possible to have them drawn when mousepos changes?
//TODO: Look into curving letters as inspired by kalligraphy, means making shapes?



drawLetterJ(widthOfLetterX,topOfLetterY);

drawLetterO(widthOfLetterX,topOfLetterY);

drawLetterH(widthOfLetterX,topOfLetterY);

drawLetterA(widthOfLetterX,topOfLetterY);

drawLetterN(widthOfLetterX,topOfLetterY);
  
}
//Letter J
public void drawLetterJ (float widthOfLetterX, float heightOfLetterY)
{
	line(widthOfLetterX*2, heightOfLetterY,widthOfLetterX*3, heightOfLetterY);
	line(widthOfLetterX*3,heightOfLetterY,widthOfLetterX*3,heightOfLetterY*1.75f);
	arc(widthOfLetterX*2.5f,heightOfLetterY*1.75f, widthOfLetterX, widthOfLetterX, 0, PI);
}
//Letter "O"
public void drawLetterO(float widthOfLetterX, float heightOfLetterY)
{
	ellipse(widthOfLetterX*3.5f, heightOfLetterY*1.5f,widthOfLetterX-(widthOfLetterX/10),heightOfLetterY);

}
//Letter H
public void drawLetterH (float widthOfLetterX, float heightOfLetterY)
{
	line(widthOfLetterX*4,heightOfLetterY,widthOfLetterX*4,heightOfLetterY*2);
	line(widthOfLetterX*5,heightOfLetterY,widthOfLetterX*5,heightOfLetterY*2);
	line(widthOfLetterX*4,heightOfLetterY*1.5f,widthOfLetterX*5,heightOfLetterY*1.5f);
}
//Letter "A"
public void drawLetterA (float widthOfLetterX, float heightOfLetterY)
{
	line(widthOfLetterX*5,heightOfLetterY*2,widthOfLetterX*5.5f,heightOfLetterY);
	line(widthOfLetterX*5.5f,heightOfLetterY,widthOfLetterX*6,heightOfLetterY*2);
	line(widthOfLetterX*5.2f,heightOfLetterY*1.5f,widthOfLetterX*5.8f,heightOfLetterY*1.5f);
}
//Letter "N"
public void drawLetterN(float widthOfLetterX, float  heightOfLetterY)
{
	line(widthOfLetterX*6,heightOfLetterY*2,widthOfLetterX*6,heightOfLetterY);
	line(widthOfLetterX*6,heightOfLetterY,widthOfLetterX*7,heightOfLetterY*2);
	line(widthOfLetterX*7,heightOfLetterY*2,widthOfLetterX*7,heightOfLetterY);
}
  public void settings() {  size(768,432); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment01" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
