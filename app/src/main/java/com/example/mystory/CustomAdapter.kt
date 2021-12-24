package com.example.mystory

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
//Define class Custom Adapter that inherent form recyclerView
class CustomAdapter( val storiesList:ArrayList<Story>,val context:Context)
    :RecyclerView.Adapter<CustomAdapter.DataHolder>(){
    //called when recycler view needs a new view holder of the given type to represent an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
       val dataHolder=DataHolder(LayoutInflater.from(parent.context).inflate(
           R.layout.custom_layout,parent,false))
        return dataHolder
    }
    //To display data at the specified position
    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val story=storiesList[position]
        holder.storyTitle.text=story.title
        holder.storySubTitle.text=story.subtitle
        holder.storyLatter.text=story.title.first().toString() //get first letter of title

        generateColors(holder,position)
        holder.itemView.setOnClickListener {//lesson to user click
            val i = Intent(context,StoryBuildActivity::class.java)//move to story build Activity
            i.putExtra("title",story.title)
            i.putExtra("desc",story.description)
            context.startActivity(i)
        }
    }
    //Generate Random Colors
 private fun  generateColors(holder: DataHolder,position: Int){
     val r = java.util.Random()
     val red=r.nextInt(255+position)
     val green=r.nextInt(255-position +1)
     val blue=r.nextInt(255+position +1)
        //generate random color for card view circle
     holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red,green,blue))
 }
    //Return the total number of Items held by adapter based on Array size
    override fun getItemCount(): Int {
        return storiesList.size
    }
    //Define Data Holder that inherent form RecyclerView class
    class DataHolder (item:View):RecyclerView.ViewHolder(item){
        val storyTitle:TextView=item.findViewById(R.id.tvtitle)
        val storySubTitle:TextView=item.findViewById(R.id.tvSubtitle)
        val storyLatter:TextView=item.findViewById(R.id.tvstoryLatter)
        val cardViewLetter:CardView=item.findViewById(R.id.circle)
    }
}