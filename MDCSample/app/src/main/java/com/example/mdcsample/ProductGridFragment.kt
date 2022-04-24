package com.example.mdcsample

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdcsample.databinding.FragmentProductGridBinding
import com.example.mdcsample.model.ProductEntry

//class ProductEntry(
//        val title: String, dynamicUrl: String, val url: String, val price: String, val description: String) {
//    val dynamicUrl: Uri = Uri.parse(dynamicUrl)

val sampleA = ProductEntry("sampleA", "url", "url", "10", "description")
val sampleB = ProductEntry("sampleB", "url", "url", "10", "description")
val sampleC = ProductEntry("sampleC", "url", "url", "10", "description")
val sampleD = ProductEntry("sampleD", "url", "url", "10", "description")
val sampleE = ProductEntry("sampleE", "url", "url", "10", "description")
val sampleF = ProductEntry("sampleF", "url", "url", "10", "description")

val products:List<ProductEntry> = listOf(sampleA, sampleB, sampleC, sampleD, sampleE, sampleF)

class ProductGridFragment : Fragment() {

    private var _binding: FragmentProductGridBinding ?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProductGridBinding.inflate(inflater, container, false)
        val view = binding.root


        //app_bar
        (activity as AppCompatActivity).setSupportActionBar(view.findViewById(R.id.app_bar))

        //recyclerview
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        val adapter = ProductCardRecyclerViewAdapter(products)
        binding.recyclerView.adapter = adapter

        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)
        binding.recyclerView.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}