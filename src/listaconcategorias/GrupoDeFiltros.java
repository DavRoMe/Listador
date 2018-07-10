package listaconcategorias;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class GrupoDeFiltros {

    private ArrayList<String> filtrosGenero;
    private ArrayList<String> filtrosVista;
    private ArrayList<String> filtrosPlataforma;

    // Tipos de filtros
    static final int INACTIVO = 0;
    static final int INCLUYENTE = 1;
    static final int EXCLUYENTE = 2;

    public GrupoDeFiltros() {
        /* Constructor por defecto */
        filtrosGenero = new ArrayList<>();
        filtrosVista = new ArrayList<>();
        filtrosPlataforma = new ArrayList<>();
    }

    public GrupoDeFiltros(DefaultTableModel generos, DefaultTableModel vistas,
            DefaultTableModel plataformas, int tipo_de_filtro) {

        switch (tipo_de_filtro) {
            case INACTIVO:
                filtrosGenero = new ArrayList<>();
                filtrosVista = new ArrayList<>();
                filtrosPlataforma = new ArrayList<>();
                break;
            case INCLUYENTE:
                filtrosGenero = incluirFiltros(generos);
                filtrosVista = incluirFiltros(vistas);
                filtrosPlataforma = incluirFiltros(plataformas);
                break;
            case EXCLUYENTE:
                filtrosGenero = excluirFiltros(generos);
                filtrosVista = excluirFiltros(vistas);
                filtrosPlataforma = excluirFiltros(plataformas);
                break;
            default:
                break;
        }
    }

    public ArrayList<String> obtenerGeneros() {
        return filtrosGenero;
    }

    public ArrayList<String> obtenerVistas() {
        return filtrosVista;
    }

    public ArrayList<String> obtenerPlataformas() {
        return filtrosPlataforma;
    }

    public int size() {
        return (filtrosGenero.size() + filtrosPlataforma.size() + filtrosVista.size());
    }

    private ArrayList<String> incluirFiltros(DefaultTableModel modelo) {
        /* Este metodo guarda la ID de los objetos SELECCIONADOS */
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 2).equals(true)) {
                lista.add(modelo.getValueAt(i, 0).toString());
            }
        }

        return lista;
    }

    private ArrayList<String> excluirFiltros(DefaultTableModel modelo) {
        /* Este metodo guarda la ID de los objetos NO seleccionados */
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 2).equals(false)) {
                lista.add(modelo.getValueAt(i, 0).toString());
            }
        }

        return lista;
    }
}
