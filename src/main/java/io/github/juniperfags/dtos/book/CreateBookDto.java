package io.github.juniperfags.dtos.book;

import jakarta.validation.constraints.NotBlank;

public class CreateBookDto {

  @NotBlank(message = "Title is required")
  private String title;

  public String getTitle() {
    return title;
  }

  @NotBlank(message = "Author is required")
  private String author;

  public String getAuthor() {
    return author;
  }

  @NotBlank(message = "Description is required")
  private String description;

  public String getDescription() {
    return description;
  }

}