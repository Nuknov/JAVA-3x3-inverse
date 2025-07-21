/*
Basic 3 * 3 Inverse Matrix Tool.
A normal programming project for displaying. 

Follow me:
https://github.com/Anonkryptiquz
https://github.com/Nuknov
https://x.com/AnonKryptiQuz
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

interface Ahmed {
    void Display();
}



class Naveed implements Ahmed {
    public void Display() {
        // JOptionPane.showMessageDialog(null, "Enter 9 Elements of Vector A:");
    }
}

class Parent {
    public void OVERRIDING(float k[][]) {
        StringBuilder sb = new StringBuilder("The Adjoint Of Matrix Is:\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(k[i][j]).append(" ");
            }
            sb.append("\n");
        }

String resultHtml = sb.toString().replace("\n", "<br>");
JLabel label = new JLabel(
    "<html><body style='color:green; font-size:14px;'><br><b>" + resultHtml + "</b></body></html>"
);

JOptionPane.showMessageDialog(null, label, "Adjoint Of Matrix", JOptionPane.INFORMATION_MESSAGE);

}

    public void Detere(float Deter[][]) {
        JLabel label = new JLabel("<html><body style='color:green; font-size:14px;'>Determinant: <b>" + Deter[2][2] + "</b></body></html>");
        JOptionPane.showMessageDialog(null, label, "Matrix Determinant", JOptionPane.INFORMATION_MESSAGE);

    }

    public void Detere() {
        // JLabel label = new JLabel("<html><body style='color:green; font-size:14px;'></b></body></html>");
        // JOptionPane.showMessageDialog(null, label, "", JOptionPane.INFORMATION_MESSAGE);
    }
}

class Khan extends Parent {
    public void OVERRIDING(float k[][]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(String.format("%.4f", k[j][i])).append(" ");
            }
            sb.append("\n");
        }

        // Convert to HTML view
        String htmlOutput = sb.toString().replace("\n", "<br>");

        JLabel label = new JLabel(
            "<html><body style='color:green; font-size:14px;'>The Transpose Of It:<br><pre>" +
            htmlOutput +
            "</pre></body></html>"
        );

        JOptionPane.showMessageDialog(null, label, "Transpose Matrix", JOptionPane.INFORMATION_MESSAGE);
    }
}

abstract class OOP {
    public abstract void DISPLAY();
}

class OOPINVERSE extends OOP {
    public void DISPLAY() {
        // JLabel label = new JLabel("<html><body style='color:green; font-size:14px;'></b></body></html>");
        // JOptionPane.showMessageDialog(null, label, "The Inverse Of Matrix Vector A :-", JOptionPane.INFORMATION_MESSAGE);
    }
}

public class GUIWrapper {
    private static JTextField[][] matrixFields = new JTextField[3][3];

    public static void main(String[] args) {
        // Naveed display = new Naveed();
        // display.Display();      
        JFrame frame = new JFrame("3x3 Matrix Inverse Calculator - by Nuknov");
        JButton clear = new JButton("Clear");
        clear.setBackground(new Color(30,30,30));
        clear.setForeground(new Color(0,255,128));
        clear.setFont(new Font("Courier New", Font.BOLD, 18));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new BorderLayout());

        JPanel matrixPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 matrixFields[i][j] = new JTextField(3);
                 matrixFields[i][j].setBackground(new Color(20, 20, 20));
                 matrixFields[i][j].setForeground(new Color(0, 255, 128));
                 matrixFields[i][j].setCaretColor(Color.WHITE);
                 matrixFields[i][j].setFont(new Font("Courier New", Font.BOLD, 18));
                 matrixFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                 matrixPanel.add(matrixFields[i][j]);
            }
        }

        JButton calcBtn = new JButton("Calculate Inverse");
        calcBtn.setBackground(new Color(30,30,30));
        calcBtn.setForeground(new Color(0,255,128));
        calcBtn.setFont(new Font("Courier New", Font.BOLD, 18));
        calcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    float[][] array = new float[3][3];
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            array[i][j] = Float.parseFloat(matrixFields[i][j].getText());
                        }
                    }

                    // All My Own Logic.
                    Naveed NFF = new Naveed();
                    NFF.Display();

                    float[][] Deter = new float[3][3];
                    Parent IM = new Parent();
                    IM.Detere();

                    Deter[0][0] = array[1][1] * array[2][2] - array[1][2] * array[2][1];
                    Deter[0][1] = array[1][0] * array[2][2] - array[1][2] * array[2][0];
                    Deter[0][2] = array[1][0] * array[2][1] - array[1][1] * array[2][0];
                    Deter[2][2] = array[0][0] * Deter[0][0] - array[0][1] * Deter[0][1] + array[0][2] * Deter[0][2];

                    IM.Detere(Deter);

                    float[][] temp = new float[3][3];
                    temp[0][0] = array[1][1] * array[2][2] - array[1][2] * array[2][1];
                    temp[0][1] = array[1][0] * array[2][2] - array[1][2] * array[2][0];
                    temp[0][2] = array[1][0] * array[2][1] - array[1][1] * array[2][0];

                    temp[1][0] = array[0][1] * array[2][2] - array[0][2] * array[2][1];
                    temp[1][1] = array[0][0] * array[2][2] - array[0][2] * array[2][0];
                    temp[1][2] = array[0][0] * array[2][1] - array[0][1] * array[2][0];

                    temp[2][0] = array[0][1] * array[1][2] - array[0][2] * array[1][1];
                    temp[2][1] = array[0][0] * array[1][2] - array[0][2] * array[1][0];
                    temp[2][2] = array[0][0] * array[1][1] - array[0][1] * array[1][0];

                    temp[0][1] = -temp[0][1];
                    temp[1][0] = -temp[1][0];
                    temp[1][2] = -temp[1][2];
                    temp[2][1] = -temp[2][1];

                    IM.OVERRIDING(temp);
                    new Khan().OVERRIDING(temp);

                    float[][] Result = new float[3][3];
                    Deter[2][2] = 1 / Deter[2][2];

                    OOPINVERSE ANN = new OOPINVERSE();
                    ANN.DISPLAY();


                    StringBuilder resultString = new StringBuilder();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            Result[i][j] = Deter[2][2] * temp[j][i];
                            resultString.append(toFraction(Result[i][j])).append("   ");

                        }
                        resultString.append("\n");
                    } 
JLabel label = new JLabel("<html><body style='color:green; font-size:14px;'>Inverse Matrix:<br><pre>" + resultString.toString().replace("\n", "<br>") + "</pre></body></html>");

    JOptionPane.showMessageDialog(null, label,"Inspired By Anonkryptiquz.A",JOptionPane.INFORMATION_MESSAGE );
    export(resultString.toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Invalid Input");
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrixFields[i][j].setText("");
                    }
                }
            }
        });

        JButton exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Courier New", Font.BOLD, 18));
        exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
        });


        frame.add(exit, BorderLayout.WEST);
        frame.add(matrixPanel, BorderLayout.CENTER);
        frame.add(calcBtn, BorderLayout.SOUTH);
        frame.add(clear, BorderLayout.NORTH);
        frame.setVisible(true);
    }



    // It can be faulty since I got this thing from GPT (AI), to just clean the code.    
    public static String toFraction(double value) {
    if (Math.abs(value) < 1e-10) return "0";

    int maxDenominator = 1000;
    int sign = (value < 0) ? -1 : 1;
    value = Math.abs(value);
    
    int numerator = 1;
    int denominator = 1;
    double bestError = Math.abs(value - (double) numerator / denominator);

    for (int d = 1; d <= maxDenominator; d++) {
        int n = (int) Math.round(value * d);
        double error = Math.abs(value - (double) n / d);
        if (error < bestError) {
            numerator = n;
            denominator = d;
            bestError = error;
        }
        if (bestError < 1e-6) break;
    }

    return (sign * numerator) + "/" + denominator;
}



// Exported .txt file.
public static void export(String filers) {
try {
FileWriter file = new FileWriter("sad.txt");
file.write(filers);
file.close();
JLabel label = new JLabel("<html><body style='color:green; font-size:14px;'>Results Saved Sucessfully named as sad.txt <b>" + "</b></body></html>");
JOptionPane.showMessageDialog(null, label,"Exportation", JOptionPane.INFORMATION_MESSAGE);
}
catch(IOException e) {
JOptionPane.showMessageDialog(null, "Results Failed To Export." + e.getMessage());
}
}




}


