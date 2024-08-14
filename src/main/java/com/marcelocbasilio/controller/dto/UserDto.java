package com.marcelocbasilio.controller.dto;

import com.marcelocbasilio.domain.model.User;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto(Long id,
                      String name,
                      AccountDto account,
                      CardDto card,
                      List<FeatureDto> features,
                      List<NewsDto> news) {

    public UserDto(User user) {
        this(
                user.getId(),
                user.getName(),
                ofNullable(user.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(user.getCard()).map(CardDto::new).orElse(null),
                ofNullable(user.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList()),
                ofNullable(user.getNews()).orElse(emptyList()).stream().map(NewsDto::new).collect(toList())
        );
    }

    public User toUser() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setAccount(ofNullable(this.account).map(AccountDto::toAccount).orElse(null));
        user.setCard(ofNullable(this.card).map(CardDto::toCard).orElse(null));
        user.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toFeature).collect(toList()));
        user.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toNews).collect(toList()));
        return user;
    }
}
