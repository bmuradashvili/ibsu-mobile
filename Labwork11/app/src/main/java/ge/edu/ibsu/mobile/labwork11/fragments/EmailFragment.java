package ge.edu.ibsu.mobile.labwork11.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ge.edu.ibsu.mobile.labwork11.R;

public class EmailFragment extends Fragment {
    private static final String EMAIL_TAG = "EMAIL";
    private String email;

    private TextView tvEmail;

    public static EmailFragment getInstance(String email) {
        EmailFragment fragment = new EmailFragment();
        Bundle args = new Bundle();
        args.putString(EMAIL_TAG, email);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        email = getArguments() != null ? getArguments().getString(EMAIL_TAG) : null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvEmail = view.findViewById(R.id.tvEmail);

        if (email != null) {
            tvEmail.setText(email);
        } else {
            tvEmail.setText(R.string.email_not_found);
        }
    }
}
