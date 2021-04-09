/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict2client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rog
 */
public class ICT2Client {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICT2Client client = new ICT2Client();
        client.execute();
    }

    private void execute() {
        System.out.println("[CLIENT] - Executing Connection Test\n");
        if(isConnected() == 0.0){
            System.out.println("[CLIENT] - Server is Connected test can continue...\n");
            
            System.out.println("[CLIENT] - Testing the booleanAND method.");
            boolean a = true;
            boolean b = false;
            boolean c = booleanAnd(a,b);
            System.out.println("\t[CLIENT] - Boolean value a "+a+" and Boolean value b "+b+" is equal to value "+c);
            
            System.out.println("[CLIENT] - Testing the safeBooleanAND method.");
            try{                
                Boolean d = null;
                Boolean e = null;
                c = safeBooleanAND(d, e);
            }catch(Exception_Exception e){
                System.out.println("\t[CLIENT] - Both values has to be defined.");
            }try{
                c = safeBooleanAND(a, b);
                System.out.println("\t[CLIENT] - Boolean value a "+a+" and Boolean value b "+b+" is equal to value "+c);
            }catch(Exception_Exception e){
                System.out.println("[CLIENT] - Both values has to be defined.");
            }
            
            System.out.println("[CLIENT] - Testing addBooleanOnServer(BooleanContainer b)");
            BooleanContainer booleanContainer = new BooleanContainer();
            Boolean f = true;
            booleanContainer.setA(f);
            try {
                addBooleanOnServer(booleanContainer);
            } catch (Exception_Exception ex) {
                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\t[CLIENT] - Boolean container value is "+booleanContainer.isA());
            f = null;
            booleanContainer.setA(f);
            try {
                addBooleanOnServer(booleanContainer);
            } catch (Exception_Exception ex) {
                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\t[CLIENT] - Boolean container value is "+booleanContainer.isA());
            
            
            System.out.println("[CLIENT] - Testing getNumberOfTrueValues()");
            int x = 0;
            try {
                x = getNumberOfTrueValues();
            } catch (Exception_Exception ex) {
                Logger.getLogger(ICT2Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\t[CLIENT] - The number of true statements in the array is "+x);
            
            
            
        }else{
            System.out.println("[CLIENT] - Server is NOT Connected, test has Failed !");
        }
    }

    private static Double isConnected() {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.isConnected();
    }

    private static Boolean booleanAnd(java.lang.Boolean a, java.lang.Boolean b) {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.booleanAnd(a, b);
    }

    private static Boolean safeBooleanAND(java.lang.Boolean a, java.lang.Boolean b) throws Exception_Exception {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.safeBooleanAND(a, b);
    }

    private static BooleanContainer addBooleanOnServer(ict2client.BooleanContainer b) throws Exception_Exception {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.addBooleanOnServer(b);
    }

    private static Integer getNumberOfTrueValues() throws Exception_Exception {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.getNumberOfTrueValues();
    }

}
