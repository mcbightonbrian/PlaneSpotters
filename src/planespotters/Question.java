/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planespotters;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Brian McFadden
 */
public class Question  {

    String questionText;
    javax.swing.JLabel qPic;
    String picPath;
    String rB1;
    String rB2;
    String rB3;
    String rB4;

    String answer;
    
    public Question(String qText, String picpath, String rb1, String rb2, String rb3, String rb4, String ans) {
        
        questionText = qText;
        picPath = picpath;
        
        rB1 = rb1;
        rB2 = rb2;
        rB3 = rb3;
        rB4 = rb4;
        
        answer = ans;
    }
    
    public String getQuestion() {
        return questionText;
    }
    
    /*public Image getImage() {
    return qPic;
    }*/
    
    public String getRB1() {
        return rB1;
    }
    
    public String getRB2() {
       return rB2;
    }
    
    public String getRB3() {
        return rB3;
    }
    
    public String getRB4() {
        return rB4;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    
    
    
    
}
