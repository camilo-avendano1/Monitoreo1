package co.udea.ssmu.api.component;

import co.udea.ssmu.api.model.jpa.model.Coordenadas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineInit implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8080/ssmu-api/taxiapp/send-coordenada";

        @Override
        public void run(String... args) throws Exception {
            List<Coordenadas> coordenadas = new ArrayList<>();

            coordenadas.add(new Coordenadas(6.238983289054362, -75.57040214538576));
            coordenadas.add(new Coordenadas(6.2385566772058105, -75.57031631469727));
            coordenadas.add(new Coordenadas(6.238897966712429, -75.57044506073));
            coordenadas.add(new Coordenadas(6.239281917141721, -75.57018756866456));
            coordenadas.add(new Coordenadas(6.239495222814223, -75.57014465332033));
            coordenadas.add(new Coordenadas(6.239879172805947, -75.5700159072876));
            coordenadas.add(new Coordenadas(6.24009247823534, -75.56993007659914));
            coordenadas.add(new Coordenadas(6.240433766741763, -75.56975841522218));
            coordenadas.add(new Coordenadas(6.24051908883364, -75.56971549987794));
            coordenadas.add(new Coordenadas(6.240860377062185, -75.56958675384523));
            coordenadas.add(new Coordenadas(6.241116343087723, -75.56954383850099));
            coordenadas.add(new Coordenadas(6.241372308988189, -75.5693292617798));
            coordenadas.add(new Coordenadas(6.241585613809715, -75.56924343109132));
            coordenadas.add(new Coordenadas(6.2417989185443865, -75.56924343109132));
            coordenadas.add(new Coordenadas(6.242097545027016, -75.56911468505861));
            coordenadas.add(new Coordenadas(6.242396171339396, -75.56902885437013));
            coordenadas.add(new Coordenadas(6.242822780061767, -75.56885719299318));
            coordenadas.add(new Coordenadas(6.243121405960675, -75.56859970092773));
            coordenadas.add(new Coordenadas(6.243633335676957, -75.56855678558351));
            coordenadas.add(new Coordenadas(6.244017282635754, -75.56847095489503));
            coordenadas.add(new Coordenadas(6.244443890037597, -75.56812763214113));
            coordenadas.add(new Coordenadas(6.2448704970918945, -75.5678701400757));
            coordenadas.add(new Coordenadas(6.2448704970918945, -75.56782722473146));
            coordenadas.add(new Coordenadas(6.244891827435493, -75.56774139404298));
            coordenadas.add(new Coordenadas(6.244955818461047, -75.56802034378053));
            coordenadas.add(new Coordenadas(6.245083800488698, -75.56827783584596));
            coordenadas.add(new Coordenadas(6.245105130823607, -75.5683207511902));
            coordenadas.add(new Coordenadas(6.245190452154517, -75.56864261627199));
            coordenadas.add(new Coordenadas(6.245190452154517, -75.56896448135376));
            coordenadas.add(new Coordenadas(6.245286438635174, -75.56885719299318));
            coordenadas.add(new Coordenadas(6.245361094774622, -75.56913614273073));
            coordenadas.add(new Coordenadas(6.245414420582011, -75.56927561759949));
            coordenadas.add(new Coordenadas(6.245499741862516, -75.5694365501404));
            coordenadas.add(new Coordenadas(6.245585063129116, -75.56973695755006));
            coordenadas.add(new Coordenadas(6.245627723757218, -75.56985497474672));
            coordenadas.add(new Coordenadas(6.245670384381823, -75.57000517845154));
            coordenadas.add(new Coordenadas(6.245723710157712, -75.57015538215639));
            coordenadas.add(new Coordenadas(6.245745040466541, -75.57043433189394));
            coordenadas.add(new Coordenadas(6.245467746383955, -75.57047724723817));
            coordenadas.add(new Coordenadas(6.245286438635174, -75.57058453559877));
            coordenadas.add(new Coordenadas(6.245147791490792, -75.57062745094301));
            coordenadas.add(new Coordenadas(6.244945153290667, -75.57068109512329));
            coordenadas.add(new Coordenadas(6.244678523960474, -75.57079911231996));
            coordenadas.add(new Coordenadas(6.244465220398575, -75.57093858718873));
            coordenadas.add(new Coordenadas(6.244241251565064, -75.57098150253297));
            coordenadas.add(new Coordenadas(6.244091938956164, -75.57103514671326));
            coordenadas.add(new Coordenadas(6.2436653312675885, -75.57121753692628));
            coordenadas.add(new Coordenadas(6.243345375273114, -75.57132482528688));
            coordenadas.add(new Coordenadas(6.2431107407529165, -75.57143211364748));
            coordenadas.add(new Coordenadas(6.242982758243069, -75.57152867317201));
            coordenadas.add(new Coordenadas(6.242684132265105, -75.57160377502443));
            coordenadas.add(new Coordenadas(6.242268188654936, -75.5717968940735));
            coordenadas.add(new Coordenadas(6.242129540711486, -75.57204365730287));
            coordenadas.add(new Coordenadas(6.242193532074561, -75.57233333587648));
            coordenadas.add(new Coordenadas(6.2423001843289745, -75.57258009910585));
            coordenadas.add(new Coordenadas(6.242310849553221, -75.57265520095827));
            coordenadas.add(new Coordenadas(6.242321514777264, -75.57288050651552));
            coordenadas.add(new Coordenadas(6.242385506116892, -75.57315945625305));
            coordenadas.add(new Coordenadas(6.242470827890892, -75.57343840599061));
            coordenadas.add(new Coordenadas(6.242396171339396, -75.57344913482667));


            enviarCoordenadasPeriodicamente(coordenadas);
        }

        void enviarCoordenadasPeriodicamente(List<Coordenadas> coordenadas) {
            for (Coordenadas coordenada : coordenadas) {
                enviarCoordenada(coordenada);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    void enviarCoordenada(Coordenadas coordenada) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Coordenadas> requestEntity = new HttpEntity<>(coordenada, headers);

        ResponseEntity<Coordenadas> responseEntity = restTemplate.postForEntity(url, requestEntity, Coordenadas.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            System.out.println("Coordenada enviada: " + coordenada);}
        else{
            System.out.println("Error al enviar coordenada: " + coordenada);
        }

    }
}
