/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

/**
 *
 * @author ZAFL
 */
public class AllError extends Exception {

    /**
     * Creates a new instance of <code>AllError</code> without detail message.
     */
    public AllError() {
    }

    /**
     * Constructs an instance of <code>AllError</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public AllError(String msg) {
        super(msg);
    }
}
