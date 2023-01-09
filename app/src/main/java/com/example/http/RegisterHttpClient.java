package com.example.http;

import android.util.Log;

import com.example.model.Usuario;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RegisterHttpClient {

    public static final RegisterHttpClient INSTANCE = new RegisterHttpClient();

    private Executor executor;
    private OkHttpClient client;
    private Gson gson;
    private Usuario usuario_temp;

    private static final String REGISTRAR_URL = "https://salvavaro.uk.r.appspot.com/api/usuarios";

    private RegisterHttpClient() {
        executor = Executors.newFixedThreadPool(4);
        client = new OkHttpClient();
        gson = new Gson();

    }

    public void registrarUsuario(RegisterHttpCallback callback, Usuario usuario_temp) {

        RequestBody formBody = new FormBody.Builder()
                .add("nombre", "bernabeu")
                .add("apellido", "panda")
                .add("correo", "corruu@hotmail.com")
                .add("password", "contrita")
                .add("rol", "fancy")
                .build();

        String name=usuario_temp.getNombre().toString();
        String correo=usuario_temp.getCorreo().toString();
        String password=usuario_temp.getPassword().toString();

        String jjson = "{\"nombre\":\""+name+"\",\"correo\":\""+correo+"\",\"password\":\""+password+"\"}";

        RequestBody otroBody=RequestBody.create(MediaType.parse("application/json"), jjson);

        Request request = new Request.Builder()
                .url(REGISTRAR_URL)
                .post(otroBody)
                .build();

        executor.execute(() -> {
            try {
                Response response = client.newCall(request).execute();
                ResponseBody responseBody = response.body();

                if (response.code() == 200) {
                    callback.onSuccess();

                }

            } catch (IOException e) {
                Log.e("BlogHttpClient", "Error brouuu", e);
            }
            callback.onError();
        });
    }


}
