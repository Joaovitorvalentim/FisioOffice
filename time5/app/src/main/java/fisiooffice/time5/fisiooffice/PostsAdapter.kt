package fisiooffice.time5.fisiooffice

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.time5.fisiooffice.R
import fisiooffice.time5.fisiooffice.model.Post
import com.squareup.picasso.Picasso
import com.time5.fisiooffice.R.*

class PostsAdapter(val posts: ArrayList<Post>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_POST: Int = 0
        const val TYPE_AD: Int = 1
    }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_POST) {

            //Exibe o botão de adicionar post
            val view: View = LayoutInflater.from(parent.context).inflate(layout.post_row, parent, false)
            return PostViewHolder(view)
        }

        //Exibe o anuncio na tela
        val view: View = LayoutInflater.from(parent.context).inflate(layout.ad_row, parent, false)
        return AdViewHolder(view)
    }

    //A cada 5 posts adiciona um anuncio
    override fun getItemViewType(position: Int): Int {
        if ((position % 5) == 0 && position != 0) {
            return TYPE_AD
        }
        return TYPE_POST
    }

    //Exibe os seguintes dados em cada celula da RecycleView ( Ecercicio, texto e foto)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_POST) {
            (holder as PostViewHolder).exercicio.text = posts[position].exercicio
            holder.text.text = posts[position].text
            Picasso.with(context).load(posts[position].photo).into(holder.photo)
        } else if (getItemViewType(position) == TYPE_AD) {

        }
    }
    // Classe onde há as informaçoes que serão exibidas na RecycleView
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exercicio: TextView = itemView.findViewById(id.exercicio)
        val text: TextView = itemView.findViewById(id.text)
        val photo: ImageView = itemView.findViewById(id.photo)
    }

    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val photo: ImageView = itemView.findViewById(R.id.photo)
//        anuncio. coloque o texto aqui
    }
}
