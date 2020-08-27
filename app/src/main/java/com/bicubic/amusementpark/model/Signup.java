package com.bicubic.amusementpark.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 25-Nov-16.
 */

public class Signup {

    /**
     * status : 1
     * message : success
     * data : {"id":"15","name":"jay","email":"t@gmail.com","IMEI":"9912345678","phone":"1234567898","image":"http://192.168.1.201/eldorado/uploads/no_image.jpg","dob":"2016-11-25","facebook_id":"","created_at":"2016-11-25 07:36:09","updated_at":"2016-11-25 07:36:09","status":"1"}
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
         * id : 15
         * name : jay
         * email : t@gmail.com
         * IMEI : 9912345678
         * phone : 1234567898
         * image : http://192.168.1.201/eldorado/uploads/no_image.jpg
         * dob : 2016-11-25
         * facebook_id :
         * created_at : 2016-11-25 07:36:09
         * updated_at : 2016-11-25 07:36:09
         * status : 1
         */

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("email")
        private String email;
        @SerializedName("IMEI")
        private String IMEI;
        @SerializedName("phone")
        private String phone;
        @SerializedName("image")
        private String image;
        @SerializedName("dob")
        private String dob;
        @SerializedName("facebook_id")
        private String facebookId;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIMEI() {
            return IMEI;
        }

        public void setIMEI(String IMEI) {
            this.IMEI = IMEI;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getFacebookId() {
            return facebookId;
        }

        public void setFacebookId(String facebookId) {
            this.facebookId = facebookId;
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
