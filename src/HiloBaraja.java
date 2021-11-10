
import java.applet.AudioClip;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEMO0464
 */
public class HiloBaraja extends Thread {
    
    Ventana p;
    boolean silence = true;
    boolean ejecucion = true;
    boolean pause = true;
    AudioClip clip;
    ImageIcon icono1; 
    Icon icono;
    String cartares="Cartas  Restantes: \n\n";
    String[] cartas = {"1. El gallo","2. El diablito","3. La dama","4. El catrín",
    "5. El paraguas","6. La sirena","7. La escalera","8. La botella","9. El barril",
    "10. El árbol","11. El melón","12. El valiente","13. El gorrito","14. La muerte",
    "15. La pera","16. La bandera","17. El bandolón","18. El violoncello","19. La garza",
    "20. El pájaro","21. La mano","22. La bota","23. La luna","24. El cotorro","25. El borracho",
    "26. El negrito","27. El corazón","28. La sandía","29. El tambor","30. El camarón","31. Las jaras",
    "32. El músico","33. La araña","34. El soldado","35. La estrella","36. El cazo","37. El mundo",
    "38. El apache","39. El nopal","40. El alacrán","41. La rosa","42. La calavera","43. La campana",
    "44. El cantarito","45. El venado","46. El sol","47. La corona","48. La chalupa","49. El pino",
    "50. El pescado","51. La palma","52. La maceta","53. El arpa","54. La rana"};
    String text=""; 

    int[] pos = new int[54];
    int i = 0, c = 0;
    
    
    
    public HiloBaraja(Ventana puntero){
        p =  puntero;
        
    }
    
    public void ran(){
        pos[i] = (int)(Math.random()*54);
        for(i = 1; i < pos.length; i++){
            pos[i] = (int)(Math.random()*54);
             for(int j = 0; j < i; j++){
                if(pos[i] == pos[j]) i--;
            }
        }
    }

    public void pausa(){
       pause = !pause;
    }
    
    public void sonidos(){
        clip = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/"+c+".wav"));
        clip.play();
    }
    
    public void terminar(){
        
        for(int o=i;o<pos.length; o++){
            
            cartares += cartas[pos[o]]+"\n";
        }
        clip.stop();
        ejecucion = false;
    }
    
    @Override
    public void run() {
        super.run(); 
        ran();
        i=0;
        //dormir para activar el audio de comienso
        try {
            sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBaraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        while(ejecucion){
            try {
                if(pause){
                    if(i<cartas.length){
                        //texto
                        p.jLabel1.setText(cartas[pos[i]]);
                        //textarea
                        text += cartas[pos[i]]+"\n";
                        p.jTextArea1.setText(text);
                        //Imagenes
                        c = pos[i]+1;
                        icono1 = new ImageIcon(getClass().getResource("/Imagenes/"+c+".jpg"));
                        icono = new ImageIcon(icono1.getImage().getScaledInstance(p.jLabel2.getWidth(),p.jLabel2.getHeight(),Image.SCALE_DEFAULT));
                        p.jLabel2.setIcon(icono);
                        //sonidos
                        sonidos();
                        i++;
                    }
                    sleep(9000);
                }     
            sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBaraja.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}        
    
    

