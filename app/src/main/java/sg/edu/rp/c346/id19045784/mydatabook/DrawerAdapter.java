package sg.edu.rp.c346.id19045784.mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerAdapter extends ArrayAdapter {
    private ArrayList<Drawer> drawers;
    private Context context;
    private TextView tvDrawerTitle;
    private ImageView image;




    public DrawerAdapter(Context context, int resource, ArrayList<Drawer> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        drawers = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvDrawerTitle = rowView.findViewById(R.id.tvDrawer);
        image = rowView.findViewById(R.id.imageView);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Drawer currentDrawer = drawers.get(position);
        // Set the TextView to show the food
        if (currentDrawer.getName().equals("Bio")){
            image.setImageResource(R.drawable.ic_baseline_error_24);
            tvDrawerTitle.setText(currentDrawer.getName());
        }
        else if (currentDrawer.getName().equals("Vaccination")){
            image.setImageResource(R.drawable.ic_baseline_edit_24);
            tvDrawerTitle.setText(currentDrawer.getName());
        }
        else if (currentDrawer.getName().equals("Anniversary")){
            image.setImageResource(R.drawable.ic_baseline_calendar_today_24);
            tvDrawerTitle.setText(currentDrawer.getName());
        }
        else if (currentDrawer.getName().equals("AboutUs")){
            image.setImageResource(R.drawable.ic_baseline_star_24);
            tvDrawerTitle.setText(currentDrawer.getName());
        }

        // Return the nicely done up View to the ListView
        return rowView;


    }

}
