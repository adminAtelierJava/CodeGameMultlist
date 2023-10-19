/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Game;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author Nabil
 */
public class GameList extends Form {

    public GameList(Resources theme) {
        this.setLayout(BoxLayout.y());
        Toolbar tb = new Toolbar();
        this.setToolbar(tb);
        tb.setTitle("G-Store Esprit");
        ArrayList<Game> list = new ArrayList<>();

        Game game1 = new Game("Devil May Cry 5", 200, "/dmc5.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game2 = new Game("Resident Evill VIII", 200, "/re8.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game3 = new Game("Need For Speed Heat", 100, "/nfs.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game4 = new Game("Red Dead Redemption II", 150, "/rdr2.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game5 = new Game("FIFA 22", 100, "/fifa.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
        Game game6 = new Game("Minecraft", 200, "/minecraft.jpg", "Even with the best gameplay footage and screenshots to entice players to dive deeper on your game page, you can’t just stick a basic marketplace description and count on the visuals to pull more than their fair share of the weight to convince players to choose your game.");
         list.add(game1);
        list.add(game2);
        list.add(game3);
        list.add(game4);
        list.add(game5);
        list.add(game6);
        for(Game g:list)
            this.add(addItem(g, theme));
//        this.add(addItem(game1, theme));
//        this.add(addItem(game2, theme));
//        this.add(addItem(game3, theme));
//        this.add(addItem(game4, theme));
//        this.add(addItem(game5, theme));
//        this.add(addItem(game6, theme));
        tb.addCommandToLeftBar("back", null, 
                ev->new SignUp((theme)).showBack());
    }

    public Container addItem(Game game, Resources theme) {
        Container c1 = new Container(BoxLayout.x());
        Image im = null;
//        try {
//            im = Image.createImage(game.getImg());
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
       im=getImage("http://192.168.136.155/Gstore"+game.getImg());
        ImageViewer img = new ImageViewer(im);
        Container c2 = new Container(BoxLayout.y());
        Label name = new Label(game.getName());
        Label price = new Label(game.getPrice() + "TND");
        c2.add(name);
        c2.add(price);
        c1.add(img);
        c1.add(c2);
        
        name.addPointerPressedListener(e->{System.out.println(game);
        GameDetails gam=new GameDetails(theme, game);
        gam.show();
        });
        c1.setLeadComponent(name);
        return c1;
    }
    
    private Image getImage(String url)
    {
    //String url="http://192.168.136.155/Gstore/dmc5.jpg";
        EncodedImage enc=null;
        try {
            enc = EncodedImage.create("/load.png");
        } catch (IOException ex) {
           
        }
      
        URLImage urlImg=URLImage.createToStorage(enc, "test"+url, url); 
   return urlImg;
    }

}
