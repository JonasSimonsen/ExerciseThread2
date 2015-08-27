/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author jonassimonsen
 */
public class TesterClass {

    public void Tester(String url1, String url2, String url3) throws InterruptedException {
        ThreadClass tc1 = new ThreadClass(url1);
        ThreadClass tc2 = new ThreadClass(url2);
        ThreadClass tc3 = new ThreadClass(url3);

    long start = System.nanoTime(); 
        tc1.run();
        tc2.run();
        tc3.run();

        tc1.join();
        tc2.join();
        tc3.join();
        long end = System.nanoTime();
        System.out.println("Time Sequental: " + (end - start));

        int sum = tc1.getSize() + tc2.getSize() + tc3.getSize();

        System.out.println(sum);
    }
}