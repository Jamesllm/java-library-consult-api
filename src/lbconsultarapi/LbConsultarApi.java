/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lbconsultarapi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Llapapasca Montes
 */
public class LbConsultarApi {

    public String consultarAPI(String url, String method) throws IOException {
        StringBuilder response = new StringBuilder();
        try {
            URL urloj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urloj.openConnection();
            connection.setRequestMethod(method);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());

                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
            } else {
                response.append("ERROR DE GET METODO. Código de respuesta: ").append(responseCode);
            }

        } catch (MalformedURLException e) {
            response.append("URL Mal Formada: ").append(e.getMessage());
        } catch (IOException e) {
            response.append("Error de Entrada/Salida: ").append(e.getMessage());
        }
        return response.toString();
    }
}
