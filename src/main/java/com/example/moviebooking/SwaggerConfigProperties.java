package com.example.moviebooking;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration("swaggerConfigProperties")

public class SwaggerConfigProperties {

    @Value("${api.version}")

    private String apiVersion;

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUseDefaultResponseMessages() {
        return useDefaultResponseMessages;
    }

    public void setUseDefaultResponseMessages(String useDefaultResponseMessages) {
        this.useDefaultResponseMessages = useDefaultResponseMessages;
    }

    public void setEnableUrlTemplating(String enableUrlTemplating) {
        this.enableUrlTemplating = enableUrlTemplating;
    }

    public void setDeepLinking(String deepLinking) {
        this.deepLinking = deepLinking;
    }

    public void setDefaultModelsExpandDepth(String defaultModelsExpandDepth) {
        this.defaultModelsExpandDepth = defaultModelsExpandDepth;
    }

    public String getDefaultModelExpandDepth() {
        return defaultModelExpandDepth;
    }

    public void setDefaultModelExpandDepth(String defaultModelExpandDepth) {
        this.defaultModelExpandDepth = defaultModelExpandDepth;
    }

    public String getDisplayOperationId() {
        return displayOperationId;
    }

    public void setDisplayOperationId(String displayOperationId) {
        this.displayOperationId = displayOperationId;
    }

    public String getDisplayRequestDuration() {
        return displayRequestDuration;
    }

    public void setDisplayRequestDuration(String displayRequestDuration) {
        this.displayRequestDuration = displayRequestDuration;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getMaxDisplayedTags() {
        return maxDisplayedTags;
    }

    public void setMaxDisplayedTags(String maxDisplayedTags) {
        this.maxDisplayedTags = maxDisplayedTags;
    }

    public void setShowExtensions(String showExtensions) {
        this.showExtensions = showExtensions;
    }

    @Value("${swagger.enabled}")

    private String enabled = "false";

    @Value("${swagger.title}")

    private String title;

    @Value("${swagger.description}")

    private String description;

    @Value("${swagger.useDefaultResponseMessages}")

    private String useDefaultResponseMessages;

    @Value("${swagger.enableUrlTemplating}")

    private String enableUrlTemplating;

    @Value("${swagger.deepLinking}")

    private String deepLinking;

    @Value("${swagger.defaultModelsExpandDepth}")

    private String defaultModelsExpandDepth;

    @Value("${swagger.defaultModelExpandDepth}")

    private String defaultModelExpandDepth;

    @Value("${swagger.displayOperationId}")

    private String displayOperationId;

    @Value("${swagger.displayRequestDuration}")

    private String displayRequestDuration;

    @Value("${swagger.filter}")

    private String filter;

    @Value("${swagger.maxDisplayedTags}")

    private String maxDisplayedTags;

    @Value("${swagger.showExtensions}")

    private String showExtensions;

    public String getEnableUrlTemplating() {
        return enableUrlTemplating;
    }

    public String getDefaultModelsExpandDepth() {
        return defaultModelsExpandDepth;
    }

    public String getDeepLinking() {
        return deepLinking;
    }

    public String getFilter() {
        return filter;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getShowExtensions() {
        return showExtensions;
    }


}