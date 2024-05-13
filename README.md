# Java Library: Consult API

Esta biblioteca de Java te permite realizar consultas a una API mediante URL. Puedes realizar tanto consultas GET como POST a una URL, ya sea local o remota. También se puede complementar con GSON para convertir el resultado a JSON.

## Instalación
Para usar esta biblioteca en tu proyecto Java, sigue estos pasos:

1. Descarga la biblioteca: Puedes descargar el archivo JAR desde la sección de "Releases" de este repositorio.

2. Agrega la biblioteca a tu proyecto:
    - Si estás utilizando un IDE como Eclipse o IntelliJ, puedes agregar el archivo JAR descargado a tu proyecto como una dependencia externa
    - Si estás compilando manualmente, asegúrate de incluir el archivo JAR en tu classpath al compilar y ejecutar tu proyecto.

## Ejemplo de uso 😎
A continuación se muestra un ejemplo de cómo usar la biblioteca junto con GSON:

```java
// importar la libreria lbConsultarApi
import lbconsultarapi.LbConsultarApi;

// Importar la libreria para trabajar con JSON
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *
 * @author James Lm
 */
public class PruebaLibreria {

    public static void main(String[] args) {
        // Crear una instancia de LbConsultarApi
        LbConsultarApi consultar = new LbConsultarApi();

        try {
            // Realizar una consulta a la API
            String respuesta = consultar.consultarAPI("http://localhost:8085/dni/12345678", "POST");
            String json = respuesta.toString();

            // Crear un objeto Gson
            Gson gson = new Gson();

            // Analizar el JSON a un objeto JsonObject
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            // Obtener los valores individuales del objeto JSON
            String dni = jsonObject.get("dni").getAsString();
            String nombreCompleto = jsonObject.get("nombre_completo").getAsString();

            // Imprimir los valores
            System.out.println("DNI: " + dni);
            System.out.println("Nombre Completo: " + nombreCompleto);
        } catch (Exception e) {
            // Manejo de errores
            System.out.println("ERROR");
        }
    }
}
```