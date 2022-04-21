package com.test.zss.book;
import com.test.zss.category.Category;
import com.test.zss.category.CategoryRepository;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

    public Book() {

    }

    public Book(String title, String description, Double price, Long categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = new Category(categoryId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
