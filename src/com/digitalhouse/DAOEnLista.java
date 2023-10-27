package com.digitalhouse;

import java.util.ArrayList;

public class DAOEnLista {

    private static List<Medicamento> medicamentos = new ArrayList<Medicamento>();

    public boolean guardar(Medicamento medicamento) {
        return medicamentos.add(medicamento);
    }

    public List<Medicamento> listar() {
        return listaMedicamentos;
    }


}
