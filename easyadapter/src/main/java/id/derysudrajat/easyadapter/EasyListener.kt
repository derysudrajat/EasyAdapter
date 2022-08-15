package id.derysudrajat.easyadapter

import androidx.viewbinding.ViewBinding

interface EasyListener<T, Binding : ViewBinding> {
    fun onBind(binding: Binding, data: T, position: Int)
}