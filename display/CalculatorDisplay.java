package display;

import javax.swing.*;
import exceptions.*;

import java.awt.event.*;
import operations.*;

public class CalculatorDisplay extends JFrame{

    private JTextField display;
    private boolean errorDisplayed = false;     // Error Flag

    private void clearAll(){
        display.setText("");
        errorDisplayed = false;
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

        //ErrorHandler.setDisplay(this);

        JButton btn0 = new JButton("0");
        btn0.setBounds(25,490,150,60);
        frame.add(btn0);

        btn0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.out.println("clicked 0!");
                if(errorDisplayed){
                    clearAll();
                    errorDisplayed = false;
                }
                display.setText(display.getText()+"0");
            }
        });


        JButton btn1 = new JButton("1");
        btn1.setBounds(25,400,60,60);
        frame.add(btn1);

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(errorDisplayed){
                    clearAll();
                    errorDisplayed = false;
                }
                display.setText(display.getText()+"1");
            }
        });


        JButton btn2 = new JButton("2");
        btn2.setBounds(115,400,60,60);
        frame.add(btn2);

        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(2));
            }
        });

        JButton btn3 = new JButton("3");
        btn3.setBounds(205,400,60,60);
        frame.add(btn3);
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(3));
            }
        });


        JButton btn4 = new JButton("4");
        btn4.setBounds(25,300,60,60);
        frame.add(btn4);

        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(4));
            }
        });

        
        JButton btn5 = new JButton("5");
        btn5.setBounds(115,300,60,60);
        frame.add(btn5);

        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(5));
            }
        });

        
        JButton btn6 = new JButton("6");
        btn6.setBounds(205,300,60,60);
        frame.add(btn6);
        
        btn6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(6));
            }
        });


        JButton btn7 = new JButton("7");
        btn7.setBounds(25,210,60,60);
        frame.add(btn7);

        btn7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(7));
            }
        });

        
        JButton btn8 = new JButton("8");
        btn8.setBounds(115,210,60,60);
        frame.add(btn8);
        btn8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(8));
            }
        });


        JButton btn9 = new JButton("9");
        btn9.setBounds(205,210,60,60);
        frame.add(btn9);
        btn9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+String.valueOf(9));
            }
        });


        JButton btndivot = new JButton(".");
        btndivot.setBounds(205,490,60,60);
        frame.add(btndivot);

        btndivot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+".");
            }
        });


        JButton btnadd = new JButton("+");
        btnadd.setBounds(300,490,60,60);
        frame.add(btnadd);

        btnadd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+"+");
            }
        });

        
        JButton btnsub = new JButton("-");
        btnsub.setBounds(300,400,60,60);
        frame.add(btnsub);

        btnsub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+"-");
            }
        });

        
        JButton btnmul = new JButton("*");
        btnmul.setBounds(300,300,60,60);
        frame.add(btnmul);

        btnmul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+"*");
            }
        });

        
        JButton btndiv = new JButton("/");
        btndiv.setBounds(300,210,60,60);
        frame.add(btndiv);

        btndiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText(display.getText()+"/");
            }
        });


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
                    display.setText(e.getMessage()+"by handler");
                    errorDisplayed = true;
                }
            }
        });


        JButton btndel = new JButton("Delete");
        btndel.setBounds(150,150,100,50);
        frame.add(btndel);

        btndel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String currentInput = display.getText();
                if(currentInput != null && currentInput.length()>0){
                    String newInput = currentInput.substring(0,currentInput.length()-1);
                    display.setText(newInput);
                }
            }
        });

        
        JButton btnac = new JButton("AC");
        btnac.setBounds(25,150,100,50);
        frame.add(btnac);

        btnac.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                display.setText("");
            }
        });

        frame.setVisible(true);

    }
}


