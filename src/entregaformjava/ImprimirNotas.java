/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregaformjava;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package formularionotas;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author roalga20
 */
public class ImprimirNotas extends JFrame implements ActionListener
{
    public JLabel nombre,carrera,semestre,
            materia1,materia2,materia3,
            materia4,promedio,promedioLetras,nombreSistema;
    private JButton NuevaConsulta,Finalizar;
    public ImprimirNotas()
    {
        setLayout(null);
        //TITULO SISTEMA
        nombreSistema=new JLabel("SISTEMA DE GESTIÓN DE NOTAS UNIVERSIDAD.");
        nombreSistema.setBounds (100,2,450,30);
        add(nombreSistema);
        
        //NOMBRE
        nombre=new JLabel("NOMBRES Y APELLIDOS DEL ESTUDIANTE: ");
        nombre.setBounds(20,50,500,30);
        add(nombre);
        //nombre1.setText("NOMBRES Y APELLIDOS DEL ESTUDIANTE: "+matriz[fila][1]);
        //CARRERA
        carrera=new JLabel("PROGRAMA DE FORMACIÓN: ");
        carrera.setBounds(20,80,500,30);
        add(carrera);
           //SEMESTRE
        semestre=new JLabel("SEMESTRE ACTUAL: ");
        semestre.setBounds(20,110,500,30);
        add(semestre);
          //MATERIA1
        materia1=new JLabel("MATERIA I: ");
        materia1.setBounds(20,140,100,30);
        add(materia1);
          //MATERIA2
        materia2=new JLabel("MATERIA II:");
        materia2.setBounds(20,170,100,30);
        add(materia2);
          //MATERIA3
        materia3=new JLabel("MATERIA III:");
        materia3.setBounds(20,200,100,30);
        add(materia3);
          //MATERIA4
        materia4=new JLabel("MATERIA IV:");
        materia4.setBounds(20,230,100,30);
        add(materia4);
        // promedio
        promedio=new JLabel("PROMEDIO:");
        promedio.setBounds(20,260,100,30);
        add(promedio);
        // RESULTADO EN TEXTO DEL PROMEDIO
        promedioLetras=new JLabel("El promedio de sus notas es: ");
        promedioLetras.setBounds(20,290,600,30);
        add(promedioLetras);
        // BOTON NuevaConsulta
        NuevaConsulta =new JButton("Nueva Consulta");
        NuevaConsulta.setBounds(100,360,150,30);
        add(NuevaConsulta);
        NuevaConsulta.addActionListener(this);
        // BOTON FINALIZAR
        Finalizar =new JButton("FINALIZAR");
        Finalizar.setBounds(300,360,150,30);
        add(Finalizar);
        Finalizar.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent escuchaBotones)
    {
        if(escuchaBotones.getSource()==Finalizar)
        {
            System.exit(0);
        }
        
        if (escuchaBotones.getSource()==NuevaConsulta)
        {
            EntregaFormJava FormularioNotas_obj = new EntregaFormJava();
            FormularioNotas_obj.setBounds(10,20,550,180);
            FormularioNotas_obj.setVisible(true);
            FormularioNotas_obj.setResizable(false);
            dispose();
        }
    }    
}
