package id.derysudrajat.exampleeasyadapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import id.derysudrajat.easyadapter.EasyAdapter
import id.derysudrajat.easyadapter.EasyAdapterIndexed
import id.derysudrajat.easyadapter.MultipleEasyAdapter
import id.derysudrajat.exampleeasyadapter.Data
import id.derysudrajat.exampleeasyadapter.MainViewModel
import id.derysudrajat.exampleeasyadapter.databinding.FragmentMainBinding
import id.derysudrajat.exampleeasyadapter.databinding.ItemDataBinding
import id.derysudrajat.exampleeasyadapter.databinding.ItemTextBinding

class MultiAddAdapterFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val model: MainViewModel by viewModels()

    private lateinit var multipleAdapter: MultipleEasyAdapter

    private var adapter = EasyAdapter.init<Data, ItemDataBinding>(ItemDataBinding::inflate)
    private var adapterIndexed =
        EasyAdapterIndexed.init<Data, ItemDataBinding>(ItemDataBinding::inflate)

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
        setupAdapter()
        model.data.observe(viewLifecycleOwner) {
            adapter = EasyAdapter(it, ItemDataBinding::inflate) { binding, data ->
                binding.tvName.text = data.name
                binding.tvId.text = data.id
            }
            setupAdapter()
        }
        model.dataAnother.observe(viewLifecycleOwner) {
            adapterIndexed =
                EasyAdapterIndexed(it, ItemDataBinding::inflate) { binding, data, index ->
                    binding.tvName.text = buildString {
                        append("This item number-${index + 1}: ${data.name}")
                    }
                    binding.tvId.text = data.id
                }
            setupAdapter()
        }
        binding.btnChange.setOnClickListener { model.changeData() }
    }

    private fun populateData() {
        binding.rvMain.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = multipleAdapter.assemble()
        }
    }

    private fun setupAdapter() {
        multipleAdapter = MultipleEasyAdapter {
            item("List with addAdapter", ItemTextBinding::inflate) { binding, data ->
                binding.root.text = data
            }
            addAdapter(adapter)
            item("List with addAdapter Indexed", ItemTextBinding::inflate) { binding, data ->
                binding.root.text = data
            }
            addAdapter(adapterIndexed)
        }
        populateData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}