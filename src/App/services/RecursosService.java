package services;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class RecursosService {

    private static RecursosService servicio;
    private Color colorFndoIzq, colorFndoCampos, colorFont, colorFontOp, colorBtnIngresar;
    private Font fontPrincipal, fontSecundaria, fontPer;
    private Cursor cMano;
    
    private RecursosService() {
        colorFndoIzq = new Color(249, 249, 249);
        colorFndoCampos = new Color(237, 237, 237);
        colorFont = new Color(0, 0, 0);
        colorFontOp = new Color(0, 0, 0, 80);
        colorBtnIngresar = new Color(209, 54, 57);
        fontPrincipal = new Font("Typold Condensed Medium", Font.BOLD, 22);
        fontSecundaria = new Font("Typold Condensed Medium", Font.BOLD, 11);
        fontPer = new Font("Typold Condensed Medium", Font.BOLD, 13);
        cMano = new Cursor(Cursor.HAND_CURSOR);
    }
    
    public static RecursosService getService(){
        if(servicio==null)
            servicio = new RecursosService();
        return servicio;
    }

    public Color getColorFndoIzq() {
        return colorFndoIzq;
    }

    public Color getColorFndoCampos() {
        return colorFndoCampos;
    }

    public Color getColorFont() {
        return colorFont;
    }

    public Color getColorFontOp() {
        return colorFontOp;
    }

    public Font getFontPrincipal() {
        return fontPrincipal;
    }

    public Font getFontSecundaria() {
        return fontSecundaria;
    }

    public Font getFontPer() {
        return fontPer;
    }

    public Cursor getcMano() {
        return cMano;
    }

    public Color getColorBtnIngresar(){
        return colorBtnIngresar;
    }
}