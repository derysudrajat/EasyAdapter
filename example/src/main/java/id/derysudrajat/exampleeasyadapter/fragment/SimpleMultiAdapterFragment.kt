package id.derysudrajat.exampleeasyadapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import id.derysudrajat.easyadapter.MultipleEasyAdapter
import id.derysudrajat.exampleeasyadapter.Data
import id.derysudrajat.exampleeasyadapter.MainViewModel
import id.derysudrajat.exampleeasyadapter.databinding.FragmentMainBinding
import id.derysudrajat.exampleeasyadapter.databinding.ItemDataBinding
import id.derysudrajat.exampleeasyadapter.databinding.ItemTextBinding

class SimpleMultiAdapterFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val model: MainViewModel by viewModels()

    private lateinit var multipleAdapter: MultipleEasyAdapter

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
        model.getAnotherData()
        model.data.observe(viewLifecycleOwner) { setDataAdapter(it, model.dataAnother.value) }
        model.dataAnother.observe(viewLifecycleOwner) { setDataAdapter(model.data.value, it) }
        binding.btnChange.setOnClickListener { model.changeData() }
    }

    private fun populateData() {
        binding.rvMain.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = multipleAdapter.assemble()
        }
    }

    private fun setDataAdapter(listOne: List<Data>?, listTwo: List<Data>?) {
        multipleAdapter = MultipleEasyAdapter {
            item("List with Items", ItemTextBinding::inflate) { binding, data ->
                binding.root.text = data
            }
            items(listOne, ItemDataBinding::inflate) { binding, data ->
                binding.tvName.text = data.name
                binding.tvId.text = data.id
            }
            item("List with ItemsIndexed", ItemTextBinding::inflate) { binding, data ->
                binding.root.text = data
            }
            itemsIndexed(listTwo, ItemDataBinding::inflate) { binding, data, index ->
                binding.tvName.text = buildString {
                    append("This item number-${index + 1}: ${data.name}")
                }
                binding.tvId.text = data.id
            }
        }
        populateData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}