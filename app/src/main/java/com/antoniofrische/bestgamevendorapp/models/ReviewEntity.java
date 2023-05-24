package com.antoniofrische.bestgamevendorapp.models;


import java.util.Objects;


public class ReviewEntity {

    private int idReview;

    private String reviewText;

    private String reviewRating;

    private UserEntity user;

    private ProductosEntity product;

    public ReviewEntity() {
    }

    public ReviewEntity(int idReview, String reviewText, String reviewRating, UserEntity user, ProductosEntity product) {
        this.idReview = idReview;
        this.reviewText = reviewText;
        this.reviewRating = reviewRating;
        this.user = user;
        this.product = product;
    }

    public int getIdReview() {
        return idReview;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity fkUser) {
        this.user = fkUser;
    }

    public ProductosEntity getProduct() {
        return product;
    }

    public void setProduct(ProductosEntity fkProducts) {
        this.product = fkProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewEntity that = (ReviewEntity) o;
        return idReview == that.idReview && user == that.user && product == that.product && Objects.equals(reviewText, that.reviewText) && Objects.equals(reviewRating, that.reviewRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReview, reviewText, reviewRating, user, product);
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "idReview=" + idReview +
                ", reviewText='" + reviewText + '\'' +
                ", reviewRating='" + reviewRating + '\'' +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
