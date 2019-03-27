/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayerj
 */
public class Lab2Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // The thing I don't like about interface superclasses is this:
        // Using  the Liskov substitution principle you'd make an instance of each of these subclasses by typing:
        // ProgrammingClass advjava = new AdvancedJavaClass();, etc.
        // But since I'm only listing the COMMON methods in the interface, I miss out on the local methods in the subclass.
        // ProgrammingClass intro = new IntroJavaCourse("MyFirstJava", "001"); gives me an error on intro.setPrerequisites("none"); below.
        // So to use the Liskoff substitution principle is only useful for putting all class objects in an array and even then
        // you have to check for the instance of and then cast the element in the array.
        /*
         Interfaces
         Advantages:

         1) Java doesn't support multiple inheritance, but interfaces make multiple inheritance possible
         2) Interfaces break up complex designs and guide the programmer to not make dependencies between classes/objects.
         3) Interfaces makes your application loosely coupled.
         4) Interfaces force classes implementing them to include all methods which standardizes classes within a project

         Disadvantages:

         1) Can only contain abstract methods so the body of the method is not described in the interface
         2) Interface should be used multiple number of times else there is hardly any use of having them

         Abstract classes

         Advantages:
         Can group several related classes together to keep track of them in a project with hundreds of classes
         You can have be abstract and concrete methods in an abstract class so if you want to dictate how the body of a method
         should be, make it concrete. (Interfaces only have abstract methods.)
         Disadvantages:
         Doesn't allow multiple inheritance. One point to interfaces in this regard.
         */

        String msg = "";
        List<ProgrammingClass> classList = new ArrayList<>();

        AdvancedJavaCourse advJava = new AdvancedJavaCourse("ADV_Java", "003");
        advJava.setCredits(4.0);
        advJava.setPrerequisites("IntroJavaCourse");
        classList.add(advJava);

        IntroJavaCourse introJava = new IntroJavaCourse("INTRO_Java", "002");
        introJava.setCredits(3.0);
        introJava.setPrerequisites("IntroProgCourse");
        classList.add(introJava);

        IntroToProgrammingCourse introProg = new IntroToProgrammingCourse("INTRO_PROG", "001");
        introProg.setCredits(2.0);
        classList.add(introProg);

        //System.out.println(advJava);
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i) instanceof AdvancedJavaCourse) {
                msg += ((AdvancedJavaCourse) classList.get(0)).getCourseNumber() + " " + ((AdvancedJavaCourse) classList.get(0)).getCourseName() + " has a prerequisite of "
                        + ((AdvancedJavaCourse) classList.get(0)).getPrerequisites() + " and is "
                        + ((AdvancedJavaCourse) classList.get(0)).getCredits() + " credits.\n";
            } else if (classList.get(i) instanceof IntroJavaCourse) {
                msg += ((IntroJavaCourse) classList.get(i)).getCourseNumber() + " has a prerequisite of "
                        + ((IntroJavaCourse) classList.get(i)).getPrerequisites() + " and is "
                        + ((IntroJavaCourse) classList.get(i)).getCredits() + " credits.\n";
            } else if (classList.get(i) instanceof IntroToProgrammingCourse) {
                msg += ((IntroToProgrammingCourse) classList.get(i)).getCourseNumber() + " has no prerequisites and "
                        + ((IntroToProgrammingCourse) classList.get(i)).getCredits() + " credits.\n";

            }
        }
        printme(msg);
    }

    public static void printme(String msg) {
        System.out.println(msg);
    }
}
