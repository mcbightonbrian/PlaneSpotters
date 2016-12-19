/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planespotters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Brian McFadden
 */
public class Controller {
    
    Model model;
   
    StartView theStartView;
    ActionListener startActionListener;
    
    View theView;
    ActionListener actionListener;
    
    Answer theAnswerView;
    ActionListener answerListener;
    
    
    
    EndView theEndView;
        
    int count;
    int points;
    javax.swing.JLabel jLabel2;
    
    
    public Controller() {
            model = new Model();

            theStartView = new StartView();
            theStartView.setVisible(true);
            
            theView = new View();
            theAnswerView = new Answer();
            theEndView = new EndView();
            count = 0;
            points = 0;

            startButton();
            checkAnsButton();


    }
  
public void startButton() {
    
    startActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
                theView.setVisible(true);

                theStartView.setVisible(false);
                theStartView.dispose();

                Question question = model.allQuestions[count];
                int qNum = count + 1;

                theView.questionNum.setText("Question " + qNum);
                theView.questionText.setText(question.questionText);
                theView.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(question.picPath)));

                theView.jRadioButton1.setText(question.rB1);
                theView.jRadioButton2.setText(question.rB2);
                theView.jRadioButton3.setText(question.rB3);
                theView.jRadioButton4.setText(question.rB4);

                theView.pointsScore.setText(Integer.toString(count));
            }
    };   
           theStartView.jButton1.addActionListener(startActionListener);
}
       
        
public void checkAnsButton() {
 
        actionListener = new ActionListener() {
             public void actionPerformed(ActionEvent e) {

                    // checks which radio button has been selected
                    if (count <= model.allQuestions.length - 1) {

                            String ansGiven ="";
                            Boolean result;

                            if (theView.jRadioButton1.isSelected()) {
                                    ansGiven = "A";
                            }
                            else if (theView.jRadioButton2.isSelected()) {
                                        ansGiven = "B";
                            }
                            else if (theView.jRadioButton3.isSelected()) {
                                        ansGiven = "C";
                            }
                            else if (theView.jRadioButton4.isSelected()) {
                                      ansGiven = "D";
                            } 
        
                        // checks if the answer selected matches the correct answer in the question         
                         if (ansGiven.equals(model.allQuestions[count].answer)) {
                            points = points + 1;
                            result = true;
                        } else  { 
                                  result = false;
                                }
  
                        String ansText = ""; 
                        if (model.allQuestions[count].answer == "A"){
                             ansText = model.allQuestions[count].rB1;
                        } 
                        else if (model.allQuestions[count].answer == "B") {
                            ansText = model.allQuestions[count].rB2;
                        }
                        else if (model.allQuestions[count].answer == "C") {
                            ansText = model.allQuestions[count].rB3;
                        }
                        else if (model.allQuestions[count].answer == "D")
                        {
                            ansText = model.allQuestions[count].rB4;
                        }
                    
                         
                        theAnswerView = new Answer();
                        theAnswerView.setVisible(true);
                        theAnswerView.pointsScoreAns.setText(Integer.toString(points));
                        nextQuestionButton(); // adds the action listener to the Next Question button
                        theView.setVisible(false);
                        theView.dispose();

                        theAnswerView.questionNum.setText("Question " + (count));
                        theAnswerView.answPic.setIcon(new javax.swing.ImageIcon(getClass().getResource(model.allQuestions[count - 1].picPath)));

                        // displays the result in the text field of the wheter the answer given was correct
                        if (result == true) {
                            theAnswerView.questionText.setText("Correct! Its a " + ansText + "." );
                        }
                        else
                        {
                            theAnswerView.questionText.setText("False! Its a " + ansText + ".");
                        }
                    } // end if
             }
        };
  
    theView.checkAnswButton.addActionListener(actionListener);
} 
        
                
                
 

public void nextQuestionButton() {
      
    count = count + 1;
        if (count <= model.allQuestions.length - 1) {
                 answerListener = new ActionListener() {
                 public void actionPerformed(ActionEvent e) {

                        theAnswerView.setVisible(false);
                        theAnswerView.dispose();
                        theView = new View();
                        theView.setVisible(true);
                        checkAnsButton();
                        Question question = model.allQuestions[count];
                        int qNum = count + 1;
                        theView.questionNum.setText("Question " + (count + 1));
                        theView.questionText.setText(question.questionText);
                        theView.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(question.picPath)));
                        theView.jRadioButton1.setText(question.rB1);
                        theView.jRadioButton2.setText(question.rB2);
                        theView.jRadioButton3.setText(question.rB3);
                        theView.jRadioButton4.setText(question.rB4);
                        theView.pointsScore.setText(Integer.toString(points));
                 }  
                }; 
                theAnswerView.nextQuestionButton.addActionListener(answerListener);
        } else  {
                theAnswerView.nextQuestionButton.setText("End of game");
                theAnswerView.setVisible(true);
                answerListener = new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                    theAnswerView.setVisible(false);
                    theAnswerView.dispose();
                    theEndView.setVisible(true);
                    theEndView.jTextField1.setText("Your score was " + points + " out of " + model.allQuestions.length); 
                 }
                };
                theAnswerView.nextQuestionButton.addActionListener(answerListener);
              }   
} // end of method 
                     




} // end of class
                     
  