package com.mobileappscompany.training.listviewoption2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Android1 on 3/4/2015.
 */
public class EditDeleteDialog extends DialogFragment {

    private EditDeleteListener myListener;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Which action should I take?")
                .setPositiveButton("Edit.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        myListener.edit();
                    }
                })
                .setNegativeButton("Delete.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        myListener.delete();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        myListener = (EditDeleteListener) activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        myListener = null;
        super.onDetach();
    }
}
