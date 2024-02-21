package sem.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sem.configs.ApiConfig;
import sem.model.Characters;
import sem.model.Result;

import java.util.List;
import java.util.Random;

@Service
@Data
public class ServiceApiImpl implements ServiceApi{

    private RestTemplate template = new RestTemplate();


    private HttpHeaders headers = new HttpHeaders();

 private  final ApiConfig apiConfig;


    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String a = apiConfig.getAllCharacters()+"/?page="+new Random().nextInt(0,30);
        ResponseEntity<Characters> responce = template.exchange( a,HttpMethod.GET,entity, Characters.class);

        return responce.getBody();
    }

    @Override
    public Result getCharacter(int id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String a = apiConfig.getCharacter()+"/"+id;
        ResponseEntity<Result> responce = template.exchange( a,HttpMethod.GET,entity, Result.class);

        return responce.getBody();
    }
}