package listaconcategorias;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ListaConCategorias {

    public static void main(String[] args) {

        try {
            // Set System L&F

            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage() + " not supported");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + " not found");
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage() + " Illegal Access");
        }

        VentanaListado ventana = new VentanaListado();
        ventana.setVisible(true);
        ventana.setSize(700, 500);
    }

}
