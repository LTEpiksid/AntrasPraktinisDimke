package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.model.Racer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

/**
 * Paslauga, atsakinga už PDF dokumentų generavimą iš XML duomenų.
 */
@Service
public class PdfService {

    private static final Logger logger = Logger.getLogger(PdfService.class.getName());

    /**
     * Generuoja lenktynininko XML failą nurodytoje vietoje.
     *
     * @param racer      lenktynininko objektas
     * @param outputPath XML failo išsaugojimo kelias
     * @throws IOException jei įvyksta įrašymo klaida
     */
    public void generateRacerXml(Racer racer, String outputPath) throws IOException {
        File file = new File(outputPath);
        // Užtikrina, kad tėviniai katalogai egzistuoja
        file.getParentFile().mkdirs();

        // Įkrauna vaizdus naudojant ClassPathResource
        URL helmetImageUrl = new ClassPathResource("static/Image/Helmet.png").getURL();
        URL winImageUrl = new ClassPathResource("static/Image/Win.png").getURL();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<racer>\n");
            writer.write("    <id>" + racer.getId() + "</id>\n");
            writer.write("    <first_name>" + racer.getFirstName() + "</first_name>\n");
            writer.write("    <last_name>" + racer.getLastName() + "</last_name>\n");
            writer.write("    <phone_number>" + racer.getPhoneNumber() + "</phone_number>\n");
            writer.write("    <status>" + racer.getStatus().getStatusName() + "</status>\n");
            writer.write("    <races_involved>" + racer.getRaceInfos().size() + "</races_involved>\n");
            writer.write("    <wins>" + getNumberOfWins(racer) + "</wins>\n");
            writer.write("    <helmet_image_path>" + helmetImageUrl.toString() + "</helmet_image_path>\n");
            writer.write("    <win_image_path>" + winImageUrl.toString() + "</win_image_path>\n");
            writer.write("</racer>\n");
        }
    }

    /**
     * Generuoja lenktynių XML failą nurodytoje vietoje.
     *
     * @param race       lenktynių objektas
     * @param outputPath XML failo išsaugojimo kelias
     * @throws IOException jei įvyksta įrašymo klaida
     */
    public void generateRaceXml(Race race, String outputPath) throws IOException {
        File file = new File(outputPath);
        file.getParentFile().mkdirs();

        // Įkrauna vaizdą naudojant ClassPathResource
        URL flagImageUrl = new ClassPathResource("static/Image/Flag.png").getURL();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<race>\n");
            writer.write("    <id>" + race.getId() + "</id>\n");
            writer.write("    <name>" + race.getName() + "</name>\n");
            writer.write("    <location>" + race.getLocation() + "</location>\n");
            writer.write("    <date>" + race.getDate() + "</date>\n");
            writer.write("    <flag_image_path>" + flagImageUrl.toString() + "</flag_image_path>\n");
            writer.write("    <participants>\n");
            for (RaceInfo raceInfo : race.getRaceInfos()) {
                writer.write("        <participant>\n");
                writer.write("            <id>" + raceInfo.getRacer().getId() + "</id>\n");
                writer.write("            <first_name>" + raceInfo.getRacer().getFirstName() + "</first_name>\n");
                writer.write("            <last_name>" + raceInfo.getRacer().getLastName() + "</last_name>\n");
                writer.write("            <finish_time>" + raceInfo.getFinishTime() + "</finish_time>\n");
                writer.write("            <position>" + raceInfo.getPositionNumber() + "</position>\n");
                writer.write("        </participant>\n");
            }
            writer.write("    </participants>\n");
            writer.write("</race>\n");
        }
    }

    /**
     * Generuoja lenktynininkų pagal statusą XML failą nurodytoje vietoje.
     *
     * @param racers     lenktynininkų sąrašas
     * @param status     lenktynininkų statusas
     * @param outputPath XML failo išsaugojimo kelias
     * @throws IOException jei įvyksta įrašymo klaida
     */
    public void generateRacersByStatusXml(List<Racer> racers, String status, String outputPath) throws IOException {
        File file = new File(outputPath);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<racers status=\"" + status + "\">\n");
            for (Racer racer : racers) {
                writer.write("    <racer>\n");
                writer.write("        <id>" + racer.getId() + "</id>\n");
                writer.write("        <first_name>" + racer.getFirstName() + "</first_name>\n");
                writer.write("        <last_name>" + racer.getLastName() + "</last_name>\n");
                writer.write("        <phone_number>" + racer.getPhoneNumber() + "</phone_number>\n");
                writer.write("        <races_involved>" + racer.getRaceInfos().size() + "</races_involved>\n");
                writer.write("        <wins>" + getNumberOfWins(racer) + "</wins>\n");
                writer.write("    </racer>\n");
            }
            writer.write("</racers>\n");
        }
    }

    /**
     * Generuoja lenktynių pabaigos laikų XML failą nurodytoje vietoje.
     *
     * @param topFinishes lenktynių pabaigos laikų sąrašas
     * @param outputPath  XML failo išsaugojimo kelias
     * @throws IOException jei įvyksta įrašymo klaida
     */
    public void generateTopFinishTimesXml(List<RaceInfo> topFinishes, String outputPath) throws IOException {
        File file = new File(outputPath);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<top_finishes>\n");
            for (RaceInfo raceInfo : topFinishes) {
                writer.write("    <finish>\n");
                writer.write("        <racer_id>" + raceInfo.getRacer().getId() + "</racer_id>\n");
                writer.write("        <first_name>" + raceInfo.getRacer().getFirstName() + "</first_name>\n");
                writer.write("        <last_name>" + raceInfo.getRacer().getLastName() + "</last_name>\n");
                writer.write("        <finish_time>" + raceInfo.getFinishTime() + "</finish_time>\n");
                writer.write("    </finish>\n");
            }
            writer.write("</top_finishes>\n");
        }
    }

    /**
     * Skaičiuoja laimėjimų skaičių lenktynininkui.
     *
     * @param racer lenktynininko objektas
     * @return laimėjimų skaičius
     */
    private long getNumberOfWins(Racer racer) {
        return racer.getRaceInfos().stream().filter(raceInfo -> raceInfo.getPositionNumber() == 1).count();
    }
}
