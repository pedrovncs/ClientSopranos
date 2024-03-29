package org.infnet.assessment;

import org.infnet.assessment.services.EpisodesService;
import org.infnet.assessment.services.SeasonsService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit;
    private static ApiClient instance = null;

    private ApiClient() {
        String baseUrl = "http://localhost:8080/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public EpisodesService getEpisodeService() {
        return retrofit.create(EpisodesService.class);
    }

    public SeasonsService getSeasonsService() {
        return retrofit.create(SeasonsService.class);
    }
}
