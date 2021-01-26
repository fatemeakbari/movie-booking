package com.example.moviebooking.controller.responseDto;

public class CommentResponseDto {

    private Long id;

    private String name;

    private String viewPoint;

    private Integer likeComment;

    public CommentResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(String viewPoint) {
        this.viewPoint = viewPoint;
    }

    public Integer getLikeComment() {
        return likeComment;
    }

    public void setLikeComment(Integer likeComment) {
        this.likeComment = likeComment;
    }
}
