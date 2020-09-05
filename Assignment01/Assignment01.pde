void setup(){

  size(768,432);
  background(#390155);
  
}void draw(){ 

//Todo: Do first ugly code in the draw function the letters.
//TODO: Make sure your able to open with processing and nothing wrong there.
//TODO: Send up to repository @ Github, see if that works, send link, promise improvment.
//TODO: Pull branch, make changes.
//TODO: Set float var as positioning for letters proportional to dimensions of screen.
//TODO: Set function for each letter that you may send float position to.
//TODO: Set better looking size of lettering
//TODO: Look into animating letters, possible to have them drawn when mousepos changes?
//TODO: Look into curving letters as inspired by kalligraphy, means making shapes?

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
