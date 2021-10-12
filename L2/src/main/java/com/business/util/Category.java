package com.business.util;

public enum Category {
    COMEDY("comedy"),
    ACTION("action"),
    HORROR("horror"),
    DRAMA("drama"),
    UNKNOWN("unknown");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static Category fromString(String text) {
        for (Category cat : Category.values()) {
            if (cat.category.equalsIgnoreCase(text)) {
                return cat;
            }
        }
        return null;
    }
}
