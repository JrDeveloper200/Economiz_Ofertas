package br.com.irrconsultoria.economizofertas.Entidades

import com.google.gson.annotations.SerializedName

data class Produto(
        val id: Int,
        @SerializedName("nomeProduto")
        val nomeProduto: String,
        @SerializedName("descProduto")
        val descProduto: String,
        @SerializedName("categoriaProduto1")
        val categoriaProduto1: String,
        @SerializedName("vendedor")
        val vendedor: String,
        @SerializedName("urlImg")
        val urlImg: String,
        @SerializedName("validade")
        val validade: String,
        @SerializedName("valor")
        val valor: Double

)