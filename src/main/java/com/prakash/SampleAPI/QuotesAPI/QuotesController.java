package com.prakash.SampleAPI.QuotesAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @GetMapping("/about")
    public List<QuotesModel> about(){
        QuotesModel about = new QuotesModel(1982,"Built by Prakash" , "Prakash",null);
        return List.of(about);
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<QuotesModel>>GetAllQuotes(){
        return ResponseEntity.ok().body(quotesService.retreiveAllQuotes());
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Optional<QuotesModel>> getQuotebyID(@PathVariable long id){
        return ResponseEntity.ok().body(quotesService.retreiveQuoteByID(id));
    }
    @PostMapping("/quotes")
    public ResponseEntity<QuotesModel> createProduct(@RequestBody QuotesModel quote){
        return ResponseEntity.ok().body(this.quotesService.createQuote(quote));
    }

    @PutMapping("/quotes/{id}")
    public ResponseEntity<QuotesModel> updateQuote (@PathVariable long id, @RequestBody QuotesModel quote){
        quote.setId(id);
        return ResponseEntity.ok().body(this.quotesService.updateQuote(quote));
    }

    @DeleteMapping("/quotes/{id}")
    public HttpStatus deleteQuote(@PathVariable long id){
        this.quotesService.deleteQuote(id);
        return HttpStatus.OK;
    }

}
