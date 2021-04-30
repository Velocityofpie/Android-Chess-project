package chess;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.content.DialogInterface;
import android.widget.Toast;

public class ChessPopUp extends  DialogFragment {
//    public Dialog onCreateDialog(Bundle savidInstanceState) {
//        Bundle bundle = getArguments();
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        String p = bundle.getString(MESSAGE_KEY);
//        String message = (p.equals("w") ? "Black" : "White") + " is offering a Draw.";
//        builder.setTitle(message);
//        builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        ((Chess) getActivity()).acceptDraw();
//                    }
//                }
//        );
//        builder.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                Toast.makeText(getContext(), "Draw Declined", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // Create the AlertDialog object and return it
//        return builder.create();
//    }
}