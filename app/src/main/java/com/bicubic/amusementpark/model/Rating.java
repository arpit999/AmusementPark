package com.bicubic.amusementpark.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 25-Nov-16.
 */

public class Rating {

    /**
     * status : 1
     * message : success
     * data : {"id":"5","user_id":"1","theme_type_id":"2","rating":"4","created_at":"2016-11-25 11:13:23","updated_at":"2016-11-25 11:13:23","status":"1"}
     */
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * user_id : 1
         * theme_type_id : 2
         * rating : 4
         * created_at : 2016-11-25 11:13:23
         * updated_at : 2016-11-25 11:13:23
         * status : 1
         */

        @SerializedName("id")
        private String id;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("theme_type_id")
        private String themeTypeId;
        @SerializedName("rating")
        private String rating;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("status")
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getThemeTypeId() {
            return themeTypeId;
        }

        public void setThemeTypeId(String themeTypeId) {
            this.themeTypeId = themeTypeId;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
