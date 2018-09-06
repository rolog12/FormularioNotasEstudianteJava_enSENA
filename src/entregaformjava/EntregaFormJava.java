/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregaformjava;

/*import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.text.DecimalFormat;import java.util.Scanner;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JTextField;*/
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author SENA
 */
//public class EntregaFormJava {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package formularionotas;

//import java.awt.event.*;
//import java.text.DecimalFormat;
//import java.util.Scanner;
//import javax.swing.*;

/**
 *
 * @author roalga20
 */
public class EntregaFormJava extends JFrame implements ActionListener
{
    
    private JLabel id,nombre1,nombreSistema,carrera,semestre,
            materia1,materia2,materia3,
            materia4,promedio, promedioLetras;
    private JTextField identificacionConsulta;
    private JButton unboton,imprimir;
    public EntregaFormJava()
    {
        setLayout (null);
        //TITULO DEL FORMULARIO
        nombreSistema=new JLabel("SISTEMA DE GESTIÓN DE NOTAS UNIVERSIDAD.");
        nombreSistema.setBounds (100,2,450,30);
        add(nombreSistema);
         //ID
        id=new JLabel("NÚMERO DE IDENTIFICACIÓN: ");
        id.setBounds(20,50,200,30);
        add(id);
        // Campo que recibe la identificacion a Buscar
        identificacionConsulta= new JTextField ();
        identificacionConsulta.setBounds(190,50,200,30);
        add(identificacionConsulta);
        //boton "imprimir" que envia datos a nuevo formulario
        imprimir =new JButton("Imprimir");
        imprimir.setBounds(400,50,100,30);
        add(imprimir);
        imprimir.addActionListener(this);
        //boton Finalizar
        unboton =new JButton("Finalizar");
        unboton.setBounds(250,100,100,30);
        add(unboton);
        unboton.addActionListener(this);        
    }
    public void actionPerformed (ActionEvent escuchabotones)
    {
        if (escuchabotones.getSource()==unboton)
        {
            System.exit(0);
        }
        if (escuchabotones.getSource()==imprimir)
        {
            ImprimirNotas Imprimir_obj= new ImprimirNotas();
            //DEFINIMOS VARIABLES
            String consulta="",unidades="",decimales="";
            byte fila=0;
            boolean loencontro=false;
            Scanner leer = new Scanner(System.in);
            DecimalFormat miformato = new DecimalFormat("#.00");
            double promediar=0,redondeo=0,parteDecimalParcial=0,parteDecimal=0;
            // FIN DEFINIMOS VARIABLES

            //INICIA MATRIZ
            String [][] matriz={{"51662369","Sandra Milena Castellanos Marín","Medicina","VI","3.5","4","3.3","3.5"},
                        {"80223220","Luis Andrés Montoya Montoya","Ingeniería de Telecomunicaciones","IV","3","3.3","4.2","4.5"},
                        {"79444555","Francisco Martínez Marin","Ingeniería de Alimentos","III","3.4","4.5","4.4","3"},
                        {"79001003","Luis Francisco Castañeda Roa","Ingeniería de Sistemas","VIII","3.3","3.4","4.5","4.4"},
                        {"79003003","Pedro José Pineda Pineda","Odontología","VI","4","4.1","3.9","4.5"},
                        {"52900901","Ruth Paola Mahecha Mahecha","Odontología","VII","3.6","3.6","3.8","3.9"},
                        {"26900345","Lucia Valderrama Pineda","Fisioterapia","VIII","4.4","4.5","4.1","3.1"},
                        {"35676900","Mariela Lucia Olguín Ramírez","Medicina","V","3","3.1","4.6","3.7"},
                        {"27101234","Lucila Peñaranda Peñaranda","Enfermería","II","2.5","4.6","3.4","4.6"},
                        {"80231678","Milena Palacios Palacios","Ingeniería Mecánica","III","3.6","3.4","3.5","4.5"},
                        {"1030617979","Luis Alberto Castellanos Frias","Odontología","VI","4","4.1","3.9","4.5"},
                        {"1019066342","Nercy Aleidis Rengifo Rengifo","Fisioterapia","VII","3.6","3.6","3.8","3.9"},
                        {"1014249436","Fabián Raúl Moreno Carvajal","Medicina","VIII","4.4","4.5","4.1","3.1"},
                        {"1022380843","Jonathan Mauricio Baez Baez","Enfermería","V","3","3.1","4.6","1.8"},
                        {"1012353083","Germán Dario Rodríguez Baez","Ingeniería Mecánica","II","2.5","4.6","3.4","4.6"},
                        {"1030630231","Diego Fernando Giraldo Romero","Ingeniería de Petróleo","III","3.6","3.4","3.5","4.5"},
                        {"1020765332","Luz Herminda Fonseca Daza","Psicología","VI","4","4.1","3.9","4.5"},
                        {"1022357137","Rhonald Dahian Jiménez García","Ingeniería Civil","VI","3.5","4","3.3","3.5"},
                        {"52263227","Edgar Andrés Bejarano Pérez","Ingeniería Civil","IV","3","3.3","4.2","4.5"},
                        {"1013579638","Diego Fernando Bautista Gómez","Ingeniería Civil","III","3.4","4.5","4.4","3"},
                        {"10306179791","Luis Alberto Jaime Hernández","Ingeniería  de Sistemas","II","4","4.1","3.9","4.5"},
                        {"10190663421","Zabala Pereira Nercy Aleidys","Ingeniería Mecánica","V","3","3.3","4.2","4.5"},
                        {"10142494361","Fabian Raul Duarte Serrano","Medicina","IV","3.6","3.6","3.8","3.9"},
                        {"10223808431","Jhonatan Mauricio Rodríguez  C.","Ingeniería de Petróleos","I","3.4","4.5","4.4","3"},
                        {"10123530831","German Dario González  Riaño","Ingeniería de Petróleos","III","3.4","4.5","4.4","3"},
                        {"96040605441","Michael Duvan Beltran Salcedo","Medicina","IV","3","3.3","4.2","4.5"},
                        {"1013641467","Romero Piña Dylan David","Fisioterapia","II","3.6","3.6","3.8","3.9"},
                        {"1030632107","Ruben Dario Fuquene C.","Ingeniería Mecánica","V","3","3.3","4.2","4.5"},
                        {"53072770","Maryory Cuesta Rodríguez","Ingeniería de Telecomunicaciones","IV","3","3.3","4.2","4.5"},
                        {"1014245401","Cristian Camilo Ortiz Ortiz","Ingeniería de Telecomunicaciones","VI","2","3.1","4.8","1.5"},
                        {"95070115361","Yuly Katherine Sierra","Ingeniería Mecánica","V","2.7","3.9","4.7","4.5"},
                        {"1020796896","Daniel Andres Zapata Bello","Ingeniería Mecánica","IV","3","3.3","4.2","4.5"},
                        {"1003819124","José Eitner Montiel  Aldana","Medicina","IV","3","3.3","4.2","4.5"},
                        {"1031131906","Luis Guillermo Andrade Cifuentes","Medicina","VIII","3.9","3.8","2.6","4.5"},
                        {"1019018284","Jairo Joel Noguera melo","Medicina","VIII","3.7","3.7","4.7","4"},
                        {"1014218719","Bryan Andrés Ortegón","Medicina","IV","3","3.3","4.2","4.5"},
                        {"1030611565","Mónica Andrea Plaza Bernal","Medicina","IV","3.6","3.8","4.8","4"}};
           //TERMINA MATRIZ
           consulta= identificacionConsulta.getText();
           //Imprimir_obj.nombre.setText(consulta.getText());     
            do
                {
                    if(consulta.equals(matriz[fila][0])) 
                    {
                        loencontro=true;
                    }
                    else
                    {
                        fila++;
                    }
                }while(loencontro==false && fila<37);
               // inicia fin
               if (loencontro)
                {            

                   promediar=   (Double.parseDouble(matriz[fila][4])+
                                Double.parseDouble(matriz[fila][5])+
                                Double.parseDouble(matriz[fila][6])+
                                Double.parseDouble(matriz[fila][7]))/4;
                   //imprimimos promedio redondeado
                   redondeo=(double)Math.round(promediar*10)/10;


                   //Calculo parte Decimal
                   parteDecimalParcial=(redondeo-(int)redondeo)*10;
                   parteDecimal=Math.round(parteDecimalParcial);
                   //fin calculo parte decimal*/

                    //NOMBRE
                    Imprimir_obj.nombre.setText("NOMBRES Y APELLIDOS DEL ESTUDIANTE: "+matriz[fila][1]);
                    
                    
                    //CARRERA
                    Imprimir_obj.carrera.setText("PROGRAMA DE FORMACIÓN: "+matriz[fila][2]);
                       //SEMESTRE
                    Imprimir_obj.semestre.setText("SEMESTRE ACTUAL: "+matriz[fila][3]);
                     //MATERIA1
                    Imprimir_obj.materia1.setText("MATERIA I: "+matriz[fila][4]);
                      //MATERIA2
                    Imprimir_obj.materia2.setText("MATERIA II: "+matriz[fila][5]);
                      //MATERIA3
                    Imprimir_obj.materia3.setText("MATERIA IIII: "+matriz[fila][6]);
                      //MATERIA4
                    Imprimir_obj.materia4.setText("MATERIA VI:"+matriz[fila][7]);
                     switch ((int)redondeo)
                        {
                            case 0: unidades="Cero";
                            break;
                            case 1: unidades="Uno";
                            break;
                            case 2: unidades="Dos";
                            break;
                            case 3: unidades="Tres";
                            break;
                            case 4: unidades="Cuatro";
                            break;
                            case 5: unidades="Cinco";
                            break;
                        }
                        switch ((int)parteDecimal)
                        {
                            case 0: decimales="Cero";
                            break;
                            case 1: decimales="Uno";
                            break;
                            case 2: decimales="Dos";
                            break;
                            case 3: decimales="Tres";
                            break;
                            case 4: decimales="Cuatro";
                            break;
                            case 5: decimales="Cinco";
                            break;
                            case 6: decimales="Seis";
                            break;
                            case 7: decimales="Siete";
                            break;
                            case 8: decimales="Ocho";
                            break;
                            case 9: decimales="Nueve";
                            break;
                        }
                        Imprimir_obj.promedio.setText("PROMEDIO: "+miformato.format(redondeo));                            
                        Imprimir_obj.promedioLetras.setText("El promedio de sus notas es: "+unidades+ " punto "+decimales);                            
                        //siga=JOptionPane.showConfirmDialog(null, "Esta seguro de la consulta?");
                        // INSTANCIAMOS CLASE IMPRIMIR
                        //ImprimirNotas Imprimir_obj= new ImprimirNotas();
                        Imprimir_obj.setBounds(400,20,500,450);
                        Imprimir_obj.setVisible(true);
                        Imprimir_obj.setResizable(false);
                        dispose();
                        //TERMINA INSTANCIA IMPRIMIR
                }
                else
                    {
                        JOptionPane.showMessageDialog(null, "LA PERSONA NO SE ENCUENTRA DENTRO DE NUESTROS REGISTROS"); //+siga
                    }            
        }
    }
    
    public static void main(String[] args)
    {
        EntregaFormJava formularioObjeto= new EntregaFormJava();
        formularioObjeto.setBounds(10,20,550,180);
        formularioObjeto.setVisible(true);
        formularioObjeto.setResizable(false);
    }    
}
