package com.example.gpsmapapp;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.net.URL; // Importa la clase URL
import java.security.KeyStore;

public class HttpsConnectionHelper {
    public HttpsURLConnection getHttpsConnection(URL url) throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init((KeyStore) null);
        context.init(null, tmf.getTrustManagers(), null);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(context.getSocketFactory());
        return connection;
    }
}
