package com.example.ff_sdci.board;

public class Notice {
    private String Title;
    private String content;
    // 좋아요랑... 북마크도?

    public Notice() {

    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
