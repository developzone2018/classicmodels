
package classicmodels;

import dataconnection.DataConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomersCTL implements ActionListener {

    private CustomersVTA customersVta;

    public CustomersCTL(CustomersVTA customersVta) {
        this.customersVta = customersVta;
        
        iniciar();
        asignarListeners();
    }
    
   private void iniciar(){
       
       customersVta.setLocationRelativeTo(null);
       customersVta.setVisible(true);
       
   }
   
   
   private void asignarListeners(){
       
       customersVta.getAceptar().addActionListener(this);
       customersVta.getCerrar().addActionListener(this);
       
       
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == customersVta.getAceptar()) print();
        if(e.getSource() == customersVta.getCerrar()) close();

    }
    
    private void print(){
        
    
        try {
        
            new JasperPrint(Integer.parseInt(customersVta.getTxtCustomerNumber().getText()), DataConnection.createConnection().getConnection());
       
        
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersCTL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersCTL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
     
    private void close(){
        System.exit(0);
    }
    
}
