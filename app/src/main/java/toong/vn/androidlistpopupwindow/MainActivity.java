package toong.vn.androidlistpopupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;
import toong.vn.androidlistpopupwindow.model.Item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_show_list_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListMenu(view);
            }
        });
    }

    private void showListMenu(View anchor) {
        final ListPopupWindow popupWindow = new ListPopupWindow(this);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("A", R.mipmap.ic_launcher));
        itemList.add(new Item("B", R.mipmap.ic_launcher));
        itemList.add(new Item("C", R.mipmap.ic_launcher));

        ListAdapter adapter = new ListPopupWindowAdapter(this, itemList);
        popupWindow.setAnchorView(anchor);
        popupWindow.setAdapter(adapter);
        popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupWindow.dismiss();
            }
        });
        popupWindow.show();
    }
}
