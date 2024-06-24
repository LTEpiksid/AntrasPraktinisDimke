package lt.viko.eif.s.dieliautas.Race;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Pagrindinė programos klasė, paleidžianti Spring Boot aplikaciją.
 */
@SpringBootApplication
public class Main {

    /**
     * Pagrindinis metodas, paleidžiantis Spring Boot aplikaciją.
     *
     * @param args komandinės eilutės argumentai.
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Įvykio klausytojas, kuris paleidžia naršyklę ir atidaro pagrindinį puslapį po to, kai aplikacija startuoja.
     *
     * @param event WebServerInitializedEvent įvykis.
     */
    @EventListener(WebServerInitializedEvent.class)
    public void onApplicationEvent(WebServerInitializedEvent event) {
        String url = "http://localhost:" + event.getWebServer().getPort() + "/";
        openHomePage(url);
    }

    /**
     * Atidaro nurodytą URL naršyklėje.
     *
     * @param url URL adresas, kurį reikia atidaryti.
     */
    private static void openHomePage(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                System.err.println("Nepavyko atidaryti naršyklės. Prašome rankiniu būdu atidaryti URL: " + url);
            }
        } else {
            // Bando atidaryti URL naudojant platformai specifinius komandus
            try {
                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("win")) {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    Runtime.getRuntime().exec("open " + url);
                } else if (os.contains("nix") || os.contains("nux")) {
                    Runtime.getRuntime().exec("xdg-open " + url);
                } else {
                    System.err.println("Desktop nėra palaikomas. Prašome rankiniu būdu atidaryti URL: " + url);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Nepavyko atidaryti naršyklės. Prašome rankiniu būdu atidaryti URL: " + url);
            }
        }
    }
}
