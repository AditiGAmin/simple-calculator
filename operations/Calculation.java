package operations;

public class Calculation {
 
    public double calculate(OperationData data){
        double result = 0;
        double op1 = data.getNum1();
        double op2 = data.getNum2();
        char op = data.getOperator();

        switch(op){
            case '+':
                    result = op1+op2;
                    break;
            case '-':
                    result = op1-op2;
                    break;
            case '*':
                    result = op1*op2;
                    break;
            case '/':
                    result = op1/op2;
                    break;
            default:
                    return Double.NaN;
        }
        System.out.println(result);
        return result;
    }
}

