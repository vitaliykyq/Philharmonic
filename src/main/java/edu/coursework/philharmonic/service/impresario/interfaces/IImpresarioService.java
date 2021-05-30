package edu.coursework.philharmonic.service.impresario.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IImpresarioService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Impresario;

import java.util.List;

public interface IImpresarioService {

    Impresario getById(String id);
    Impresario create(Impresario helicopter);
    Impresario update(Impresario helicopter);
    Impresario delete(String id);
    List<Impresario> getAll();
}
