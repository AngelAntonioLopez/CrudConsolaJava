package conexion;

import com.sun.xml.ws.security.opt.impl.util.SOAPUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection cn = null;
    static String bd = "plataforma";
    static String user = "root";
    static String pass = "1234";
    static String path = "jdbc:mysql://localhost:3306/" + bd;

    public Conexion() {
    }

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(path, user, pass);
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
        return cn;
    }

    public void desconectar() {
        System.out.println("Desconectado");
        try {
            cn.close();
        } catch (Exception e) {
            System.out.println("ERROR AL CERRAR LA CONEXION : "+e);
        }
    }

}
