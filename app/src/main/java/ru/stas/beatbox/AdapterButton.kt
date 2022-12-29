package ru.stas.beatbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.stas.beatbox.databinding.ListItemSoundBinding

class AdapterButton(private val sounds: List<Sound>): RecyclerView.Adapter<AdapterButton.ViewHolder>() {

    inner class ViewHolder(private var binding: ListItemSoundBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.viewModel = SoundViewModel()
        }
        fun bind(sounds: Sound){
            binding.apply {
                viewModel?.sound = sounds
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemSoundBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sound = sounds[position]
        holder.bind(sound)
    }

    override fun getItemCount() = sounds.size


}