package id.derysudrajat.easyadapter

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface EasyListener<T, Binding : ViewBinding> {
    fun create(parent: ViewGroup): Binding
    fun onBind(binding: Binding, data: T)
}