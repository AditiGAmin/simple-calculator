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
            double num = Double.parseDouble(input.trim());
            return new OperationData(num, 0, '+'); 
        }
        
        double num1 = 0;
        num1 = Double.parseDouble(input.substring(0,operatorIndex).trim());
        if(Double.isNaN(num1)){
        }
        

        double num2 =0;
        String tempnum2= input.substring(operatorIndex+1);
        
        if (!tempnum2.isEmpty()){
            num2 = Double.parseDouble(input.substring(operatorIndex+1).trim());
        }
        else{
            throw new ExceptionHandler("Incomplete Input");
        }


        if (operator == '/' && num2 == 0){
            throw new ExceptionHandler("ERROR");
        }

        return new OperationData(num1,num2,operator);

        }
    }