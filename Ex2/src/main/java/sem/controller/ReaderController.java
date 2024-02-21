package sem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sem.repository.ReaderRepository;
import sem.model.Reader;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepo;

    @GetMapping
    public List<Reader> getAll(){
        return readerRepo.findAll();
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader){
        return readerRepo.save(reader);
    }
}