package br.com.irrconsultoria.economizofertas.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.irrconsultoria.economizofertas.Entidades.Produto
import br.com.irrconsultoria.economizofertas.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_produto.view.*

class ProdutosAdapter(val produtos: List<Produto>) :
        RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        return ProdutosViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_produto, parent, false)
        )
    }

    override fun getItemCount() = produtos.size

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val getdata = produtos[position]
        holder.view.textViewVendedor.text = getdata.vendedor
        holder.view.textViewNomeProduto.text = getdata.nomeProduto
        holder.view.textViewDescProduto.text = getdata.descProduto
        holder.view.textViewValor.text = "R$: " + getdata.valor.toString()
        holder.view.textViewCategoria.text = getdata.categoriaProduto1
        holder.view.btnValidade.text = "Validade da Oferta: " + getdata.validade

        Glide.with(holder.view.context)
                .load(getdata.urlImg)
                .into(holder.view.imageViewUrl)
    }


    class ProdutosViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}