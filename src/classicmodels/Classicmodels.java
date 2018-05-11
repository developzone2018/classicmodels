
package classicmodels;

import java.awt.EventQueue;


public class Classicmodels {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
         
                new CustomersCTL(new CustomersVTA());
            
            }
        });


    }
    
}
