import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunPSI extends CodigoSQL implements ActionListener{
	
	private JFrame frame;
	private JLabel munLabel;
	private JLabel ambLabel;
	private JLabel conLabel;
	private JButton button;
	private JLabel choice;
	private JComboBox<String> munComboBox;
	private JComboBox<String> ambComboBox;
	private JComboBox<String> conComboBox;
	
	public RunPSI(){
		
		String[] optionsMun = {"AJALVIR ", "ALAMO (EL) ", "ALCALA DE HENARES ","ALCOBENDAS ","ALCORCÓN ","ARANJUEZ ","ARGANDA DEL REY ","BOADILLA DEL MONTE ","BOALO (EL) ","BUITRAGO DEL LOZOYA ","CABRERA (LA) ","CADALSO DE LOS VIDRIOS ","CASARRUBUELOS ","CHINCHON ","CIEMPOZUELOS ","COLLADO VILLALBA ","COLMENAR VIEJO ","COSLADA ","CUBAS DE LA SAGRA ","DAGANZO DE ARRIBA ","ESCORIAL (EL) ","FUENLABRADA ","GALAPAGAR ","GETAFE ","GUADALIX DE LA SIERRA ","GUADARRAMA ","HUMANES DE MADRID ","LEGANÉS ","LLANERA ","LOECHES ","LOZOYUELA-NAVAS-SIETEIGLESIAS ","MADRID ","MAJADAHONDA ","MEJORADA DEL CAMPO ","MIRAFLORES DE LA SIERRA ","MOLAR (EL) ","MORALZARZAL ","MORATA DE TAJUÑA ","MÓSTOLES ","NAVALAGAMELLA ","NAVALCARNERO ","NAVAS DEL REY ","PARACUELLOS DE JARAMA ","PARLA ","PELAYOS DE LA PRESA ","PINTO ","PONFERRADA ","POZUELO DE ALARCON ","POZUELO DE ALARCÓN ","RIVAS-VACIAMADRID ","ROZAS DE MADRID (LAS) ","SAN AGUSTIN DEL GUADALIX ","SAN FERNANDO DE HENARES ","SAN MARTIN DE LA VEGA ","SAN MARTIN DE VALDEIGLESIAS ","SAN SEBASTIAN DE LOS REYES ","SAN SEBASTIÁN DE LOS REYES ","SERRANILLOS DEL VALLE ","SEVILLA LA NUEVA ","TORREJÓN DE ARDOZ ","TORREJON DE LA CALZADA ","TORREJON DE VELASCO ","TORRELODONES ","TORRES DE LA ALAMEDA ","TRES CANTOS ","VALDEMORO ","VENTURADA ","VILLA DEL PRADO ","VILLALBILLA ","VILLANUEVA DE LA CAÑADA ","VILLANUEVA DEL PARDILLO ","VILLAREJO DE SALVANES ","VILLAVICIOSA DE ODON "};
		String[] optionsAmb = {"Actividades auxiliares en la industria alimentaria", "Actividades culturales y recreativas", "Actividades físico-deportivo recreativas", "Actividades y técnicas gráficas artísticas", "Administración y auditoría", "Aeronáutica", "Agencias de viaje", "Agricultura", "Agroturismo", "Albañilería y acabados", "Alimentos diversos", "Alojamiento", "Análisis y control", "Asistencia social", "Asistencia social y servicios al consumidor", "Atención sanitaria", "Atención social", "Cárnicas", "Carpintería y mueble", "Carrocería de vehículos", "Centros", "Colocación y montaje", "Competencia clave", "Compraventa", "Comunicaciones", "Conducción de vehículos por carretera", "Confección en textil y piel", "Conservas vegetales", "Construcciones aeronáuticas", "Construcciones metálicas", "Desarrollo", "Diseño gráfico y multimedia", "Edición", "Eficiencia energética", "Electromecánica de vehículos", "Energía eléctrica", "Energías renovables", "Equipos electrónicos", "Especialidades sin área definida (administración y oficinas)", "Especialidades sin área definida (agraria)", "Estética", "Estructuras", "Fabricación electromecánica", "Finanzas y seguros", "Formación y educación", "Frío y climatización", "Ganadería", "Gas", "Gestión ambiental", "Gestión de la información y la comunicación", "Hormigón", "Horticultura", "Impresión", "Información, promoción y desarrollo turístico", "Informática", "Informática complementaria", "Instalaciones de telecomunicación", "Instalaciones eléctricas", "Jardinería", "Joyería y orfebrería", "Laboratorio químico", "Lenguas y dialectos españoles", "Logística comercial y gestión del transporte", "Manipulación alimentaria", "Maquinaria", "Maquinaria de construcción"	,  "Maquinaria y equipo industrial",  "Máquinas electromecánicas",  "Marketing y relaciones públicas",  "Montaje y mantenimiento de instalaciones",  "Operaciones mecánicas",  "Orientación laboral",  "Ornamentales y jardinería",  "Panadería, pastelería, confitería y molinería",  "Peluquería",  "Peluquería y tratamientos de belleza",  "Peluquería y tratamientos de piel y belleza",  "Pre-impresión",  "Prevención y recuperación",  "Producción audiovisual",  "Producción carpintería y mueble",  "Producción mecánica",  "Producciones fotográficas",  "Proyectos y seguimiento de Obras",  "Publicidad - imagen",  "Publicidad/imagen",  "Restauración",  "Seguridad y prevención",  "Seguridad y salud laboral",  "Seguros",  "Servicios al consumidor",  "Servicios y productos sanitarios",  "Sistemas y telemática",  "Soporte y ayuda al diagnóstico",  "Transformación y conversión en industrias gráficas",  "Transporte por carretera",  "Turismo", "Venta"};
		String[] optionsCon = {" Desempleado", " Empleado"};


		munComboBox = new JComboBox<>(optionsMun);
        munComboBox.setBounds(80, 50, 140, 20);
        ambComboBox = new JComboBox<>(optionsAmb);
        ambComboBox.setBounds(80, 50, 140, 20);
        conComboBox = new JComboBox<>(optionsCon);
        conComboBox.setBounds(80, 50, 140, 20);
		
        
		frame = new JFrame();
		frame.setSize(400,400);
		
		
		button = new JButton("Accept");
		button.addActionListener(this);
		munLabel = new JLabel("Municipio: ");
		munLabel.setBounds(10, 20, 80, 25);
		ambLabel = new JLabel("Ambito Profesional: ");
		ambLabel.setBounds(10, 20, 80, 25);
		conLabel = new JLabel("Condicion Laboral: ");
		conLabel.setBounds(10, 20, 80, 25);
		choice = new JLabel("");
		choice.setBounds(50, 50, 50, 50);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(5,2));
		panel.add(munLabel);
		panel.add(munComboBox);
		panel.add(ambLabel);
		panel.add(ambComboBox);
		panel.add(conLabel);
		panel.add(conComboBox);
		panel.add(button);

		
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		p2.setLayout(new GridLayout(1,1));
		p2.add(choice);
		
		
		frame.add(panel,BorderLayout.PAGE_START);
		frame.add(p2,BorderLayout.PAGE_END);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FPHunter");
		frame.pack();
		frame.setVisible(true);	
	}	
	
    public void actionPerformed(ActionEvent e) {
             String selected = "You selected " + munComboBox.getItemAt(munComboBox.getSelectedIndex()) + ambComboBox.getItemAt(ambComboBox.getSelectedIndex()) + conComboBox.getItemAt(conComboBox.getSelectedIndex());
             choice.setText(selected);
    }


	public static void main(String[] args) {					
					
	
		//createTableSector(); //works
		//createTableCurso(); //works
		//createTableUsuario(); //CUANDO FUNCIONE GUI
		//createTableCentro();	//works
		//createTableMunicipio(); //wip
		
		
		new RunPSI();
		
		/*
		List<Tabla> tabla = readFromCSV();		
		
			   
		for (int i = 0; i < tabla.size(); ++i) {
			createSector(tabla.get(i).getIDsector(),tabla.get(i).getDescSector(),(tabla.get(i).getFamSector()), (tabla.get(i).getAreaSector()),(tabla.get(i).getEspSector()));
		}
				
		for (int i = 0; i < tabla.size(); ++i) {
			createCurso(tabla.get(i).getIDcurso(), tabla.get(i).getDesccurso(), tabla.get(i).getDurFcurso(), tabla.get(i).getDurPcurso(), 
						tabla.get(i).getEspcurso(), tabla.get(i).getModcurso(), tabla.get(i).getIDsector());
		}			
		
		for (int i = 0; i < tabla.size(); ++i) {
			createCentro(tabla.get(i).getIDsector(), tabla.get(i).getDesccentro(), tabla.get(i).getTelcentro(), tabla.get(i).getEmailcentro(), 
					     tabla.get(i).getDircentro(), tabla.get(i).getCPcentro(), tabla.get(i).getIDcurso());	
		}	
				
		for (int i = 0; i < tabla.size(); ++i) {
			createMunicipio(tabla.get(i).getMunicipio());
		}
		
		
		
		
		/* HACER UNA VES QUE TENGA EL GUI
		for (int i = 0; i < tabla.size(); ++i) {
			createUsuario(null, null, null);;
		}
		*/
		
	}


}
