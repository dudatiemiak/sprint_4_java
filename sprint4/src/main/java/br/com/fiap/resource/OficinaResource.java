package br.com.fiap.resource;

import br.com.fiap.bo.OficinaBO;
import br.com.fiap.to.OficinaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/sprint4")
public class OficinaResource {
    private OficinaBO oficinaBO = new OficinaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<OficinaTO> resultado = oficinaBO.findAll();
        Response.ResponseBuilder response = null;

        if (resultado != null) {
            response = Response.ok(); // 200 (ok)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return  response.build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("codigo") Long codigo) {
        OficinaTO resultado = oficinaBO.findByCodigo(codigo);

        Response.ResponseBuilder response = null;

        if (resultado != null) {
            response = Response.ok(); //200 ok
        } else {
            response = Response.status(404); //404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid OficinaTO oficina) {
        OficinaTO resultado = oficinaBO.save(oficina);

        Response.ResponseBuilder response = null;

        if  (resultado != null) {
            response = Response.created(null); //201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return  response.build();
    }

    //método que vai responder ao verbo delete
    //só o delete vai ser diferente pq ele retorna verdadeiro ou falso
    @DELETE
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long codigo){
        Response.ResponseBuilder response = null;
        if(oficinaBO.delete(codigo)){
            response = Response.status(204); //204 é o NO CONTENT - porque depois que eu apaguei não tem mais conteúdo, ou seja, deu certo.
        }else{
            response = Response.status(404); //404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid OficinaTO oficina, @PathParam("codigo") Long codigo) throws SQLException {
        oficina.setCodigo(codigo);
        OficinaTO resultado = oficinaBO.update(oficina);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); //201 CREATED
        }else {
            response = Response.status(400); //400 BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}