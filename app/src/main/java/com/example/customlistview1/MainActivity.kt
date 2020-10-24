package com.example.customlistview1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_view_element.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_view.adapter = CustomerAdapter(this)
    }

    private class CustomerAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return 12
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val layoutElement = layoutInflater.inflate(R.layout.list_view_element, viewGroup, false)

            val textViewHeader = layoutElement.findViewById<TextView>(R.id.text_view_header)
            val textViewDescription = layoutElement.findViewById<TextView>(R.id.text_view_description)
            var countPosition = position+1
                textViewHeader.text = "Hello world №$countPosition"
                textViewDescription.text = "This is description number $countPosition"

            return layoutElement
        }
    }
}