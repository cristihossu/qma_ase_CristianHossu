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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Binks
 */
public class HossuTests extends TestCase{
    
    public HossuTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInitialized(){
        Complex c=new Complex(1,2);
        assert(c.isInitialized());
    }
    
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
    
    @Test
    public void testToFail(){
        Complex a=new Complex(1,2);
        Complex b=new Complex(0,2);
        try{
            a.substract(b);
            assert(!a.isReal());
        } catch (Exception ex) {
            Logger.getLogger(HossuTests.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    @Test
    public void testAPlusBiXAMinusBi(){
        try {
            Complex a=new Complex(2,3);
            Complex b=new Complex(2,-3);
            a.multiplyByComplex(b);
            Complex c=new Complex(13,0);
            assert(Complex.isEqual(a,c));
        } catch (Exception ex) {
            Logger.getLogger(HossuTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
