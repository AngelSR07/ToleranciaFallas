/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_Service;

import Web_Service_client.SelectAllResponse;
import Web_Service_client.User;
import Web_Service_client.WebServiceUser;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author ANGEL
 */
@Path("webserviceuserport")
public class WebServiceUserPort {

    private WebServiceUser port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServiceUserPort
     */
    public WebServiceUserPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method update
     * @param name resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<java.lang.Boolean>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("update/")
    public JAXBElement<Boolean> postUpdate(JAXBElement<User> name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.Boolean result = port.update(name.getValue());
                return new JAXBElement<java.lang.Boolean>(new QName("http//lang.java/", "boolean"), java.lang.Boolean.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method delete
     * @param name resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<java.lang.Boolean>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("delete/")
    public JAXBElement<Boolean> getDelete(@QueryParam("name")
            @DefaultValue("0") int name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.Boolean result = port.delete(name);
                return new JAXBElement<java.lang.Boolean>(new QName("http//lang.java/", "boolean"), java.lang.Boolean.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method insert
     * @param name resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<java.lang.Boolean>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("insert/")
    public JAXBElement<Boolean> postInsert(JAXBElement<User> name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.Boolean result = port.insert(name.getValue());
                return new JAXBElement<java.lang.Boolean>(new QName("http//lang.java/", "boolean"), java.lang.Boolean.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method login
     * @param name resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<java.lang.Boolean>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("login/")
    public JAXBElement<Boolean> postLogin(JAXBElement<User> name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.Boolean result = port.login(name.getValue());
                return new JAXBElement<java.lang.Boolean>(new QName("http//lang.java/", "boolean"), java.lang.Boolean.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method selectAll
     * @return an instance of javax.xml.bind.JAXBElement<Web_Service_client.SelectAllResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("selectall/")
    public JAXBElement<SelectAllResponse> getSelectAll() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<Web_Service_client.User> result = port.selectAll();

                class SelectAllResponse_1 extends Web_Service_client.SelectAllResponse {

                    SelectAllResponse_1(java.util.List<Web_Service_client.User> _return) {
                        this._return = _return;
                    }
                }
                Web_Service_client.SelectAllResponse response = new SelectAllResponse_1(result);
                return new Web_Service_client.ObjectFactory().createSelectAllResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private WebServiceUser getPort() {
        try {
            // Call Web Service Operation
            Web_Service_client.WebServiceUser_Service service = new Web_Service_client.WebServiceUser_Service();
            Web_Service_client.WebServiceUser p = service.getWebServiceUserPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
