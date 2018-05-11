
package classicmodels;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class JasperPrint {
    
    public JasperPrint(int param, Connection dc) {
    
        try {
            
            Map parameter = new HashMap();
            parameter.put("_customernumber", param);
            
            JasperReport report = JasperCompileManager.compileReport("customers.jrxml");
            
            
            net.sf.jasperreports.engine.JasperPrint jp = JasperFillManager.fillReport(report, parameter, dc);
            
            net.sf.jasperreports.view.JasperViewer viewer = new JasperViewer(jp);
            
            viewer.setSize(850, 700);
            viewer.setLocationRelativeTo(null);
            viewer.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(JasperPrint.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
    
    

    
}
