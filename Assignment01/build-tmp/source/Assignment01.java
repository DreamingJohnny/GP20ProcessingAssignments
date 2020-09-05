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

public void setup(){

  
  background(0xff390155);
  
}public void draw(){ 

//Todo: Do first ugly hardcode in the draw function the letters.

stroke(0);
noFill();

//Letter J
line(100,50,150,50);
line(150,50,150,120);
arc(125, 120, 50, 50, 0, PI);

//Letter "O"
ellipse(180, 100, 50, 100);

//Letter "H"
line(220,50,220,150);
line(220,100,250,100);
line(250,50,250,150);

//Letter "A"
line(260,150,285,50);
line(285,50,310,150);
line(260,100,310,100);

//Letter "N"
line(320,150,320,50);
line(320,50,370,150);
line(370,150,370,50);  
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
