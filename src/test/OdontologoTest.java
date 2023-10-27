package test;

import com.digitalhouse.DAOEnLista;
import com.digitalhouse.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;

public class OdontologoTest {

    private static final Logger logger = loggerFactory.getLogger(OdontologoTest.class);


    @Test
    public void probarFuncionalidadDeLog() {

        logger.info("Mensaje de prueba");
    }

    @Test
    public void crearClaseOdontologo() {

        assertNotNull(new Odontologo());

    }

    @Test
    public void crearTablaDeServicioYDAO() {

            // llamar al DAO para crear la tabla en la Base CREATE TABLE

    }

    @Test
    public void creaTablaEnBaseDeDatos() {

        // llamar al DAO para crear la tabla en la Base CREATE TABLE

    }

    @Test
    public void testearDAOMemory() {

        DAOEnLista dao = new DAOEnLista();

        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", "Ibuprofeno 600", 10);

        assertTrue(daoEnLista.guardar(medicamento));

        assetEquals(1, daoEnLista.listar().size());
    }

    @Test
    public void testearH2() {

        // lo mismo de arriba pero DAO en H2


    }
}
