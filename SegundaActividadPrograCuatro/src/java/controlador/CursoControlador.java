package controlador;

import com.sun.xml.ws.security.opt.impl.util.SOAPUtil;
import dao.CursoDao;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;
import modelo.Curso;

public class CursoControlador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CursoDao cd = new CursoDao();
        Curso curso = new Curso();
        List<Curso> l = new LinkedList<Curso>();
        int option = Integer.MAX_VALUE;
        String fechaT = "";
        String fechap = "";

        System.out.println("========================================");
        while (option != 0) {
            System.out.println("que desea hacer?"
                    + "\n 1-insertar nuevo curso"
                    + "\n 2-Actualizar curso"
                    + "\n 3-Eliminar curso"
                    + "\n 4-Mostrar un curso "
                    + "\n 5-Listar Cursso"
                    + "\n 0-Sali del sistema");

            do {
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un numero valido");
                    sc.nextLine();
                }
            } while (option == Integer.MAX_VALUE);

            switch (option) {
                case 0:
                    System.out.println("----------------------------------------");
                    System.out.println("-----------------SALIENDO---------------");
                    System.out.println("----------------------------------------");
                    break;
                case 1:
                    System.out.println("----------------------------------------");
                    System.out.println("----------INSERTAR NUEVO CURSO----------");
                    System.out.println("----------------------------------------");
                    System.out.println("ESCRIBA EL NOMBRE DEL CURSO");
                    curso.setNombre(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA EL NOMBRE DEL INSTRUCTOR");
                    curso.setInstructor(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA EL PRECIO DEL CURSO");
                    curso.setPrecio(Double.MAX_VALUE);
                    while (curso.getPrecio() == Double.MAX_VALUE) {
                        try {
                            curso.setPrecio(sc.nextDouble());
                        } catch (Exception e) {
                            System.out.println("escriba un numero valido");
                            sc.nextLine();
                        }
                        if (Double.compare(curso.getPrecio(), 0) < 0) {
                            curso.setPrecio(Double.MAX_VALUE);
                            System.out.println("El precion puede ser 0 pero nunca menor que 0");
                        }
                    }
                    System.out.println("ESCRIBA LA FECHA DE INICIO DEL CURSO EN FORMATO \"dd/MM/yyyy\"");
                    fechaT = "";
                    while (fechaT.equals("")) {
                        try {
                            MaskFormatter formato = new MaskFormatter("##/##/####");
                            String texto = sc.next();
                            fechap = (String) formato.stringToValue(texto.trim());
                            fechaT = fechap;
                        } catch (Exception e) {
                            System.out.println("POR FAVOR INGRESE LA FECHA CON FORMATO dd/MM/yyyy ");
                            System.out.println("Ingrese la Fecha");
                        }
                    }
                    curso.setFechaInicio(fechaT);
                    cd.insert(curso);
                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    System.out.println("----------------------------------------");
                    System.out.println("------------ACTUALIZAR CURSO------------");
                    System.out.println("----------------------------------------");
                    curso = new Curso();
                    l = cd.selectAll();
                    System.out.println("ID" + "\t" + "NOMBRE" + "\t" + "INSTRUCTOR" + "\t" + "PRECIO" + "\t" + "FECHA DE INICIO");
                    for (Curso curso1 : l) {
                        System.out.println(curso1.getId() + "\t" + curso1.getNombre() + "\t" + curso1.getInstructor() + "\t" + curso1.getPrecio() + "\t" + curso1.getFechaInicioString());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL CURSO A ACTUALIZAR");
                    
                    curso.setId(Integer.MAX_VALUE);
                    while (curso.getId() == Integer.MAX_VALUE) {
                        try {
                            option = sc.nextInt();
                            curso.setId(option);
                        } catch (Exception e) {
                            System.out.println("Digite un numero valido");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                    System.out.println("ESCRIBA EL NOMBRE DEL CURSO");
                    curso.setNombre(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA EL NOMBRE DEL INSTRUCTOR");
                    curso.setInstructor(sc.next());
                    sc.nextLine();
                    System.out.println("ESCRIBA EL PRECIO DEL CURSO");
                    curso.setPrecio(Double.MAX_VALUE);
                    while (curso.getPrecio() == Double.MAX_VALUE) {
                        try {
                            curso.setPrecio(sc.nextDouble());
                        } catch (Exception e) {
                            System.out.println("escriba un numero valido");
                            sc.nextLine();
                        }
                        if (Double.compare(curso.getPrecio(), 0) < 0) {
                            curso.setPrecio(Double.MAX_VALUE);
                            System.out.println("El precion puede ser 0 pero nunca menor que 0");
                        }
                    }
                    System.out.println("ESCRIBA LA FECHA DE INICIO DEL CURSO EN FORMATO \"dd/MM/yyyy\"");
                    fechaT = "";
                    while (fechaT.equals("")) {
                        try {
                            MaskFormatter formato = new MaskFormatter("##/##/####");
                            String texto = sc.next();
                            fechap = (String) formato.stringToValue(texto.trim());
                            fechaT = fechap;
                        } catch (Exception e) {
                            System.out.println("POR FAVOR INGRESE LA FECHA CON FORMATO dd/MM/yyyy ");
                            System.out.println("Ingrese la Fecha");
                        }
                    }
                    curso.setFechaInicio(fechaT);
                    cd.update(curso);
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    System.out.println("----------------------------------------");
                    System.out.println("-------------ELIMINAR CURSO-------------");
                    System.out.println("----------------------------------------");
                     l = cd.selectAll();
                    System.out.println("ID" + "\t" + "NOMBRE" + "\t" + "INSTRUCTOR" + "\t" + "PRECIO" + "\t" + "FECHA DE INICIO");
                    for (Curso curso1 : l) {
                        System.out.println(curso1.getId() + "\t" + curso1.getNombre() + "\t" + curso1.getInstructor() + "\t" + curso1.getPrecio() + "\t" + curso1.getFechaInicioString());
                    }
                    System.out.println("****************************************");
                    System.out.println("ESCRIBA EL ID DEL CURSO A ELIMINAR");
                    cd.delete(sc.nextInt());
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    System.out.println("----------------------------------------");
                    System.out.println("--------------MIRAR UN CURSO------------");
                    System.out.println("----------------------------------------");
                    l = cd.selectAll();
                    System.out.println("ID" + "\t" + "NOMBRE");
                    for (Curso curso1 : l) {
                        System.out.println(curso1.getId() + "\t" + curso1.getNombre());
                    }
                    System.out.println("ESCRIBA EL ID DEL CURSO A VER");
                    curso = cd.oneCurso(sc.nextInt());
                    System.out.println(curso.getId() + "\t" + curso.getNombre() + "\t" + curso.getInstructor() + "\t" + curso.getPrecio() + "\t" + curso.getFechaInicioString());
                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("----------------------------------------");
                    System.out.println("------------TODOS LOS CURSOS------------");
                    System.out.println("----------------------------------------");
                    l = cd.selectAll();
                    System.out.println("ID" + "\t" + "NOMBRE" + "\t" + "INSTRUCTOR" + "\t" + "PRECIO" + "\t" + "FECHA DE INICIO");
                    for (Curso curso1 : l) {
                        System.out.println(curso1.getId() + "\t" + curso1.getNombre() + "\t" + curso1.getInstructor() + "\t" + curso1.getPrecio() + "\t" + curso1.getFechaInicioString());
                    }
                    System.out.println("----------------------------------------");
                    break;
                default:
                    System.out.println("POR FAVOR DIGITE UN NUMERO VALIDO");
                    break;
            }
        }
        System.out.println("========================================");
    }
}
