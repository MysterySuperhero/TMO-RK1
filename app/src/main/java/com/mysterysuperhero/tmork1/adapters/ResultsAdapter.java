package com.mysterysuperhero.tmork1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mysterysuperhero.tmork1.R;

import java.util.ArrayList;

/**
 * Created by dmitri on 13.04.16.
 */
public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder> {

    ArrayList<String> results;

    public ResultsAdapter(ArrayList<String> results) {
        this.results = results;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        return new ResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        holder.resutlTextView.setText(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {

        TextView resutlTextView;

        public ResultViewHolder(View itemView) {
            super(itemView);

            resutlTextView = (TextView) itemView.findViewById(R.id.result_textView);
        }
    }
}
