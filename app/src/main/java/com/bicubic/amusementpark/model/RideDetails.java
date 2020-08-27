package com.bicubic.amusementpark.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22-Nov-16.
 */

public class RideDetails implements Parcelable {

    @Override
    public String toString() {
        return "RideDetails{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", rideDesc='" + rideDesc + '\'' +
                ", ratting='" + ratting + '\'' +
                ", rideImage='" + rideImage + '\'' +
                ", image=" + image +
                ", video=" + video +
                '}';
    }

    /**
     * status : 1
     * message : success
     * ride_desc : its fab!
     * ratting :
     * ride_image : http://192.168.1.201/eldorado/uploads/rides/1479558441_2131277738.png
     * image : [{"ride_image":"http://192.168.1.201/eldorado/uploads/ride_gallery/1479801558_1913134430.png"},{"ride_image":"http://192.168.1.201/eldorado/uploads/ride_gallery/1479801558_1964895877.png"}]
     * video : [{"ride_video":"http://192.168.1.201/eldorado/uploads/ride_gallery/1479801558_2142774409.3gp"},{"ride_video":"http://192.168.1.201/eldorado/uploads/ride_gallery/1479801558_1172862341.3gp"}]
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("ride_desc")
    private String rideDesc;
    @SerializedName("ratting")
    private String ratting;
    @SerializedName("ride_image")
    private String rideImage;
    @SerializedName("image")
    private List<ImageBean> image;
    @SerializedName("video")
    private List<VideoBean> video;

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

    public String getRideImage() {
        return rideImage;
    }

    public void setRideImage(String rideImage) {
        this.rideImage = rideImage;
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


        /**
         * ride_image : http://192.168.1.201/eldorado/uploads/ride_gallery/1479801558_1913134430.png
         */

        @SerializedName("ride_image")
        private String rideImage;

        public String getRideImage() {
            return rideImage;
        }

        public void setRideImage(String rideImage) {
            this.rideImage = rideImage;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.rideImage);
        }

        public ImageBean() {
        }

        protected ImageBean(Parcel in) {
            this.rideImage = in.readString();
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

        /**
         * ride_video : http://192.168.1.201/eldorado/uploads/ride_gallery/1479801558_2142774409.3gp
         */

        @SerializedName("ride_video")
        private String rideVideo;

        public String getRideVideo() {
            return rideVideo;
        }

        public void setRideVideo(String rideVideo) {
            this.rideVideo = rideVideo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.rideVideo);
        }

        public VideoBean() {
        }

        protected VideoBean(Parcel in) {
            this.rideVideo = in.readString();
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
        dest.writeString(this.rideDesc);
        dest.writeString(this.ratting);
        dest.writeString(this.rideImage);
        dest.writeList(this.image);
        dest.writeList(this.video);
    }

    public RideDetails() {
    }

    protected RideDetails(Parcel in) {
        this.status = in.readInt();
        this.message = in.readString();
        this.rideDesc = in.readString();
        this.ratting = in.readString();
        this.rideImage = in.readString();
        this.image = new ArrayList<ImageBean>();
        in.readList(this.image, ImageBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<RideDetails> CREATOR = new Parcelable.Creator<RideDetails>() {
        @Override
        public RideDetails createFromParcel(Parcel source) {
            return new RideDetails(source);
        }

        @Override
        public RideDetails[] newArray(int size) {
            return new RideDetails[size];
        }
    };
}
