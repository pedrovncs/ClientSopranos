package org.infnet.assessment.callbacks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonCallback<T> implements Callback<T> {

    private String msg;

    public JsonCallback(String msg) {
        this.msg = msg;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            T responseBody = response.body();
            if (responseBody != null) {
                System.out.println(msg + responseBody);
            }
        } else {
            System.out.println("Erro Código " + response.code() + " " + response.message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        System.out.println("Erro na requisição: " + t.getMessage());
    }
}
