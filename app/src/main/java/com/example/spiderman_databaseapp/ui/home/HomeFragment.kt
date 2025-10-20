package com.example.spiderman_databaseapp.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spiderman_databaseapp.R
import com.example.spiderman_databaseapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterr2: VideoAdapterr2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        val sampleVideos = listOf(
            Video("Killing Man in BF OFF COURSE!", Uri.parse("android.resource://${requireContext().packageName}/${R.raw.spidermanshort}")),
            Video("It's Me Spider! :)", Uri.parse("android.resource://${requireContext().packageName}/${R.raw.spidermanshortwo}")),
            Video("The Man Of Truck!", Uri.parse("android.resource://${requireContext().packageName}/${R.raw.spidermanshortthree}"))
        )
        adapterr2 = VideoAdapterr2(sampleVideos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapterr2

        return view
    }
//sonraki adım
    /*Bu yapı artık:

    ✅ Liste görünümü hazır

    ✅ Videolar çalışıyor

    ⬆️ Sırada UploadFragment ve Firebase bağlantısı

    İstersen bir sonraki aşamada şunu yapalım:

    “Video yükleme ekranı (UploadFragment)” — dosya seç, yükle, Firestore’a kaydet, Home’da gözüksün.

    Hazırsan bir sonraki adım olarak Upload kısmını birlikte kuralım mı?*/
}