package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Curso {

    private int id;
    private String nombre;
    private String instructor;
    private double precio;
    private Date fechaInicio;

    public Curso() {
    }

    public Curso(int id, String nombre, String instructor, double precio, String fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.precio = precio;
        try {
            this.fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
        } catch (Exception e) {
            System.out.println("ERROR AL PARSIAR LA FECHA");
        }
    }

    public Curso(int id, String nombre, String instructor, double precio, Date fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaInicioString() {
        String fecha = "";
        String formato ="yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(formato);
        fecha = df.format(this.getFechaInicio());
        return fecha;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public void setFechaInicio(String fechaInicio) {
        try {
            this.fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
        } catch (Exception e) {
            System.out.println("ERROR AL PARSEAR LA FECHA : "+e);
        }
    
    }
    
    
    
}
