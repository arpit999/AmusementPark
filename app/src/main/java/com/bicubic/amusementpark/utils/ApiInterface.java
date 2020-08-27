package com.bicubic.amusementpark.utils;

import com.bicubic.amusementpark.model.Gallery;
import com.bicubic.amusementpark.model.Global;
import com.bicubic.amusementpark.model.Offers;
import com.bicubic.amusementpark.model.Rating;
import com.bicubic.amusementpark.model.Ride;
import com.bicubic.amusementpark.model.RideDetails;
import com.bicubic.amusementpark.model.Signup;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {
    //    @GET("movie/top_rated")
//    Call<Stackoverflow> getGallery(@Query("api_key") String apiKey);

//    @GET("questions?order=desc&sort=creation&site=stackoverflow&tagged=android")
//    Call<Stackoverflow> getGallery();
//
//    @GET("movie/{id}")
//    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);


    @Multipart
    @POST("signup")
    Call<ResponseBody> SignupWithImage(@Part("name") RequestBody name, @Part("email") RequestBody email, @Part("dob") RequestBody dob, @Part("phone") RequestBody phone, @Part("IMEI") RequestBody IMEI, @Part MultipartBody.Part file);

    @POST("signup")
    Call<Signup> SignupWithText(@Query("name") String name, @Query("email") String email, @Query("dob") String dob, @Query("phone") String mobile, @Query("IMEI") String IMEI);

    @GET("gallery_list")
    Call<Gallery> getGallery();

    @GET("rides_list")
    Call<Ride> getRides();

    @GET("restaurant_list")
    Call<Global> getRestaurantVlaue();

    @GET("theater_list")
    Call<Global> getTheaterVlaue();

    @POST("ride_gallery_list")
    Call<RideDetails> getRideDetails(@Query("ride_id") String id);

    @POST("hot_offer_list")
    Call<Offers> getAllOffers();

    @POST("rating_add")
    Call<Rating> setRating(@Query("user_id") String userid,@Query("ride_id") String rideid,@Query("rating") String rating,@Query("theme_type_id") String theme_type_id);



}
