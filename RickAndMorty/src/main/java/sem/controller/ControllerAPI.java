package sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sem.model.Characters;
import sem.model.Result;
import sem.service.ServiceApi;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    /**
     * отобразить список из 20 персонажей
     * @param model
     * @return
     */
    @GetMapping("/")
    public String getCharacters(Model model)
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        model.addAttribute("charactersLine1", allCharacters.getResults().subList(0,5));
        model.addAttribute("charactersLine2", allCharacters.getResults().subList(5,10));
        model.addAttribute("charactersLine3", allCharacters.getResults().subList(10,15));
        model.addAttribute("charactersLine4", allCharacters.getResults().subList(15,20));
        return "home";
    }

    /**
     * открыть карточку персонажа
     * @param id id персонажа
     * @param model
     * @return
     */
    @GetMapping("/character/{id}")
    public String getCharacters(@PathVariable int id, Model model)
    {
        Result result = serviceApi.getCharacter(id);
        model.addAttribute("char", result);
        return "char";
    }
}