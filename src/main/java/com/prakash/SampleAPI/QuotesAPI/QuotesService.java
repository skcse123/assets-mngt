package com.prakash.SampleAPI.QuotesAPI;

import java.util.List;
import java.util.Optional;

public interface QuotesService {

    QuotesModel createQuote(QuotesModel quote);
    Optional<QuotesModel> retreiveQuoteByID(long quoteID);
    QuotesModel updateQuote(QuotesModel quote);
    List<QuotesModel>retreiveAllQuotes();
    void deleteQuote(long quoteID);



}
