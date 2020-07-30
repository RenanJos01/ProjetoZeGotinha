package br.com.etecia.zegotinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MenuPrincipal_Activity extends AppCompatActivity {

    GridView gridView;

    String[] nomes = {"Fripe ou resfriado ?", "Quais são os sintomas ?", "Por que me vacinar ?"};
    int[] icons = {R.id.gripe, R.id.pulmao, R.id.vacina};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.GridView);

        Adapter adapter = new Adapter();
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Gripe_ou_resfriado_Activity.class);
                startActivity(intent);
            }
        });
    }

    public class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.gripe_ou_resfriado_layout, null);

            return view;
        }
    }
}