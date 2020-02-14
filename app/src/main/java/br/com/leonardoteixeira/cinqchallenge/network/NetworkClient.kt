package br.com.leonardoteixeira.cinqchallenge.network

import br.com.leonardoteixeira.cinqchallenge.Config
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private var mRetrofit: Retrofit? = null

    fun getRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            val builder = OkHttpClient.Builder()
            val okHttpClient = builder.build()
            mRetrofit =
                Retrofit.Builder()
                    .baseUrl(Config.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
        }
        return mRetrofit
    }
}
