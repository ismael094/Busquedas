/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:we [filtro/{key}, {nombre},
 * {page}]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Ismael1
 */
public class NewJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://ws.docencia.ces.siani.es/a01/FiltroWS/webresources/";

    public NewJerseyClient(String key, String nombre, String page) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        String resourcePath = java.text.MessageFormat.format("filtro/{0}, {1}, {2}", new Object[]{key, nombre, page});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    public void setResourcePath(String key, String nombre, String page) {
        String resourcePath = java.text.MessageFormat.format("filtro/{0}, {1}, {2}", new Object[]{key, nombre, page});
        webTarget = client.target(BASE_URI).path(resourcePath);
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T getJson(Class<T> responseType) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
