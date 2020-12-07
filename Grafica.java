package practica2_2dos;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import static practica2_2dos.interfaz.imagenantes;

public class Grafica extends Thread {
    int orden;
    int velocidad;
    int tipoalgoritmo;
    int vel;
    double c1[]=null;
    String c2[]= null;
//    int velmedia;
//    int velrapida;
    
    public Grafica(){
        //Solo pra que exista
    }
    
    public Grafica(int x, int y, int z){
        this.orden=x;
        this.velocidad=y;
        this.tipoalgoritmo=z;
    }
    
    @Override
    public void run(){
        System.out.println();
        try{
            
            while(interfaz.iniciaHilo){

                if (velocidad==1) {
                    vel=1000;
//              
                ejecutarHiloGrafica();

                }else if(velocidad==2){
                    vel=500;
                    ejecutarHiloGrafica();
                }else{
                    vel=100;
                    ejecutarHiloGrafica();
                }
            }
            
            String reporte = "Reporte Graficas.html";
            PrintWriter writer = new PrintWriter(reporte, "UTF-8");
            writer.println("<HTML>");
            writer.println("<BODY style=\"background-color:rgba(255,0,0,0.5);>");
            writer.println("<h3 align= \"center\"> --- REPORTE DE GRAFICAS ---</h3>");
            writer.println("<h3 align= \"center\"> Oscar Daniel Oliva España   ------------    201902663</h3>");
            writer.println("<hr color=\"black\" size=3>");
            
            writer.print("<p> <strong>" +"Algoritmo: &nbsp;&nbsp      </strong> ");
            writer.print( interfaz.espacioscortos.getText()+   interfaz.TipoAlgoritmo.getText()   );
            writer.print( interfaz.espacios.getText()+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp  <strong>  Tiempo: &nbsp;&nbsp    </strong>"   );
            writer.println( interfaz.CronometroenMovimiento.getText()   + "</p>");
            
            writer.print("<p> <strong>" +"Velocidad:&nbsp;&nbsp"+ " </strong>");
            writer.print(   interfaz.Velocidad.getText()   + " ");
            writer.print(" <strong>" +   "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp Pasos:&nbsp;&nbsp"   + " </strong>");
            writer.println(   interfaz.Pasos.getText()   + " </p>");
            
            writer.print("<p> <strong>" +   "Orden:&nbsp;&nbsp"   + " </strong>");
            writer.println(  interfaz.TipoOrdenamiento.getText()  + "</p>");
            
            writer.println("<hr color=\"black\" size=3>");
            
            
            double max = based.getInstance().data[0].getConteo();
            double min = based.getInstance().data[0].getConteo();
            
            String maximo=based.getInstance().data[0].getNombre();
            String minimo=based.getInstance().data[0].getNombre();
            
            
            for (int i = 0; i < based.getInstance().data.length; i++) {
                if (based.getInstance().data[i]==null) {
                    
                }else{
                    if (based.getInstance().data[i].getConteo()>max) {
                        max = based.getInstance().data[i].getConteo();
                        maximo = based.getInstance().data[i].getNombre();
                    }else{
                        
                    }
                }
            }
            
            for (int i = 0; i < based.getInstance().data.length; i++) {
                if (based.getInstance().data[i]==null) {
                    
                }else{
                    if (based.getInstance().data[i].getConteo()<min) {
                        min = based.getInstance().data[i].getConteo();
                        minimo = based.getInstance().data[i].getNombre();
                    }else{
                        
                    }
                }
            }
            writer.print("<h3> Dato Maximo");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");

            writer.print("Dato Minimo</h3>");
            writer.print("<p> <strong>" + maximo + ":&nbsp;&nbsp"  + max+ "");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            writer.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
            
            writer.print(  minimo + ":&nbsp;&nbsp"  + min+ " </strong> </p>");
            
            writer.println("<hr color=\"black\" size=3>");
            
            writer.println("<h3 align= \"center\"> DATOS DESORDENADOS</h3>");
            
            
            
//            
            writer.println("<table>");
            
            System.out.println(based.getInstance().data.length-1);
            
//            for (int i = 0; i < based.getInstance().data.length-1; i++) {
//                if (based.getInstance().data[i]==null) {
//
//                }else{
//                    writer.println("<tr>");
//                    writer.println(based.getInstance().data[i].getNombre()+"l");
//                    for (int j = i; j < based.getInstance().data.length-1; j++) {
//                        writer.println("<th>");
//                        writer.println(based.getInstance().data[j].getConteo()+"l");
//                        writer.println("</th>");
//                        
//                        break;
//                    }
//                    System.out.println("Entro al bueno?");
//                    
//                    writer.println("</tr>");
//
//                    
//                }
//            }
            for (int i = 0; i < based.getInstance().data.length-1; i++) {
                writer.println("<tr>");
                writer.println(based.getInstance().data[i].getNombre()+" | ");
               
                writer.println("</tr>");
            }
            for (int i = 0; i < based.getInstance().data.length-1; i++) {    
                writer.println("<th>");
                writer.println(based.getInstance().data[i].getConteo() +" | ");
             
                writer.println("</th>");    
            }
            writer.println("</table>");
            
            
            writer.println("<img align= \"center\" id=\"PrimeraGrafica\" src=\"PrimeraGrafica.jpg\" alt=\"The Pulpit PrimeraGrafica\" width=\"750\" height=\"750\"  >");

            
            writer.println("<hr color=\"black\" size=3>");
            
            System.out.println("Imprimiendo la segunda imagen");
            System.out.println(c2.length);
            System.out.println(based.getInstance().data.length-1);
            writer.println("<table>");
            
            
            for (int i = 0; i < based.getInstance().data.length-1; i++) {
                writer.println("<tr>");
                writer.println(c2[i]+" | ");
               
                writer.println("</tr>");
            }
            for (int i = 0; i < based.getInstance().data.length-1; i++) {    
                writer.println("<th>");
                writer.println(c1[i]+" | ");
             
                writer.println("</th>");    
            }
            
            writer.println("</table>");
            
            
            
            writer.println("<img align= \"center\" id=\"Grafica\" src=\"Grafica.jpg\" alt=\"The Pulpit Grafica\" width=\"750\" height=\"750\"  >");

            


            
            writer.println("</BODY>");
            writer.println("</HTML");
            writer.close();
            
            
            
            
        }catch(Exception e){
            System.out.println("Exception en el hilo : "+ e.getMessage());
            e.printStackTrace();
        }
        
    }

    private void ejecutarHiloGrafica() {
        try{
//            System.out.println("Entro a ejercutar hilografica");
            if (orden==1) {
    //            System.out.println("Entro al if 1");
                if (tipoalgoritmo==1) {
                    
//                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//                    for (int i = 0; i < based.getInstance().data.length; i++) {
//                        if (based.getInstance().data[i]==null) {
//
//                        }else{
//                            dataset.addValue(based.getInstance().data[i].getConteo(), based.getInstance().data[i].getNombre(), based.getInstance().data[i].getNombre());
//                        }
//                    }
//
//                    JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
//    //                CategoryPlot plot = chart.getCategoryPlot();
//    //
//    //		/* Change Bar colors */
//                    BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
//    //
//                    renderer.setItemMargin(-4);
//                    interfaz.grafico.setChart(chart);
//    //                grafico.repaint(1, 230, 580, 330);
//                    interfaz.grafico.setVisible(true);

                    int tamaño=based.getInstance().data.length;

                    double conteoaux [] = new double [tamaño];
                    String nombreaux [] = new String [tamaño];
                    for (int i = 0; i < conteoaux.length; i++) {
    //                    System.out.println("Entro al for de metida de datos");
                        if (based.getInstance().data[i]!=null) {
    //                                    System.out.println("Entro al if 3");
                            conteoaux[i]=based.getInstance().data[i].getConteo();
                            nombreaux[i]=based.getInstance().data[i].getNombre();
                        }else{

                        }
                    }

                    for (int i = 0; i < conteoaux.length; i++) {
                        for (int j = 0; j < conteoaux.length-1; j++) {
                            if(conteoaux[j]>conteoaux[j+1]) {
                                
                                double auxiliar = conteoaux[j];
                                conteoaux[j]=conteoaux[j+1];
                                conteoaux[j+1]=auxiliar;
                                
                                String auxiliarnombre = nombreaux[j];
                                nombreaux[j]=nombreaux[j+1];
                                nombreaux[j+1]=auxiliarnombre;
                                
//                                based.getInstance().data[j]= new datos(nombreaux[j+1],conteoaux[j+1]);
//                                based.getInstance().data[j+1] = new datos(auxiliarnombre,auxiliar);

//                                based.getInstance().data[j]= new datos(nombreaux[j],conteoaux[j]);
//                                based.getInstance().data[j+1] = new datos(nombreaux[j+1],conteoaux[j+1]);

                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                                for (int k = 0; k < based.getInstance().data.length; k++) {
                                    if (nombreaux[k]==null/*based.getInstance().data[k]==null*/) {

                                    }else{
                                        dataset.addValue(conteoaux[k], nombreaux[k], nombreaux[k]);
//                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
                                    }
                                }

                                JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
                //                CategoryPlot plot = chart.getCategoryPlot();
                //
                //		/* Change Bar colors */
                                BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                //
                                renderer.setItemMargin(-10);
                                renderer.setSeriesPaint(0, Color.CYAN);
                                interfaz.grafico.setChart(chart);
                //                grafico.repaint(1, 230, 580, 330);
                                interfaz.grafico.setVisible(true);
                                
                                interfaz.contarpasos++;
                                
                                System.out.println(interfaz.contarpasos);
                                String meterpasos=""+interfaz.contarpasos;
                                interfaz.Pasos.setText(meterpasos);
                                
                                Thread.sleep(vel);
                                interfaz.imagendespues = chart.createBufferedImage(600, 600);
                                
                                try {
                                    ImageIO.write(interfaz.imagendespues, "jpg", new File("Grafica.jpg"));
                                } catch (IOException e) {
                                   System.out.println("Error de escritura");
                                }
                                
                                c1=conteoaux;
                                c2=nombreaux;

                            }else{
                                continue;
                            }
                            
                        }
//                        System.out.println(" Entro al for de ordenmaiento");
//                        if (conteoaux[i]!=0) {
////                            System.out.println("Entro al if 3");
////                            for (int j = (i+1); j < conteoaux.length; j++) {
////    //                            System.out.println("entro al for para ver si entra al if");
////                                if (conteoaux[j]>conteoaux[maximo]){
//////                                    System.out.println("cambioa a maximo");
////                                    maximo=j;
////                                }
////                            }
//
//
//                            
//
////                        double auxiliar = conteoaux[i];
////                        String auxiliarnombre = nombreaux[i];
////
////                        conteoaux[i]=conteoaux[maximo];
////                        conteoaux[maximo]=auxiliar;
////
////                        nombreaux[i]=nombreaux[maximo];
////                        nombreaux[maximo]=auxiliarnombre;
////
////                        based.getInstance().data[i]= new datos(nombreaux[i],conteoaux[i]);
////                        based.getInstance().data[maximo] = new datos(nombreaux[maximo],conteoaux[maximo]);
////
////                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
////
////                        for (int j = 0; j < based.getInstance().data.length; j++) {
////                            if (based.getInstance().data[j]==null) {
////
////                            }else{
////                                dataset.addValue(based.getInstance().data[j].getConteo(), based.getInstance().data[j].getNombre(), based.getInstance().data[j].getNombre());
////                            }
////                        }
////
////                        JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
////        //                CategoryPlot plot = chart.getCategoryPlot();
////        //
////        //		/* Change Bar colors */
////                        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
////        //
////                        renderer.setItemMargin(-4);
////                        interfaz.grafico.setChart(chart);
////        //                grafico.repaint(1, 230, 580, 330);
////                        interfaz.grafico.setVisible(true);
////                        Thread.sleep(vel);
//
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//                        
//////                            System.out.println("Ya va a hacer la grafica");
////                        DefaultCategoryDataset datos = new DefaultCategoryDataset();
////
////                        for (int k = 0; k < based.getInstance().data.length; k++) {
////                            if(based.getInstance().data[i]==null){
////
////                            }else{
////                                datos.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), "DATOS");
////                            }
////                        }
////
////                        JFreeChart chara = ChartFactory.createBarChart(based.getInstance().nombretabla, based.getInstance().ejes[0].getX(), based.getInstance().ejes[0].getY(), datos, PlotOrientation.VERTICAL,true,true,false);
////
//////                            interfaz.grafico.repaint();
////                        interfaz.grafico.setChart(chara);
////                        interfaz.grafico.setVisible(true);
//
////                        interfaz.contarpasos++;
////                        System.out.println(interfaz.contarpasos);
////                        String meterpasos=""+interfaz.contarpasos;
////                        interfaz.Pasos.setText(meterpasos);
//
//
////                            System.out.println("");
////                            System.out.println("");
////    //                        System.out.println("Esta cambiando los datos");
////                            System.out.print(based.getInstance().data[i].getNombre());
////                            System.out.print(based.getInstance().data[i].getConteo());
////                            System.out.println("");
////                            System.out.println("");
////                        System.out.println("Ya cambio los datos");
////                        hacergrafica();
//
//                        }
                    }
                    
                    
                    

                        interfaz.iniciaHilo=false;
//                        interfaz.contarpasos=0;
//                        interfaz.milisegundo=0;
//                        interfaz.segundo=0;
//                        interfaz.minuto=0;

                

                }else if(tipoalgoritmo==2){
                    
                    int tamaño=based.getInstance().data.length;

                    double conteoaux [] = new double [tamaño];
                    String nombreaux [] = new String [tamaño];
                    
                    for (int i = 0; i < conteoaux.length; i++) {
                        if (based.getInstance().data[i]!=null) {
                            conteoaux[i]=based.getInstance().data[i].getConteo();
                            nombreaux[i]=based.getInstance().data[i].getNombre();
                        }else{

                        }
                    }
                    conteoaux=quicksortint(conteoaux, nombreaux);
                    
                    interfaz.iniciaHilo=false;

                }else{
                    
                    int tamaño=based.getInstance().data.length;

                    double conteoaux [] = new double [tamaño];
                    String nombreaux [] = new String [tamaño];
                    
                    for (int i = 0; i < conteoaux.length; i++) {
                        if (based.getInstance().data[i]!=null) {
                            conteoaux[i]=based.getInstance().data[i].getConteo();
                            nombreaux[i]=based.getInstance().data[i].getNombre();
                        }else{

                        }
                    }
                    
                    int salto,j,k;
                    double aux;
                    String auxnombre;
                    salto=tamaño/2;
                    while(salto>0){
                        for (int i = 0; i < conteoaux.length; i++) {
                            j=i-salto;
                            while(j>=0){
                                k=j+salto;
                                if (conteoaux[j]<=conteoaux[k]) {
                                    j=-1;
                                }else{
                                    aux=conteoaux[j];
                                    conteoaux[j]=conteoaux[k];
                                    conteoaux[k]=aux;

                                    auxnombre=nombreaux[j];
                                    nombreaux[j]=nombreaux[k];
                                    nombreaux[k]=auxnombre;
                                    
                                    
                                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                                for (int l = 0; l < based.getInstance().data.length; l++) {
                                    if (nombreaux[l]==null/*based.getInstance().data[k]==null*/) {

                                    }else{
                                        dataset.addValue(conteoaux[l], nombreaux[l], nombreaux[l]);
//                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
                                    }
                                }

                                JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
                //                CategoryPlot plot = chart.getCategoryPlot();
                //
                //		/* Change Bar colors */
                                BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                //
                                renderer.setItemMargin(-10);
                                renderer.setSeriesPaint(0, Color.CYAN);
                                interfaz.grafico.setChart(chart);
                //                grafico.repaint(1, 230, 580, 330);
                                interfaz.grafico.setVisible(true);
                                
                                interfaz.contarpasos++;
                                
                                System.out.println(interfaz.contarpasos);
                                String meterpasos=""+interfaz.contarpasos;
                                interfaz.Pasos.setText(meterpasos);
                                
                                Thread.sleep(vel);
                                interfaz.imagendespues = chart.createBufferedImage(600, 600);
                                
                                try {
                                    ImageIO.write(interfaz.imagendespues, "jpg", new File("Grafica.jpg"));
                                } catch (IOException e) {
                                   System.out.println("Error de escritura");
                                }
                                
                                c1=conteoaux;
                                c2=nombreaux;
                                    
                                    
                                    j-=salto;
                                }
                            }
                        }
                        salto=salto/2;
                    }
                    
                    interfaz.iniciaHilo=false;
                }
            }else{
                if (tipoalgoritmo==1) {
                    int tamaño=based.getInstance().data.length;

                    double conteoaux [] = new double [tamaño];
                    String nombreaux [] = new String [tamaño];
                    for (int i = 0; i < conteoaux.length; i++) {
                        if (based.getInstance().data[i]!=null) {
                            conteoaux[i]=based.getInstance().data[i].getConteo();
                            nombreaux[i]=based.getInstance().data[i].getNombre();
                        }else{

                        }
                    }    
                    for (int i = 0; i < conteoaux.length; i++) {
                        for (int j = 0; j < conteoaux.length-1; j++) {
                            if(conteoaux[j]<conteoaux[j+1]) {
                                
                                double auxiliar = conteoaux[j];
                                conteoaux[j]=conteoaux[j+1];
                                conteoaux[j+1]=auxiliar;
                                
                                String auxiliarnombre = nombreaux[j];
                                nombreaux[j]=nombreaux[j+1];
                                nombreaux[j+1]=auxiliarnombre;
                                
//                                based.getInstance().data[j]= new datos(nombreaux[j+1],conteoaux[j+1]);
//                                based.getInstance().data[j+1] = new datos(auxiliarnombre,auxiliar);

//                                based.getInstance().data[j]= new datos(nombreaux[j],conteoaux[j]);
//                                based.getInstance().data[j+1] = new datos(nombreaux[j+1],conteoaux[j+1]);

                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                                for (int k = 0; k < based.getInstance().data.length; k++) {
                                    if (nombreaux[k]==null/*based.getInstance().data[k]==null*/) {

                                    }else{
                                        dataset.addValue(conteoaux[k], nombreaux[k], nombreaux[k]);
//                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
                                    }
                                }

                                JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
                //                CategoryPlot plot = chart.getCategoryPlot();
                //
                //		/* Change Bar colors */
                                BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                //
                                renderer.setItemMargin(-10);
                                renderer.setSeriesPaint(0, Color.CYAN);
                                interfaz.grafico.setChart(chart);
                //                grafico.repaint(1, 230, 580, 330);
                                interfaz.grafico.setVisible(true);
                                
                                interfaz.contarpasos++;
                                
                                System.out.println(interfaz.contarpasos);
                                String meterpasos=""+interfaz.contarpasos;
                                interfaz.Pasos.setText(meterpasos);
                                
                                Thread.sleep(vel);
                                interfaz.imagendespues = chart.createBufferedImage(600, 600);
                                
                                try {
                                    ImageIO.write(interfaz.imagendespues, "jpg", new File("Grafica.jpg"));
                                } catch (IOException e) {
                                   System.out.println("Error de escritura");
                                }
                                
                                c1=conteoaux;
                                c2=nombreaux;

                            }else{
                                continue;
                            }
                            
                        }    
                        
                        
                        
                    }
                    interfaz.iniciaHilo=false;



                }else if(tipoalgoritmo==2){
                    
                    int tamaño=based.getInstance().data.length;

                    double conteoaux [] = new double [tamaño];
                    String nombreaux [] = new String [tamaño];
                    
                    for (int i = 0; i < conteoaux.length; i++) {
                        if (based.getInstance().data[i]!=null) {
                            conteoaux[i]=based.getInstance().data[i].getConteo();
                            nombreaux[i]=based.getInstance().data[i].getNombre();
                        }else{

                        }
                    }
                    
                    conteoaux = quicksortdint(conteoaux, nombreaux);
                    //////
                    //////
                    //////
                    //////
                    //////
                    //////
                    //////
                    //////
                    //////
                    //////
                    interfaz.iniciaHilo=false;

                }else{
                    
                    int tamaño=based.getInstance().data.length;

                    double conteoaux [] = new double [tamaño];
                    String nombreaux [] = new String [tamaño];
                    
                    for (int i = 0; i < conteoaux.length; i++) {
                        if (based.getInstance().data[i]!=null) {
                            conteoaux[i]=based.getInstance().data[i].getConteo();
                            nombreaux[i]=based.getInstance().data[i].getNombre();
                        }else{

                        }
                    }
                    
                    int salto,j,k;
                    double aux;
                    String auxnombre;
                    salto=tamaño/2;
                    while(salto>0){
                        for (int i = 0; i < conteoaux.length; i++) {
                            j=i-salto;
                            while(j>=0){
                                k=j+salto;
                                if (conteoaux[j]-1>=conteoaux[k]-1) {
                                    j=-1;
                                }else{
                                    aux=conteoaux[j];
                                    conteoaux[j]=conteoaux[k];
                                    conteoaux[k]=aux;

                                    auxnombre=nombreaux[j];
                                    nombreaux[j]=nombreaux[k];
                                    nombreaux[k]=auxnombre;
                                    
                                    
                                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                                for (int l = 0; l < based.getInstance().data.length; l++) {
                                    if (nombreaux[l]==null/*based.getInstance().data[k]==null*/) {

                                    }else{
                                        dataset.addValue(conteoaux[l], nombreaux[l], nombreaux[l]);
//                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
                                    }
                                }

                                JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
                //                CategoryPlot plot = chart.getCategoryPlot();
                //
                //		/* Change Bar colors */
                                BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                //
                                renderer.setItemMargin(-10);
                                renderer.setSeriesPaint(0, Color.CYAN);
                                interfaz.grafico.setChart(chart);
                //                grafico.repaint(1, 230, 580, 330);
                                interfaz.grafico.setVisible(true);
                                
                                interfaz.contarpasos++;
                                
                                System.out.println(interfaz.contarpasos);
                                String meterpasos=""+interfaz.contarpasos;
                                interfaz.Pasos.setText(meterpasos);
                                
                                Thread.sleep(vel);
                                
                                interfaz.imagendespues = chart.createBufferedImage(600, 600);
                                
                                try {
                                    ImageIO.write(interfaz.imagendespues, "jpg", new File("Grafica.jpg"));
                                } catch (IOException e) {
                                   System.out.println("Error de escritura");
                                }
                                
                                
                                c1=conteoaux;
                                c2=nombreaux;
                                    
                                    
                                    j-=salto;
                                }
                            }
                        }
                        salto=salto/2;
                    }
                        
                    interfaz.iniciaHilo=false;

                }
            }
            
    }catch(Exception e){
}    


        
    }

    public double[] quicksortint(double[] conteoaux,String[]nombreaux) {
        System.out.println("Entro al metodo?");
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        for (int k = 0; k < based.getInstance().data.length; k++) {
//            if (nombreaux[k]==null/*based.getInstance().data[k]==null*/) {
//
//            }else{
//                dataset.addValue(conteoaux[k], nombreaux[k], nombreaux[k]);
////                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
//            }
//        }
//
//        JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
////                CategoryPlot plot = chart.getCategoryPlot();
////
////		/* Change Bar colors */
//        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
////
//        renderer.setItemMargin(-4);
//        renderer.setSeriesPaint(0, Color.CYAN);
//        interfaz.grafico.setChart(chart);
//        interfaz.grafico.repaint(1, 230, 580, 330);
//        interfaz.grafico.setVisible(true);
//
//        interfaz.contarpasos++;
//
//        System.out.println(interfaz.contarpasos);
//        String meterpasos=""+interfaz.contarpasos;
//        interfaz.Pasos.setText(meterpasos);
//                                
//        try {
//            Thread.sleep(vel);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        return quicksortint1(conteoaux,0,conteoaux.length-1, nombreaux);
    }


    private double[] quicksortint1(double[] conteoaux, int izquierda, int derecha, String[]nombreaux) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int k = 0; k < based.getInstance().data.length; k++) {
            if (nombreaux[k]==null/*based.getInstance().data[k]==null*/) {

            }else{
                dataset.addValue(conteoaux[k], nombreaux[k], nombreaux[k]);
//                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
//                CategoryPlot plot = chart.getCategoryPlot();
//
//		/* Change Bar colors */
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
//
        renderer.setItemMargin(-10);
        renderer.setSeriesPaint(0, Color.CYAN);
        interfaz.grafico.setChart(chart);
        interfaz.grafico.repaint(1, 230, 580, 330);
        interfaz.grafico.setVisible(true);

        interfaz.contarpasos++;

        System.out.println(interfaz.contarpasos);
        String meterpasos=""+interfaz.contarpasos;
        interfaz.Pasos.setText(meterpasos);
                                
        try {
            Thread.sleep(vel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        interfaz.imagendespues = chart.createBufferedImage(600, 600);
                                
        try {
            ImageIO.write(interfaz.imagendespues, "jpg", new File("Grafica.jpg"));
        } catch (IOException e) {
           System.out.println("Error de escritura");
        }

        c1=conteoaux;
        c2=nombreaux;

        if (izquierda>=derecha) 
//             int i=izq;
//            int d =der;
            return conteoaux;
            int i=izquierda;
            int d =derecha;
        if (izquierda !=derecha) {
            int pivote=izquierda;
            double aux;
            String nomaux;
            while(izquierda!=derecha){
                while(conteoaux[derecha]>=conteoaux[pivote]&& izquierda<derecha)
                    derecha--;
                while(conteoaux[izquierda]<conteoaux[pivote]&& izquierda<derecha)
                    izquierda++;
                    if (derecha!=izquierda) {
                       aux = conteoaux[derecha];
                       conteoaux[derecha] = conteoaux [izquierda];
                       conteoaux[izquierda] = aux;
                       
                       nomaux=nombreaux[derecha];
                       nombreaux[derecha] = nombreaux [izquierda];
                       nombreaux[izquierda] = nomaux;
                       
                    }
                    if (izquierda == derecha) {
                        quicksortint1(conteoaux,i,izquierda-1,nombreaux);
                        quicksortint1(conteoaux, izquierda+1, d,nombreaux);
                    }
            }
            
            return conteoaux;
        }
        return conteoaux;
        
    }

    private double[] quicksortdint(double[] conteoaux, String[] nombreaux) {
        return quicksortdint1(conteoaux, 0, conteoaux.length-1,nombreaux);
    }

    private double[] quicksortdint1(double[] conteoaux, int primero, int ultimo, String[] nombreaux) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int k = 0; k < based.getInstance().data.length; k++) {
            if (nombreaux[k]==null/*based.getInstance().data[k]==null*/) {

            }else{
                dataset.addValue(conteoaux[k], nombreaux[k], nombreaux[k]);
//                                        dataset.addValue(based.getInstance().data[k].getConteo(), based.getInstance().data[k].getNombre(), based.getInstance().data[k].getNombre());
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,true,true,false);
//                CategoryPlot plot = chart.getCategoryPlot();
//
//		/* Change Bar colors */
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
//
        renderer.setItemMargin(-10);
        renderer.setSeriesPaint(0, Color.CYAN);
        interfaz.grafico.setChart(chart);
        interfaz.grafico.repaint(1, 230, 580, 330);
        interfaz.grafico.setVisible(true);

        interfaz.contarpasos++;

        System.out.println(interfaz.contarpasos);
        String meterpasos=""+interfaz.contarpasos;
        interfaz.Pasos.setText(meterpasos);
                                
        try {
            Thread.sleep(vel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        interfaz.imagendespues = chart.createBufferedImage(600, 600);
                                
        try {
            ImageIO.write(interfaz.imagendespues, "jpg", new File("Grafica.jpg"));
        } catch (IOException e) {
           System.out.println("Error de escritura");
        }
        
        c1=conteoaux;
        c2=nombreaux;
        
        
        double pivote=conteoaux[(primero+ultimo)/2];
        
        int i=primero;
        int j=ultimo;
        double aux;
        String nomaux;
        
        do{
            while(conteoaux[i]>pivote){
                i++;
            }
            while(conteoaux[j]<pivote){
                j--;
            }
            
            if (i<=j) {
                aux=conteoaux[i];
                conteoaux[i]=conteoaux[j];
                conteoaux[j]=aux;
                
                nomaux=nombreaux[i];
                nombreaux[i]=nombreaux[j];
                nombreaux[j]=nomaux;
                
                i++;
                j--;
            }
        }while(i<=j);
        
        if (primero<j) {
            quicksortdint1(conteoaux,primero,j,nombreaux);
        }
        
        if (i<ultimo) {
            quicksortdint1(conteoaux,i,ultimo,nombreaux);
        }
        
        
        
//        if (primero>=ultimo) 
//            return conteoaux;
//            int i=primero;
//            int d =ultimo;
//        if (primero !=ultimo) {
//            int pivote=primero;
//            double aux;
//            String nomaux;
//            while(primero!=ultimo){
//                while(conteoaux[ultimo]-1<=conteoaux[pivote]-1&& primero<ultimo)
//                    ultimo--;
//                while(conteoaux[primero]-1>conteoaux[pivote]-1&& primero<ultimo)
//                    primero++;
//                    if (ultimo!=primero) {
//                       aux = conteoaux[ultimo];
//                       conteoaux[ultimo] = conteoaux [primero];
//                       conteoaux[primero] = aux;
//                       
//                       nomaux=nombreaux[ultimo];
//                       nombreaux[ultimo] = nombreaux [primero];
//                       nombreaux[primero] = nomaux;
//                       
//                    }
//                    if (primero == ultimo) {
//                        quicksortint1(conteoaux,i,primero-1,nombreaux);
//                        quicksortint1(conteoaux, primero+1, d,nombreaux);
//                    }
//            }
//            
//            return conteoaux;
//        }
//        return conteoaux;
        return null;
    }

}
