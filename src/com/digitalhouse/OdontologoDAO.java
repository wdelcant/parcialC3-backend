package com.digitalhouse;

import java.sql.Connection;
import java.util.List;

public interface OdontologoDAO {

        void registrar(Odontologo odontologo) throws Exception;

        void actualizar(Odontologo odontologo);

        void eliminar(Long id);

        void buscarPorId(Long id) throws Exception;

        List<Odontologo> listarTodos();

        void crearTablaOdontologo() throws Exception;

        Connection getConexion();
}
