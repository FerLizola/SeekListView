package ittepic.edu.mx.seeklistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar skb_num;
    ListView lst_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skb_num=(SeekBar) findViewById(R.id.skb_num);
        lst_res=(ListView) findViewById(R.id.lst_res);
        final ArrayList<String> array=new ArrayList<String>();
        final String[] cad = {""};
        final ArrayAdapter<String> arreglo= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        skb_num.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int num = skb_num.getProgress();
                array.clear();
                for(int a=0;a<11;a++){
                    cad[0] =""+("\n"+num+" x "+a+" = "+(a*num));
                    array.add(cad[0]);
                }

                lst_res.setAdapter(arreglo);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        lst_res.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Usted selecciono "+((TextView)view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
