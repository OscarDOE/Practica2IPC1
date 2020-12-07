package practica2_2dos;

import static practica2_2dos.interfaz.CronometroenMovimiento;

public class Cronometro extends Thread{
    
    public Cronometro(){
        //Solo para que exista
    }
    
    @Override
    public void run(){
        try{
            int x=0;
            
            while(interfaz.iniciaHilo){
                Thread.sleep(1);
//                System.out.println(x);
                ejecutareHiloCronometro(x);
                x++;
            }
            
        }catch(Exception e){
//            System.out.println("Exception en el hilo : "+ e.getMessage());
            e.printStackTrace();
        }
    }

    private void ejecutareHiloCronometro(int x) {
//        System.out.println(x+" - "+Thread.currentThread().getName());
        interfaz.milisegundo++;
        
        if (interfaz.milisegundo>999) {
            interfaz.milisegundo=0;
            interfaz.segundo++;
            if (interfaz.segundo>59) {
                interfaz.segundo=0;
                interfaz.minuto++;
            }
        }
        String textmili="", textsegu="",textminu="";
        
        if (interfaz.milisegundo<10) {
            textmili="00"+interfaz.milisegundo;
        }else if (interfaz.milisegundo<100){
            textmili="0"+interfaz.milisegundo;
        }else{
            textmili=""+interfaz.milisegundo;
        }
        
        if (interfaz.segundo<10) {
            textsegu="0"+interfaz.segundo;
        }else {
            textsegu=""+interfaz.segundo;
        }
        
        if (interfaz.minuto<10) {
            textminu="0"+interfaz.minuto;
        }else {
            textminu=""+interfaz.minuto;
        }
        
        
        String reloj = textminu+":"+textsegu+":"+textmili;
        
        interfaz.CronometroenMovimiento.setText(reloj);

        
        
        
    }
}
