package sem.service;


import sem.configs.ApiConfig;
import sem.model.Characters;
import sem.model.Result;

public interface ServiceApi {
    public Characters getAllCharacters();
    Result getCharacter(int id);

}