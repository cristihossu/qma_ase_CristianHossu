/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import complex.Complex;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Binks
 */
public class HossuTest2 extends TestCase{
     @Test
    public void testNotInitialized(){
        Complex a=new Complex();
        assert(!a.isInitialized());
        Complex b=new Complex(1,2);
        b.forget();
        assert(!b.isInitialized());
    }
    
    @Test
    public void testTwoComplexNumbers(){
        Complex c=new Complex();
        c.setRealPart(1);
        c.setComplexPart(2);
        Complex d=new Complex(2,3);
        try {
            assert(!c.isEqualTo(d));
        } catch (Exception ex) {
            Logger.getLogger(HossuTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setTo(1,0);
    }
    
    @Test
    public void testPureComplex(){
        Complex c=new Complex(0,-2.6);
        try {
            c.addComplex(new Complex(0.0,2.6));
            assert(c.isReal());
        } catch (Exception ex) {
            Logger.getLogger(HossuTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
