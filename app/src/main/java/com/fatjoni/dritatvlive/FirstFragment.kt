package com.fatjoni.dritatvlive

import android.content.Intent
import android.content.res.AssetManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.fatjoni.dritatvlive.databinding.FragmentFirstBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.io.InputStream


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val query: Query = Firebase.database("https://drita-media-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
            .child("channels")

        val options = FirebaseRecyclerOptions.Builder<Channel>()
            .setQuery(query, Channel::class.java)
            .build()

        val adapter = object : FirebaseRecyclerAdapter<Channel, MyViewHolder>(options){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.channel_item, parent, false))
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Channel) {
                holder.textView.text = model.name
                val assetManager: AssetManager = activity!!.getAssets()
                val inputStream: InputStream = assetManager.open("img/tvchannel.jpg")
                val bitmap = BitmapFactory.decodeStream(inputStream)
                holder.imageView.load(bitmap)
                holder.streamBtn.setOnClickListener {
                    Intent(context, StreamActivity::class.java).apply {
                        putExtra("streamUrl", model.link)
                        startActivity(this)
                    }
                }
            }

        }

        adapter.startListening()
        binding.recyclerview.apply {
            layoutManager=LinearLayoutManager(context)
            this.adapter = adapter
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}