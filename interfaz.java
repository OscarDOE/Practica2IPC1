package practica2_2dos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class interfaz extends JFrame{
    Validaciondedatos valuso = new Validaciondedatos();
    datos uso = new datos();
    static JLabel CronometroenMovimiento= new JLabel();
    static JLabel TipoOrdenamiento= new JLabel();
    static JLabel Velocidad= new JLabel();
    static JLabel TipoAlgoritmo= new JLabel();
    static JLabel Pasos= new JLabel();
    static JLabel tCronometroenMovimiento= new JLabel();
    static JLabel tTipoOrdenamiento= new JLabel();
    static JLabel tVelocidad= new JLabel();
    static JLabel tOrden= new JLabel();
    static JLabel tPasos= new JLabel();
    
    
    
    static boolean iniciaHilo=false; 
    static int minuto=0,segundo=0,milisegundo=0;
    
    static int x;
    static int y;
    static int z;
    
    
    static int contarpasos=0;
    static ChartPanel grafico= new ChartPanel(null);
    
    
    static BufferedImage imagenantes;
    static BufferedImage imagendespues;

    
    
    static JLabel espacioscortos = new JLabel("     ");
    static JLabel espacios = new JLabel("                         ");
    
    
    public interfaz (){
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proceso de Datos");
        setLocationRelativeTo(null);        
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);  
        
        grafico.setBackground(Color.green);
        grafico.setBounds(1,230 , 780, 530);
        panel.add(grafico);  
        grafico.setVisible(false);
//        
        
        
        //--------------------------
       //Empiezan los que aparecen al ejecutarse
       //Se ponen en visible false, para ponerlos true despues

        CronometroenMovimiento.setText("00:00:000");
        CronometroenMovimiento.setFont(new Font("arial",Font.PLAIN,12));
        CronometroenMovimiento.setBounds(390,120,150,75 );
        panel.add(CronometroenMovimiento);
        CronometroenMovimiento.setVisible(false);

        TipoOrdenamiento.setText("------");
        TipoOrdenamiento.setFont(new Font("arial",Font.PLAIN,12));
        TipoOrdenamiento.setBounds(90,120,150,75 );
        panel.add(TipoOrdenamiento);
        TipoOrdenamiento.setVisible(false);

        Velocidad.setText("-------");
        Velocidad.setFont(new Font("arial",Font.PLAIN,12));
        Velocidad.setBounds(90,150,150,75 );
        panel.add(Velocidad);
        Velocidad.setVisible(false);

        TipoAlgoritmo.setText("------");
        TipoAlgoritmo.setFont(new Font("arial",Font.PLAIN,12));
        TipoAlgoritmo.setBounds(80,180,150,75 );
        panel.add(TipoAlgoritmo);
        TipoAlgoritmo.setVisible(false);

        Pasos.setText("------");
        Pasos.setFont(new Font("arial",Font.PLAIN,12));
        Pasos.setBounds(380,150,150,75 );
        panel.add(Pasos);
        Pasos.setVisible(false);

//Solo los titulos de los labels
//Se ponen en visible false, para ponerlos true despues
        tCronometroenMovimiento.setText("Tiempo: ");
        tCronometroenMovimiento.setFont(new Font("arial",Font.BOLD,12));
        tCronometroenMovimiento.setBounds(330,120,150,75 );
        panel.add(tCronometroenMovimiento);
        tCronometroenMovimiento.setVisible(false);

        tTipoOrdenamiento.setText("Algoritmo: ");
        tTipoOrdenamiento.setFont(new Font("arial",Font.BOLD,12));
        tTipoOrdenamiento.setBounds(10,120,150,75 );
        panel.add(tTipoOrdenamiento);
        tTipoOrdenamiento.setVisible(false);

        tVelocidad.setText("Velocidad: ");
        tVelocidad.setFont(new Font("arial",Font.BOLD,12));
        tVelocidad.setBounds(10,150,150,75 );
        panel.add(tVelocidad);
        tVelocidad.setVisible(false);

        tOrden.setText("Orden: ");
        tOrden.setFont(new Font("arial",Font.BOLD,12));
        tOrden.setBounds(10,180,150,75 );
        panel.add(tOrden);
        tOrden.setVisible(false);

        tPasos.setText("Pasos: ");
        tPasos.setFont(new Font("arial",Font.BOLD,12));
        tPasos.setBounds(330,150,150,75 );
        panel.add(tPasos);
        tPasos.setVisible(false);

//---------------
//Terminan los que aparecen al ejecutarse
        
        JLabel route = new JLabel("Ruta del Archivo");
        route.setFont(new Font("arial",Font.PLAIN,15));
        route.setBounds(125,10,150,75 );
        panel.add(route);
        
        JTextField nomar = new JTextField();
        nomar.setBounds(120, 60, 400, 20);
        panel.add(nomar);     
        
        JButton boton1 = new JButton("Buscar");////////////////////////////////////////////////        
        boton1.setFont(new Font("arial",Font.CENTER_BASELINE,15));
        boton1.setForeground(Color.blue);
        boton1.setBounds(550, 60, 120, 20);
        panel.add(boton1);
        
        JLabel title = new JLabel("Título de Gráfica");
        title.setFont(new Font("arial",Font.PLAIN,15));
        title.setBounds(125,70,150,75 );
        panel.add(title);

        JTextField nomgraf = new JTextField();
        nomgraf.setBounds(120, 120, 400, 20);
        panel.add(nomgraf);     
        
        JButton boton2 = new JButton("Aceptar");////////////////////////////////////////////////        
        boton2.setFont(new Font("arial",Font.CENTER_BASELINE,15));
        boton2.setForeground(Color.blue);
        boton2.setBounds(550, 120, 120, 20);
        panel.add(boton2);
        
        if (based.getInstance().rutaescogida.equals("")) {
            System.out.println("Es diferente");
        }else{
            nomar.setText(based.getInstance().rutaescogida);
        }
        
        if (based.getInstance().nombretabla.equals("")) {
            System.out.println("Es diferente");
        }else{
            nomgraf.setText(based.getInstance().nombretabla);
        }
        
        if (based.getInstance().ch==null) {
            System.out.println("Es diferente");
        }else{
            grafico.setChart(based.getInstance().ch);
            grafico.setVisible(true);
        }
        
        
        
        
        ActionListener boto = (ActionEvent ae)->{
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(fc);
            String narchivo="";
            if (op==JFileChooser.APPROVE_OPTION) {
                System.out.println(fc.getSelectedFile());
                narchivo=fc.getSelectedFile().toString();
            }else{
                System.out.println("Hola, no supe como hacerlo");
            }
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto","csv","txt");
            fc.setFileFilter(filtro);
            
            nomar.setText(narchivo);
            based.getInstance().rutaescogida=narchivo;
                            
            try{
                File archivo = fc.getSelectedFile();
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                 
                String lineap;
                int lala =0;
                while((lineap=br.readLine())!=null){
                    lala++;
                    
                }
                System.out.println(lala);
                based.getInstance().data= new datos[lala];
                based.getInstance().datosalfinal= new datos[lala];
                
            }catch(Exception er){
                er.printStackTrace();
            }

            try{
                
                File archivo = fc.getSelectedFile();
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                
                int zero = 0;
                
                String linea;
                while((linea=br.readLine())!=null){
                    
                    if (zero==0) {
                        String []delineado = linea.split(",");
                        String ejex=delineado[0];
                        String ejey=delineado[1];
                        based.getInstance().ejes[0]= new datos(ejex,ejey);
                        based.getInstance().ejesalfinal[0]= new datos(ejex,ejey);
                        
                        zero++;
                        
                    }else{
//                        System.out.println("entro a ver si zero es distinto?");
                        if (uso.metodatos(based.getInstance().data)) {
//                            System.out.println("llego a datos?");
                            int pos = uso.leerdatos(based.getInstance().data);
                            String []delineado = linea.split(",");
                            String nombres=delineado[0];
                            double conteo=Double.parseDouble(delineado[1]);
                            based.getInstance().data[pos]= new datos(nombres, conteo);
                            based.getInstance().datosalfinal[pos]= new datos(nombres, conteo);
//                            System.out.println("Imprimiendo los datos metidos");
                            System.out.print(based.getInstance().data[pos].getNombre());
                            System.out.print(based.getInstance().data[pos].getConteo());
                            System.out.println("");
                            zero++;
                        }
                    }
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }

            if (based.getInstance().data!=null) {
                System.out.println("Esta creando grafica");
 
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                
                for (int i = 0; i < based.getInstance().data.length; i++) {
                    if (based.getInstance().data[i]==null) {

                    }else{
                        dataset.addValue(based.getInstance().data[i].getConteo(), based.getInstance().data[i].getNombre(), based.getInstance().data[i].getNombre());
                    }
                }
                based.getInstance().nombretabla=nomgraf.getText();
                
                JFreeChart chart = ChartFactory.createBarChart(based.getInstance().nombretabla,based.getInstance().ejes[0].getX() ,based.getInstance().ejes[0].getY() ,dataset, PlotOrientation.VERTICAL,false,false,false);
//                CategoryPlot plot = chart.getCategoryPlot();
//
//		/* Change Bar colors */
		BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
//
                renderer.setItemMargin(-10);
                renderer.setSeriesPaint(0, Color.CYAN);
                
//		renderer.setSeriesPaint(0, Color.red);
//
//		renderer.setDrawBarOutline(true);
//		renderer.setItemMargin(-4);
                grafico.setChart(chart);
//                grafico.repaint(1, 230, 580, 330);
                grafico.setVisible(true);
                
                based.getInstance().ch=chart;
////                based.getInstance().g.setChart(chart);
//                BufferedImage imagen = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                imagenantes = chart.createBufferedImage(600, 600);
                try {
                    ImageIO.write(imagenantes, "jpg", new File("PrimeraGrafica.jpg"));
                } catch (IOException e) {
                   System.out.println("Error de escritura");
                }
                
                



            }else{
                
            }
        };
        boton1.addActionListener(boto);
        
        ActionListener boto1 = (ActionEvent ae)->{
            if (nomgraf.getText().equals("")) {
                
            }else{
                based.getInstance().nombretabla=nomgraf.getText();
            }
            valuso.setVisible(true);
            this.dispose();
        };
        boton2.addActionListener(boto1);
        
        //Iniciando el Hilo
        if (iniciaHilo==true) {
            System.out.println("hola");
            contarpasos=0;
            milisegundo=0;
            segundo=0;
            minuto=0;
            Cronometro micro = new Cronometro();
            micro.start();
            CronometroenMovimiento.setVisible(true);
            TipoOrdenamiento.setVisible(true);
            if (based.getInstance().escogio[0].getTior()==1) {
                TipoOrdenamiento.setText("Ascendente");
            }else{
                TipoOrdenamiento.setText("Descendente");
            }
            
            Velocidad.setVisible(true);
            if (based.getInstance().escogio[0].getVelor()==1) {
                Velocidad.setText("Baja");
            }else if(based.getInstance().escogio[0].getVelor()==2){
                Velocidad.setText("Media");
            }else{
                Velocidad.setText("Alta");
            }
            
            TipoAlgoritmo.setVisible(true);
            if (based.getInstance().escogio[0].getAlgoror()==1) {
                TipoAlgoritmo.setText("BubbleSort");
                
            }else if(based.getInstance().escogio[0].getAlgoror()==2){
                TipoAlgoritmo.setText("QuickSort");
            }else{
                TipoAlgoritmo.setText("ShellSort");
            }
            Pasos.setVisible(true);
            
            tCronometroenMovimiento.setVisible(true);
            tTipoOrdenamiento.setVisible(true);
            tVelocidad.setVisible(true);
            tOrden.setVisible(true);
            tPasos.setVisible(true);
            
            Grafica graph = new Grafica(x,y,z);
            graph.start();

            
            
        }
        
        
        
    }

    
    
    
}
