package com.prakash.SampleAPI.QuotesAPI;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class QuotesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Column(name = "quote")
    private String Quote;
    @Column(name = "author")
    private String Author;

    @CreationTimestamp
    private Date PublishedOn;

    public QuotesModel() {
    }



    @Override
    public String toString() {
        return "QuotesModel{" +
                "id=" + id +
                ", Quote='" + Quote + '\'' +
                ", Author='" + Author + '\'' +
                ", PublishedOn=" + PublishedOn +
                '}';
    }

    public QuotesModel(long id, String quote, String author, Date publishedOn) {
        this.id = id;
        Quote = quote;
        Author = author;
        PublishedOn = publishedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return Quote;
    }

    public void setQuote(String quote) {
        Quote = quote;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Date getPublishedOn() {
        return PublishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        PublishedOn = publishedOn;
    }
}
