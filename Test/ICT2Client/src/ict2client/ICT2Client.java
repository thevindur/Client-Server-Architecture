/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict2client;

public class ICT2Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICT2Client client = new ICT2Client();
        client.execute();
        // TODO code application logic here
    }

    private void execute() {
        System.out.println("[CLIENT] - Testing Connection...");
        if(testConnection() == 1.0){
            System.out.println("[CLIENT] - Connection Successful");
            String s4 = "string123";
            String s5 = "string1";
            String s = longestString(s4,s5);
            System.out.println("[CLIENT] - longest string is " + s);
            try{
                s4 = "";
                s5 = "";
                s = safeLongestString(s4,s5);
            System.out.println("[CLIENT] - longest string is " + s);
            }
            catch(Exception_Exception Ex){
                System.out.println("[CLIENT] - Exception");
                
            }
            
            Double x = 2.4;
            Double y = 3.4;
            addDoubleToArray(x);
            addDoubleToArray(y);
            
            System.out.println("[CLIENT] - added " + x + " to array");
            System.out.println("[CLIENT] - added " + y + " to array");
            try{
                Double z = getLargestDoubleOnServer();
                System.out.println("[CLIENT] - Largest double on server is " + z);
            }catch(Exception_Exception Ex){
                System.out.println("[CLIENT] - Exception");
            }
            
            Double d = 1.0;
            getAllDoubleSamplesAbove(d);
            System.out.println("[CLIENT] - Getting all double samples greater than " + d);
            
           
        }else{
        
            System.out.println("[CLIENT] - Connection Lost");
        }
        
    }

    private static Double testConnection() {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.testConnection();
    }

    private static String longestString(java.lang.String s1, java.lang.String s2) {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.longestString(s1, s2);
    }

    private static String safeLongestString(java.lang.String s1, java.lang.String s2) throws Exception_Exception {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.safeLongestString(s1, s2);
    }

    private static void addDoubleToArray(java.lang.Double d) {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        port.addDoubleToArray(d);
    }

    private static Double getLargestDoubleOnServer() throws Exception_Exception {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.getLargestDoubleOnServer();
    }

    private static java.util.List<java.lang.Object> getAllDoubleSamplesAbove(java.lang.Double d) {
        ict2client.ICT2WebService_Service service = new ict2client.ICT2WebService_Service();
        ict2client.ICT2WebService port = service.getICT2WebServicePort();
        return port.getAllDoubleSamplesAbove(d);
    }

    

    
    
    
    
    
}
