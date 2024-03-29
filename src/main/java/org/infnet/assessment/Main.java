package org.infnet.assessment;

import org.infnet.assessment.callbacks.JsonCallback;
import org.infnet.assessment.callbacks.StringCallback;
import org.infnet.assessment.models.Episode;
import org.infnet.assessment.models.Season;
import org.infnet.assessment.services.EpisodesService;
import org.infnet.assessment.services.SeasonsService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final SeasonsService seasonsService = ApiClient.getInstance().getSeasonsService();
    private static final EpisodesService episodesService = ApiClient.getInstance().getEpisodeService();

    private static Episode episodeExample1 = new Episode(1, "Members Only", "Tim Van Patten", "Terence Winter", "Tony faces pressure from his own crew while Junior's trial reaches its conclusion.", 9.1);
    private static Episode episodeExample2 = new Episode(2, "Join the Club", "David Nutter", "David Chase", "Tony and Carmela try a therapy session together, which ends in an angry dispute. Artie, meanwhile, tries to move in on Adriana.", 9.3);
    private static Episode episodeExample3 = new Episode(2, "Join the Club - updated", "David Nutter - updated", "David Chase - updated", "Tony and Carmela try a therapy session together, which ends in an angry dispute. Artie, meanwhile, tries to move in on Adriana. - updated", 9.3);
    private static Season seasonExample = new Season(6, new ArrayList<Episode>() {{
        add(episodeExample1);
    }});

    public static void main(String[] args) {
//        listSeasons();
//        createSeason(seasonExample);
//        listAllEpisodesFromSeason(6);
//        createEpisode(6, episodeExample2);
//        updateEpisode(6, episodeExample3);
//        deleteEpisode(6, 2);
//        deleteSeason(6);
//        updateSeason(1, seasonExample);
//
//        getEpisode(1, 1);
//        getEpisodeTitle(1, 1);
//        getRating(1, 1);
//        getDescription(1, 1);
//        getDirector(1, 1);
//        getWriter(1, 1);
    }

    //SEASONS
    public static void listSeasons() {
        Call<List<Season>> call = seasonsService.list();
        call.enqueue(new JsonCallback<>("Lista de Seasons:"));
    }

    public static void createSeason(Season season) {
        Call<Season> call = seasonsService.createSeason(season);
        call.enqueue(new JsonCallback<>("Season Criada: "));
    }

    public static void deleteSeason(int season_num) {
        Call<Season> call = seasonsService.deleteSeason(season_num);
        call.enqueue(new JsonCallback<>("Season deletada: "));
    }

    public static void updateSeason(int season_num, Season season) {
        Call<Season> call = seasonsService.updateSeason(season_num, season);
        call.enqueue(new JsonCallback<>("Resultado do UpdateSeason: "));
    }

 //EPISODES

    public static void listAllEpisodesFromSeason(int season_num) {
        Call<List<Episode>> call = episodesService.list(season_num);
        call.enqueue(new JsonCallback<>("Episodes da Season: " + season_num + ": "));
    }

    public static void createEpisode(int season_num, Episode episode) {
        Call<Episode> call = episodesService.createEpisode(season_num, episode);
        call.enqueue(new JsonCallback<>("Episode Criado: "));
    }

    public static void updateEpisode(int season_num, Episode episode) {
        Call<Episode> call = episodesService.updateEpisode(season_num, episode.getEpisodeNumber(), episode);
        call.enqueue(new JsonCallback<>("Episode Atualizado: "));
    }

    public static void deleteEpisode(int season_num, int episode_num) {
        Call<Episode> call = episodesService.deleteEpisode(season_num, episode_num);
        call.enqueue(new JsonCallback<>("Episode Deletado:"));
    }

    public static void getEpisode(int season_num, int episode_num) {
        Call<Episode> call = episodesService.getEpisode(season_num, episode_num);
        call.enqueue(new JsonCallback<>("Episode Buscado: "));
    }

    public static void getEpisodeTitle(int season_num, int episode_num) {
        Call<String> call = episodesService.getEpisodeTitle(season_num, episode_num);
        call.enqueue(new StringCallback("Episode Título: "));
    }

    public static void getRating(int season_num, int episode_num) {
        Call<String> call = episodesService.getRating(season_num, episode_num);
        call.enqueue(new StringCallback("Episode Nota: "));
    }

    public static void getDescription(int season_num, int episode_num) {
        Call<String> call = episodesService.getDescription(season_num, episode_num);
        call.enqueue(new StringCallback("Episode Descrição: "));
    }

    public static void getDirector(int season_num, int episode_num) {
        Call<String> call = episodesService.getDirector(season_num, episode_num);
        call.enqueue(new StringCallback("Episode Diretor: "));
    }

    public static void getWriter(int season_num, int episode_num) {
        Call<String> call = episodesService.getWriter(season_num, episode_num);
        call.enqueue(new StringCallback("Episode Roteirista: "));
    }

}