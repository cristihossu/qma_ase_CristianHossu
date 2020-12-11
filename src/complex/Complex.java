/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Binks
 */
public class Complex {
    private double realPart;
    private double complexPart;
    private boolean initialized=false;
    private final static String NUMBER_NOT_INITIALIZED="Number is not initialized";
    private final static String DIVISION_BY_ZERO="Division by zero";
    
    public boolean isInitialized(){
        return initialized;
    }
    
    
    public Complex(double realPart, double complexPart){
        this.realPart=realPart;
        this.complexPart=complexPart;
        initialized=true;
    }
    
    
    public double getRealPart() throws Exception{
        if (isInitialized()) return realPart;
        throw new Exception(NUMBER_NOT_INITIALIZED);
    }
    
    public double getComplexPart() throws Exception{
        if (isInitialized()) return complexPart;
        throw new Exception(NUMBER_NOT_INITIALIZED);
    }
    
    public double getR() throws Exception{
        if (!isInitialized()) throw new Exception(NUMBER_NOT_INITIALIZED);
        return sqrt(realPart*realPart+complexPart*complexPart);
    }
    
    public double getTheta() throws Exception{
        if (!isInitialized()) throw new Exception(NUMBER_NOT_INITIALIZED);
        if (complexPart==0.0){
            if (realPart>=0){
                return 0.0;
            }
            return PI;
        }
        
        if (realPart==0.0){
            if (complexPart>=0.0){
                return PI/2;
            }
            return -PI/2;
        }
        return atan(complexPart/realPart);
    }
    
    public void addReal(double a) throws Exception{
        if (!isInitialized()){
            throw new Exception(NUMBER_NOT_INITIALIZED);
        }
        realPart+=a;
        
    }
    
    public void addComplex(double b) throws Exception{
        if (!isInitialized()){
            throw new Exception(NUMBER_NOT_INITIALIZED);
        }
        complexPart+=b;
    }
    
    public void addComplex(Complex b) throws Exception{
        if (!isInitialized()){
            throw new Exception(NUMBER_NOT_INITIALIZED);
        }
        if (!b.isInitialized()){
            throw new Exception(NUMBER_NOT_INITIALIZED);
        }
        realPart+=b.realPart;
        complexPart+=b.complexPart;
    }
    
    public boolean isEqual(Complex a,Complex b) throws Exception{
        if (!a.isInitialized() || !b.isInitialized()){
            throw new Exception(NUMBER_NOT_INITIALIZED);
        }
        if (a.getComplexPart()==b.getComplexPart() && a.getRealPart()==b.getRealPart()){
            return true;
        }
        return false;
    }
    
    public String toString(){
        StringBuffer sb=new StringBuffer();
        try {
            sb.append(String.format("%f",getRealPart()));
            if (getComplexPart()>=0.0){
                sb.append("+");
            }
            sb.append(String.format("%f",getComplexPart()));
            if (getComplexPart()!=0.0){
                sb.append("i");
            }
        } catch (Exception ex) {
            Logger.getLogger(Complex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
    
    public void multiplyByComplex(Complex p) throws Exception{
        if (!isInitialized() || !p.isInitialized()){
            throw new Exception(NUMBER_NOT_INITIALIZED);
        }
        double a=this.getRealPart();
        double b=this.getComplexPart();
        this.realPart=a*p.getRealPart()-b*p.getComplexPart();
        this.complexPart=a*p.getComplexPart()+b*p.getRealPart();
    }
    
    public void inverse() throws Exception{
        if (!isInitialized())
            throw new Exception(NUMBER_NOT_INITIALIZED);
        double r=getR();
        if (r==0.0){
            throw new Exception(DIVISION_BY_ZERO);
        }
        double c=this.getRealPart()/(r*r);
        double d=-this.getComplexPart()/(r*r);
        this.realPart=c;
        this.complexPart=d;
        
    }
    
    public static void main(String[] args) {
        Complex c=new Complex(2,3);
        Complex d=c;
        System.out.println(c.toString());
        try {
            c.inverse();
            System.out.println(c.toString());
            Complex e=c;
            e.multiplyByComplex(c);
            System.out.println(e.toString());
        } catch (Exception ex) {
            Logger.getLogger(Complex.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
