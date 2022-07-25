package com.fatjoni.dritatvlive

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fatjoni.dritatvlive.databinding.FragmentFirstBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            val intent = Intent(context, StreamActivity::class.java)
            startActivity(intent)
        }
        // Write a message to the database
        //val database = Firebase.database("https://drita-media-default-rtdb.europe-west1.firebasedatabase.app/")
        //Firebase.database.setPersistenceEnabled(true)
        //val myRef = database.getReference("message")

        //myRef.setValue("Hello, World!")

        val query: Query = Firebase.database("https://drita-media-default-rtdb.europe-west1.firebasedatabase.app/")
            .reference
            .child("channels")
            .limitToLast(10)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}