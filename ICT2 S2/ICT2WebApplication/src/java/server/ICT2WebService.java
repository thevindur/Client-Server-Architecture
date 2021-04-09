/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rog
 */
@WebService(serviceName = "ICT2WebService")
public class ICT2WebService {
    static ArrayList<BooleanContainer> booleanContainerArray = new ArrayList();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Double isConnected() {
        System.out.println("[SERVER] - Testing the server Connection .....");
        System.out.println("[SERVER] - Connection Successfull");
        return 0.0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "booleanAnd")
    public Boolean booleanAnd(@WebParam(name = "a") Boolean a, @WebParam(name = "b") Boolean b) {
        System.out.println("[SERVER] - Calling the booleanAnd Method");
        return a & b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "safeBooleanAND")
    public Boolean safeBooleanAND(@WebParam(name = "a") Boolean a, @WebParam(name = "b") Boolean b) throws Exception {
        System.out.println("[SERVER] - Calling the safeBooleanAnd Method");
        if(a==null && b==null){
            throw new Exception();
        }else{
            return a&b;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addBooleanOnServer")
    public BooleanContainer addBooleanOnServer(@WebParam(name = "b") BooleanContainer b) throws Exception {
        System.out.println("[SERVER] - Calling addBooleanOnServer(BooleanContainer b) method");
        BooleanContainer booleanContainer = new BooleanContainer();
        booleanContainerArray.add(b);
        return b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumberOfTrueValues")
    public Integer getNumberOfTrueValues() throws Exception {
        System.out.println("[SERVER] - Calling getNumberOfTrueValues() method");
        int count=0;
        BooleanContainer booleanContainer = new BooleanContainer();
        Boolean f = true;
        booleanContainer.setA(f);
        for (int i = 0; i < booleanContainerArray.size() ; i++) {
            if(booleanContainerArray.get(i).equals(booleanContainer)){
                count++;
            }
        }
        System.out.println("[SERVER] - Number of true statements is "+count);
        return count;
    }   
        
}
