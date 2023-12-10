package com.anshul.buzzme;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anshul.buzzme.databinding.RowStoriesBinding;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.List;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.StoryHolder> {

    Context context;
    FirebaseAuth firebaseAuth;
    String uid;

    public AdapterStory(Context context, List<ModelStory> list) {
        this.context = context;
        this.list = list;
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getUid();
    }
    List<ModelStory> list;


    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_stories,parent,false);
        return new StoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStory.StoryHolder holder, int position) {

        ModelStory story=list.get(position);
        String hisuid= story.getSender();
        String storyImage = story.getStory();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(story.getTimestamp()));
        String timedate = DateFormat.format("dd/MM/yyyy hh:mm aa", calendar).toString();
        holder.binding.timeStory.setText(timedate);
        Glide.with(context).load(storyImage).placeholder(R.drawable.profile_image).into(holder.binding.imageStory);
        FirebaseDatabase.getInstance().getReference()
                .child("Users")
                .child(hisuid)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ModelUsers storyuser = snapshot.getValue(ModelUsers.class);
                        holder.binding.nameStory.setText(storyuser.getName());

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        holder.binding.imageStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ImageViewActivity.class);

                intent.putExtra("image",storyImage);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StoryHolder extends RecyclerView.ViewHolder{

        RowStoriesBinding binding;
        public StoryHolder(@NonNull View itemView){
            super(itemView);
            binding=RowStoriesBinding.bind(itemView);
        }
    }
}
