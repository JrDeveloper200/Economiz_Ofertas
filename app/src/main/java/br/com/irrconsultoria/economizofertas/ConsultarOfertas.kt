package br.com.irrconsultoria.economizofertas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.irrconsultoria.economizofertas.Adapter.ProdutosAdapter
import br.com.irrconsultoria.economizofertas.Entidades.Produto
import br.com.irrconsultoria.economizofertas.PDO.ProdutosApi
import kotlinx.android.synthetic.main.activity_consultar_ofertas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ConsultarOfertas : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_ofertas)

        refreshLayout.setOnRefreshListener {
            fetchProdutos()
        }

        fetchProdutos()

    }

    private fun fetchProdutos() {
        refreshLayout.isRefreshing = true

        ProdutosApi().getProdutos().enqueue(object : Callback<List<Produto>> {
            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(
                        applicationContext,
                        /*t.message + */" Tempo Esgotado! Recarregue a Página",
                        Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                refreshLayout.isRefreshing = false
                val produtos = response.body()

                produtos?.let {
                    showProdutos(it)
                    Toast.makeText(
                            applicationContext,
                            "Produtos Carregados com Sucesso!",
                            Toast.LENGTH_LONG
                    ).show()

                }

            }

        })
    }

    private fun showProdutos(produtos: List<Produto>) {
        recyclerProdutos.layoutManager = LinearLayoutManager(this)
        recyclerProdutos.adapter = ProdutosAdapter(produtos)

    }

}
