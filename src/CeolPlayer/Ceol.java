package CeolPlayer;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import com.sun.javafx.font.FontConstants;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import jdk.nashorn.internal.ir.Flags;
import jdk.nashorn.internal.ir.TryNode;
import org.tritonus.share.sampled.file.TAudioFileFormat;
import sun.java2d.pipe.BufferedBufImgOps;

class retstuff
{
    BufferedInputStream bis;
    File loc;
   
   retstuff(BufferedInputStream B,File F)
    {
        this.bis=B;
        this.loc=F;
    }
}
class Music extends Thread
{
BufferedInputStream b;
Player pl;
JLabel j;
JLabel j2;
    public Music(BufferedInputStream b,Player pl,JLabel j,JLabel j2) {
    this.b=b;
    this.pl=pl;
    this.j=j;
    this.j2=j2;
    }
    
    public void run()
    {
                 try {
                    pl = new Player(b);
                    pl.play();
                    ImageIcon imageplay = new ImageIcon("src/CeolPlayer/Play.png");
                    j.setIcon(imageplay);
                    j2.setLocation(0,283);
                    
        } catch (Exception e) {
        }
                 
    }
}
class MPlayer
{
public retstuff selectFile()
{
JFileChooser chooser = new JFileChooser();
     BufferedInputStream bufferedtrack =null;
     retstuff these=null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try
            {
                File track = chooser.getSelectedFile();
                FileInputStream trackstream = new FileInputStream(track);
                bufferedtrack = new BufferedInputStream(trackstream);
                these= new retstuff(bufferedtrack,track);
                
             
            }
            
            catch(FileNotFoundException e)
            {
                
            }
        }
        
return these;
}

public int getDurationWithMp3Spi(File file,JLabel j3) throws UnsupportedAudioFileException, IOException {

    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    if (fileFormat instanceof TAudioFileFormat) {
        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
        String key = "duration";
        Long microseconds = (Long) properties.get(key);
        int mili = (int) (microseconds / 1000);
        int sec = (mili / 1000) % 60;
        int min = (mili / 1000) / 60;
        int tsec = (mili/1000);
        if(sec/10<1)
        {
            j3.setText(min+":0"+sec);
        }
        else
        {
            j3.setText(min+":"+sec);
        }
    
        return tsec;
    } else {
        throw new UnsupportedAudioFileException();
    }

}

}
public class Ceol extends javax.swing.JFrame {

    public Ceol() {
        initComponents();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog1 = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        dialog1.setTitle("Playlist");
        dialog1.setLocation(new java.awt.Point(400, 225));
        dialog1.setMaximumSize(new java.awt.Dimension(231, 342));
        dialog1.setMinimumSize(new java.awt.Dimension(231, 342));
        dialog1.setName(""); // NOI18N
        dialog1.setPreferredSize(new java.awt.Dimension(231, 342));
        dialog1.setResizable(false);
        dialog1.getContentPane().setLayout(null);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Add.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        dialog1.getContentPane().add(jLabel11);
        jLabel11.setBounds(63, 30, 105, 30);

        dialog1.getAccessibleContext().setAccessibleName("");

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Ceol Player");
        setLocation(new java.awt.Point(550, 225));
        setMaximumSize(new java.awt.Dimension(231, 342));
        setMinimumSize(new java.awt.Dimension(231, 342));
        setPreferredSize(new java.awt.Dimension(231, 340));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exit(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Ceol Blank Disc.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(22, 0, 180, 180);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Play.png"))); // NOI18N
        jLabel2.setName(""); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(98, 242, 32, 32);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Next.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(137, 242, 32, 32);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Previous.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(57, 242, 32, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Repeat.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(177, 242, 32, 32);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Playlist.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(22, 246, 32, 32);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Seek.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 283, 32, 32);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CeolPlayer/Seekbar.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 298, 205, 3);

        jLabel8.setFont(new java.awt.Font("SF Compact Display", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("trackname");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(22, 202, 180, 18);

        jLabel9.setFont(new java.awt.Font("SF Compact Display", 0, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("artistname");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(23, 221, 180, 13);

        jLabel12.setFont(new java.awt.Font("SF Compact Display", 0, 8)); // NOI18N
        jLabel12.setText("--:--");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(195, 278, 20, 10);

        jLabel14.setFont(new java.awt.Font("SF Compact Display", 0, 8)); // NOI18N
        jLabel14.setText("--:--");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 278, 20, 10);

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int x=0;
    int tc=0;
    
    class TimeDelay extends Thread
{   
    float tfrac;
    long tlfrac;
    
    JLabel j;
    public TimeDelay(JLabel j,float ti) {
        this.j=j;
        this.tfrac=(float)(ti/194);
        this.tlfrac=(long)(tfrac*1000);
    }
    
    public void run()
    {
        try {
            
            while(x<195)
            {
                x=x+1;
                j.setLocation(x, 283);
                this.sleep(tlfrac);
            }
            
        } catch (Exception e) {
        }
    }
    
}
    
    class timeTrack extends Thread
        
{
    JLabel j4;
    float tt;
    timeTrack(float tt,JLabel j4)
    {
        this.tt=tt;
        this.j4=j4;
    }
    public void run()
    {
        try {
            int mm;
            int ss;
            while(tc<=tt)
            {
                this.sleep(1000);
                tc++;
                mm=tc/60;
                ss=tc%60;
                if(ss/10<1)
                {
                    j4.setText(mm+":0"+ss);
                }
                else
                    j4.setText(mm+":"+ss);
            }
        } catch (Exception e) {
        }
    }
}

       
    retstuff retthis=null;
    MPlayer p =new MPlayer();
    Player player=null;
    int flag1=0;
    Music music = null;
    TimeDelay rt=null;
    float timeinseconds;
    timeTrack trackthis;

    
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
        dialog1.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
   
        retthis=p.selectFile();
        
        try {
            Mp3File mp3file = new Mp3File(retthis.loc);
            timeinseconds = p.getDurationWithMp3Spi(retthis.loc,jLabel12);
                 if (mp3file.hasId3v1Tag()) 
                 {
                 ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                 jLabel8.setText(id3v1Tag.getTitle());
                 jLabel9.setText(id3v1Tag.getArtist());
                 }
                 if (mp3file.hasId3v2Tag())
                 {
                 ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                 
                InputStream in = new ByteArrayInputStream(id3v2Tag.getAlbumImage()); // Puts byte[] image to InputStream
                BufferedImage img = ImageIO.read(in); // Converts InputStream to Buffered image
                
                 jLabel1.setIcon(new ImageIcon(img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), 
                 Image.SCALE_SMOOTH))); // here img needs to be a buffered image. Ok bewakoof Neeraj?
                 
                 jLabel10.setLocation(0,283);
                 ImageIcon imageplay = new ImageIcon("src/CeolPlayer/Play.png");
                 jLabel2.setIcon(imageplay);
                 jLabel14.setText("0:00");
                 x=0;
                 music.stop();
                 rt.stop();
                 trackthis.stop();
                 tc=0;
                 }
        
        } catch (Exception e) {
        }
        
        

    }//GEN-LAST:event_jLabel11MouseClicked

    private void exit(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exit
        // TODO add your handling code here:
    }//GEN-LAST:event_exit
   
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
             
             if(flag1==0)
             {
                 ImageIcon imagepause = new ImageIcon("src/CeolPlayer/Pause.png");
                 jLabel2.setIcon(imagepause);
                 music = new Music(retthis.bis,player,jLabel2,jLabel10);
                 music.start();
                 rt=new TimeDelay(jLabel10,timeinseconds);
                 rt.start();
                 trackthis=new timeTrack(timeinseconds,jLabel14);
                 trackthis.start();
                 flag1=1;
                 
                 
                 
                 
             }
             else
             {
                 ImageIcon imageplay = new ImageIcon("src/CeolPlayer/Play.png");
                 jLabel2.setIcon(imageplay);
                 music.stop();
                 rt.stop();
                 trackthis.stop();
                 flag1=0;
        
             }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
           
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ceol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ceol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ceol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ceol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
     
        java.awt.EventQueue.invokeLater(() -> {
            Ceol frame = new Ceol();
            frame.setVisible(true);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:/FFOutput/Ico.png"));
            
        });
      
        
      
       
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}

