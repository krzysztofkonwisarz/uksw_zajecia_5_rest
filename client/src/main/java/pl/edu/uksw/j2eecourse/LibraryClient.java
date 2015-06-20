package pl.edu.uksw.j2eecourse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class LibraryClient {

    private static final String ADRES_USLUGI = "http://localhost:8080/api/books";

    public static void main(String[] args) {

        sendBook(buildBookJson("1", "tytuł 1"));
        sendBook(buildBookJson("2", "tytuł 2"));
        sendBook(buildBookJson("3", "tytuł 3"));

    }

    private static String buildBookJson(String isbn, String title) {

        // w tej metodzie budujemy JSON mapujący się na BookDto
        // pamiętasz coś z drugich zajęć, nieprawdaż? ;)
        // w pom.xml masz już wszystkie niezbędne zależności

        return null;
    }

    /**
     *
     *      -----------------Zwróć uwagę w jaki sposób odbywa się komunikacja z serwerem!-----------------
     *
     *      Ta metoda potrafi tylko POSTować. W wolnym czasie spróbuj obok dorobić pobieranie listy książek GETem.
     *
     *
     */
    private static void sendBook(String jsonString) {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(ADRES_USLUGI);

            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonString);

            if (response.getStatus() != 201) {
                System.out.println("Próba nieudana: kod HTTP: " + response.getStatus());
            } else {
                System.out.println("Sukces! Status: " + response.getStatus() + ", body: ");
                String output = response.getEntity(String.class);
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
