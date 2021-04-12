package com.riskpace.demo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riskpace.demo.R
import com.riskpace.demo.base.Result
import com.riskpace.demo.data.remote.AssociatedDrug
import com.riskpace.demo.ui.dashboard.adapter.MedicineAdapter
import com.riskpace.demo.widget.RecyclerSectionItemDecoration
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var rvData: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val pbDashboard: ProgressBar = root.findViewById(R.id.pbDashboard)
        rvData = root.findViewById(R.id.rvData)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        dashboardViewModel.getData().apply {
            pbDashboard.visibility = View.VISIBLE
        }

        rvData.layoutManager = LinearLayoutManager(activity)
        val adapter = MedicineAdapter()
        rvData.adapter = adapter

        dashboardViewModel.mData.observe(viewLifecycleOwner, Observer {
            pbDashboard.visibility = View.GONE
            when (it) {
                is Result.Success -> {
                    adapter.addItem(it.data)
                    val sectionItemDecoration =
                        RecyclerSectionItemDecoration(
                            resources.getDimensionPixelSize(R.dimen.recycler_section_header_height),
                            true,
                            getSectionCallback(it.data)
                        )
                    rvData.addItemDecoration(sectionItemDecoration)
                }
                is Result.Error -> {
                    Toast.makeText(activity, "Something went wrong !!", LENGTH_SHORT).show()
                }
            }
        })
        return root
    }

    private fun getSectionCallback(alData: ArrayList<AssociatedDrug>): RecyclerSectionItemDecoration.SectionCallback {
        return object : RecyclerSectionItemDecoration.SectionCallback {
            override fun isSection(position: Int): Boolean {
                return (position == 0 || alData[position].problems !== alData[position - 1].problems)
            }

            override fun getSectionHeader(position: Int): CharSequence {
                return alData[position].problems
            }
        }
    }
}