package com.example.shoppify.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shoppify.R
import com.example.shoppify.databinding.FragmentDashboardBinding
import com.example.shoppify.ui.activities.SettingsActivity

class DashboardFragment : Fragment() {

   // private lateinit var dashboardViewModel: DashboardViewModel
  //  private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // If we want to use the option menu in fragment we need to add it.
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

      //  _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        //val root: View = binding.root
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)


            textView.text = "This is Dashboard fragment"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //_binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.dashboard_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> {
                startActivity(Intent(activity, SettingsActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}