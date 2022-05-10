import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


 
public class CodigoSQL{

	 //Info para conectarse al servidor de la base de datos.
	 private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
     private static final String DATABASE_URL = "jdbc:mysql://195.235.211.197/prsi_8"; //ip de la base
     private static final String USERNAME = "pr_si8user"; 
     private static final String PASSWORD = "jjw.8";
	
     //Crea las tablas
     public static void createTableSector(){
           Connection connection = null;
           Statement statement = null;
           try {        	          	   
                 Class.forName(JDBC_DRIVER);
                 
                  connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                  
                  if(connection != null){
                	System.out.println();  
                  }
                  
                  statement = connection.createStatement();
                  //boolean b=statement.execute("DROP TABLE IF EXISTS emp");
                  //Commando de SQL para crea la tabla               
                  boolean b=statement.execute("CREATE TABLE SECTOR(ID_SECTOR INT, SECTOR VARCHAR (25), FAMILIA VARCHAR (50), AREA VARCHAR (150), ESPECIALIDAD VARCHAR (150), PRIMARY KEY (ID_SECTOR));");                   
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
                boolean b=statement.execute("CREATE TABLE CURSO(ID_CURSO VARCHAR (10), DESCRIPCION VARCHAR (250), DURACION_FORMACION INT, DURACION_PRACTICAS INT, ESPECIALIDAD_CERTIFICADO VARCHAR (3), MODALIDAD VARCHAR (15), ID_SECTOR INT,  PRIMARY KEY (ID_CURSO), FOREIGN KEY (ID_SECTOR) REFERENCES SECTOR (ID_SECTOR));");                   
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
                boolean b=statement.execute("CREATE TABLE CENTRO(NOMBRE_CENTRO VARCHAR (150), TELEFONO VARCHAR (12), CORREO_ELECTRONICO VARCHAR (150), DIRECCION_CENTRO VARCHAR (150), CODIGO_POSTAL INT, ID_CURSO VARCHAR (10), FOREIGN KEY (ID_CURSO) REFERENCES CURSO (ID_CURSO));");                   
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
                boolean b=statement.execute("CREATE TABLE MUNICIPIO(NOMBRE_MUNICIPIO VARCHAR (100), NOMBRE_CENTRO VARCHAR (150), FOREIGN KEY (NOMBRE_CENTRO) REFERENCES CENTRO (NOMBRE_CENTRO));");                   
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
     public static void fillSector(String ID, String sector, String familia, String area, String especialidad){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO SECTOR VALUES(?,?,?,?,?)");
                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, sector);
                preparedStatement.setString(3, familia);
                preparedStatement.setString(4, area);
                preparedStatement.setString(5, especialidad);
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
     
     public static void fillCurso(String IDC, String descCurso, String duracionF, String duracionP, String espCurso, String modalidad, String IDsector){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO CURSO VALUES(?,?,?,?,?,?,?)");
                preparedStatement.setString(1, IDC);
                preparedStatement.setString(2, descCurso);
                preparedStatement.setString(3, duracionF);
                preparedStatement.setString(4, duracionP);               
                preparedStatement.setString(5, espCurso);
                preparedStatement.setString(6, modalidad);
                preparedStatement.setString(7, IDsector);
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
     
     public static void fillCentro(String IDCentro, String nombreC, String telCentro, String emailCentro, String dirCentro, String cpCentro, String IDcurso){
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
                preparedStatement.setString(7, IDcurso);
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
     
     public static void fillMunicipio(String municipio){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO MUNICIPIO VALUES(?)");
                preparedStatement.setString(1, municipio);
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
     
     
     //Muestra la tabla     
     public static void readSector() {
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                              PASSWORD);
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM SECTOR");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();
                for (int i = 1; i <= noCols; i++) {
                       if (i != 3)
                              System.out.printf("%-10s\t", metaData.getColumnName(i).toUpperCase());
                }
                System.out.println();
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {
                              if (i != 3)
                                    System.out.printf("%-10s\t", resultSet.getObject(i));
                       }
                       System.out.println();
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
   }
     
     public static void readCurso() {
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                              PASSWORD);
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM CURSO");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();
                for (int i = 1; i <= noCols; i++) {
                       if (i != 3)
                              System.out.printf("%-10s\t", metaData.getColumnName(i).toUpperCase());
                }
                System.out.println();
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {
                              if (i != 3)
                                    System.out.printf("%-10s\t", resultSet.getObject(i));
                       }
                       System.out.println();
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
   }
     
     public static void readCentro() {
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                              PASSWORD);
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM CENTRO");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();
                for (int i = 1; i <= noCols; i++) {
                       if (i != 3)
                              System.out.printf("%-10s\t", metaData.getColumnName(i).toUpperCase());
                }
                System.out.println();
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {
                              if (i != 3)
                                    System.out.printf("%-10s\t", resultSet.getObject(i));
                       }
                       System.out.println();
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
   }
     
     public static void readMunicipio() {
         Connection connection = null;
         Statement statement = null;
         try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                              PASSWORD);
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM MUNICIPIO");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int noCols = metaData.getColumnCount();
                for (int i = 1; i <= noCols; i++) {
                       if (i != 3)
                              System.out.printf("%-10s\t", metaData.getColumnName(i).toUpperCase());
                }
                System.out.println();
                while (resultSet.next()) {
                       for (int i = 1; i <= noCols; i++) {
                              if (i != 3)
                                    System.out.printf("%-10s\t", resultSet.getObject(i));
                       }
                       System.out.println();
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
   }  
  
     
     //Lee un csv y lo guarda en una List<>
     protected static List<CSV> readFromCSV() {
    	 
	        List<CSV> csvs = new ArrayList<>();
	        String path = "C:\\Users\\mauv2\\Desktop\\UEM\\TablaPSI2.csv";

	        // crea una instancia de BufferedReader para leer el csv
	        try  {
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
		    String EspSector = metadata[5];
		    String Desccurso = metadata[6];
		    String DurFcurso = metadata[7];
		    String DurPcurso = metadata[8];
		    String Espcurso = metadata[9];
		    String Modcurso = metadata[10];
		    String Empuser = metadata[11];
		    String Desccentro = metadata[12];
		    String Telcentro = metadata[13];
		    String Emailcentro = metadata[14];
		    String Dircentro = metadata[15];
		    String CPcentro = metadata[16];
		    String Municipio = metadata[17];

	        // crea y regresa el array del metadata
		    
		    return new CSV(IDcurso, IDsector, DescSector, FamSector, AreaSector, EspSector, Desccurso, DurFcurso, DurPcurso, Espcurso, Modcurso, Empuser, Desccentro, Telcentro, Emailcentro, Dircentro, CPcentro, Municipio);

	    }

	}

	 class CSV {
	    
		private String IDcurso;
		private String IDsector;
	    private String DescSector;
	    private String FamSector;
	    private String AreaSector;
	    private String EspSector;
	    private String Desccurso;
	    private String DurFcurso;
	    private String DurPcurso;
	    private String Espcurso;
	    private String Modcurso;
	    private String Empuser;
	    private String Desccentro;
	    private String Telcentro;
	    private String Emailcentro;
	    private String Dircentro;
	    private String CPcentro;
	    private String Municipio;
	    
	    public CSV(String IDcurso, String IDsector, String DescSector, String FamSector, String AreaSector, String EspSector, String Desccurso, String DurFcurso, String DurPcurso, String Espcurso, String Modcurso, String Empuser, String Desccentro, String Telcentro, String Emailcentro, String Dircentro, String CPcentro, String Municipio) {
		
	    	this.setIDcurso(IDcurso);
	    	
	    	this.setIDsector(IDsector);
	    	this.setDescSector(DescSector);
	    	this.setFamSector(FamSector);
	    	this.setAreaSector(AreaSector);
	    	this.setEspSector(EspSector);
	    	
	    	this.setDesccurso(Desccurso);
	    	this.setDurFcurso(DurFcurso);
	    	this.setDurPcurso(DurPcurso);
	    	this.setEspcurso(Espcurso);
	    	this.setModcurso(Modcurso);
	    	
	    	this.setEmpuser(Empuser);
	    	
	    	this.setDesccentro(Desccentro);
	    	this.setTelcentro(Telcentro);
	    	this.setEmailcentro(Emailcentro);
	    	this.setDircentro(Dircentro);
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

		public String getEspSector() {
			return EspSector;
		}

		public void setEspSector(String espSector) {
			EspSector = espSector;
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

		public String getEmpuser() {
			return Empuser;
		}

		public void setEmpuser(String empuser) {
			Empuser = empuser;
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
	        return IDcurso + IDsector + DescSector + FamSector + AreaSector + EspSector + Desccurso + DurFcurso + DurPcurso + Espcurso + Modcurso + Empuser + Desccentro + Telcentro + Emailcentro + Dircentro + CPcentro + Municipio;
	    }

	
     
     
     
     
}
