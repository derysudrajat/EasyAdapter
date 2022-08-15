package id.derysudrajat.easyadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseEasyAdapter<T, Binding : ViewBinding>(
    private val data: MutableList<T>,
    private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
) : RecyclerView.Adapter<BaseEasyAdapter.ViewHolder>(), EasyListener<T, Binding> {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private lateinit var binding: Binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = bindingInflater.invoke(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBind(binding, data[position], position)
    }

    override fun getItemCount(): Int = data.size

}