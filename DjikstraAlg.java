import edu.princeton.cs.algs4.*;

public class DjikstraAlg{

    public static void main(String args[]){
        System.out.println("\nPlease enter an operation to solved using the Two Stack Algorithm, for example '(1+((2+3)*(4*5)))' ");
        String s = StdIn.readString();
        StdOut.print("Completely Parenthetical Evaluation: " +  solve(s));
    }

    public static double solve(String op){
        int start;
        Stack<Double> operand = new Stack<Double>();
        Stack<Character> operator = new Stack<Character>();
        for(int i = 0; i < op.length(); i++){
            if(op.charAt(i) == ')'){
                char s = operator.pop();
                double answer;
                if(s == '+'){
                    answer = operand.pop() + operand.pop();
                    operand.push(answer);
                }
                else if(s == '-'){
                    double second = operand.pop();
                    answer = operand.pop() - second;
                    operand.push(answer);
                }
                else if(s == '*'){
                    answer = operand.pop() * operand.pop();
                    operand.push(answer);
                }
                else if(s == '/'){
                    double second = operand.pop();
                    answer = operand.pop() / second;
                    operand.push(answer);
                }
            }
            else if(op.charAt(i) == '+' || op.charAt(i) == '-' || op.charAt(i) == '*' || op.charAt(i) == '/'){
                operator.push(op.charAt(i));
            }
            else if(op.charAt(i) != '('){
                start = i;
                if(op.charAt(i + 1) == '+' || op.charAt(i + 1) == '-' || op.charAt(i + 1) == '*' || op.charAt(i + 1) == '/' || op.charAt(i + 1) == ')'){
                    operand.push(Double.valueOf(op.substring(start, i + 1)));
                }
            }
        }
        return operand.pop();
    }
}
