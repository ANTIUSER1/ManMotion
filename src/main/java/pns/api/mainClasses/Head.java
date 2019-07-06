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

    @Override
    public void run() {
        super.run();
        this.generatePointSet();
        System.out.println("    HHH length  " + length);
    }

    @Override
    protected void generatePointSet() {
        length = Math.random() * 100;
        super.generatePointSet(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Head{" + "size=" + length + "  ,  " + System.lineSeparator() + super.toString() + '}' + System.lineSeparator() + "  " + System.lineSeparator();
    }

}
