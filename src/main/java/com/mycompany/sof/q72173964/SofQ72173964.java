/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.sof.q72173964;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author leandro
 */
public class SofQ72173964 {
    
    static Logger logger = LogManager.getLogger(SofQ72173964.class);

    public static void main(String[] args) throws EmailException {
        logger.info("Hello World!");
        
        try {
            Integer.parseInt("Force exception to call log4j");
        } catch (NumberFormatException ex) {
            logger.error(ex);
        }
        
        JOptionPane.showMessageDialog(new JLabel(), "Click ok to continue");
        
        
        String ori = "from@gmail.com";
        String dest = "to@gmail.com";
        String paswd = "passwd";

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com"); //servidor smtp
        email.setAuthentication(ori, paswd);
        email.setSmtpPort(465);
        email.setSSLOnConnect(true);
        email.setStartTLSEnabled(true);
        email.setFrom(ori, ori);
        email.addTo(dest);
        email.setSubject("TEST");
        email.setHtmlMsg("Hello World");
        email.setCharset("UTF-8");
        email.setDebug(true);
        
        email.send();
        
        logger.info("SENT");

    }
}
