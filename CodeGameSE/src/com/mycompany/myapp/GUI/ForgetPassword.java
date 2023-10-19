/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
/**
 *
 * @author Nabil
 */
public class ForgetPassword extends Form{
  private  TextField userName;
  private Button SuivantButton;
    public ForgetPassword(Resources theme) {
        this.setLayout(BoxLayout.y());
        Image  img=theme.getImage("minecraft.jpg");
        ImageViewer imgV=new ImageViewer(img);
        imgV.setPreferredH(600);
        imgV.setPreferredW(200);
        
        userName=new TextField("","Username");
        SuivantButton=new Button("réinisialiser password");
        this.addAll(imgV,userName,SuivantButton);
        
        Toolbar tb=new Toolbar();
        setToolbar(tb);
        tb.setTitle("Forget Password");
        tb.addCommandToLeftBar("back", null, 
                ev->new SignUp((theme)).showBack());
    }
    
    
    
}
