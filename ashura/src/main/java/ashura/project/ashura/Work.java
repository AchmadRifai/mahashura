/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ashura.project.ashura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashura
 */
public class Work {
    @SuppressWarnings("deprecation")
	public static void hindar(Exception ex, String url) {
        java.sql.Timestamp t=java.sql.Timestamp.valueOf(LocalDateTime.now());
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.mahashura/error/"+url+"/"+
        t.getDate()+
                "a"+t.getMonth()+"a"+t.getYear()+"b"+t.getHours()+"c"+t.getMinutes()+"c"+t.getSeconds()+"d"+
                t.getNanos()+".log");
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        if(f.exists())f.delete();
        try {
            java.io.PrintStream o=new java.io.PrintStream(f);
            ex.printStackTrace(o);
            o.close();
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    public static RSA genRSA() throws GeneralSecurityException, IOException {
    	return new RSA(System.getProperty("user.home")+"/.mahashura/kunci/pri",
    			System.getProperty("user.home")+"/.mahashura/kunci/pub");
    }
}