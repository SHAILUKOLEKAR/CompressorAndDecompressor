/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import COM_DECOM.Compressor_;
import COM_DECOM.De_compressor;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


/**
 *
 * @author SHAILU KOLEKAR
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressBtn;
    JButton decompressbtn;
    
   public AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        Color btnColor = new Color(243, 249, 126);
        
        compressBtn = new JButton("Select file to compress");
        compressBtn.setBounds(20,100,200,30);
        compressBtn.setBackground(btnColor);
        compressBtn.addActionListener(this);
        
        decompressbtn = new JButton("Select file to decompress");
        decompressbtn.setBounds(350,100,200,30);
        decompressbtn.setBackground(btnColor);
        decompressbtn.addActionListener(this);
       
        this.setTitle("Compressor And Decompressor");
        this.add(compressBtn);
        this.add(decompressbtn);
        this.setSize(600,300);
        Color c1 = new Color(150, 243, 118);
        this.getContentPane().setBackground(c1);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compressBtn)
        {
            JFileChooser fileChooser = new JFileChooser(); 
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compressor_.method(file);
                    
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                    
                }
            }
        }
        
        if(e.getSource()== decompressbtn)
        {
            JFileChooser fileChooser = new JFileChooser(); 
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    De_compressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                    
                }
            }
        }
    }
}
