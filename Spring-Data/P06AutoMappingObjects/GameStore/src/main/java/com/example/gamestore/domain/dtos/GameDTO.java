package com.example.gamestore.domain.dtos;

import com.example.gamestore.domain.entities.Game;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDTO {

    private String title;

    private BigDecimal price;

    private float size;

    private String trailerId;

    private String imageURL;

    private String description;

    private LocalDate releaseDate;

    public GameDTO() {
    }

    public GameDTO(String title,
                   BigDecimal price,
                   float size,
                   String trailerId,
                   String imageURL,
                   String description,
                   LocalDate releaseDate) {
        setTitle(title);
        setPrice(price);
        setSize(size);
        setTrailerId(trailerId);
        setImageURL(imageURL);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null &&
                Character.isLowerCase(title.charAt(0))
                || title.length() < 3
                || title.length() > 100) {
            throw new IllegalArgumentException("Not a valid title.");
        }

        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price != null && price.longValue() <= 0) {
            throw new IllegalArgumentException("Price should be positive number.");
        }

        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        if (size <= 0.0) {
            throw new IllegalArgumentException("Size should be positive number.");
        }

        this.size = size;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        if (trailerId != null && trailerId.length() != 11) {
            throw new IllegalArgumentException("Trailer id should exactly 11 symbols");
        }

        this.trailerId = trailerId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        if (imageURL != null && !imageURL.startsWith("http://") && !imageURL.startsWith("https://")) {
            throw new IllegalArgumentException("Link should begin with http:// or https://");
        }

        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() < 20) {
            throw new IllegalArgumentException("Description must be at least 20 symbols.");
        }

        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Game toGame() {
        return new Game(title, trailerId, imageURL, size, price, description, releaseDate);
    }
}
