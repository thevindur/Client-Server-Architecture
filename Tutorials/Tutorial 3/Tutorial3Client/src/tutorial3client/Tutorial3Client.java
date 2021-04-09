/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial3client;

/**
 *
 * @author rog
 */
public class Tutorial3Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tutorial3Client client = new Tutorial3Client();
        client.execute();
    }
    
    private void execute(){
        System.out.println("[CLIENT] - Executing Connection Test");
        if(isConnected()== true){
            System.out.println("[CLIENT] - Server is Connected test can continue...");
        }else{
            System.out.println("[CLIENT] - Server is NOT Connected, test has Failed !");
        }
        
        
    }

    private static Boolean isConnected() {
        tutorial3client.SimpleWebService_Service service = new tutorial3client.SimpleWebService_Service();
        tutorial3client.SimpleWebService port = service.getSimpleWebServicePort();
        return port.isConnected();
    }

    private static String hello(java.lang.String name) {
        tutorial3client.SimpleWebService_Service service = new tutorial3client.SimpleWebService_Service();
        tutorial3client.SimpleWebService port = service.getSimpleWebServicePort();
        return port.hello(name);
    }
    
    
}
//dataaccess.com/webservicesserver/NumberConversion.wso?WSDL