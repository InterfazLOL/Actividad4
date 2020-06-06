package client.login;

import java.awt.Image;
import javax.swing.border.Border;

import services.ObjGraficosService;
import services.RecursosService;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginTemplate extends JFrame {

    private JPanel pIzquierda, pDerecha;
    private JLabel lTituloApp, lFondo, lIcon;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    //private JComboBox<String> cbTipoUsuario;
    private JCheckBox checkMantenerConexion;
    private JButton bAyuda, bEntrar, bCrearCuenta, bCantSesion, bVers;
    private Border borderCampos;

    // Declarancion objetos decoradores
    private ImageIcon iIcon, iFondo, iAyuda, iAux, iEntrar;

    // Declaracion de servicios
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    public LoginTemplate() {

        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        
        crearObjetosDecoradores();        
        crearJPanels();
        crearJLabels();
        crearCheckBoxs();
        crearJButtons();
        crearJTexts();

        this.setSize(1300, 730);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setTitle("Rito Client");
        this.setVisible(true);
    }

    public void crearObjetosDecoradores(){
        iIcon = new ImageIcon("resources/img/iLogin.jpg");
        iFondo = new ImageIcon("resources/img/fondoLogin.jpg");
        iAyuda = new ImageIcon("resources/img/ayuda.png");
        iEntrar = new ImageIcon("resources/img/loginEntrar.png");
        borderCampos = BorderFactory.createLineBorder(sRecursos.getColorFndoCampos(), 3, true);
    }

    public void crearJPanels(){
        pIzquierda = sObjGraficos.construirJPanel(0, 0, 400, 730, sRecursos.getColorFndoIzq(), null, null);
        this.add(pIzquierda);
        pDerecha = sObjGraficos.construirJPanel(400, 0, 900, 730, null, null, null);
        this.add(pDerecha);
    }

    public void crearJLabels(){
        iAux = new ImageIcon(iIcon.getImage().getScaledInstance(60, 65, Image.SCALE_SMOOTH));
        lIcon = sObjGraficos.construirJLabel("", 50, 45, 60, 65, iAux, null, null, null, null, "c");
        pIzquierda.add(lIcon);

        lTituloApp = sObjGraficos.construirJLabel("<html><div align='justify'> Iniciar sesión con tu cuenta de Rito </div> </html>", 
        (pIzquierda.getWidth() - 284) / 2, 170, 284, 60, null, sRecursos.getFontPrincipal(), null, sRecursos.getColorFont(), 
        null, "l");
        pIzquierda.add(lTituloApp);

        //Panel derecho
        iAux = new ImageIcon(iFondo.getImage().getScaledInstance(900, 730, Image.SCALE_AREA_AVERAGING));
        lFondo = sObjGraficos.construirJLabel(null, 0, 0, 900, 730, iAux, null, null, null, null, "c");
        pDerecha.add(lFondo);
    }

    public void crearJButtons(){
        //Boton ayuda
        iAux = new ImageIcon(iAyuda.getImage().getScaledInstance(15, 15, Image.SCALE_AREA_AVERAGING));
        bAyuda = sObjGraficos.crearJButton(null, 320, 70, 15, 15, null, iAux, null, null, null, null, "c", false, false);
        pIzquierda.add(bAyuda);
        //Boton Entrar
        iAux = new ImageIcon(iEntrar.getImage().getScaledInstance(64, 64, Image.SCALE_AREA_AVERAGING));
        bEntrar = sObjGraficos.crearJButton(null, (pIzquierda.getWidth() - 64) / 2, 486, 64, 64, null, iAux, null,
        sRecursos.getColorBtnIngresar(), null, null, "o", true, false);
        pIzquierda.add(bEntrar);
        //Boton crear cuenta
        bCrearCuenta = sObjGraficos.crearJButton("CREAR UNA CUENTA", 50, 640, 165, 14, sRecursos.getcMano(), null,
            sRecursos.getFontSecundaria(), null, null, null, "l", false, false);
        pIzquierda.add(bCrearCuenta);
        //Boton no puedo iniciar sesion
        bCantSesion = sObjGraficos.crearJButton("¿NO PUEDES INICIAR SESIÓN?", 50, 654, 165, 14, sRecursos.getcMano(),
            null, sRecursos.getFontSecundaria(), null, null, null, "l", false, false);
        pIzquierda.add(bCantSesion);
        //Boton version actual
        bVers = sObjGraficos.crearJButton("V 20.3.0", 290, 654, 55, 14, sRecursos.getcMano(), null, 
            sRecursos.getFontSecundaria(), null, null, null, "l", false, false);
        pIzquierda.add(bVers);
    }

    public void crearJTexts(){
        //Txt nombre de usuario
        tNombreUsuario = sObjGraficos.construirTextField("NOMBRE DE USUARIO", 284, 47, (pIzquierda.getWidth() - 
            284) / 2, 280, sRecursos.getFontSecundaria(), sRecursos.getColorFontOp(), sRecursos.getColorFndoCampos(),
            sRecursos.getColorFont(), borderCampos, "c");
        pIzquierda.add(tNombreUsuario);
        //Txt contraseña
        tClaveUsuario = new JPasswordField();
        tClaveUsuario.setSize(284, 47);
        tClaveUsuario.setLocation((pIzquierda.getWidth() - tClaveUsuario.getWidth()) / 2, 344);
        tClaveUsuario.setText("Contraseña");
        tClaveUsuario.setFont(sRecursos.getFontSecundaria());
        tClaveUsuario.setForeground(sRecursos.getColorFontOp());
        tClaveUsuario.setBackground(sRecursos.getColorFndoCampos());
        tClaveUsuario.setBorder(null);
        tClaveUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        pIzquierda.add(tClaveUsuario);
    }

    public void crearCheckBoxs(){
        checkMantenerConexion = new JCheckBox("Permanecer conectado");
        checkMantenerConexion.setSize(283, 30);
        checkMantenerConexion.setLocation(56, 410);
        checkMantenerConexion.setFocusable(false);
        checkMantenerConexion.setFont(sRecursos.getFontPer());
        checkMantenerConexion.setForeground(sRecursos.getColorFontOp());
        checkMantenerConexion.setBackground(sRecursos.getColorFndoIzq());
        checkMantenerConexion.setCursor(sRecursos.getcMano());
        pIzquierda.add(checkMantenerConexion);

        /*
         * cbTipoUsuario = new JComboBox(); cbTipoUsuario.addItem("Administrador");
         * cbTipoUsuario.addItem("Cajero"); cbTipoUsuario.addItem("Cliente");
         * cbTipoUsuario.setSize(250, 20);
         * cbTipoUsuario.setLocation((pIzquierda.getWidth()-cbTipoUsuario.getWidth())/2,
         * 450); cbTipoUsuario.setForeground(Color.GRAY);
         * cbTipoUsuario.setBackground(new Color(237, 237, 237)); ((JLabel)
         * cbTipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
         * pIzquierda.add(cbTipoUsuario);
         */
    }
}