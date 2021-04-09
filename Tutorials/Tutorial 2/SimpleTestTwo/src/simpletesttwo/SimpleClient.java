/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesttwo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rog
 */
public class SimpleClient {
    SimpleCalculatorServer server = new SimpleCalculatorServer();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.executeTest();
    }
    
    private void executeTest(){
        System.out.println("[CLIENT] - Testing if the server is connected....");
        if(server.isServerConnected()){
            System.out.println("[CLIENT] - The Client is connected, the test can proceed....");
            
            //Addition
            int x = 2;
            int y = 3;
            System.out.println("[CLIENT] - Asking the server what is the sum of " + x + " and " +y);
            int z = server.addIntegerNumbers(x, y);
            System.out.println("[CLIENT] - The server has replied that the sum of " + x + " and " + y + " is " + z);
            if(z==x+y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the wrong answer");            
            }
            
            //Division
            x = 4;
            y = 2;
            System.out.println("[CLIENT] - Asking the server what is the division of " + x + " and " +y);
            try {
                z = server.divideIntegerNumbers(x, y);
                System.out.println("[CLIENT] - The server has replied that " + x + " / " + y + " is " + z);
                //System.out.println("[CLIENT] - This line will not be seen !!!");
                if(z==x/y){
                    System.out.println("[CLIENT] - The server has returned the correct answer");
                }else{
                    System.out.println("[CLIENT] - The server has returned the wrong answer");            
                }
            } catch (Exception ex) {
                System.out.println("[CLIENT] - Exception Caught !!!");
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE,"Cannot divide by zero !!!", ex);
            }
            
            //Substraction
            x = 10;
            y = 4;
            System.out.println("[CLIENT] - Asking the server what is the substraction of " + x + " and " +y);
            z = server.substractIntegerNumbers(x, y);
            System.out.println("[CLIENT] - The server has replied that the substraction of " + x + " and " + y + " is " + z);
            if(z==x-y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the wrong answer");            
            }
            
            //Multiplication
            x = 5;
            y = 3;
            System.out.println("[CLIENT] - Asking the server what is the multiplication of " + x + " and " +y);
            z = server.multiplyIntegerNumbers(x, y);
            System.out.println("[CLIENT] - The server has replied that the multiplication of " + x + " and " + y + " is " + z);
            if(z==x*y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the wrong answer");            
            }
            
            /*Division Solution
                The reason is we are using integers in the first division so the answer will be displayed as an int becuase we are using integer division.
                The simpleset solution would be to use double values inorder to get the correct answer.
                A new method has to be created in the Server inorder to divide double numbers.
                The solution is given below.
            */            
            double t = 4;
            double s = 3;
            System.out.println("[CLIENT] - Asking the server what is the division of " + t + " and " +s);
            try {
                double r = server.divideDoubleNumbers(t, s);
                System.out.println("[CLIENT] - The server has replied that " + t + " / " + s + " is " + r);
                //System.out.println("[CLIENT] - This line will not be seen !!!");
                if(r==t/s){
                    System.out.println("[CLIENT] - The server has returned the correct answer");
                }else{
                    System.out.println("[CLIENT] - The server has returned the wrong answer");            
                }
            } catch (Exception ex) {
                System.out.println("[CLIENT] - Exception Caught !!!");
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE,"Cannot divide by zero !!!", ex);
            }
        /*    
        //ArraySolution
            Integer a[] = {1,2,3};
            Integer b[] = {4,5,6};
            
            //Addition
            System.out.println("[CLIENT] - Asking the server what is the sum of " + a + " and " +b);
            Integer[] c = server.arrayCalculations(a, b);
            System.out.println("[CLIENT] - The server has replied that the substraction of " + a + " and " + b + " is " + c);
            */
        }else{
            System.out.println("[CLIENT] - The Client is Not connected, the test has failed....");
        }
    }
}
