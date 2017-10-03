/*
 * Author: Fintan Costello & Alex Cronin
 * Description: This program requests the user to enter a width and a height of a box and the box is then output
 * using '*' characters.
 */


import javax.swing.JOptionPane;             //import JOptionPane class

public class StarBox{                       //class declaration

    public static void main(String[] args){ //main method of the class

        String widthString;                 //declare String variable called 'widthString' to store the users input regarding the width of the box
        int width;                          //declare int variable called 'width' to store the width of the box
        String heightString;                //declare String variable called 'heightString' to store the users input regarding the height of the box
        int height;                         //declare int variable called 'height' to store the height of the box

        widthString = JOptionPane.showInputDialog(null,"Enter box width");  //request user input with an InputDialog box and store the value in 'widthString'
        width = Integer.parseInt(widthString);                              //parse the input String to an int and store it in the variable 'width'

        heightString = JOptionPane.showInputDialog(null,"Enter box height");//request user input with an InputDialog box and store the value in 'heightString'
        height = Integer.parseInt(heightString);                            //parse the input String to an int and store it in the variable 'height'

        // print out the first line of width-number stars (followed by a newline)
        for (int i = 0; i < width;i++) {
            System.out.print("*");
        }
        System.out.println();

        // print out the height-2 middle lines (with blank spaces inside them)
        for (int j = 0; j < height-2; j++){
            System.out.print("*");               // starting star of line
            for (int i = 0; i < width-2;i++) {   // print width-2 spaces inside line
                  System.out.print(" ");
            }
            System.out.println("*");             // ending star of line
        }

        // print out the last line of width-number stars (followed by a newline)
        for (int i = 0; i < width;i++) {
            System.out.print("*");
        }

    }
}   