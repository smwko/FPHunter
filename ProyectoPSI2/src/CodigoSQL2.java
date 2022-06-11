import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

   
import javax.swing.*; 
 
public class CodigoSQL2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	//Info para conectarse al servidor de la base de datos.
	 private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
     private static final String DATABASE_URL = "jdbc:mysql://195.235.211.197/prsi_8_2"; //ip de la base
     private static final String USERNAME = "pr_si8user"; 
     private static final String PASSWORD = "vaisasuspender";
	 
     //Crea las tablas
     public static void createTableArea(){
           Connection connection = null;
           Statement statement = null;
           try {        	          	   
                 Class.forName(JDBC_DRIVER);
                 
                  connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);                  
                  
                  statement = connection.createStatement();
                  //boolean b=statement.execute("DROP TABLE IF EXISTS emp");
                  //Commando de SQL para crea la tabla              
                  boolean b=statement.execute("CREATE TABLE AREA(ID_AREA VARCHAR(20), AREA VARCHAR (100), PRIMARY KEY (ID_AREA));");                   
                  if(b==true)
                         System.out.println("Tables created...");
           } catch (SQLException sqlEx) {
                  sqlEx.printStackTrace();
                  System.exit(1);
           } catch (ClassNotFoundException clsNotFoundEx) {
                  clsNotFoundEx.printStackTrace();
                  System.exit(1);
           } finally {
                  try {
                         statement.close();
                         connection.close();
                  } catch (Exception e) {
                         System.exit(1);
                  }
           }
     }

     public static void createTableCurso(){
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                              PASSWORD);
                statement = connection.createStatement();
                //boolean b=statement.execute("DROP TABLE IF EXISTS emp");
                //Commando de SQL para crea la tabla               
                boolean b=statement.execute("CREATE TABLE CURSO(ID_CURSO VARCHAR (20), DESCRIPCION VARCHAR (400), DURACION_FORMACION INT, DURACION_PRACTICAS INT, ESPECIALIDAD_CERTIFICADO VARCHAR (3), MODALIDAD VARCHAR (20), ID_AREA VARCHAR (20), ID_CENTRO VARCHAR(20), PRIMARY KEY (ID_CURSO), FOREIGN KEY (ID_AREA) REFERENCES AREA(ID_AREA), FOREIGN KEY (ID_CENTRO) REFERENCES CENTRO (ID_CENTRO));");                   
                if(b==true)
                       System.out.println("Tables created...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       statement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }

     public static void createTableCentro(){
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                statement = connection.createStatement();
                //boolean b=statement.execute("DROP TABLE IF EXISTS emp");
                //Commando de SQL para crea la tabla               
                boolean b=statement.execute("CREATE TABLE CENTRO(ID_CENTRO VARCHAR (20), NOMBRE_CENTRO VARCHAR (150), TELEFONO VARCHAR (12), CORREO_ELECTRONICO VARCHAR (150), DIRECCION_CENTRO VARCHAR (150), CODIGO_POSTAL INT, ID_MUNICIPIO INT, PRIMARY KEY (ID_CENTRO), FOREIGN KEY (ID_MUNICIPIO) REFERENCES MUNICIPIO (ID_MUNICIPIO));");                   
                if(b==true)
                       System.out.println("Tables created...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       statement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }

     public static void createTableMunicipio(){
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                              PASSWORD);
                statement = connection.createStatement();
                //boolean b=statement.execute("DROP TABLE IF EXISTS emp");
                //Commando de SQL para crea la tabla               
                boolean b=statement.execute("CREATE TABLE MUNICIPIO (ID_MUNICIPIO INT, NOMBRE_MUNICIPIO VARCHAR (100), PRIMARY KEY (ID_MUNICIPIO));");                   
                if(b==true)
                       System.out.println("Tables created...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       statement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }


     //Ingresa informacion a la tabla correspondiente
     public static void fillArea(String ID, String area){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO AREA VALUES(?,?)");
                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, area);             
                boolean b = preparedStatement.execute();
                if(b==true)
                       System.out.println("1 record inserted...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       preparedStatement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }
        
     public static void fillCurso(String IDC, String descCurso, String duracionF, String duracionP, String espCurso, String modalidad, String IDsector, String IDCentro){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO CURSO VALUES(?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1, IDC);
                preparedStatement.setString(2, descCurso);
                preparedStatement.setString(3, duracionF);
                preparedStatement.setString(4, duracionP);               
                preparedStatement.setString(5, espCurso);
                preparedStatement.setString(6, modalidad);
                preparedStatement.setString(7, IDsector);
                preparedStatement.setString(8, IDCentro);
                boolean b=preparedStatement.execute();
                if(b==true)
                       System.out.println("1 record inserted...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       preparedStatement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }
     
     public static void fillCentro(String IDCentro, String nombreC, String telCentro, String emailCentro, String dirCentro, String cpCentro, String idMunicipio){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO CENTRO VALUES(?,?,?,?,?,?,?)");
                preparedStatement.setString(1, IDCentro);
                preparedStatement.setString(2, nombreC);
                preparedStatement.setString(3, telCentro);
                preparedStatement.setString(4, emailCentro);          
                preparedStatement.setString(5, dirCentro);
                preparedStatement.setString(6, cpCentro);
                preparedStatement.setString(7, idMunicipio);
                boolean b=preparedStatement.execute();
                if(b==true)
                       System.out.println("1 record inserted...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       preparedStatement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }
     
     public static void fillMunicipio(String idMunicipio, String municipio){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO MUNICIPIO VALUES(?,?)");
                preparedStatement.setString(1, idMunicipio);
                preparedStatement.setString(2, municipio);
                boolean b=preparedStatement.execute();
                if(b==true)
                       System.out.println("1 record inserted...");
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       preparedStatement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
   }

 
     //Leer la informacion de las tablas    
     public List<String> readInputUser(String municipio, String area, String especialidad) {
         Connection connection = null;
         Statement statement = null;
         List<String> list =new ArrayList<String>();
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                statement = connection.createStatement();         
                String SELECT = "SELECT * FROM MUNICIPIO, CENTRO, AREA, CURSO WHERE MUNICIPIO.ID_MUNICIPIO = CENTRO.ID_MUNICIPIO AND AREA.ID_AREA = CURSO.ID_AREA AND CENTRO.ID_CENTRO = CURSO.ID_CENTRO AND MUNICIPIO.NOMBRE_MUNICIPIO = '" + municipio + "'AND AREA.AREA = '" + area + "' AND CURSO.ESPECIALIDAD_CERTIFICADO = '" + especialidad + "';";
                ResultSet resultSet = statement.executeQuery(SELECT);
                
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();      
             
               
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {                            
                           
                    	   list.add(resultSet.getObject(i).toString());
                    	   
                       }    
                    
                }
                
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       statement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
  
         return list;
         
   }
     
     public List<String> readEstadisticasMunicipio() {
         Connection connection = null;
         Statement statement = null;
         List<String> list =new ArrayList<String>();
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                statement = connection.createStatement();         
                String SELECT = "SELECT MUNICIPIO.NOMBRE_MUNICIPIO AS 'MUNICIPIO', COUNT(CENTRO.ID_MUNICIPIO), ROUND(((COUNT(CENTRO.ID_MUNICIPIO))*100)/(SELECT COUNT(ID_CURSO) FROM CURSO), 2) AS PORCENTAJE FROM MUNICIPIO, CENTRO, CURSO WHERE CENTRO.ID_MUNICIPIO = MUNICIPIO.ID_MUNICIPIO AND CENTRO.ID_CENTRO = CURSO.ID_CENTRO GROUP BY CENTRO.ID_MUNICIPIO;";
                ResultSet resultSet = statement.executeQuery(SELECT);
                
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();                                 
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {                                                       
                    	   list.add(resultSet.getObject(i).toString());
                    	   
                       }    
                    
                }
                
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       statement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
  
         return list;
         
   }
     
     public List<String> readEstadisticasCurso() {
         Connection connection = null;
         Statement statement = null;
         List<String> list =new ArrayList<String>();
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                statement = connection.createStatement();         
                String SELECT = "SELECT ROUND((SELECT COUNT(CURSO.ID_CURSO) FROM CURSO WHERE CURSO.ESPECIALIDAD_CERTIFICADO = 'SI')*100 / COUNT(ID_CURSO), 2) AS '% CON CERTIFICADO', ROUND((SELECT COUNT(CURSO.ID_CURSO) FROM CURSO WHERE CURSO.ESPECIALIDAD_CERTIFICADO = 'NO')*100 / COUNT(ID_CURSO), 2) AS '% SIN CERTIFICADO', ROUND((SELECT COUNT(CURSO.ID_CURSO) FROM CURSO WHERE CURSO.MODALIDAD = 'PRESENCIAL')*100 / COUNT(ID_CURSO), 2) AS '% CURSO PRESENCIALES', ROUND((SELECT COUNT(CURSO.ID_CURSO) FROM CURSO WHERE CURSO.MODALIDAD = 'TELEFORMACION')*100 / COUNT(ID_CURSO), 2) AS '% CURSO TELEFORMACION', ROUND(SUM(DURACION_FORMACION)/COUNT(ID_CURSO), 2) AS 'DURACION MEDIA DE FORMACION', ROUND(SUM(DURACION_PRACTICAS)/COUNT(ID_CURSO), 2) AS 'DURACION MEDIA DE PRACTICAS' FROM CURSO;";
                ResultSet resultSet = statement.executeQuery(SELECT);
                
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();                                 
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {                                                       
                    	   list.add(resultSet.getObject(i).toString());
                    	   
                       }    
                    
                }
                
         } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
         } catch (ClassNotFoundException clsNotFoundEx) {
                clsNotFoundEx.printStackTrace();
                System.exit(1);
         } finally {
                try {
                       statement.close();
                       connection.close();
                } catch (Exception e) {
                       System.exit(1);
                }
         }
  
         return list;
         
   }
     //Lee un csv y lo guarda en una List<>
     protected static List<CSV> readFromCSV() {
    	 
	        List<CSV> csvs = new ArrayList<>();
	        String path = "C:\\Users\\mauv2\\Desktop\\UEM\\TablaPSIv0.4.csv";

	        
	        try  {
	        	// crea una instancia de BufferedReader para leer el csv
	        	BufferedReader br = new BufferedReader(new FileReader(path));

	            // lee la primera fila del csv
	            String line = br.readLine();

	            // loop hasta que lee todas las lineas
	            while (line != null) {

	                // usa string.split para cargar una matriz de cadenas con los valores de cada línea del archivo, usando una coma como delimitador
	                String[] attributes = line.split(",");

	                CSV csv = createTabla(attributes);

	                // agrega el array al arrayList
	                csvs.add(csv);

	                // le la siguiente fila y si encuentra algo regresa al inicio, si esta vacio termina el while loop	          
	                line = br.readLine();
	            }
	            
	            // cierra el BufferedReader
	            br.close();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	     
	        
	        return csvs;
	    }
 
	        
	    
     
	 protected static CSV createTabla(String[] metadata) {
	    	String IDcurso = metadata[0];
	    	String IDsector = metadata[1];
		    String DescSector = metadata[2];
		    String FamSector = metadata[3];
		    String AreaSector = metadata[4];		
		    String Desccurso = metadata[5];
		    String DurFcurso = metadata[6];
		    String DurPcurso = metadata[7];
		    String Espcurso = metadata[8];
		    String Modcurso = metadata[9];
		    String idCentro = metadata[10];
		    String Desccentro = metadata[11];
		    String Telcentro = metadata[12];
		    String Emailcentro = metadata[13];
		    String Dircentro = metadata[14];
		    String idMunicipio = metadata[15];
		    String CPcentro = metadata[16];
		    String Municipio = metadata[17];

	        // crea y regresa el array del metadata
		    
		    return new CSV(IDcurso, IDsector, DescSector, FamSector, AreaSector, Desccurso, DurFcurso, DurPcurso, Espcurso, Modcurso, idCentro, Desccentro, Telcentro, Emailcentro, Dircentro, idMunicipio, CPcentro, Municipio);

	    }

	}

	 class CSV {
	    
		private String IDcurso;
		private String IDsector;
	    private String DescSector;
	    private String FamSector;
	    private String AreaSector;
	    private String Desccurso;
	    private String DurFcurso;
	    private String DurPcurso;
	    private String Espcurso;
	    private String Modcurso;
	    private String idCentro;
	    private String Desccentro;
	    private String Telcentro;
	    private String Emailcentro;
	    private String Dircentro;
	    private String idMunicipio;
	    private String CPcentro;
	    private String Municipio;
	    
	    public CSV(String IDcurso, String IDsector, String DescSector, String FamSector, String AreaSector, String Desccurso, String DurFcurso, String DurPcurso, String Espcurso, String Modcurso, String idCentro, String Desccentro, String Telcentro, String Emailcentro, String Dircentro, String idMunicipio, String CPcentro, String Municipio) {
		
	    	this.setIDcurso(IDcurso);
	    	
	    	this.setIDsector(IDsector);
	    	this.setDescSector(DescSector);
	    	this.setFamSector(FamSector);
	    	this.setAreaSector(AreaSector);
	    	
	    	
	    	this.setDesccurso(Desccurso);
	    	this.setDurFcurso(DurFcurso);
	    	this.setDurPcurso(DurPcurso);
	    	this.setEspcurso(Espcurso);
	    	this.setModcurso(Modcurso);
	    	
	    	this.setIDCentro(idCentro);	    	
	    	this.setDesccentro(Desccentro);
	    	this.setTelcentro(Telcentro);
	    	this.setEmailcentro(Emailcentro);
	    	this.setDircentro(Dircentro);
	    	this.setidMunicipio(idMunicipio);
	    	this.setCPcentro(CPcentro);
	    	
	    	this.setMunicipio(Municipio);	
	    	
	    }
	    
	    public String getIDcurso() {
	        return IDcurso;
	    }

	    public void setIDcurso(String IDcurso) {
	    	// le dice al programa que esta instancia de IDcurso es igual al parametro que esta recibiendo
	        this.IDcurso = IDcurso;
	    }
	    	    
	    public String getIDsector() {
	    	return IDsector;
	    }
	    
	    public void setIDsector(String IDsector) {	    	
	    	this.IDsector = IDsector;
	    }

		public String getDescSector() {
			return DescSector;
		}

		public void setDescSector(String descSector) {
			DescSector = descSector;
		}

		public String getFamSector() {
			return FamSector;
		}

		public void setFamSector(String famSector) {
			FamSector = famSector;
		}

		public String getAreaSector() {
			return AreaSector;
		}

		public void setAreaSector(String areaSector) {
			AreaSector = areaSector;
		}

		public String getDesccurso() {
			return Desccurso;
		}

		public void setDesccurso(String desccurso) {
			Desccurso = desccurso;
		}

		public String getDurFcurso() {
			return DurFcurso;
		}

		public void setDurFcurso(String durFcurso) {
			DurFcurso = durFcurso;
		}

		public String getDurPcurso() {
			return DurPcurso;
		}

		public void setDurPcurso(String durPcurso) {
			DurPcurso = durPcurso;
		}

		public String getEspcurso() {
			return Espcurso;
		}

		public void setEspcurso(String espcurso) {
			Espcurso = espcurso;
		}

		public String getModcurso() {
			return Modcurso;
		}

		public void setModcurso(String modcurso) {
			Modcurso = modcurso;
		}

		public String getIDCentro() {
			return idCentro;
		}

		public void setIDCentro(String idcentro) {
			idCentro = idcentro;
		}

		public String getDesccentro() {
			return Desccentro;
		}

		public void setDesccentro(String desccentro) {
			Desccentro = desccentro;
		}

		public String getTelcentro() {
			return Telcentro;
		}

		public void setTelcentro(String telcentro) {
			Telcentro = telcentro;
		}

		public String getEmailcentro() {
			return Emailcentro;
		}

		public void setEmailcentro(String emailcentro) {
			Emailcentro = emailcentro;
		}

		public String getDircentro() {
			return Dircentro;
		}

		public void setDircentro(String dircentro) {
			Dircentro = dircentro;
		}

		public String getidMunicipio() {
			return idMunicipio;
			
		}
		
		public void setidMunicipio(String IDMunicipio){
			idMunicipio = IDMunicipio;
		}
		
		public String getCPcentro() {
			return CPcentro;
		}
		
		public void setCPcentro(String cPcentro) {
			CPcentro = cPcentro;
		}

		public String getMunicipio() {
			return Municipio;
		}

		public void setMunicipio(String municipio) {
			Municipio = municipio;
		}
		
		@Override
	    public String toString() {
	        return IDcurso + IDsector + DescSector + FamSector + AreaSector + Desccurso + DurFcurso + DurPcurso + Espcurso + Modcurso + idCentro + Desccentro + Telcentro + Emailcentro + Dircentro + idMunicipio + CPcentro + Municipio;
	    }

	
     
     
     
     
}
