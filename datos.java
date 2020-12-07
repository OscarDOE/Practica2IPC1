package practica2_2dos;

public class datos {
    private String nombre;
    private double conteo;
    private String X;
    private String Y;
    private int tior;
    private int velor;
    private int algoror;
    
    
    
    public datos(){
        //SOLO PARA QUE EXISTA
    }

    public datos(String nom, double cont) {
        this.nombre = nom;
        this.conteo = cont;
    }
    
    public datos(String x, String y) {
        this.X = x;
        this.Y = y;
    }
    
    public datos(int tipo, int velo, int algor){
        this.tior = tipo;
        this.velor = velo;
        this.algoror = algor;
    }
    
    public boolean metodatos(datos[] dara){
        for (int i = 0; i < dara.length; i++) {
            if (dara[i]!=null) {
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
    
    public int leerdatos(datos[] dara) {
        int a=0;
        for (int i = 0; i < dara.length; i++) {
            if (dara[i]==null) {
                a=i++;
                break;
            }else if(dara[i]!=null){
                a++;
            }
        }
        return a;
    }
    

    public String getNombre() {
        return nombre;
    }
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getConteo() {
        return conteo;
    }
    
    public void setConteo(double conteo) {
        this.conteo = conteo;
    }

    public String getX() {
        return X;
    }

    public void setX(String X) {
        this.X = X;
    }

    public String getY() {
        return Y;
    }

    public void setY(String Y) {
        this.Y = Y;
    }

    
    
    
    //Los valores de los ordenamientos

    public int getTior() {
        return tior;
    }


    public void setTior(int tior) {
        this.tior = tior;
    }


    public int getVelor() {
        return velor;
    }


    public void setVelor(int velor) {
        this.velor = velor;
    }

    
    public int getAlgoror() {
        return algoror;
    }


    public void setAlgoror(int algoror) {
        this.algoror = algoror;
    }

   
    
    
    
    
}
