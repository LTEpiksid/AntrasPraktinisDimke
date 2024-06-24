package lt.viko.eif.s.dieliautas.Race.controller;

import lt.viko.eif.s.dieliautas.Race.util.XMLTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class MainPageController {

    @Autowired
    private XMLTransformer xmlTransformer;

    /**
     * Apdoroja GET užklausą pagrindiniam puslapiui (/mainpage).
     * Paskaito XML duomenis ir transformuoja juos į HTML naudodamas XSLT.
     *
     * @param model Modelis, naudojamas perduoti duomenis į vaizdą.
     * @return Pagrindinio puslapio šablono pavadinimas.
     */
    @GetMapping("/mainpage")
    public String getMainPage(Model model) {
        try {
            String xmlData = new String(Files.readAllBytes(Paths.get("src/main/resources/xml/data.xml")));
            String htmlContent = xmlTransformer.transformToHTML(xmlData, "xslt/main-page.xsl");
            model.addAttribute("htmlContent", htmlContent);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error during transformation: " + e.getMessage());
        }
        return "mainpage";
    }
}
