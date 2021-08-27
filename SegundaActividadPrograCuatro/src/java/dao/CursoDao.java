package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;
import modelo.Curso;

public class CursoDao {

    public boolean insert(Curso curso) {
        boolean flag = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO `plataforma`.`curso` (`nombre`, `instructor`, `precio`, `fecha_inicio`) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getInstructor());
            ps.setDouble(3, curso.getPrecio());
            ps.setString(4, curso.getFechaInicioString());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Insertado");
            }else{
                System.out.println("No se a podido insertar");
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        return flag;
    }

    public boolean update(Curso curso) {
        boolean flag = false;
        String sql = "UPDATE `plataforma`.`curso` SET `nombre` = ?, `instructor` = ?, `precio` = ?, `fecha_inicio` = ? WHERE (`id` = ?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getInstructor());
            ps.setDouble(3, curso.getPrecio());
            ps.setString(4, curso.getFechaInicioString());
            ps.setInt(5, curso.getId());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Actualizado");
            }else{
                System.out.println("No se a Podido actualizar");
            }
            conexion.desconectar();

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = false;
        String sql = "DELETE FROM `plataforma`.`curso` WHERE (`id` = ?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Eliminado");
            }else{
                System.out.println("No se a podido eliminar");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return flag;
    }

    public Curso oneCurso(int id) {
        Curso curso = new Curso();
        String sql = "SELECT * FROM plataforma.curso WHERE (`id` = ?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                curso = new Curso(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("instructor"),
                        rs.getDouble("precio"),
                        rs.getDate("fecha_inicio"));
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return curso;
    }

    public List<Curso> selectAll() {
        List<Curso> lista = new LinkedList<Curso>();
        String sql = "SELECT * FROM plataforma.curso;";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Curso cursito;
            while (rs.next()) {
                cursito = new Curso(rs.getInt("id"), rs.getString("nombre"), rs.getString("instructor"), rs.getDouble("precio"), rs.getDate("fecha_inicio"));
                lista.add(cursito);
            }

            if (lista.size() > 0) {
                System.out.println("Lista llena");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
        
        return lista;
    }


    /*public int pedirInt() {
        Scanner sc1 = new Scanner(System.in);
        int linea = Integer.MAX_VALUE;
        while (linea == Integer.MAX_VALUE) {
            try {
                linea = sc1.nextInt();
            } catch (Exception e) {
                System.out.println("LO ESCRITO EN ES UN int PORFAVOR DIGITE UN int");
                sc1.nextLine();
                System.out.println("");
                linea = Integer.MAX_VALUE;
            }
        }
        sc1.nextLine();
        sc1.close();
        return linea;
    }

    public double pedirDouble() {
        Scanner sc2 = new Scanner(System.in);
        double linea = Double.MAX_VALUE;
        while (linea == Double.MAX_VALUE) {
            try {
                linea = sc2.nextDouble();
            } catch (Exception e) {
                System.out.println("LO ESCRITO EN ES UN double PORFAVOR DIGITE UN double");
                sc2.nextLine();
                System.out.println("");
                linea = Integer.MAX_VALUE;
            }
        }
        sc2.nextLine();
        sc2.close();
        return linea;
    }

    public String pedirFechaConFormato() {
        Curso c = new Curso();
        String linea = "";
        String potencialFecha = "";
        Scanner sc3 = new Scanner(System.in);
        while (linea.equals("")) {
            try {
                MaskFormatter formato = new MaskFormatter("##/##/####");
                String texto = sc3.next();
                potencialFecha = (String) formato.stringToValue(texto.trim());
                linea = potencialFecha;
            } catch (Exception e) {
                System.out.println("POR FAVOR INGRESE LA FECHA CON FORMATO dd/MM/yyyy ");
                System.out.println("Ingrese la Fecha");
            }
        }
        sc3.nextLine();
        sc3.close();
        return linea;
    }
*/
}
