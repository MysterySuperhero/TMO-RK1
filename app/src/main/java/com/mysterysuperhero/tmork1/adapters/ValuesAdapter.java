package com.mysterysuperhero.tmork1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        int i = 0;
        values = new ArrayList<>();
        values.add(new Value(Value.P, false, i++));
        values.add(new Value(Value.R, false, i++));
        values.add(new Value(Value.P_K_CHANNELS_OCCUP, false, i++));
        values.add(new Value(Value.AVERAGE_COUNT_OCCUP_CHANNELS, false, i++));
        values.add(new Value(Value.P_REQUEST_SERVICE, false, i++));
        values.add(new Value(Value.P_OCCUP_CHANNEL, false, i++));
        values.add(new Value(Value.P_FULL_OCCUP_SYS, false, i++));
        values.add(new Value(Value.AVER_OCCUP_CHANNEL_TIME, false, i++));
        values.add(new Value(Value.AVER_PLAIN_CHANNEL_TIME, false, i++));
        values.add(new Value(Value.AVER_TIME_FULL_OCCUP_SYS, false, i++));
        values.add(new Value(Value.AVER_NOT_FULL_OCCUP_SYS, false, i++));
        values.add(new Value(Value.AVER_PLAIN_TIME_SYS, false, i++));
        values.add(new Value(Value.AVER_TIME_STAY_REQUEST, false, i));
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

    public ArrayList<Value> getValues() {
        return values;
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
