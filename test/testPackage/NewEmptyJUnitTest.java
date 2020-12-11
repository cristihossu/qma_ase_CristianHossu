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
import static org.junit.Assert.*;

/**
 *
 * @author Binks
 */
public class NewEmptyJUnitTest extends TestCase{
    
    public NewEmptyJUnitTest() {
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
    public void testHello1(){
        Complex c=new Complex(1,2);
        assert(c.isInitialized());
    }
    
    @Test
    public void testHello2(){
        Complex c=new Complex();
        c.setRealPart(1);
        c.setComplexPart(2);
        Complex d=new Complex(2,3);
        try {
            assert(!c.isEqualTo(d));
        } catch (Exception ex) {
            Logger.getLogger(NewEmptyJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewEmptyJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
