/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rog
 */
public class Tutorial1 {
    private static String clientid = "Client_001";
    private static String password = "123@Raja";
    private static DummyServer server = new DummyServer();
    private final static Logger logger = Logger.getLogger(Logger.class.getName());
    
    //singleton
    private Tutorial1(DummyServer server ){
        logger.setLevel(Level.INFO);
        logger.info("[SERVER] CREATED SUCCESSFULLY");
        this.server = server;
    }
    
    public Tutorial1() {
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your User Name : ");
        String user = sc.next();
        System.out.println("Please Enter Your Password : ");
        String pw = sc.next();
        if (user.equalsIgnoreCase(clientid)){
            if (pw.equalsIgnoreCase(password)){
                logger.info("INFO: [CLIENT] : CREATING THE SERVER");
                Tutorial1 tutorial1 = new Tutorial1(server);
                tutorial1.execute();
                logger.info("INFO: [CLIENT] : CREATED SUCCESSFULLY");
            }
        }
    }

    
    
    private void execute(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        server.testConnection();
        System.out.println("INFO: [CLIENT] : Connection from " + clientid + " Succeded @"+timestamp);
    }
}
