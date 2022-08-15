package id.derysudrajat.exampleeasyadapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import id.derysudrajat.easyadapter.EasyAdapterIndexed
import id.derysudrajat.exampleeasyadapter.MainViewModel
import id.derysudrajat.exampleeasyadapter.databinding.FragmentMainBinding
import id.derysudrajat.exampleeasyadapter.databinding.ItemDataBinding

class IndexAdapterFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val model: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.getData()
        model.data.observe(viewLifecycleOwner) {
            binding.rvMain.apply {
                setHasFixedSize(true)
                itemAnimator = DefaultItemAnimator()
                adapter = EasyAdapterIndexed(it, ItemDataBinding::inflate) { binding, data, index ->
                    binding.tvName.text = buildString {
                        append("This item number-${index + 1}: ${data.name}")
                    }
                    binding.tvId.text = data.id
                }
            }
        }
        binding.btnChange.setOnClickListener { model.changeData() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}