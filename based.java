package practica2_2dos;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class based {
    
    private static based base=null;
    static datos [] data;
    static datos [] datosalfinal;
    
    static datos [] ejes = new datos[1];
    static datos [] ejesalfinal = new datos[1];
    
    static datos [] escogio = new datos[1];
    static String rutaescogida="";
    static String nombretabla="";
    static JFreeChart ch;
    static ChartPanel g = new ChartPanel(null);
    
    public based(){
        //SOLO PARA QUE EXISTA
    }
    
    public static based getInstance(){
        if (base==null) {
            base= new based();
        }return base;
    }   
    
    
    
}
