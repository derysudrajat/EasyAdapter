package id.derysudrajat.easyadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class EasyAdapter<T, Binding : ViewBinding>(
    private val data: MutableList<T>,
) : RecyclerView.Adapter<EasyAdapter.ViewHolder>(), EasyListener<T, Binding> {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private lateinit var binding: Binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = create(parent)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBind(binding, data[position])
    }

    override fun getItemCount(): Int = data.size

}