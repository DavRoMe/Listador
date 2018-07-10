package listaconcategorias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaDB {

    private static Connection coneccion;
    private static boolean tieneDatos = false;

    private void inicializar() throws SQLException {
        if (!tieneDatos) {
            tieneDatos = true;

            Statement sentencia = coneccion.createStatement();
            //ResultSet rs = sentencia.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='juegos'");
            ResultSet rs = sentencia.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");

            if (!rs.next()) {
                // Creacion de la tabla
                Statement sentencia2 = coneccion.createStatement();
                sentencia2.execute(
                        "CREATE TABLE t_generos (\n"
                        + "    id_generos INTEGER      PRIMARY KEY AUTOINCREMENT\n"
                        + "                               UNIQUE\n"
                        + "                               NOT NULL,\n"
                        + "    genero     VARCHAR (20) UNIQUE\n"
                        + "                               NOT NULL);");

                Statement sentencia3 = coneccion.createStatement();
                sentencia3.execute("CREATE TABLE t_plataforma (\n"
                        + "    id_plataforma INTEGER      PRIMARY KEY AUTOINCREMENT\n"
                        + "                               UNIQUE\n"
                        + "                               NOT NULL,\n"
                        + "    plataforma    VARCHAR (25) UNIQUE\n);");

                Statement sentencia4 = coneccion.createStatement();
                sentencia4.execute("CREATE TABLE t_vista (\n"
                        + "    id_vista INTEGER      PRIMARY KEY AUTOINCREMENT\n"
                        + "                          UNIQUE\n"
                        + "                          NOT NULL,\n"
                        + "    vista    VARCHAR (20) UNIQUE\n);");

                Statement sentencia5 = coneccion.createStatement();
                sentencia5.execute("CREATE TABLE t_juegogenero (\n"
                        + "    id_juego_jc     INTEGER REFERENCES t_juegos (id_juego),\n"
                        + "    id_genero_jc INTEGER REFERENCES t_generos (id_generos) \n"
                        + ");");

                Statement sentencia6 = coneccion.createStatement();
                sentencia6.execute("CREATE TABLE t_juegos (\n"
                        + "    id_juego        INTEGER      PRIMARY KEY AUTOINCREMENT\n"
                        + "                                 NOT NULL\n"
                        + "                                 UNIQUE,\n"
                        + "    nombre          VARCHAR (30) NOT NULL\n"
                        + "                                 UNIQUE,\n"
                        + "    id_vista_j      INTEGER      REFERENCES t_vista (id_vista),\n"
                        + "    id_plataforma_j INTEGER      REFERENCES t_plataforma (id_plataforma) \n"
                        + ");");

                // Insertando algunos datos
                PreparedStatement prep = coneccion.prepareStatement("INSERT INTO t_generos VALUES(?,?);");
                prep.setString(2, "RPG");
                prep.execute();

                PreparedStatement prep2 = coneccion.prepareStatement("INSERT INTO t_plataforma VALUES(?,?);");
                prep2.setString(2, "PC");
                prep2.execute();

                PreparedStatement prep3 = coneccion.prepareStatement("INSERT INTO t_vista VALUES(?,?);");
                prep3.setString(2, "3-D");
                prep3.execute();

                PreparedStatement prep4 = coneccion.prepareStatement("INSERT INTO t_juegos"
                        + " VALUES(?,?,(SELECT id_vista FROM t_vista WHERE vista = '3-D'),"
                        + "(SELECT id_plataforma FROM t_plataforma WHERE plataforma = 'PC'));");
                prep4.setString(2, "Dark Souls");
                prep4.execute();

                PreparedStatement prep5 = coneccion.prepareStatement("INSERT INTO t_juegogenero"
                        + " VALUES((SELECT id_juego FROM t_juegos WHERE nombre = 'Dark Souls')"
                        + ",(SELECT id_generos FROM t_generos WHERE genero = 'RPG'));");
                prep5.execute();
            }
        }
    }

    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        coneccion = DriverManager.getConnection("jdbc:sqlite:db_juegos.db");
        inicializar();
    }

    public void agregaJuego(String nombre, String vista, String plataforma, ArrayList<String> generos)
            throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        String sentencia = "INSERT INTO t_juegos(nombre";
        String v = vista, p = plataforma;
        String n = "'" + nombre + "'";
        if (!v.equalsIgnoreCase("Null")) {
            v = ",(SELECT id_vista FROM t_vista WHERE vista = '" + vista + "')";
            sentencia += ", id_vista_j";
        } else {
            v = "";
        }
        if (!p.equalsIgnoreCase("Null")) {
            p = ",(SELECT id_plataforma FROM t_plataforma WHERE plataforma = '" + plataforma + "')";
            sentencia += ", id_plataforma_j";
        } else {
            p = "";
        }
        sentencia += ") VALUES(" + n + v + p + ");";
        /// Prueba de impresion de sentencia
//        System.out.println(sentencia);
        Statement insrtJuego = coneccion.createStatement();
        insrtJuego.executeUpdate(sentencia);

        Statement insrtGeneros = coneccion.createStatement();
        for (int i = 0; i < generos.size(); i++) {
            insrtGeneros.executeUpdate("INSERT INTO t_juegogenero VALUES((SELECT id_juego FROM t_juegos"
                    + " WHERE nombre = '" + nombre + "'), (SELECT id_generos FROM t_generos WHERE"
                    + " genero = '" + generos.get(i) + "'));");
        }
    }

    public void editaJuego(String id, String nombre, String vista, String plataforma, ArrayList<String> genSumados,
            ArrayList<String> genRestados, boolean editNom, boolean editVis, boolean editPlat)
            throws ClassNotFoundException, SQLException {

        if (coneccion == null) {
            conectar();
        }
        Statement sentencia = coneccion.createStatement();

        if (editNom) {
            sentencia.executeUpdate("UPDATE t_juegos SET nombre = '" + nombre + "' WHERE id_juego = '" + id + "'");
        }
        if (editVis) {
            sentencia.executeUpdate("UPDATE t_juegos SET id_vista_j = (SELECT id_vista FROM t_vista WHERE vista = '" + vista + "') WHERE id_juego = " + id);
        }
        if (editPlat) {
            sentencia.executeUpdate("UPDATE t_juegos SET id_plataforma_j = (SELECT id_plataforma FROM t_plataforma WHERE plataforma = '" + plataforma + "') WHERE id_juego = " + id);
        }

        for (String res : genRestados) {
            sentencia.executeUpdate("DELETE FROM t_juegogenero WHERE (id_juego_jc = " + id + " AND id_genero_jc = (SELECT id_generos FROM t_generos WHERE genero = '" + res + "'))");
        }
        for (String sum : genSumados) {
            sentencia.executeUpdate("INSERT INTO t_juegogenero VALUES (" + id + ", (SELECT id_generos FROM t_generos WHERE genero = '" + sum + "')) ");
        }

    }

    public void renombraGenero(String nombre, String id) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("UPDATE t_generos SET genero = '" + nombre + "' WHERE id_generos = '" + id + "'");
    }

    public void renombraVista(String nombre, String id) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("UPDATE t_vista SET vista = '" + nombre + "' WHERE id_vista = '" + id + "'");
    }

    public void renombraPlataforma(String nombre, String id) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("UPDATE t_plataforma SET plataforma = '" + nombre + "' WHERE id_plataforma = '" + id + "'");
    }

    public void eliminarJuego(String juego) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("DELETE FROM t_juegogenero WHERE id_juego_jc = (SELECT"
                + " id_juego FROM t_juegos WHERE nombre = '" + juego + "')");
        sentencia.executeUpdate("DELETE FROM t_juegos WHERE nombre = '" + juego + "'");
    }

    public void agregaVista(String vista) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("INSERT INTO t_vista(vista) VALUES('" + vista + "')");
    }

    public void agregaPlataforma(String pltfrm) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("INSERT INTO t_plataforma(plataforma) VALUES('" + pltfrm + "')");
    }

    public void agregaGenero(String genero) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("INSERT INTO t_generos(genero) VALUES('" + genero + "')");
    }

    public void borrarGenero(String id_gen) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("DELETE FROM t_juegogenero WHERE id_genero_jc = " + id_gen);
        sentencia.executeUpdate("DELETE FROM t_generos WHERE id_generos = " + id_gen);
    }

    public void borrarVista(String id_vis) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("UPDATE t_juegos SET id_vista_j = NULL WHERE id_vista_j = " + id_vis);
        sentencia.executeUpdate("DELETE FROM t_vista WHERE id_vista = " + id_vis);
    }

    public void borrarPlataforma(String id_plat) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        sentencia.executeUpdate("UPDATE t_juegos SET id_plataforma_j = NULL WHERE id_plataforma_j = " + id_plat);
        sentencia.executeUpdate("DELETE FROM t_plataforma WHERE id_plataforma = " + id_plat);
    }

    public ResultSet leerJuegos() throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT id_juego, nombre, vista, plataforma\n"
                + "FROM t_juegos\n"
                + "LEFT JOIN t_vista ON id_vista_j = id_vista\n"
                + "LEFT JOIN t_plataforma ON id_plataforma_j = id_plataforma\n"
                + "ORDER BY nombre");

        return rs;
    }

    public ResultSet leerJuegos(GrupoDeFiltros filtros) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        boolean whereActivado = false;

        String cadenaGen;
        if (filtros.obtenerGeneros().size() > 0) {
            whereActivado = true;
            cadenaGen = "WHERE id_juego IN (SELECT id_juego_jc FROM t_juegogenero WHERE id_genero_jc IN (";
            cadenaGen = filtros.obtenerGeneros().stream().map((s) -> s + ", ").reduce(cadenaGen, String::concat);
            /* Metodo anterior
            for(String s : filtros.obtenerGeneros()){
                cadenaGen += s + ", ";
            } */
            cadenaGen = cadenaGen.substring(0, cadenaGen.length() - 2);
            cadenaGen += "))\n";
        } else {
            cadenaGen = "";
        }
//        System.out.println(cadenaGen);    // Para depuracion

        String cadenaVis;
        if (filtros.obtenerVistas().size() > 0) {
            if (whereActivado) {
                cadenaVis = " AND id_vista_j IN (";
            } else {
                whereActivado = true;
                cadenaVis = "WHERE id_vista_j IN (";
            }
            cadenaVis = filtros.obtenerVistas().stream().map((s) -> s + ", ").reduce(cadenaVis, String::concat);
            cadenaVis = cadenaVis.substring(0, cadenaVis.length() - 2);
            cadenaVis += ")\n";
        } else {
            cadenaVis = "";
        }

        String cadenaPlat;
        if (filtros.obtenerPlataformas().size() > 0) {
            if (whereActivado) {
                cadenaPlat = " AND id_plataforma_j IN (";
            } else {
                cadenaPlat = "WHERE id_plataforma_j IN (";
            }
            cadenaPlat = filtros.obtenerPlataformas().stream().map((s) -> s + ", ").reduce(cadenaPlat, String::concat);
            cadenaPlat = cadenaPlat.substring(0, cadenaPlat.length() - 2);
            cadenaPlat += ")\n";
        } else {
            cadenaPlat = "";
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT id_juego, nombre, vista, plataforma\n"
                + "FROM t_juegos\n"
                + "LEFT JOIN t_vista ON id_vista_j = id_vista\n"
                + "LEFT JOIN t_plataforma ON id_plataforma_j = id_plataforma\n"
                + cadenaGen + cadenaVis + cadenaPlat
                + "ORDER BY nombre");

        return rs;
    }

    public ResultSet leerGeneros() throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT genero, id_generos FROM t_generos ORDER BY genero");

        return rs;
    }

    public ResultSet leerPlataformas() throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT plataforma, id_plataforma FROM t_plataforma ORDER BY plataforma");

        return rs;
    }

    public ResultSet leerVistas() throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT vista, id_vista FROM t_vista ORDER BY vista");

        return rs;
    }

    public ResultSet verGenerosDeJuego(String idJuego) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT genero FROM t_generos,"
                + " t_juegogenero, t_juegos WHERE (id_juego_jc = " + idJuego + " AND "
                + "id_generos = id_genero_jc AND id_juego =" + idJuego + ") ORDER BY genero;");

        return rs;
    }

    public ResultSet leerID(String nomJuego) throws ClassNotFoundException, SQLException {
        if (coneccion == null) {
            conectar();
        }

        Statement sentencia = coneccion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT id_juego FROM t_juegos WHERE (nombre = '" + nomJuego + "');");

        return rs;
    }
}
