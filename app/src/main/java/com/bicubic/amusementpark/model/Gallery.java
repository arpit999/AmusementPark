package com.bicubic.amusementpark.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 19-Nov-16.
 */

public class Gallery {


    /**
     * status : 1
     * message : success
     * gallery_image : [{"image":"http://192.168.1.201/eldorado/uploads/no_image.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469423_2062509641.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469474_118106875.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469546_1820224205.png"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469563_78580467.png"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469737_137642793.png"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469862_1669165360.png"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469905_1612568545.png"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469917_1247021541.png"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479469940_254981697.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479470069_2119075898.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479470069_344905013.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479470095_1711277872.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479470095_1135405882.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479470095_1653496758.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479537981_1123493058.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479537981_759945139.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479538645_1527396492.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479538645_1618013928.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479538760_1383124509.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479538760_556009180.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479538851_942978149.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479538851_1143097464.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539001_1484324991.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539001_610225948.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539041_1200227095.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539041_1421205811.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539048_1718100311.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539048_1404418580.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539096_182630672.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539096_400520980.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539128_226233654.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539128_1707369920.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539472_346137685.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539472_232836364.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539507_1280672300.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539507_2046200663.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539573_2137036232.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539573_497511710.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539578_990277723.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539578_1895762660.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539588_324092326.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539588_2019177452.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539644_555570452.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539644_1076655941.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539828_1338637509.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479539828_336723192.jpeg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479549688_1276631856.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479549688_91337531.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_1907044388.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_527856971.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_421254975.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479550096_1486306722.mp4"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479550096_1640481036.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479550096_573696334.JPG"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479555452_1154543034.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479555452_79143976.jpg"},{"image":"http://192.168.1.201/eldorado/uploads/gallery/1479555452_1002527726.jpg"}]
     * gallery_video : [{"video":"http://192.168.1.201/eldorado/uploads/no_image.jpg"},{"video":"http://192.168.1.201/eldorado/uploads/no_image.jpg"},{"video":"http://192.168.1.201/eldorado/uploads/no_image.jpg"},{"video":"http://192.168.1.201/eldorado/uploads/no_image.jpg"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_269961284.3gp"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479549888_792675364.mp4"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479550096_514862366.3gp"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479550096_1152429480.mp4"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479555452_948933342.3gp"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479555452_1777816086.3gp"},{"video":"http://192.168.1.201/eldorado/uploads/gallery/1479555452_100706882.mp4"}]
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("gallery_image")
    private List<GalleryImageBean> galleryImage;
    @SerializedName("gallery_video")
    private List<GalleryVideoBean> galleryVideo;

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

    public List<GalleryImageBean> getGalleryImage() {
        return galleryImage;
    }

    public void setGalleryImage(List<GalleryImageBean> galleryImage) {
        this.galleryImage = galleryImage;
    }

    public List<GalleryVideoBean> getGalleryVideo() {
        return galleryVideo;
    }

    public void setGalleryVideo(List<GalleryVideoBean> galleryVideo) {
        this.galleryVideo = galleryVideo;
    }

    public static class GalleryImageBean {
        /**
         * image : http://192.168.1.201/eldorado/uploads/no_image.jpg
         */

        @SerializedName("image")
        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class GalleryVideoBean {
        /**
         * video : http://192.168.1.201/eldorado/uploads/no_image.jpg
         */

        @SerializedName("video")
        private String video;

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }
    }
}
