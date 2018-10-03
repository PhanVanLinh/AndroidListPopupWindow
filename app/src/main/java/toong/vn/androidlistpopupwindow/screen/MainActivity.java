package toong.vn.androidlistpopupwindow.screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import toong.vn.androidlistpopupwindow.R;
import toong.vn.androidlistpopupwindow.listpopupwindow.ListPopupWindowAdapter;
import toong.vn.androidlistpopupwindow.listpopupwindow.model.ListPopupItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_show_list_popup_from_top).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showListPopupWindow(view);
                    }
                });

        findViewById(R.id.button_show_list_popup_from_bottom).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showListPopupWindow(view);
                    }
                });
    }

    /**
     * I show MATCH_PARENT popup here, you can show a specific with for popup (eg: 100px, 200px,...)
     * If you set popup width = WRAP_CONTENT, popup width will equals ANCHOR width
     */
    private void showListPopupWindow(View anchor) {
        List<ListPopupItem> listPopupItems = new ArrayList<>();
        listPopupItems.add(new ListPopupItem("Menu 1", R.mipmap.ic_launcher));
        listPopupItems.add(new ListPopupItem("Menu 2", R.mipmap.ic_launcher));
        listPopupItems.add(new ListPopupItem("Menu 3", R.mipmap.ic_launcher));

        final ListPopupWindow listPopupWindow =
                createListPopupWindow(anchor, ViewGroup.LayoutParams.MATCH_PARENT, listPopupItems);
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listPopupWindow.dismiss();
                Toast.makeText(MainActivity.this, "clicked at " + position, Toast.LENGTH_SHORT)
                        .show();
            }
        });
        listPopupWindow.show();
    }

    private ListPopupWindow createListPopupWindow(View anchor, int width,
            List<ListPopupItem> items) {
        final ListPopupWindow popup = new ListPopupWindow(this);
        ListAdapter adapter = new ListPopupWindowAdapter(items);
        popup.setAnchorView(anchor);
        popup.setWidth(width);
        popup.setAdapter(adapter);
        return popup;
    }
}
