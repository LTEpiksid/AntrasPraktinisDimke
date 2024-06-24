package lt.viko.eif.s.dieliautas.Race.controller;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import lt.viko.eif.s.dieliautas.Race.model.Racer;
import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.service.PdfService;
import lt.viko.eif.s.dieliautas.Race.service.RaceService;
import lt.viko.eif.s.dieliautas.Race.service.RacerService;
import lt.viko.eif.s.dieliautas.Race.util.XMLTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class PDFController {

    @Autowired
    private RacerService racerService;

    @Autowired
    private RaceService raceService;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private XMLTransformer xmlTransformer;

    /**
     * Apdoroja GET užklausą PDF pagrindiniam puslapiui (/pdf-main).
     *
     * @return PDF pagrindinio puslapio šablono pavadinimas.
     */
    @GetMapping("/pdf-main")
    public String pdfMain() {
        return "pdfMain";
    }

    /**
     * Apdoroja POST užklausą generuoti PDF failą pagal lenktynininko ID.
     *
     * @param racerId Lenktynininko ID.
     * @return ResponseEntity su generuotu PDF failu arba klaidos pranešimu.
     * @throws IOException Jei įvyksta I/O klaida.
     */
    @PostMapping("/generate-racer-pdf")
    public ResponseEntity<InputStreamResource> generateRacerPDF(@RequestParam("racerId") int racerId) throws IOException {
        Racer racer = racerService.getRacerById(racerId);

        if (racer == null) {
            return ResponseEntity.status(404).build();
        }

        // Nustato kelią generuojamam XML failui
        String xmlPath = "src/main/resources/static/generated/racer_" + racerId + ".xml";

        try {
            // Generuoja XML failą lenktynininkui
            pdfService.generateRacerXml(racer, xmlPath);

            // Transformuoja XML į PDF naudodamas XSL-FO
            String xslPath = "src/main/resources/static/xsl/racers-to-pdf.xsl";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            xmlTransformer.transformToPDF(new File(xmlPath), new File(xslPath), out);

            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=racer_" + racerId + ".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        } finally {
            // Išvalo generuotą XML failą
            File xmlFile = new File(xmlPath);
            if (xmlFile.exists()) {
                xmlFile.delete();
            }
        }
    }

    /**
     * Apdoroja POST užklausą generuoti PDF failą pagal lenktynių ID.
     *
     * @param raceId Lenktynių ID.
     * @return ResponseEntity su generuotu PDF failu arba klaidos pranešimu.
     * @throws IOException Jei įvyksta I/O klaida.
     */
    @PostMapping("/generate-raceinfo-pdf")
    public ResponseEntity<InputStreamResource> generateRaceInfoPDF(@RequestParam("raceId") int raceId) throws IOException {
        Race race = raceService.getRaceById(raceId);

        if (race == null) {
            return ResponseEntity.status(404).build();
        }

        // Nustato kelią generuojamam XML failui
        String xmlPath = "src/main/resources/static/generated/race_" + raceId + ".xml";

        try {
            // Generuoja XML failą lenktynėms
            pdfService.generateRaceXml(race, xmlPath);

            // Transformuoja XML į PDF naudodamas XSL-FO
            String xslPath = "src/main/resources/static/xsl/race-info-pdf.xsl";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            xmlTransformer.transformToPDF(new File(xmlPath), new File(xslPath), out);

            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=race_" + raceId + ".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        } finally {
            // Išvalo generuotą XML failą
            File xmlFile = new File(xmlPath);
            if (xmlFile.exists()) {
                xmlFile.delete();
            }
        }
    }

    /**
     * Apdoroja POST užklausą generuoti PDF failą pagal lenktynininkų būseną.
     *
     * @param status Lenktynininkų būsena.
     * @return ResponseEntity su generuotu PDF failu arba klaidos pranešimu.
     * @throws IOException Jei įvyksta I/O klaida.
     */
    @PostMapping("/generate-racers-by-status-pdf")
    public ResponseEntity<InputStreamResource> generateRacersByStatusPDF(@RequestParam("status") String status) throws IOException {
        List<Racer> racers = racerService.getRacersByStatus(status);

        if (racers.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        // Nustato kelią generuojamam XML failui
        String xmlPath = "src/main/resources/static/generated/racers_" + status + ".xml";

        try {
            // Generuoja XML failą lenktynininkams pagal būseną
            pdfService.generateRacersByStatusXml(racers, status, xmlPath);

            // Transformuoja XML į PDF naudodamas XSL-FO
            String xslPath = "src/main/resources/static/xsl/racers-by-status-to-pdf.xsl";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            xmlTransformer.transformToPDF(new File(xmlPath), new File(xslPath), out);

            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=racers_" + status + ".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        } finally {
            // Išvalo generuotą XML failą
            File xmlFile = new File(xmlPath);
            if (xmlFile.exists()) {
                xmlFile.delete();
            }
        }
    }

    /**
     * Apdoroja POST užklausą generuoti PDF failą su geriausiais finišo laikais.
     *
     * @return ResponseEntity su generuotu PDF failu arba klaidos pranešimu.
     * @throws IOException Jei įvyksta I/O klaida.
     */
    @PostMapping("/generate-top-finish-time-pdf")
    public ResponseEntity<InputStreamResource> generateTopFinishTimePDF() throws IOException {
        List<RaceInfo> topFinishes = racerService.getTopFinishTimes();

        if (topFinishes.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        // Nustato kelią generuojamam XML failui
        String xmlPath = "src/main/resources/static/generated/top_finish_times.xml";

        try {
            // Generuoja XML failą su geriausiais finišo laikais
            pdfService.generateTopFinishTimesXml(topFinishes, xmlPath);

            // Transformuoja XML į PDF naudodamas XSL-FO
            String xslPath = "src/main/resources/static/xsl/top-finish-times-to-pdf.xsl";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            xmlTransformer.transformToPDF(new File(xmlPath), new File(xslPath), out);

            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=top_finish_times.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        } finally {
            // Išvalo generuotą XML failą
            File xmlFile = new File(xmlPath);
            if (xmlFile.exists()) {
                xmlFile.delete();
            }
        }
    }
}
