/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.sql.Timestamp;

/**
 *
 * @author rog
 */

public class DummyServer {
    String nameOfTheServer = "Server_001";

    public DummyServer(String nameOfTheServer) {
        this.nameOfTheServer = nameOfTheServer;
    }

    DummyServer() {    
    }
    
    String testConnection(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("INFO: [SERVER] : DummyServer " +
                nameOfTheServer + " Connection being tested... @"+timestamp);
        return "Connection Succeded";
    }
}
