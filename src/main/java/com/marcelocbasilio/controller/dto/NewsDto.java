package com.marcelocbasilio.controller.dto;

import com.marcelocbasilio.domain.model.News;

public record NewsDto(Long id, String icon, String description) {

    public NewsDto(News news) {
        this(news.getId(), news.getIcon(), news.getDescription());
    }

    public News toNews() {
        News news = new News();
        news.setId(this.id);
        news.setIcon(this.icon);
        news.setDescription(this.description);
        return news;
    }
}
