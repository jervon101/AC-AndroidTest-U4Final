package nyc.c4q.androidtest_unit4final;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nyc.c4q.androidtest_unit4final.api.Stuff;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ColorAdapter adapter;
    static HashMap<String, String> colorDict = new HashMap<>();
    LinearLayout layout;
    List<String> colorsList;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorsList = new ArrayList<>();

        setup();

        layout = (LinearLayout) findViewById(R.id.fragment_container);

        colorDict.put("indigo", "#4b0082");
        colorDict.put("green", "#00ff00");
        colorDict.put("blue", "#0000ff");
        colorDict.put("red", "#ff0000");
        // TODO: adding all the colors and their values would be tedious, instead fetch it from the url below

        String[] names = new String[]{"blue", "red", "purple", "indigo", "orange", "brown", "black", "green"};

        for (String n : names) colorsList.add(n);


        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }



    public void setup() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Stuff.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Stuff api = retrofit.create(Stuff.class);
        Call<HashMap<String, String>> call = api.getcall();
        call.enqueue(new Callback<HashMap<String, String>>() {
            @Override
            public void onResponse(Call<HashMap<String, String>> call, retrofit2.Response<HashMap<String, String>> response) {
                HashMap<String, String> test = response.body();


                for (String s : test.keySet()) {
                    colorDict.put(s, test.get(s));
                    if (!colorsList.contains(s)) {
                        colorsList.add(s);
                    }
                }

                String[] arr = new String[colorsList.size()];

                for (int i = 0; i < colorsList.size(); i++) {
                    arr[i] = colorsList.get(i);
                }

                int j;
                boolean is = true;
                String temp;

                while (is) {
                    is = false;
                    for (j = 0; j < arr.length - 1; j++) {
                        if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {

                            temp = arr[j];

                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;

                            is = true;
                        }
                    }
                }

                colorsList.clear();

                for (int i = 0; i < arr.length; i++) {
                    colorsList.add(arr[i]);
                }

               Log.e("THis List", colorsList.size()+""+ colorDict.size());



                adapter = new ColorAdapter(colorsList, colorDict);
                recyclerView.setAdapter(adapter);

            }


            @Override
            public void onFailure(Call<HashMap<String, String>> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.info:
                  if(layout.getVisibility()==View.GONE){
                      layout.setVisibility(View.VISIBLE);

                      InfoFragment ad = new InfoFragment();
                      FragmentManager manager = getSupportFragmentManager();
                      FragmentTransaction transaction = manager.beginTransaction();
                      transaction.replace(R.id.fragment_container, ad);
                      transaction.commit();
                  } else if (layout.getVisibility() !=View.GONE){
                      layout.setVisibility(View.GONE);
                  }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    public void help_me(View view) {
//
//        }
//    }
}