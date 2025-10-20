package com.example.spiderman_databaseapp.ui.home



import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.spiderman_databaseapp.R

data class Video(val title: String, val uri: Uri)

class VideoAdapterr2(private val video: List<Video>):
    RecyclerView.Adapter<VideoAdapterr2.VideoViewHolder>(){
    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val videoView: VideoView = itemView.findViewById(R.id.videoView)
        val videoTitle: TextView = itemView.findViewById(R.id.videoTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = video[position]
        holder.videoTitle.text = video.title
        holder.videoView.setVideoURI(video.uri)
        holder.videoView.setOnPreparedListener{mediaPlayer ->
            mediaPlayer.isLooping = true
            holder.videoView.start()
        }
    }

    override fun getItemCount() = video.size
}