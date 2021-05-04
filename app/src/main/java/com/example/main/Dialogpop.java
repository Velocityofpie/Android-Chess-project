package com.example.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogpop extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog (Bundle saveInstanceState) {
        Bundle bundle = getArguments();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // String p = bundle.getString(game.Trun);
        builder.setTitle(bundle.getString("draw"))
                .setMessage("Do you want to save game?").setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Toast.makeText(getContext(), "Draw Declined", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
        return builder.create();
    }
}

