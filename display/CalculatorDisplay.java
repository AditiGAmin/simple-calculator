package display;

import javax.swing.*;
import java.awt.event.*;
import operations.*;
import exceptions.*;

public class CalculatorDisplay extends JFrame{

    public JTextField display;
    public boolean errorDisplayed = false;     // Error Flag

    public void clearAll(){
        display.setText("");
        errorDisplayed = false;
    }

    public void addDigitButton(JButton button, String digit){
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (errorDisplayed){
                    clearAll();
                }
                display.setText(display.getText()+digit);
            }
        });
    }

    public void addOperatorButton(JButton button, String operator,JButton[] operatorButtons){
            button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (errorDisplayed){
                    return;
                }
                if (display.getText().isEmpty()){
                    return;
                }
                if (errorDisplayed){
                    clearAll();
                }
                display.setText(display.getText()+operator);
                for(JButton b : operatorButtons){
                    b.setEnabled(false);
                }
            }
        });
        }

    public void configureDelete(JButton button, JButton[] operatorButtons){
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String input = display.getText();
                if (input != null && input.length()>0){
                    char lastChar = input.charAt(input.length()-1);
                    display.setText(input.substring(0, input.length()-1));

                    // if last char was an operator, re-enable them
                    if ("+-*/".indexOf(lastChar)>= 0){
                        for (JButton op : operatorButtons){
                            op.setEnabled(true);
                        }
                    }
                }
            }
        });
    }

    public void configureClear(JButton button, JButton[] operatorButtons){
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                clearAll();
                for(JButton op : operatorButtons){
                    op.setEnabled(true);
                }
            }
        });
    }

    public void configureDecimal(JButton button){
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String input = display.getText();
                if(errorDisplayed){
                    clearAll();
                    input = "";
                }
                int lastOpIndex = Math.max(Math.max(input.lastIndexOf("+"),input.lastIndexOf("-")),
                                           Math.max(input.lastIndexOf("*"),input.lastIndexOf("/"))
                                           );
                String currentSegment = input.substring(lastOpIndex + 1);

                if (!currentSegment.contains(".")){
                    display.setText(input+".");
                }
            }
        });
    }

    
    public CalculatorDisplay(){
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        display = new JTextField();
        display.setEditable(false);
        display.setBounds(20,20,350,100);
        frame.add(display);

        

        JButton btn0 = new JButton("0");
        btn0.setBounds(25,490,150,60);
        frame.add(btn0);

        addDigitButton(btn0, "0");


        JButton btn1 = new JButton("1");
        btn1.setBounds(25,400,60,60);
        frame.add(btn1);

        addDigitButton(btn1, "1");


        JButton btn2 = new JButton("2");
        btn2.setBounds(115,400,60,60);
        frame.add(btn2);

        addDigitButton(btn2, "2");

        JButton btn3 = new JButton("3");
        btn3.setBounds(205,400,60,60);
        frame.add(btn3);
        
        addDigitButton(btn3, "3");


        JButton btn4 = new JButton("4");
        btn4.setBounds(25,300,60,60);
        frame.add(btn4);

        addDigitButton(btn4, "4");

        
        JButton btn5 = new JButton("5");
        btn5.setBounds(115,300,60,60);
        frame.add(btn5);

        addDigitButton(btn5, "5");

        
        JButton btn6 = new JButton("6");
        btn6.setBounds(205,300,60,60);
        frame.add(btn6);
        
        addDigitButton(btn6, "6");


        JButton btn7 = new JButton("7");
        btn7.setBounds(25,210,60,60);
        frame.add(btn7);

        addDigitButton(btn7, "7");

        
        JButton btn8 = new JButton("8");
        btn8.setBounds(115,210,60,60);
        frame.add(btn8);

        addDigitButton(btn8, "8");


        JButton btn9 = new JButton("9");
        btn9.setBounds(205,210,60,60);
        frame.add(btn9);
        
        addDigitButton(btn9, "9");


        JButton btndot = new JButton(".");
        btndot.setBounds(205,490,60,60);
        frame.add(btndot);

        configureDecimal(btndot);


        JButton btnadd = new JButton("+");
        btnadd.setBounds(300,490,60,60);
        frame.add(btnadd);
        
        JButton btnsub = new JButton("-");
        btnsub.setBounds(300,400,60,60);
        frame.add(btnsub);
        
        JButton btnmul = new JButton("*");
        btnmul.setBounds(300,300,60,60);
        frame.add(btnmul);
        
        JButton btndiv = new JButton("/");
        btndiv.setBounds(300,210,60,60);
        frame.add(btndiv);


        JButton[] operatorButtons = {btnadd, btnsub, btnmul, btndiv};

        addOperatorButton(btnadd, "+", operatorButtons);
        addOperatorButton(btnsub, "-", operatorButtons);
        addOperatorButton(btnmul, "*", operatorButtons);
        addOperatorButton(btndiv, "/", operatorButtons);
 
        JButton btneq = new JButton("=");
        btneq.setBounds(275,150,90,50);
        frame.add(btneq);

        btneq.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                try{
                    String input = display.getText();

                    StringtoOpr sop = new StringtoOpr();
                    OperationData data = sop.convert(input);

                    Calculation c = new Calculation();
                    double result = c.calculate(data);
                    
                    String answer = String.valueOf(result);
                    display.setText(answer);
                }
                catch (ExceptionHandler e){
                    display.setText(e.getMessage());
                    errorDisplayed = true;
                }

                for (JButton b : operatorButtons){
                    b.setEnabled(true);
                }
            }
        });


        JButton btndel = new JButton("Delete");
        btndel.setBounds(150,150,100,50);
        frame.add(btndel);

        configureDelete(btndel, operatorButtons);

        
        JButton btnac = new JButton("AC");
        btnac.setBounds(25,150,100,50);
        frame.add(btnac);

        configureClear(btnac, operatorButtons);


        frame.setVisible(true);

    }
}