package id.derysudrajat.easyadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class MultipleEasyAdapter(build: MultipleEasyAdapter.() -> Unit) {

    private var concatAdapter: ConcatAdapter = ConcatAdapter()

    init {
        build.invoke(this)
    }

    fun <T, Binding : ViewBinding> items(
        data: List<T>?,
        bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
        onBind: (binding: Binding, data: T) -> Unit
    ) = apply {
        concatAdapter.addAdapter(EasyAdapter(data ?: listOf(), bindingInflater, onBind))
    }

    fun <T, Binding : ViewBinding> itemsIndexed(
        data: List<T>?,
        bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
        onBind: (binding: Binding, data: T, index: Int) -> Unit
    ) = apply {
        concatAdapter.addAdapter(EasyAdapterIndexed(data ?: listOf(), bindingInflater, onBind))
    }

    fun <T, Binding : ViewBinding> item(
        data: T,
        bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
        onBind: (binding: Binding, data: T) -> Unit
    ) = apply {
        concatAdapter.addAdapter(EasyAdapter(listOf(data), bindingInflater, onBind))
    }

    fun addAdapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder?>) {
        concatAdapter.addAdapter(adapter)
    }

    fun assemble(): ConcatAdapter = concatAdapter

}
