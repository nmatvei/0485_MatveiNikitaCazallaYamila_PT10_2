/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Nikita i Yamila
 */
public class resolucio4KException extends Exception {
    
    private String error;
    
    public resolucio4KException(String msg) {
        
        this.error = msg;
        
    }
    
    public String toString() {
        return "resolucio4KException: " + this.error;
    }
    
}
