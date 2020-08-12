package br.com.irrconsultoria.economizofertas.PDO

import br.com.irrconsultoria.economizofertas.Entidades.Produto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://projectjrdeveloper.000webhostapp.com/API/economiz/"

interface ProdutosApi {

    @GET("getdata.php")
    fun getProdutos(): Call<List<Produto>>

    companion object {
        operator fun invoke(): ProdutosApi {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProdutosApi::class.java)
        }
    }


}