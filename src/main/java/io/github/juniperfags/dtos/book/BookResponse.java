package io.github.juniperfags.dtos.book;

public class BookResponse {

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BookResponse(Long id, String title, String description, String author) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.author = author;
  }

  public BookResponse() {}

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  private String author;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

}