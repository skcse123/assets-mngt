package com.prakash.SampleAPI.QuotesAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuoteServiceImplementaion implements QuotesService{


    private final QuotesRepositry quotesRepositry;

    public QuoteServiceImplementaion(QuotesRepositry quotesRepositry) {
        this.quotesRepositry = quotesRepositry;
    }

    @Override
    public QuotesModel createQuote(QuotesModel quote) {

        return quotesRepositry.save(quote);

    }

    @Override
    public Optional<QuotesModel> retreiveQuoteByID(long quoteID) {
        return quotesRepositry.findById(quoteID);
    }

    @Override
    public QuotesModel updateQuote(QuotesModel quote) {

        Optional<QuotesModel> flag = quotesRepositry.findById(quote.getId());

        if (flag.isPresent()){
                QuotesModel newflag =flag.get();
                newflag.setId(quote.getId());
                newflag.setQuote(quote.getQuote());
                newflag.setAuthor(quote.getAuthor());

                quotesRepositry.save(newflag);
                return newflag;
        }

        return null;
    }

    @Override
    public List<QuotesModel> retreiveAllQuotes() {
        return quotesRepositry.findAll();
    }

    @Override
    public void deleteQuote(long quoteID) {
        Optional<QuotesModel> flag = quotesRepositry.findById(quoteID);
        if (flag.isPresent()){
            quotesRepositry.deleteById(quoteID);
        }
    }
}
