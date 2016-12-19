/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planespotters;

/**
 *
 * @author Brian McFadden
 */
public class Model {
    
   
    
    Question Q1 = new Question("What type of aeroplane is this?", "/pictures/a350.JPG", "Dash 8 Q400", "Airbus 350", "Embraer 195", "Antnov 225", "B");
    Question Q2 = new Question("What type of aeroplane is this?", "/pictures/q400.JPG", "DC-10", "Airbus 320", "Embraer 175", "Bombdier DASH Q400", "D");
    Question Q3 = new Question("What type of aeroplane is this?", "/pictures/e195.JPG", "Embraer 195", "Boeing 727", "Mig 29", "DC-10", "A");
    Question Q4 = new Question("What type of aeroplane is this?", "/pictures/an225.JPG", "Antnov AN225", "Piper Cherokee", "Spitfire", "Honda jet", "A");
    Question Q5 = new Question("What type of aeroplane is this?", "/pictures/b747.JPG", "Boeing 747", "Airbus 320", "Airbus 380", "Boeing 727", "A");
    
    
    public Question[] allQuestions;
    
    public Model() {
         allQuestions = new Question[5];
         allQuestions[0] = Q1;
         allQuestions[1] = Q2;
         allQuestions[2] = Q3;
         allQuestions[3] = Q4;
         allQuestions[4] = Q5;
    };
    
  
    
    
}
