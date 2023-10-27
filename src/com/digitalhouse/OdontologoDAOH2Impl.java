package com.digitalhouse;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2Impl implements OdontologoDAO {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2Impl.class);

    public void crearTablaOdontologo() throws Exception{


        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            // Crear una sentencia SQL
            Statement statement = connection.createStatement();

            // Ejecutar una consulta SQL y obtener un ResultSet

            statement.execute("CREATE TABLE ODONTOLOGO(ID INT PRIMARY KEY,\n" +
                    "   NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), NUMEROMATRICULA INT);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void registrar(Odontologo odontologo) throws Exception {

        Connection connection = getConexion();

        try{

            String insert = "INSERT INTO odontologo (ID,NUMEROMATRICULA,NOMBRE, APELLIDO) VALUES (?,?,?,?)";

            PreparedStatement sentencia= connection.prepareStatement(insert);

            sentencia.setLong(1, odontologo.getId());
            sentencia.setInt(2, odontologo.getNumeroMatricula());
            sentencia.setString(3, odontologo.getNombre());
            sentencia.setString(4, odontologo.getApellido());
            sentencia.execute();

            logger.info(sentencia.toString());

            sentencia.close();

            connection.commit();

        }catch (SQLException ex){
            logger.error("Error al registrar el odotonlogo " + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();

            throw new Exception(ex);

        }catch (Exception e){
            connection.rollback();

        }finally {
            connection.close();
        }

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void buscarPorId(Long id) throws Exception {

    }

    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = getConexion();
        List<Odontologo> odontologos = new ArrayList<>();

        try {


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Odontologo odontologo = crearObjetoOdontologo(resultSet);
                odontologos.add(odontologo);
            }

            logger.info("Listado de todos los Odontologos: " + odontologos);


        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                logger.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public Connection getConexion() {

        try {

            //Obtener la conexión a la base
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            connection.setAutoCommit(false);

            logger.info("Conexión exitosa a la base de datos");

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Odontologo crearObjetoOdontologo(ResultSet resultado) throws SQLException {

        int id = resultado.getInt("id");
        int numeroMatricula = resultado.getInt("numeroMatricula");
        String nombre = resultado.getString("nombre");
        String apellido = resultado.getString("apellido");


        return new Odontologo(id, numeroMatricula, nombre, apellido);
    }
}
