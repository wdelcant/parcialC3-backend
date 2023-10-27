package com.digitalhouse;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class OdontologoService {

    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    private static List<Odontologo> odontologos = new ArrayList<Odontologo>();



    public void registrarOdontologo(Odontologo odontologo) {

        logger.info("Voy a registrar un odontologo");

        OdontologoDAO odontologoDAO = new OdontologoDAOH2Impl();

        if (odontologo.getNombre().isEmpty() || odontologo.getApellido().isEmpty() || odontologo.getNumeroMatricula() < 0) {

            logger.error("No se puede registrar el odontologo");
        } else {
            try {
                odontologoDAO.registrar(odontologo);
                logger.info("Se registro el odotologo");
            } catch (SQLException e) {
                logger.error("No se pudo registrar el odontologo" + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                logger.error("No se pudo registrar el odontologo" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public List<Odontologo> listarOdontologos() {
        return null;
    }


}
