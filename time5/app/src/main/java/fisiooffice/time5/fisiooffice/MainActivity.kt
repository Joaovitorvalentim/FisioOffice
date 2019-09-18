package fisiooffice.time5.fisiooffice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.time5.fisiooffice.R
import fisiooffice.time5.fisiooffice.model.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val posts: ArrayList<Post> = ArrayList()
        for (i in 1..100) {
            posts.add(Post("Exercício" + i, "Descrição do Exercício", "https://picsum.photos/600/300?random&" + i))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PostsAdapter(posts, this)
    }
}
