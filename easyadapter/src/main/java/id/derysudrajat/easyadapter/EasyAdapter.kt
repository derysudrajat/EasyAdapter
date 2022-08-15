package id.derysudrajat.easyadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

class EasyAdapter<T, Binding : ViewBinding>(
    data: List<T>,
    bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
    val onBindView: (binding: Binding, data: T) -> Unit
) : BaseEasyAdapter<T, Binding>(data.toMutableList(), bindingInflater) {
    override fun onBind(binding: Binding, data: T, position: Int) {
        onBindView(binding, data)
    }

    companion object {
        fun <T, Binding : ViewBinding> init(bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding) =
            EasyAdapter<T, Binding>(listOf(), bindingInflater) { _, _ -> }
    }
}

class EasyAdapterIndexed<T, Binding : ViewBinding>(
    data: List<T>,
    bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
    val onBindView: (binding: Binding, data: T, index: Int) -> Unit
) : BaseEasyAdapter<T, Binding>(data.toMutableList(), bindingInflater) {

    override fun onBind(binding: Binding, data: T, position: Int) {
        onBindView(binding, data, position)
    }

    companion object {
        fun <T, Binding : ViewBinding> init(bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding) =
            EasyAdapterIndexed<T, Binding>(listOf(), bindingInflater) { _, _, _ -> }
    }
}