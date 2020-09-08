String nameToPrint = "johan";
float topOfLetterY, bottomOfLetterY, widthOfLetterX, middleOfScreenOnX;

void setup(){

  size(768,432);
  background(#390155);
  stroke(0);
  strokeWeight(3);
  noFill();

  //To ensure positioning and dimensions of letters is relative to screensize
  topOfLetterY = height/3;
  widthOfLetterX = width/(nameToPrint.length()+4);

}void draw(){ 

//TODO: Look into animating letters, possible to have them drawn when mousepos changes?
//TODO: Look into curving letters as inspired by kalligraphy, means making shapes?

drawLetterJ(widthOfLetterX,topOfLetterY);

drawLetterO(widthOfLetterX,topOfLetterY);

drawLetterH(widthOfLetterX,topOfLetterY);

drawLetterA(widthOfLetterX,topOfLetterY);

drawLetterN(widthOfLetterX,topOfLetterY);
  
}
//Letter J
void drawLetterJ (float widthOfLetterX, float heightOfLetterY)
{
	line(widthOfLetterX*2, heightOfLetterY,widthOfLetterX*3, heightOfLetterY);
	line(widthOfLetterX*3,heightOfLetterY,widthOfLetterX*3,heightOfLetterY*1.75);
	arc(widthOfLetterX*2.5,heightOfLetterY*1.75, widthOfLetterX, widthOfLetterX, 0, PI);
}
//Letter "O"
void drawLetterO(float widthOfLetterX, float heightOfLetterY)
{
	ellipse(widthOfLetterX*3.5, heightOfLetterY*1.5,widthOfLetterX-(widthOfLetterX/10),heightOfLetterY);

}
//Letter H
void drawLetterH (float widthOfLetterX, float heightOfLetterY)
{
	line(widthOfLetterX*4,heightOfLetterY,widthOfLetterX*4,heightOfLetterY*2);
	line(widthOfLetterX*5,heightOfLetterY,widthOfLetterX*5,heightOfLetterY*2);
	line(widthOfLetterX*4,heightOfLetterY*1.5,widthOfLetterX*5,heightOfLetterY*1.5);
}
//Letter "A"
void drawLetterA (float widthOfLetterX, float heightOfLetterY)
{
	line(widthOfLetterX*5,heightOfLetterY*2,widthOfLetterX*5.5,heightOfLetterY);
	line(widthOfLetterX*5.5,heightOfLetterY,widthOfLetterX*6,heightOfLetterY*2);
	line(widthOfLetterX*5.2,heightOfLetterY*1.5,widthOfLetterX*5.8,heightOfLetterY*1.5);
}
//Letter "N"
void drawLetterN(float widthOfLetterX, float  heightOfLetterY)
{
	line(widthOfLetterX*6,heightOfLetterY*2,widthOfLetterX*6,heightOfLetterY);
	line(widthOfLetterX*6,heightOfLetterY,widthOfLetterX*7,heightOfLetterY*2);
	line(widthOfLetterX*7,heightOfLetterY*2,widthOfLetterX*7,heightOfLetterY);
}