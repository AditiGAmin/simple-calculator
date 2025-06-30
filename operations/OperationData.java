package operations;

public class OperationData {
    private double num1,num2;
    private char operator;

    public OperationData(double num1, double num2,char operator){
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public double getNum1() {return num1;}
    public double getNum2() {return num2;}
    public char getOperator() {return operator;}
}