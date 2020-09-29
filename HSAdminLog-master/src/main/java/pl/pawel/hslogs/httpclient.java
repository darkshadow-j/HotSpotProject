package pl.pawel.hslogs;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class httpclient {


        public String getTelNumberByName(String name){
            RestTemplate restTemplate = new RestTemplate();
            MultiValueMap<String, String> headers = new HttpHeaders();
            headers.add("name", name);
            HttpEntity httpEntity = new HttpEntity(headers);
            ResponseEntity<String> tel = restTemplate.exchange("http://localhost:8080/log",
                    HttpMethod.GET,
                    httpEntity,
                    String.class);
            return tel.getBody();
        }

}
