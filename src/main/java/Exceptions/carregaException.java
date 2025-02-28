/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Nikita i Yamila
 */
public class carregaException extends Exception {
    
    private String error;
    
    public carregaException(String msg) {
        
        this.error = msg;
        
    }
    
    public String toString() {
        return "carregaException: " + this.error;
    }
}
