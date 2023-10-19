/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Game;
import java.io.IOException;



/**
 *
 * @author Nabil
 */
public class GameDetails extends Form {

    private Button acheter;
    private SpanLabel descritption;
    private Label price;

    public GameDetails(Resources theme, Game game) {
        setLayout(new BoxLayout((BoxLayout.Y_AXIS)));
        Toolbar tb=new Toolbar();
        setToolbar(tb);
        setTitle(game.getName());
        tb.addCommandToLeftBar("back", null, ev->{new GameList(theme).show();});
        ImageViewer img;

        try {
            img = new ImageViewer(Image.createImage(game.getImg()));
            add(img);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        descritption=new SpanLabel(game.getDescrption());
        price=new Label(game.getPrice()+"TND");
        acheter=new Button("Buy");
        
        add(descritption);
        add(price);
        add(acheter);
    }

}
