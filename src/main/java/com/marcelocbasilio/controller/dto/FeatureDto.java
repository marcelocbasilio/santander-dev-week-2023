package com.marcelocbasilio.controller.dto;

import com.marcelocbasilio.domain.model.Feature;

public record FeatureDto(Long id, String icon, String description) {

    public FeatureDto(Feature feature) {
        this(feature.getId(), feature.getIcon(), feature.getDescription());
    }

    public Feature toFeature() {
        Feature feature = new Feature();
        feature.setId(this.id);
        feature.setIcon(this.icon);
        feature.setDescription(this.description);
        return feature;
    }
}
