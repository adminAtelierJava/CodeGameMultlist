/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Nabil
 */
public class SignUp extends Form {

    private TextField email;
    private TextField password;
    private Button loginBtn;
    private Button InscriBtn;
    private Button motdepassOu;
    private Image img;
    private ImageViewer imgV;

    public SignUp(Resources theme) {
        this.setLayout(new BorderLayout());
        this.setTitle("s'authentifier");
        img = theme.getImage("minecraft.jpg");
        imgV = new ImageViewer(img);
        imgV.setPreferredH(600);
        imgV.setPreferredW(200);
        email = new TextField("", "Email", 20, TextField.ANY);
        password = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
        loginBtn = new Button("S'authentifier");
        InscriBtn = new Button("créer un compte");
        motdepassOu = new Button("mot de passe oublié");
        Container cnt = new Container(BoxLayout.y());
        cnt.add(imgV);
        cnt.add(email);
        cnt.add(password);
        cnt.add(loginBtn);
        cnt.add(InscriBtn);
        cnt.add(motdepassOu);
        this.add(BorderLayout.CENTER, cnt);

        InscriBtn.addActionListener(e -> {
            
            SignIn sig = new SignIn(theme);
            sig.show();
        });

        motdepassOu.addActionListener(e -> {
            ForgetPassword forg = new ForgetPassword(theme);
            forg.show();
        });

        loginBtn.addActionListener(e -> {
            String url = "http://192.168.100.9/Gstore/login.php?login="+email.getText()+
                    "&password="+password.getText();
            ConnectionRequest con = new ConnectionRequest();
            con.setUrl(url);
            con.setPost(false);
            con.addResponseListener(ee -> {
                String reponse = new String(con.getResponseData());
                if(reponse.equalsIgnoreCase("OK"))
                        
                {GameMultilist game=new GameMultilist(theme);
                   //  GameList game = new GameList(theme);
                 game.show();
                }
                else Dialog.show("Error", "login ou pwd invalid", "ok","cancel");
            });
            NetworkManager.getInstance().addToQueueAndWait(con);
           
        });
    }

}
