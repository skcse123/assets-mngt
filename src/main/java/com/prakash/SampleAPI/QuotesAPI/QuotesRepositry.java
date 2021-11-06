package com.prakash.SampleAPI.QuotesAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepositry extends JpaRepository<QuotesModel,Long> {
}
