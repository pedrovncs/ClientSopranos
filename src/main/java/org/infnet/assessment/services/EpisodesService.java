package org.infnet.assessment.services;

import org.infnet.assessment.models.Episode;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface EpisodesService {
    @GET ("/seasons/{season_number}/episodes")
    Call<List<Episode>> list(@Path("season_number") int season_number);

    @GET("/seasons/{season_number}/episodes/{episode_number}")
    Call<Episode> getEpisode(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @POST("/seasons/{season_number}/episodes")
    Call<Episode> createEpisode(@Path("season_number") int season_number, @Body Episode episode);

    @DELETE("/seasons/{season_number}/episodes/{episode_number}")
    Call<Void> deleteEpisode(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @PUT("/seasons/{season_number}/episodes/{episode_number}")
    Call<Episode> updateEpisode(@Path("season_number") int season_number, @Path("episode_number") int episode_number, @Body Episode episode);

    @GET("/seasons/{season_number}/episodes/{episode_number}/title")
    Call<String> getEpisodeTitle(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @GET("/seasons/{season_number}/episodes/{episode_number}/rating")
    Call<String> getRating(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @GET("/seasons/{season_number}/episodes/{episode_number}/description")
    Call<String> getDescription(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @GET("/seasons/{season_number}/episodes/{episode_number}/director")
    Call<String> getDirector(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @GET("/seasons/{season_number}/episodes/{episode_number}/writer")
    Call<String> getWriter(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

    @PUT("/seasons/{season_number}/episodes/{episode_number}")
    Call<Episode> updateRating(@Path("season_number") int season_number, @Path("episode_number") int episode_number, @Body Episode episode);

    @DELETE("/seasons/{season_number}/episodes/{episode_number}")
    Call<Episode> deleteRating(@Path("season_number") int season_number, @Path("episode_number") int episode_number);

}
