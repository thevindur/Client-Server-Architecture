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

@WebService(serviceName = "ICT2WebService")
public class ICT2WebService {
    ArrayList<Double> doubles = new ArrayList();

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
    @WebMethod(operationName = "testConnection")
    public Double testConnection() {
        //TODO write your implementation code here:
        return 1.0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "longestString")
    public String longestString(@WebParam(name = "s1") String s1, @WebParam(name = "s2") String s2) {
        if (s1.length() > s2.length()) {
              return s1;
          }
        else{
            return s2;
        }
        //TODO write your implementation code here:
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "safeLongestString")
    public String safeLongestString(@WebParam(name = "s1") String s1, @WebParam(name = "s2") String s2) throws Exception {
        if(s1.length() == 0 || s2.length() == 0){
            throw new Exception();
        }else if(s1.length() == 0 && s2.length() == 0){
            throw new Exception();
        }
        else{
            if (s1.length() > s2.length()) {
                return s1;
            }
            else{
                return s2;
            }
        }
       
        }
            
        
        
        
        
        //TODO write your implementation code here:

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addDoubleToArray")
    public void addDoubleToArray(@WebParam(name = "d") Double d) {
        //TODO write your implementation code here:
        doubles.add(d);
        System.out.println("[SERVER] - Now arraylist is " + doubles);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLargestDoubleOnServer")
    public Double getLargestDoubleOnServer()throws Exception{
        if(doubles.size() == 0){
            throw new Exception();
        }
        else if(doubles.contains(null)){
            throw new Exception();
        }
        Double max = 0.0;
        for (int i = 0; i < doubles.size(); i++) {
            if (doubles.get(i) > max) {
                max = doubles.get(i);
            }
        }
        //TODO write your implementation code here:
        return max;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllDoubleSamplesAbove")
    public ArrayList getAllDoubleSamplesAbove(@WebParam(name = "d") Double d) {
        ArrayList<Double> maxset = new ArrayList();
        for (int i = 0; i < doubles.size(); i++) {
            if (doubles.get(i) >= d) {
                maxset.add(doubles.get(i));
                System.out.println("[SERVER] - " + d + " added to server");
                
            }
        }
        System.out.println("[SERVER] - Output ArrayList is " + maxset);
        //TODO write your implementation code here:
        return maxset;
    }
}


