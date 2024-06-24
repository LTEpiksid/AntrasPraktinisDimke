package lt.viko.eif.s.dieliautas.Race.util;

import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;
import java.io.*;

/**
 * Komponentas, skirtas XML transformacijoms į PDF ir HTML formatus.
 */
@Component
public class XMLTransformer {

    /**
     * Transformuoja XML failą į PDF formatą naudojant XSL-FO stilių.
     *
     * @param xmlFile XML failas, kurį reikia transformuoti.
     * @param xslFile XSL-FO failas, naudojamas transformacijai.
     * @param out     OutputStream, į kurį bus rašomas PDF turinys.
     * @throws Exception jei įvyksta klaida transformacijos metu.
     */
    public void transformToPDF(File xmlFile, File xslFile, OutputStream out) throws Exception {
        // Konfigūruoja FopFactory pagal poreikį
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        // Paruošia išvestį
        try (OutputStream outStream = new BufferedOutputStream(out)) {
            // Sukuria Fop su norimu išvesties formatu
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outStream);

            // Paruošia XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslFile));

            // Paruošia įvestį XSLT transformacijai
            StreamSource src = new StreamSource(xmlFile);

            // Gautieji SAX įvykiai (sugeneruotas FO) turi būti perduoti FOP
            SAXResult res = new SAXResult(fop.getDefaultHandler());

            // Pradeda XSLT transformaciją ir FOP apdorojimą
            transformer.transform(src, res);
        }
    }

    /**
     * Transformuoja XML duomenis į HTML formatą naudojant XSL stilių.
     *
     * @param xmlData    XML duomenys, kuriuos reikia transformuoti.
     * @param xslFilePath XSL failo kelias, naudojamas transformacijai.
     * @return String, kurioje yra transformuotas HTML turinys.
     * @throws Exception jei įvyksta klaida transformacijos metu.
     */
    public String transformToHTML(String xmlData, String xslFilePath) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new ClassPathResource(xslFilePath).getInputStream()));

        StringWriter writer = new StringWriter();
        StreamSource xmlSource = new StreamSource(new StringReader(xmlData));
        transformer.transform(xmlSource, new StreamResult(writer));

        return writer.toString();
    }
}
