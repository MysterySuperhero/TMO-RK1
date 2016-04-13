package com.mysterysuperhero.tmork1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.utils.Value;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by dmitri on 13.04.16.
 */
public class ValuesAdapter extends RecyclerView.Adapter<ValuesAdapter.ValueViewHolder> {

    Context context;
    ArrayList<Value> values;

    public ValuesAdapter(Context context) {
        this.context = context;

        values = new ArrayList<>();
        values.add(new Value("P(n, α)", true, 0));
        values.add(new Value("R(n, α)", true, 1));
        values.add(new Value("Вероятность обслуживания заявки", false, 2));
        values.add(new Value("Вероятность занятости канала", false, 3));
        values.add(new Value("Вероятность полной загрузки СМО", false, 4));
        values.add(new Value("Среднее время занятости канала", false, 5));
        values.add(new Value("Среднее время простоя канала", false, 6));
        values.add(new Value("Среднее время полной загрузки системы", false, 7));
        values.add(new Value("Среднее время неполной загрузки системы", false, 8));
        values.add(new Value("Среднее время простоя СМО", false, 9));
        values.add(new Value("Среднее время пребывания заявки в СМО", false, 10));
        values.add(new Value("Среднее время простоя канала", false, 11));
    }

    @Override
    public ValueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.value_item, parent, false);
        return new ValueViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ValueViewHolder holder, int position) {
        holder.valueTextView.setText(values.get(position).getValue());
        holder.stateCheckBox.setChecked(values.get(position).getState());
        holder.stateCheckBox.setId(values.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }



    public class ValueViewHolder extends RecyclerView.ViewHolder {

        TextView valueTextView;
        CheckBox stateCheckBox;

        public ValueViewHolder(View itemView) {
            super(itemView);
            valueTextView = (TextView) itemView.findViewById(R.id.value_textView);
            stateCheckBox = (CheckBox) itemView.findViewById(R.id.state_checkbox);

            stateCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (stateCheckBox.isChecked()) {
                        values.get(stateCheckBox.getId()).setState(true);
                    } else {
                        values.get(stateCheckBox.getId()).setState(false);
                    }
                    Log.d("Value at " + String.valueOf(stateCheckBox.getId()), " is "
                            + String.valueOf(values.get(stateCheckBox.getId()).getState()));
                }
            });
        }
    }
}
