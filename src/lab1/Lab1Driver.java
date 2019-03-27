/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayerj
 */
public class Lab1Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // The thing I don't like about abstract superclasses is this:
        // Using  the Liskov substitution principle you'd make an instance of each of these subclasses by typing:
        // ProgrammingClass advjava = new AdvancedJavaClass();, etc.
        // But since I'm only listing the COMMON methods in the superclass, I miss out on the local methods in the subclass.
        // ProgrammingClass intro = new IntroJavaCourse("MyFirstJava", "001"); gives me an error on intro.setPrerequisites("none"); below
        // So to use the Liskoff substitution principle is only useful for putting all class objects in an array and even then
        // you have to check for the instance of and then cast the element in the array.
        String msg = "";
        List<ProgrammingClass> classList = new ArrayList<>();

        IntroJavaCourse intro = new IntroJavaCourse("MyFirstJava", "001");
        intro.setCredits(3.0);
        intro.setPrerequisites("IntroToProg");
        classList.add(intro);

        AdvancedJavaCourse adv = new AdvancedJavaCourse("MyAdvJava", "002");
        adv.setCredits(4.0);
        adv.setPrerequisites("MyFirstJava");
        classList.add(adv);

        IntroToProgrammingCourse introToProg = new IntroToProgrammingCourse("IntroToProg", "0011");
        introToProg.setCredits(2.0);
        classList.add(introToProg);

        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i) instanceof AdvancedJavaCourse) {
                msg += ((AdvancedJavaCourse) classList.get(i)).getCourseNumber() + " " + ((AdvancedJavaCourse) classList.get(i)).getCourseName() + " has a prerequisite of "
                        + ((AdvancedJavaCourse) classList.get(i)).getPrerequisites() + " and is "
                        + ((AdvancedJavaCourse) classList.get(i)).getCredits() + " credits.\n";
            } else if (classList.get(i) instanceof IntroJavaCourse) {
                msg += ((IntroJavaCourse) classList.get(i)).getCourseNumber() + " has a prerequisite of "
                        + ((IntroJavaCourse) classList.get(i)).getPrerequisites() + " and is "
                        + ((IntroJavaCourse) classList.get(i)).getCredits() + " credits.\n";
            } else if (classList.get(i) instanceof IntroToProgrammingCourse) {
                msg += ((IntroToProgrammingCourse) classList.get(i)).getCourseNumber() + " has no prerequisites and "
                        + "is " + ((IntroToProgrammingCourse) classList.get(i)).getCredits() + " credits.\n";

            }
        }
        printme(msg);
    }

    public static void printme(String msg) {
        System.out.println(msg);
    }

}
