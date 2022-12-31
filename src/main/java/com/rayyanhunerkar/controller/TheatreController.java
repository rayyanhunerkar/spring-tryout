package com.rayyanhunerkar.controller;

import com.rayyanhunerkar.model.Theatre;
import com.rayyanhunerkar.repository.TheatreRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreRepository theatreRepository;

    public TheatreController(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Theatre> getTheatres() {
        return theatreRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void addTheatre(@RequestBody @NotNull TheatreRequest request) {
        Theatre theatre = new Theatre();
        theatre.setName(request.name);
        theatre.setLocation(request.location);
        theatreRepository.save(theatre);
    }

    @GetMapping("{id}")
    public Optional<Theatre> getTheatre(@PathVariable UUID id) {
        Optional<Theatre> theatre = theatreRepository.findById(id);
        if (theatre.isPresent()) {
            return theatre;
        } else {
            throw new ExceptionController(
                    HttpStatus.NOT_FOUND,
                    "Theatre not found");
        }

    }

    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Theatre> updateTheatre(@PathVariable UUID id, @RequestBody TheatreRequest request) {
        Optional<Theatre> theatre = theatreRepository.findById(id);
        if (theatre.isPresent()) {
            theatre.map(
                    theatre1 -> {
                        theatre1.setName(request.name);
                        theatre1.setLocation(request.location);
                        theatreRepository.save(theatre1);
                        return theatre1;
                    }
            );
        } else {
            throw new ExceptionController(
                    HttpStatus.NOT_FOUND,
                    "Theatre not found");
        }
        return theatre;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTheatre(@PathVariable UUID id) {
        theatreRepository.findById(id).ifPresent(
                theatre -> {
                    theatreRepository.deleteById(id);
                }
        );
    }

    record TheatreRequest(
            String name,
            String location
    ) {

    }
}
