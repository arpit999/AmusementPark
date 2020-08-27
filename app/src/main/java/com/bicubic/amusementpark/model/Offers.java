package com.bicubic.amusementpark.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 24-Nov-16.
 */

public class Offers {


    /**
     * status : 1
     * message : success
     * data : [{"id":"1","title":"offer offer !!!","desc":"10% discount on train ride for kids!!!","image":"http://192.168.1.201/eldorado/uploads/offer/1479911925_1561218395.png","discount":"10","created_at":"2016-11-23 15:38:45","updated_at":"2016-11-23 15:38:45","status":"1"},{"id":"2","title":"loot lo!!","desc":"hurry up!","image":"http://192.168.1.201/eldorado/uploads/offer/1479970033_1669018501.png","discount":"20","created_at":"2016-11-24 07:47:13","updated_at":"2016-11-24 07:47:13","status":"1"}]
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
         * title : offer offer !!!
         * desc : 10% discount on train ride for kids!!!
         * image : http://192.168.1.201/eldorado/uploads/offer/1479911925_1561218395.png
         * discount : 10
         * created_at : 2016-11-23 15:38:45
         * updated_at : 2016-11-23 15:38:45
         * status : 1
         */

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("desc")
        private String desc;
        @SerializedName("image")
        private String image;
        @SerializedName("discount")
        private String discount;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
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
