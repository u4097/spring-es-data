package com.myapp.elastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

@Document(indexName = "blog", type = "article")
@Data
public class Article {
    @Id
    private String id;
    @MultiField(mainField = @Field(type = Text, fielddata = true),
            otherFields = {@InnerField(suffix = "verbatim", type = Keyword)})
    private String title;

    @Field(type = Nested, includeInParent = true)
    private List<Author> authors;

    @Field(type = Keyword)
    private String[] tags;

    public Article(String title) {
         this.title = title;
    }

    public void setAuthors(List<Author> asList) {
        this.authors = asList;
    }

    public void setTags(String elasticsearch, String spring_data) {
        this.tags = new String[]{elasticsearch, spring_data};
    }
}
