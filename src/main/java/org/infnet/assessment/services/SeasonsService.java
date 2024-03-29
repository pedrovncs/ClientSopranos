package org.infnet.assessment.services;

import org.infnet.assessment.models.Season;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface SeasonsService {

    @GET("/seasons")
    Call<List<Season>> list();

    @GET("/seasons/{season_num}")
    Call<Season> getSeason(@Path("season_num") int season_num);

    @POST("/seasons")
    Call<Season> createSeason(@Body Season season);

    @DELETE("/seasons/{season_num}")
    Call<Season> deleteSeason(@Path("season_num") int season_num);

    @PUT("/seasons/{season_num}")
    Call<Season> updateSeason(@Path("season_num") int season_num, @Body Season season);
}
