package org.infnet.assessment.callbacks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StringCallback implements Callback<String> {

    private String msg;

    public StringCallback(String msg) {
        this.msg = msg;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            String responseBody = response.body();
            if (responseBody != null) {
                System.out.println(" "
                            + msg + response.body());
            } else {
                System.out.println("Erro: resposta vazia.");
            }
        } else {
            System.out.println("Erro código: " + response.code() + " " + response.message());
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        System.out.println("Erro na requisição: " + t.getMessage());
    }
}
