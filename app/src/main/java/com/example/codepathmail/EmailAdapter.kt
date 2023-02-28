package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Here our EmailAdapter extends RecyclerView Adapter as an abstraction class
// Then allows the constructor to take in a list of emails and storing it as a variable
class EmailAdapter(private val emails: List<Email>): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Specify public final variables as TextView datatype for storing later on.
        val senderTv: TextView
        val titleTv: TextView
        val summaryTv: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            senderTv = itemView.findViewById<TextView>(R.id.sender_tv)
            titleTv = itemView.findViewById<TextView>(R.id.title_tv)
            summaryTv = itemView.findViewById<TextView>(R.id.summary_tv)
        }
    }
   // "ViewHolder" object which describes and provides access to all the views within each item row.
    // Below is called when RecyclerView needs a new ViewHolder of the given type to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
       // LayoutInflater takes an XML file as input and builds the View objects from it.
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderTv.text = email.sender
        holder.titleTv.text = email.title
        holder.summaryTv.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}

