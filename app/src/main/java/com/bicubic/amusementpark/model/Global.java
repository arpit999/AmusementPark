package com.bicubic.amusementpark.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19-Nov-16.
 */

public class Global implements Parcelable {




    @Override
    public String toString() {
        return "Global{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", ratting='" + ratting + '\'' +
                ", restaurantImage='" + restaurantImage + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", video=" + video +
                '}';
    }

    /**
     * status : 1
     * message : success
     * ratting : 5
     * restaurant_image : http://192.168.1.201/eldorado/uploads/theme_type/1479382589_1575479348.jpeg
     * description : its fab!!!!
     * image : [{"id":"2","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479469423_2062509641.jpg","created_at":"2016-11-18 12:43:43","updated_at":"2016-11-18 12:43:43","status":"1"},{"id":"3","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479469474_118106875.jpg","created_at":"2016-11-18 12:44:34","updated_at":"2016-11-18 12:44:34","status":"1"},{"id":"16","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479537981_1123493058.jpg","created_at":"2016-11-19 07:46:21","updated_at":"2016-11-19 07:46:21","status":"1"},{"id":"17","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479537981_759945139.jpg","created_at":"2016-11-19 07:46:21","updated_at":"2016-11-19 07:46:21","status":"1"},{"id":"30","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539096_182630672.jpg","created_at":"2016-11-19 08:04:56","updated_at":"2016-11-19 08:04:56","status":"1"},{"id":"31","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539096_400520980.jpeg","created_at":"2016-11-19 08:04:56","updated_at":"2016-11-19 08:04:56","status":"1"},{"id":"32","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539128_226233654.jpg","created_at":"2016-11-19 08:05:28","updated_at":"2016-11-19 08:05:28","status":"1"},{"id":"33","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539128_1707369920.jpeg","created_at":"2016-11-19 08:05:28","updated_at":"2016-11-19 08:05:28","status":"1"},{"id":"34","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539472_346137685.jpg","created_at":"2016-11-19 08:11:12","updated_at":"2016-11-19 08:11:12","status":"1"},{"id":"35","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539472_232836364.jpeg","created_at":"2016-11-19 08:11:12","updated_at":"2016-11-19 08:11:12","status":"1"},{"id":"36","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539507_1280672300.jpg","created_at":"2016-11-19 08:11:47","updated_at":"2016-11-19 08:11:47","status":"1"},{"id":"37","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539507_2046200663.jpeg","created_at":"2016-11-19 08:11:47","updated_at":"2016-11-19 08:11:47","status":"1"},{"id":"38","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539573_2137036232.jpg","created_at":"2016-11-19 08:12:53","updated_at":"2016-11-19 08:12:53","status":"1"},{"id":"39","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539573_497511710.jpeg","created_at":"2016-11-19 08:12:53","updated_at":"2016-11-19 08:12:53","status":"1"},{"id":"40","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539578_990277723.jpg","created_at":"2016-11-19 08:12:58","updated_at":"2016-11-19 08:12:58","status":"1"},{"id":"41","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539578_1895762660.jpeg","created_at":"2016-11-19 08:12:58","updated_at":"2016-11-19 08:12:58","status":"1"},{"id":"42","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539588_324092326.jpg","created_at":"2016-11-19 08:13:08","updated_at":"2016-11-19 08:13:08","status":"1"},{"id":"43","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539588_2019177452.jpeg","created_at":"2016-11-19 08:13:08","updated_at":"2016-11-19 08:13:08","status":"1"},{"id":"44","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539644_555570452.jpg","created_at":"2016-11-19 08:14:04","updated_at":"2016-11-19 08:14:04","status":"1"},{"id":"45","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539644_1076655941.jpeg","created_at":"2016-11-19 08:14:04","updated_at":"2016-11-19 08:14:04","status":"1"},{"id":"46","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539828_1338637509.jpg","created_at":"2016-11-19 08:17:08","updated_at":"2016-11-19 08:17:08","status":"1"},{"id":"47","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479539828_336723192.jpeg","created_at":"2016-11-19 08:17:08","updated_at":"2016-11-19 08:17:08","status":"1"},{"id":"48","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479549688_1276631856.jpg","created_at":"2016-11-19 11:01:28","updated_at":"2016-11-19 11:01:28","status":"1"},{"id":"49","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479549688_91337531.jpg","created_at":"2016-11-19 11:01:28","updated_at":"2016-11-19 11:01:28","status":"1"},{"id":"50","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_1907044388.jpg","created_at":"2016-11-19 11:04:48","updated_at":"2016-11-19 11:04:48","status":"1"},{"id":"51","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_527856971.jpg","created_at":"2016-11-19 11:04:48","updated_at":"2016-11-19 11:04:48","status":"1"},{"id":"52","theme_type_id":"2","image":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_421254975.jpg","created_at":"2016-11-19 11:04:48","updated_at":"2016-11-19 11:04:48","status":"1"}]
     * video : [{"id":"1","theme_type_id":"2","video":"http://192.168.1.201/eldorado/uploads/no_image.jpg","created_at":"2016-11-19 08:17:08","updated_at":"2016-11-19 08:17:08","status":"1"},{"id":"2","theme_type_id":"2","video":"http://192.168.1.201/eldorado/uploads/no_image.jpg","created_at":"2016-11-19 08:17:08","updated_at":"2016-11-19 08:17:08","status":"1"},{"id":"3","theme_type_id":"2","video":"http://192.168.1.201/eldorado/uploads/no_image.jpg","created_at":"2016-11-19 11:01:28","updated_at":"2016-11-19 11:01:28","status":"1"},{"id":"4","theme_type_id":"2","video":"http://192.168.1.201/eldorado/uploads/no_image.jpg","created_at":"2016-11-19 11:01:28","updated_at":"2016-11-19 11:01:28","status":"1"},{"id":"5","theme_type_id":"2","video":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_269961284.3gp","created_at":"2016-11-19 11:04:48","updated_at":"2016-11-19 11:04:48","status":"1"},{"id":"6","theme_type_id":"2","video":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_792675364.mp4","created_at":"2016-11-19 11:04:48","updated_at":"2016-11-19 11:04:48","status":"1"}]
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("ratting")
    private String ratting;
    @SerializedName("theater_image")
    private String theaterImage;
    @SerializedName("restaurant_image")
    private String restaurantImage;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private List<ImageBean> image;
    @SerializedName("video")
    private List<VideoBean> video;

    public String getTheaterImage() {
        return theaterImage;
    }

    public void setTheaterImage(String theaterImage) {
        this.theaterImage = theaterImage;
    }

    public static Creator<Global> getCREATOR() {
        return CREATOR;
    }

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

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageBean> getImage() {
        return image;
    }

    public void setImage(List<ImageBean> image) {
        this.image = image;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class ImageBean implements Parcelable {


        @Override
        public String toString() {
            return "ImageBean{" +
                    "id='" + id + '\'' +
                    ", themeTypeId='" + themeTypeId + '\'' +
                    ", image='" + image + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }

        /**
         * id : 2
         * theme_type_id : 2
         * image : http://192.168.1.201/eldorado/uploads/gallery/1479469423_2062509641.jpg
         * created_at : 2016-11-18 12:43:43
         * updated_at : 2016-11-18 12:43:43
         * status : 1
         */

        @SerializedName("id")
        private String id;
        @SerializedName("theme_type_id")
        private String themeTypeId;
        @SerializedName("image")
        private String image;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.themeTypeId);
            dest.writeString(this.image);
            dest.writeString(this.createdAt);
            dest.writeString(this.updatedAt);
            dest.writeString(this.status);
        }

        public ImageBean() {
        }

        protected ImageBean(Parcel in) {
            this.id = in.readString();
            this.themeTypeId = in.readString();
            this.image = in.readString();
            this.createdAt = in.readString();
            this.updatedAt = in.readString();
            this.status = in.readString();
        }

        public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
            @Override
            public ImageBean createFromParcel(Parcel source) {
                return new ImageBean(source);
            }

            @Override
            public ImageBean[] newArray(int size) {
                return new ImageBean[size];
            }
        };
    }

    public static class VideoBean implements Parcelable {

        @Override
        public String toString() {
            return "VideoBean{" +
                    "id='" + id + '\'' +
                    ", themeTypeId='" + themeTypeId + '\'' +
                    ", video='" + video + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }

        /**
         * id : 1
         * theme_type_id : 2
         * video : http://192.168.1.201/eldorado/uploads/no_image.jpg
         * created_at : 2016-11-19 08:17:08
         * updated_at : 2016-11-19 08:17:08
         * status : 1
         */

        @SerializedName("id")
        private String id;
        @SerializedName("theme_type_id")
        private String themeTypeId;
        @SerializedName("video")
        private String video;
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

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.themeTypeId);
            dest.writeString(this.video);
            dest.writeString(this.createdAt);
            dest.writeString(this.updatedAt);
            dest.writeString(this.status);
        }

        public VideoBean() {
        }

        protected VideoBean(Parcel in) {
            this.id = in.readString();
            this.themeTypeId = in.readString();
            this.video = in.readString();
            this.createdAt = in.readString();
            this.updatedAt = in.readString();
            this.status = in.readString();
        }

        public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
            @Override
            public VideoBean createFromParcel(Parcel source) {
                return new VideoBean(source);
            }

            @Override
            public VideoBean[] newArray(int size) {
                return new VideoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeString(this.message);
        dest.writeString(this.ratting);
        dest.writeString(this.restaurantImage);
        dest.writeString(this.description);
        dest.writeList(this.image);
        dest.writeList(this.video);
    }

    public Global() {
    }

    protected Global(Parcel in) {
        this.status = in.readInt();
        this.message = in.readString();
        this.ratting = in.readString();
        this.restaurantImage = in.readString();
        this.description = in.readString();
        this.image = new ArrayList<ImageBean>();
        in.readList(this.image, ImageBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Global> CREATOR = new Parcelable.Creator<Global>() {
        @Override
        public Global createFromParcel(Parcel source) {
            return new Global(source);
        }

        @Override
        public Global[] newArray(int size) {
            return new Global[size];
        }
    };
}
