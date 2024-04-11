package org.example;
package ;
/**
 * Hello world!
 *
 */



class Complex{
    private double real;
    private double imag;
    public Complex(double r, double im) {
        this.imag = im;
        this.real = r;
    }
    public Complex(){
        this.imag = 0;
        this.real = 0;
    }
    public void add(Complex cm) {
        this.imag += cm.imag;
        this.real += cm.real;
    }
    public void minus(Complex cm) {
        this.imag -= cm.imag;
        this.real -= cm.real;
    }
    public void multify(Complex cm) {
        double re = this.real*cm.real-cm.imag*this.imag;
        this.imag = this.imag*cm.real+this.real*cm.imag;
        this.real = re;
    }
    public void print() {
        System.out.printf("(%f,%f)\n",this.real,this.imag);
    }
}

class Account {
    private double balance;
    public void deposit(double Money) {
        balance+=Money;
    }
    public void withdraw(double Money) {
        if(balance <Money) {
            System.out.println("余额不足，仅剩"+balance);
        }
    }
    public void getbalance() {
        System.out.println("该账户目前余额为"+balance);
    }

}

class testCompare implements Compare{
    @Override
    public double threeMax(double a, double b, double c) {
        return 0;
    }

    @Override
    public double threeMin(double a, double b, double c) {
        return 0;
    }
}

public class App 
{
    public static void main( String[] args )
    {
        Complex cm = new Complex(1.2,1.3);
        Complex cm1 = new Complex(3,2);
        cm.print();cm1.print();
        cm.add(cm1);cm.print();
        cm.minus(cm1);cm.print();
        cm.multify(cm1);cm.print();
    }
}
