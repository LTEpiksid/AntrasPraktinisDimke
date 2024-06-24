package lt.viko.eif.s.dieliautas.Race.endpoint;

import lt.viko.eif.s.dieliautas.Race.model.Racer;
import lt.viko.eif.s.dieliautas.Race.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Endpoint
public class RacerEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/racers";

    @Autowired
    private RacerService racerService;

    /**
     * Tvarko užklausą gauti lenktynininko informaciją pagal ID.
     *
     * @param request Užklausos objektas, kuriame yra lenktynininko ID.
     * @return Atsako objektas su lenktynininko informacija.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRacerRequest")
    @ResponsePayload
    public GetRacerResponse getRacer(@RequestPayload GetRacerRequest request) {
        System.out.println("Gauta užklausa lenktynininko ID: " + request.getId());
        GetRacerResponse response = new GetRacerResponse();
        Racer racer = racerService.getRacerById(request.getId());
        if (racer != null) {
            System.out.println("Lenktynininkas rastas: " + racer.getFirstName() + " " + racer.getLastName());
            response.setId(racer.getId());
            response.setFirstName(racer.getFirstName());
            response.setLastName(racer.getLastName());
            response.setPhoneNumber(racer.getPhoneNumber());
            response.setStatusName(racer.getStatus().getStatusName());
        } else {
            System.out.println("Lenktynininkas nerastas pagal ID: " + request.getId());
        }
        return response;
    }

    @XmlRootElement(namespace = "http://example.com/racers")
    public static class GetRacerRequest {
        private int id;

        @XmlElement(namespace = "http://example.com/racers")
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    @XmlRootElement(namespace = "http://example.com/racers")
    public static class GetRacerResponse {
        private int id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String statusName;

        @XmlElement(namespace = "http://example.com/racers")
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @XmlElement(namespace = "http://example.com/racers")
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @XmlElement(namespace = "http://example.com/racers")
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @XmlElement(namespace = "http://example.com/racers")
        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @XmlElement(namespace = "http://example.com/racers")
        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }
    }
}
