/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pns.api.mainClasses;

/**
 *
 * @author Movement
 */
public class Head extends Segment {

    private double size = 10;

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public void run() {
        super.run();
        this.generatePointSet();
        System.out.println("    HHH this.size  " + this.size);
    }

    @Override
    protected void generatePointSet() {
        size = Math.random() * 100;
        super.generatePointSet(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSize(int size) {
        super.setSize(size); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Head{" + "size=" + size + "  ,  " + System.lineSeparator() + super.toString() + '}' + System.lineSeparator() + "  " + System.lineSeparator();
    }

}
