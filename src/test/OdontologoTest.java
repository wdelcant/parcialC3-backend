package test;

import com.digitalhouse.OdontologoDAO;
import com.digitalhouse.OdontologoDAOH2Impl;
import com.digitalhouse.OdontologoService;
import com.digitalhouse.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;

public class OdontologoTest {

    private static final Logger logger = Logger.getLogger(OdontologoTest.class);

    /**
     * Enunciado:
     *
     * La clínica odontológica ahora nos pide que desarrollemos la posibilidad de gestionar a los odontólogos. Es decir, que el sistema permita registrar los odontólogos y listarlos.
     *
     * Luego del relevamiento obtuvimos la siguiente información:
     *
     * Un odontólogo tiene
     * Número de matrícula
     * Nombre
     * Apellido
     * ID:int
     *
     * Nuestro chapter lead de arquitectura nos pide:
     *
     *
     * Que un integrante de la dupla desarrolle la funcionalidad de persistencia utilizando H2 como base de datos aplicando
     * el patrón DAO para acceder a los datos, realizar los métodos que nos permitan guardar un odontólogo,
     * y listar todos los odontólogos.
     *
     * Que el otro integrante de la dupla desarrolle otra funcionalidad de persistencia sin utilizar una base de datos y utilizando una colección a elección (ArrayList, HashMap o HashSet) dentro del mismo patrón DAO para acceder a los datos y realizar los métodos que nos permitan guardar un odontólogo y listar todos los odontólogos.
     *
     * Loguear el resultado o la ejecución de cada operación utilizando log4j.
     *
     * Crear un script SQL para la creación de las tablas con sus respectivos atributos.
     * Tests: Con JUnit testear el listado de todos los odontólogos (previamente guardar algunos odontólogos).
     *
     *
     * Tareas:
     *
     *  1. Configuración de Proyecto
     *  - Agregar Librería de Log4J. Incluye agregar el archivo log4j.properties en el src
     *  - Agregar Librería de H2
     *
     */


    @Test
    public void probarFuncionalidadDeLog() {

        logger.info("Mensaje de prueba");
    }

    @Test
    public void crearClaseOdontologo() {

        Odontologo odontologo = new Odontologo(1 , 222222, "Perez", "Juan");

        assertNotNull(odontologo);

        logger.info("Odontologo creado: " + odontologo.toString());

    }

    @Test
    public void crearTablaDeServicioYDAO() throws Exception {

     // llamar al DAO para crear la tabla en la Base CREATE TABLE

        OdontologoDAO odontologoTabla = new OdontologoDAOH2Impl();

        odontologoTabla.crearTablaOdontologo();

    }

    @Test
    public void creaTablaEnBaseDeDatos() throws Exception {

        Odontologo odontologo = new Odontologo(1 , 222222, "Perez", "Juan");

        assertNotNull(odontologo);

        logger.info("Odontologo creado: " + odontologo.toString());

        OdontologoDAO odontologoTabla = new OdontologoDAOH2Impl();

        odontologoTabla.registrar(odontologo);

    }

    @Test
    public void testearDAOMemory() {


    }

    @Test
    public void testearH2() {

        // lo mismo de arriba pero DAO en H2


    }
}
