package com.bicubic.amusementpark.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 17-Nov-16.
 */

public class Ride {


    /**
     * status : 1
     * message : success
     * data : [{"id":"1","theme_type_id":"1","name":"ranger","user_type":"1","image":"http://192.168.1.201/eldorado/uploads/rides/tick-talk.png","ride_desc":"ohhhh its amezing","ratting":"4","created_at":"2016-11-17 06:14:14","updated_at":"2016-11-17 10:32:33","status":"1"},{"id":"2","theme_type_id":"1","name":"roller coster","user_type":"1","image":"http://192.168.1.201/eldorado/uploads/rides/wing-roller.jpg","ride_desc":"ohhhh its fabulas","ratting":"5","created_at":"2016-11-17 06:14:14","updated_at":"2016-11-17 10:32:33","status":"1"},{"id":"3","theme_type_id":"0","name":"train","user_type":"1","image":"http://192.168.1.201/eldorado/uploads/rides/1479378166_2112093884.jpg","ride_desc":"","ratting":"","created_at":"2016-11-17 11:22:46","updated_at":"2016-11-17 11:22:46","status":"1"},{"id":"4","theme_type_id":"0","name":"min bus","user_type":"0","image":"http://192.168.1.201/eldorado/uploads/rides/1479378629_564622439.jpg","ride_desc":"fgdfgdfgdf","ratting":"","created_at":"2016-11-17 11:30:29","updated_at":"2016-11-17 11:30:29","status":"1"},{"id":"5","theme_type_id":"0","name":"fgf","user_type":"0","image":"http://192.168.1.201/eldorado/uploads/rides/1479378679_1602901936.jpg","ride_desc":"fgdgdfgfg \r\nfgfg","ratting":"","created_at":"2016-11-17 11:31:19","updated_at":"2016-11-17 11:31:19","status":"1"},{"id":"6","theme_type_id":"0","name":"sadsa","user_type":"0","image":"http://192.168.1.201/eldorado/uploads/rides/1479378845_1854717677.JPG","ride_desc":"sdsad","ratting":"","created_at":"2016-11-17 11:34:05","updated_at":"2016-11-17 11:37:17","status":"9"},{"id":"7","theme_type_id":"0","name":"eee","user_type":"1","image":"http://192.168.1.201/eldorado/uploads/rides/1479379108_79471616.png","ride_desc":"fdf","ratting":"","created_at":"2016-11-17 11:38:28","updated_at":"2016-11-17 11:38:28","status":"1"}]
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * theme_type_id : 1
         * name : ranger
         * user_type : 1
         * image : http://192.168.1.201/eldorado/uploads/rides/tick-talk.png
         * ride_desc : ohhhh its amezing
         * ratting : 4
         * created_at : 2016-11-17 06:14:14
         * updated_at : 2016-11-17 10:32:33
         * status : 1
         */

        @SerializedName("id")
        private String id;
        @SerializedName("theme_type_id")
        private String themeTypeId;
        @SerializedName("name")
        private String name;
        @SerializedName("user_type")
        private String userType;
        @SerializedName("image")
        private String image;
        @SerializedName("ride_desc")
        private String rideDesc;
        @SerializedName("ratting")
        private String ratting;
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

        public String getThemeTypeId() {
            return themeTypeId;
        }

        public void setThemeTypeId(String themeTypeId) {
            this.themeTypeId = themeTypeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRideDesc() {
            return rideDesc;
        }

        public void setRideDesc(String rideDesc) {
            this.rideDesc = rideDesc;
        }

        public String getRatting() {
            return ratting;
        }

        public void setRatting(String ratting) {
            this.ratting = ratting;
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
