import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.*;    
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.rmi.activation.ActivationGroupID;


public class RunPSI2 extends CodigoSQL2{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1138210468110099561L;
	//Atributos General
	private JFrame frame;
	private CardLayout crd;   	
	@SuppressWarnings("unused")
	private int currentCard = 1;
	private Container cPane;
	private JButton buttonAtras, buttonAtras2, buttonAtras3, buttonAtras4;
	
	//Atributos Panel Control
	private JLabel selecionLabel, tituloLabel;
	private JButton crearTablasButton, llenarTablasButton, usuarioButton, estadisticasButton;
	
	//Atributos Panel Crear Tablas
	private JLabel labelCrearArea, labelCrearCurso, labelCrearCentro, labelCrearMunicipio;
	private JButton buttonCrearArea, buttonCrearCurso, buttonCrearCentro, buttonCrearMunicipio;
	
	//Atributos Panel Llenar Tablas
	private JLabel labelLlenarArea, labelLlenarCurso, labelLlenarCentro, labelLlenarMunicipio;
	private JButton buttonlLlenarArea, buttonlLlenarCurso, buttonlLlenarCentro, buttonlLlenarMunicipio;
	
	//Atributos Panel Ingresar Datos Usuario
	private JLabel municipioLabel, ambitoLabel, condicionLabel;
	private JButton buttonIngresar;
	private JComboBox<String> municipioComboBox, condicionComboBox, ambitoComboBox;

	//Atributos Panel Datos Ingresados por Usuario
	private DefaultTableModel tableModelUser;
	private JTable jtUser;
	
	//Atributos Panel Estadisticas
	private DefaultTableModel tableModelEstadisticasMunicipio, tableModelEstadisticasCurso;
	private JTable jtEstadisticasMunicipio, jtEstadsiticasCurso;
	
	
	public RunPSI2(){ 
		
		//Declarar Frame
		frame = new JFrame();
		frame.setSize(800,800);
		
		
		//Declarar CardLayout
		crd = new CardLayout(); 
		
		
		//Declarar y Vincular Contenedor 
		cPane = getContentPane();
		cPane.setLayout(crd);  		
		
		
		//Componentes General
		buttonAtras = new JButton(new AbstractAction("Atras") {
			@Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (1));
	        }
	    });
		buttonAtras2 = new JButton(new AbstractAction("Atras") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (1));
	        }
	    });
		buttonAtras3 = new JButton(new AbstractAction("Atras") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (1));
	        }
	    });
		
		//Componentes de panel estadisticas
		tableModelEstadisticasMunicipio = new DefaultTableModel();
		jtEstadisticasMunicipio = new JTable(tableModelEstadisticasMunicipio);
		JScrollPane spEstadisticasMunicipio = new JScrollPane(jtEstadisticasMunicipio);	
		
		tableModelEstadisticasCurso = new DefaultTableModel();
		jtEstadsiticasCurso = new JTable(tableModelEstadisticasCurso);
		JScrollPane spEstadisticasCurso = new JScrollPane(jtEstadsiticasCurso);
		CodigoSQL2 read = new CodigoSQL2();
    	List<String> listM= read.readEstadisticasMunicipio();    
    	List<String> listC= read.readEstadisticasCurso();  
        String[] columnM = {"Nombre de Municipio", "Numero de Centros", "Porcentaje de Centros" };
        String[] columnC = {"% de Cursos con Certificado", "% de Cursos	sin Certificado", "% de Cursos Presenciales", "% de Cursos Telematicos", "Duracion Media de Formacion", "Duracion Media de Practias" };
        for(int i = 0; i < columnM.length; i++) {	            	
            tableModelEstadisticasMunicipio.addColumn(columnM[i]);
        }           
        for(int i = 0; i < listM.size(); i += columnM.length) {
        	tableModelEstadisticasMunicipio.addRow(listM.subList(i, i+columnM.length).toArray());
        }    		
        for(int i = 0; i < columnC.length; i++) {	            	
            tableModelEstadisticasCurso.addColumn(columnC[i]);
        }           
        for(int i = 0; i < listC.size(); i += columnC.length) {
        	tableModelEstadisticasCurso.addRow(listC.subList(i, i+columnC.length).toArray());
        }   
         
		
		
		//Componentes de Panel Control
		tituloLabel = new JLabel("FPHunter");
		selecionLabel = new JLabel("Que desea hacer?");
		crearTablasButton = new JButton(new AbstractAction("Crear Tablas") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (4));
	        }
	    });	
		llenarTablasButton = new JButton(new AbstractAction("Llenar Tablas") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (5));
	        }
	    });	
		usuarioButton = new JButton(new AbstractAction("Buscar Curso") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (2));
	        }
	    });	
		estadisticasButton = new JButton(new AbstractAction("Ver Estadisticas de Tablas") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	crd.show(cPane, "" + (6));
	        	
	        	}
	        	
	        	
	        }
	    );	
		
		//Componentes de Panel Crear Tablas
		labelCrearArea = new JLabel("Crear Tabla Area");
		labelCrearCurso = new JLabel("Crear Tabla Cursos");
		labelCrearCentro =  new JLabel("Crear Tabla Centros");
		labelCrearMunicipio = new JLabel("Crear Tabla Municipios");
		buttonCrearArea = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        
	        	createTableArea(); //works	    		
	        }
	    });	
		buttonCrearCurso = new JButton(new AbstractAction("Selecionar") {
	        /**
			 * 
			 */
			private static final long serialVersionUID = -1528794900506012807L;

			@Override
	        public void actionPerformed( ActionEvent e ) {
	    		createTableCurso(); //works    	
	        }
	    });	
		buttonCrearCentro = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) { 
	        	
	    		createTableCentro(); //works
	        }
	    });	
		buttonCrearMunicipio = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	
	    		createTableMunicipio(); //works
	        }
	    });	
		
		
		//Componentes de Panel Llenar Tablas
		labelLlenarArea = new JLabel("Llenar Tabla Area");
		labelLlenarCurso = new JLabel("Llenar Tabla Curso");
		labelLlenarCentro = new JLabel("Llenar Tabla Centro");
		labelLlenarMunicipio = new JLabel("Llenar Tabla Municipio");
		buttonlLlenarArea = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	
	        	List<CSV> csv = readFromCSV();	        	    
	    	
	        	for (int i = 0; i < csv.size(); ++i) {
	        	 
	        		
	        		if (i == 0) {
	        			
	        			fillArea(csv.get(i).getIDsector(),csv.get(i).getAreaSector());
	        		
	        		}
	        		
	        		else {
	        			if (!csv.get(i).getIDsector().equals(csv.get(i-1).getIDsector())) {
	        			
	        				fillArea(csv.get(i).getIDsector(),csv.get(i).getAreaSector());
	        			
	        			}
	        		}
	        		
	    			
	    		}    		
	        }
	    });	
		buttonlLlenarCurso = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	List<CSV> csv = readFromCSV();	
	        	
	        	for (int i = 0; i < csv.size(); ++i) {
	    			fillCurso(csv.get(i).getIDcurso(), csv.get(i).getDesccurso(), csv.get(i).getDurFcurso(), csv.get(i).getDurPcurso(), 
	    						csv.get(i).getEspcurso(), csv.get(i).getModcurso(), csv.get(i).getIDsector(), csv.get(i).getIDCentro());
	        	}
	        } 	
	    });	
		buttonlLlenarCentro = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	List<CSV> csv = readFromCSV();	
	        		       
	        	
	        	for (int i = 0; i < csv.size(); ++i) {
	        		
	        			if (i == 0) {	     			
	        				fillCentro(csv.get(i).getIDCentro(), csv.get(i).getDesccentro(), csv.get(i).getTelcentro(), csv.get(i).getEmailcentro(), csv.get(i).getDircentro(), csv.get(i).getCPcentro(), csv.get(i).getidMunicipio());	
	        		
	        			}
	        			else
	        				if(!csv.get(i).getIDCentro().equals(csv.get(i-1).getIDCentro())) {
	        					fillCentro(csv.get(i).getIDCentro(), csv.get(i).getDesccentro(), csv.get(i).getTelcentro(), csv.get(i).getEmailcentro(), csv.get(i).getDircentro(), csv.get(i).getCPcentro(), csv.get(i).getidMunicipio());
	        					
	        				}			
	    		}
	        }
	    });	
		buttonlLlenarMunicipio = new JButton(new AbstractAction("Selecionar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	
	        	String[] municipios = {"AJALVIR", "ALAMO (EL)", "ALCALA DE HENARES","ALCOBENDAS","ALCORCON","ARANJUEZ","ARGANDA DEL REY","BOADILLA DEL MONTE","BOALO (EL)","BUITRAGO DEL LOZOYA","CABRERA (LA)","CADALSO DE LOS VIDRIOS","CASARRUBUELOS","CHINCHON","CIEMPOZUELOS","COLLADO VILLALBA","COLMENAR VIEJO","COSLADA","CUBAS DE LA SAGRA","DAGANZO DE ARRIBA","ESCORIAL (EL)","FUENLABRADA","GALAPAGAR","GETAFE","GUADALIX DE LA SIERRA","GUADARRAMA","HUMANES DE MADRID","LEGANES","LLANERA","LOECHES","LOZOYUELA-NAVAS-SIETEIGLESIAS","MADRID","MAJADAHONDA","MEJORADA DEL CAMPO","MIRAFLORES DE LA SIERRA","MOLAR (EL)","MORALZARZAL","MORATA DE TAJUNA","MOSTOLES","NAVALAGAMELLA","NAVALCARNERO","NAVAS DEL REY","PARACUELLOS DE JARAMA","PARLA","PELAYOS DE LA PRESA","PINTO","PONFERRADA","POZUELO DE ALARCON","POZUELO DE ALARCON","RIVAS-VACIAMADRID","ROZAS DE MADRID (LAS)","SAN AGUSTIN DEL GUADALIX","SAN FERNANDO DE HENARES","SAN MARTIN DE LA VEGA","SAN MARTIN DE VALDEIGLESIAS","SAN SEBASTIAN DE LOS REYES","SAN SEBASTIAN DE LOS REYES","SERRANILLOS DEL VALLE","SEVILLA LA NUEVA","TORREJON DE ARDOZ","TORREJON DE LA CALZADA","TORREJON DE VELASCO","TORRELODONES","TORRES DE LA ALAMEDA","TRES CANTOS","VALDEMORO","VENTURADA","VILLA DEL PRADO","VILLALBILLA","VILLANUEVA DE LA CANADA","VILLANUEVA DEL PARDILLO","VILLAREJO DE SALVANES","VILLAVICIOSA DE ODON"};
	        	
	        	for (int i = 0; i < 72; ++i) {	   
	        		String s=String.valueOf(i+1);
	        		
	    			fillMunicipio(s, municipios[i]);
	    		}
	        	
	        	
	        	
	        }
	    });	
		
		
		//Componentes de Panel Ingresar Datos		
		String[] optionsMunicipio = {"AJALVIR", "ALAMO (EL)", "ALCALA DE HENARES","ALCOBENDAS","ALCORCON","ARANJUEZ","ARGANDA DEL REY","BOADILLA DEL MONTE","BOALO (EL)","BUITRAGO DEL LOZOYA","CABRERA (LA)","CADALSO DE LOS VIDRIOS","CASARRUBUELOS","CHINCHON","CIEMPOZUELOS","COLLADO VILLALBA","COLMENAR VIEJO","COSLADA","CUBAS DE LA SAGRA","DAGANZO DE ARRIBA","ESCORIAL (EL)","FUENLABRADA","GALAPAGAR","GETAFE","GUADALIX DE LA SIERRA","GUADARRAMA","HUMANES DE MADRID","LEGANES","LLANERA","LOECHES","LOZOYUELA-NAVAS-SIETEIGLESIAS","MADRID","MAJADAHONDA","MEJORADA DEL CAMPO","MIRAFLORES DE LA SIERRA","MOLAR (EL)","MORALZARZAL","MORATA DE TAJUNA","MOSTOLES","NAVALAGAMELLA","NAVALCARNERO","NAVAS DEL REY","PARACUELLOS DE JARAMA","PARLA","PELAYOS DE LA PRESA","PINTO","PONFERRADA","POZUELO DE ALARCON","POZUELO DE ALARCON","RIVAS-VACIAMADRID","ROZAS DE MADRID (LAS)","SAN AGUSTIN DEL GUADALIX","SAN FERNANDO DE HENARES","SAN MARTIN DE LA VEGA","SAN MARTIN DE VALDEIGLESIAS","SAN SEBASTIAN DE LOS REYES","SAN SEBASTIAN DE LOS REYES","SERRANILLOS DEL VALLE","SEVILLA LA NUEVA","TORREJON DE ARDOZ","TORREJON DE LA CALZADA","TORREJON DE VELASCO","TORRELODONES","TORRES DE LA ALAMEDA","TRES CANTOS","VALDEMORO","VENTURADA","VILLA DEL PRADO","VILLALBILLA","VILLANUEVA DE LA CANADA","VILLANUEVA DEL PARDILLO","VILLAREJO DE SALVANES","VILLAVICIOSA DE ODON"};
		String[] optionsAmbito = {"Actividades auxiliares en la industria alimentaria", "Actividades culturales y recreativas", "Actividades fisico-deportivo recreativas", "Actividades y tecnicas graficas artisticas", "Administracion y auditoria", "Aeronautica", "Agencias de viaje", "Agricultura", "Agroturismo", "Albanileria y acabados", "Alimentos diversos", "Alojamiento", "Analisis y control", "Asistencia social", "Asistencia social y servicios al consumidor", "Atencion sanitaria", "Atencion social", "Carnicas", "Carpinteria y mueble", "Carroceria de vehiculos", "Centros", "Colocacion y montaje", "Competencia clave", "Compraventa", "Comunicaciones", "Conduccion de vehiculos por carretera", "Confeccion en textil y piel", "Conservas vegetales", "Construcciones aeronauticas", "Construcciones metalicas", "Desarrollo", "Diseno grafico y multimedia", "Edicion", "Eficiencia energetica", "Electromecanica de vehiculos", "Energia electrica", "Energias renovables", "Equipos electronicos", "Especialidades sin area definida (administracion y oficinas)", "Especialidades sin area definida (agraria)", "Estetica", "Estructuras", "Fabricacion electromecanica", "Finanzas y seguros", "Formacion y educacion", "Frio y climatizacion", "Ganaderia", "Gas", "Gestion ambiental", "Gestion de la informacion y la comunicacion", "Hormigon", "Horticultura", "Impresion", "Informacion, promocion y desarrollo turistico", "Informatica", "Informatica complementaria", "Instalaciones de telecomunicacion", "Instalaciones electricas", "Jardineria", "Joyeria y orfebreria", "Laboratorio quimico", "Lenguas y dialectos espanoles", "Logistica comercial y gestion del transporte", "Manipulacion alimentaria", "Maquinaria", "Maquinaria de construccion"	,  "Maquinaria y equipo industrial",  "Maquinas electromecanicas",  "Marketing y relaciones publicas",  "Montaje y mantenimiento de instalaciones",  "Operaciones mecanicas",  "Orientacion laboral",  "Ornamentales y jardineria",  "Panaderia, pasteleria, confiteria y molineria",  "Peluqueria",  "Peluqueria y tratamientos de belleza",  "Peluqueria y tratamientos de piel y belleza",  "Pre-impresion",  "Prevencion y recuperacion",  "Produccion audiovisual",  "Produccion carpinteria y mueble",  "Produccion mecanica",  "Producciones fotograficas",  "Proyectos y seguimiento de Obras",  "Publicidad - imagen",  "Publicidad/imagen",  "Restauracion",  "Seguridad y prevencion",  "Seguridad y salud laboral",  "Seguros",  "Servicios al consumidor",  "Servicios y productos sanitarios",  "Sistemas y telematica",  "Soporte y ayuda al diagnostico",  "Transformacion y conversion en industrias graficas",  "Transporte por carretera",  "Turismo", "Venta"};
		String[] optionsCondicion = {"SI", "NO"};
		
		tableModelUser = new DefaultTableModel();
		jtUser = new JTable(tableModelUser);
		municipioComboBox = new JComboBox<>(optionsMunicipio);
        municipioComboBox.setBounds(80, 50, 140, 20);
        ambitoComboBox = new JComboBox<>(optionsAmbito);
        ambitoComboBox.setBounds(80, 50, 140, 20);
        condicionComboBox = new JComboBox<>(optionsCondicion);
        condicionComboBox.setBounds(80, 50, 140, 20);					
        municipioLabel = new JLabel("Municipio: ");
		municipioLabel.setBounds(10, 20, 80, 25);
		ambitoLabel = new JLabel("Area Profesional: ");
		ambitoLabel.setBounds(10, 20, 80, 25);
		condicionLabel = new JLabel("Quieres un certificado de especialidad?  ");
		condicionLabel.setBounds(10, 20, 80, 25);
		buttonIngresar = new JButton(new AbstractAction("Ingresar") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	        	String municipio = municipioComboBox.getItemAt(municipioComboBox.getSelectedIndex());
	        	String area = ambitoComboBox.getItemAt(ambitoComboBox.getSelectedIndex());
	        	String condicion = condicionComboBox.getItemAt(condicionComboBox.getSelectedIndex());
	        	CodigoSQL2 read = new CodigoSQL2();
	        	
	        	String selected = "Has elegido el Municipio: " + municipio + ", el Area: " + area + " y" + condicion + " quiere un certificado de especialidad";	             
	            
	            List<String> list= read.readInputUser(municipio, area, condicion);
	           // choice.setText(list.get(1));
	            crd.show(cPane, "" + (3));
	            
	            String[] column = {"ID_MUNICIPIO", "NOMBRE_MUNICIPIO", "ID_CENTRO", "NOMBRE_CENTRO", "TELEFONO", "CORREO_ELECTRONICO", "DIRECCION_CENTRO", "CODIGO_POSTAL", "ID_MUNICIPIO", "ID_AREA", "AREA", "ID_CURSO", "DESCRIPCION", "DURACION_FORMACION", "DURACION_PRACTICAS", "ESPECIALIDAD_CERTIFICADO", "MODALIDAD","ID_AREA", "ID_CENTRO"};	    			           
	            
	            for(int i = 0; i < column.length; i++) {	            	
	            	tableModelUser.addColumn(column[i]);
	            }
	            
	            for(int i = 0; i < list.size(); i += column.length) {
	            	tableModelUser.addRow(list.subList(i, i+column.length).toArray());
	            		
	            	   		            	
	            }
	       	            	    
	            
	        	
	        }
	    });	
		
		
		//Componentes de panel Datos Ingresados				
		JScrollPane spUser = new JScrollPane(jtUser);  
		
		
		//Construir Panel Control
		JPanel panelControl = new JPanel();
		panelControl.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
		panelControl.setLayout(new GridLayout(3, 2, 10, 10));
		panelControl.add(tituloLabel);
		panelControl.add(selecionLabel);
		panelControl.add(crearTablasButton);
		panelControl.add(llenarTablasButton);
		panelControl.add(usuarioButton);
		panelControl.add(estadisticasButton);
		
		//Construir Panel Crear Tablas
		JPanel panelCrearTablas = new JPanel();
		panelCrearTablas.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
		panelCrearTablas.setLayout(new GridLayout(6, 3, 10, 10));
		panelCrearTablas.add(labelCrearArea);
		panelCrearTablas.add(buttonCrearArea);
		panelCrearTablas.add(labelCrearMunicipio);
		panelCrearTablas.add(buttonCrearMunicipio);
		panelCrearTablas.add(labelCrearCentro);
		panelCrearTablas.add(buttonCrearCentro);
		panelCrearTablas.add(labelCrearCurso);
		panelCrearTablas.add(buttonCrearCurso);
		panelCrearTablas.add(buttonAtras);
		
		//Contruir Panel Llenar Tablas
		JPanel panelLlenarTablas = new JPanel();
		panelLlenarTablas.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
		panelLlenarTablas.setLayout(new GridLayout(6, 2, 10, 10));
		panelLlenarTablas.add(labelLlenarMunicipio);
		panelLlenarTablas.add(buttonlLlenarMunicipio);
		panelLlenarTablas.add(labelLlenarArea);
		panelLlenarTablas.add(buttonlLlenarArea);
		panelLlenarTablas.add(labelLlenarCentro);
		panelLlenarTablas.add(buttonlLlenarCentro);	
		panelLlenarTablas.add(labelLlenarCurso);
		panelLlenarTablas.add(buttonlLlenarCurso);
		panelLlenarTablas.add(buttonAtras2);
		
		//Construir Panel Ingresar Datos
		JPanel panelIngresarDatos = new JPanel();
		panelIngresarDatos.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
		panelIngresarDatos.setLayout(new GridLayout(6 ,2, 10, 10));
		panelIngresarDatos.add(municipioLabel);
		panelIngresarDatos.add(municipioComboBox);
		panelIngresarDatos.add(ambitoLabel);
		panelIngresarDatos.add(ambitoComboBox);
		panelIngresarDatos.add(condicionLabel);
		panelIngresarDatos.add(condicionComboBox);
		panelIngresarDatos.add(buttonIngresar);
		panelIngresarDatos.add(buttonAtras3);

		
		//Construir Panel Datos Ingresados
		JPanel panelDatosIngresados = new JPanel();
		panelDatosIngresados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelDatosIngresados.setLayout(new GridLayout());
		panelDatosIngresados.add(spUser);
		
		//Contruir Panel Estadisticas
		JPanel panelEstadisticas = new JPanel();
		panelEstadisticas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelEstadisticas.setLayout(new GridLayout(1, 2));	
		panelEstadisticas.add(spEstadisticasCurso);
		panelEstadisticas.add(spEstadisticasMunicipio);
		
		//Construir panel de control
		cPane.add(panelControl, "1");
		cPane.add(panelIngresarDatos,"2");
		cPane.add(panelDatosIngresados, "3");
		cPane.add(panelCrearTablas, "4");
		cPane.add(panelLlenarTablas, "5");
		cPane.add(panelEstadisticas, "6");
			
		
		//Contruir frame
		frame.add(cPane,BorderLayout.PAGE_START);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FPHunter");
		frame.pack();
		frame.setVisible(true);	
	}	
	
	public static void main(String[] args) {						
		new RunPSI2();
					
	}
}
