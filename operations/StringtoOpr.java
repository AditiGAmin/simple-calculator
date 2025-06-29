package operations;

import exceptions.*;

public class StringtoOpr {
    public OperationData convert(String input) throws ExceptionHandler{
        char operator = ' ';
        int operatorIndex = -1;

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                operator = ch;
                operatorIndex = i;
                break;
            }
        }
        
        if (operatorIndex == -1){
            //throw new ExceptionHandler("Incomplete Input");
            double num = Double.parseDouble(input.trim());
            return new OperationData(num, 0, '+'); 
        }
        

        double num1 = Double.parseDouble(input.substring(0,operatorIndex).trim());
        System.out.println(num1+" "+" "+ operator);     //************** */
        double num2 = Double.parseDouble(input.substring(operatorIndex+1).trim());
        System.out.println(num1+" "+num2+" "+ operator);    //************** */

        // you're here <<<<<<<<>>>>>>>>>
        if (Double.isNaN(num1) || Double.isNaN(num2)){
            System.out.println("inside handler");
            throw new ExceptionHandler("Incomplete Input");
        }


        /*
        if (operator == '\0'){
            throw new ExceptionHandler("Missing Operator");
        }
        
        
             */


        if (operator == '/' && num2 == 0){
            throw new ExceptionHandler("ERROR");
        }

        return new OperationData(num1,num2,operator);

        }
    }




