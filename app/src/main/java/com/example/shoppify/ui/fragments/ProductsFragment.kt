package com.example.shoppify.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shoppify.R
import com.example.shoppify.ui.activities.AddProductActivity
import com.example.shoppify.ui.activities.SettingsActivity

//import com.example.shoppify.databinding.FragmentHomeBinding

class ProductsFragment : Fragment() {

   // private lateinit var homeViewModel: HomeViewModel
   // private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // If we want to use the option menu in fragment we need to add it.
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

     //   _binding = FragmentHomeBinding.inflate(inflater, container, false)
    //    val root: View = binding.root

   //     val textView: TextView = binding.textHome
        val root = inflater.inflate(R.layout.fragment_products, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
            textView.text = "This is Home fragment"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
       // _binding = null
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_product_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_add_product -> {
                startActivity(Intent(activity, AddProductActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}