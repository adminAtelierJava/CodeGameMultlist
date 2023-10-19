/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Nabil
 */
public class SignIn extends Form{
private TextField usernameField;
    private TextField emailField;
    private TextField passwordField;
    
    private TextArea adresseField;
    private Button annulerButton;
    private Button inscritButton;
    
    private Picker dateDeNField;
    public SignIn(Resources theme) {
        this.setTitle("créer compte");
        this.setLayout(BoxLayout.y());
       Image  img=theme.getImage("minecraft.jpg");
        ImageViewer imgV=new ImageViewer(img);
        imgV.setPreferredH(600);
        imgV.setPreferredW(200);
        emailField=new TextField("", "Email");
       usernameField=new TextField("","Username");
       passwordField=new TextField("", "password", 20,TextField.PASSWORD);
       dateDeNField=new Picker();
       dateDeNField.setType(Display.PICKER_TYPE_DATE);
       adresseField=new TextArea();
       adresseField.setRows(5);
       adresseField.setHint("Adresse de facturation");
       
       
       annulerButton=new Button("annuler");
       inscritButton=new Button("S'inscrire");
       Container cnt=new Container(new FlowLayout(CENTER));
       cnt.addAll(inscritButton,annulerButton);
       this.add(imgV);
       this.add(usernameField);
       this.add(emailField);
       this.add(passwordField);
       this.add(dateDeNField);
       this.add(adresseField);
       this.add(cnt);
       
       annulerButton.addActionListener(e->{
       SignUp si=new SignUp(theme);
       si.show();
       });
    }
    
}
