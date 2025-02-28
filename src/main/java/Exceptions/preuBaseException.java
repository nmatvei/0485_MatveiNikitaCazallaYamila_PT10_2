/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Nikita i Yamila
 */
public class preuBaseException extends Exception {
    
    private String error;
    
    public preuBaseException(String msg) {
        
        this.error = msg;
        
    }
    
    public String toString() {
        return "preuBaseException: " + this.error;
    }
}
