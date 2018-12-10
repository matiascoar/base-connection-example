package cl.telematica.basicconnectionexample.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.telematica.basicconnectionexample.R;
import cl.telematica.basicconnectionexample.models.Libro;



public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {

    private List<Libro> mDataset;

    public UIAdapter(List<Libro> mDataset) {
        this.mDataset = mDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mGeneroView;
        public ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textName);
            mGeneroView = (TextView) v.findViewById(R.id.textGenero);
            mImageView = (ImageView) v.findViewById(R.id.image);
        }
    }

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_libro, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Libro libro = mDataset.get(position);

        holder.mTextView.setText(libro.getNombre());
        holder.mGeneroView.setText(libro.getGenero());
        Glide
                .with(holder.mImageView.getContext())
                .load(libro.getPhoto())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}