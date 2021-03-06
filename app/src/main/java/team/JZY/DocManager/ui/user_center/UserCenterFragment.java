package team.JZY.DocManager.ui.user_center;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

import team.JZY.DocManager.DocManagerApplication;
import team.JZY.DocManager.R;
import team.JZY.DocManager.databinding.UserCenterFragmentBinding;
import team.JZY.DocManager.ui.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserCenterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserCenterFragment extends DocManagerApplication.Fragment {

    private UserViewModel userViewModel;
    private UserCenterFragmentBinding binding;
    public UserCenterFragment() {
        // Required empty public constructor
    }


    public static UserCenterFragment newInstance(String param1, String param2) {
        return new UserCenterFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = UserCenterFragmentBinding.inflate(inflater, container, false);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        binding.userNameText.setText(getLoggedInUserName());
        binding.mCollectionLayout.setOnClickListener(v ->onCollectionClicked());
        binding.mDownloadLayout.setOnClickListener(v -> onDownloadClicked());
        binding.mUploadLayout.setOnClickListener(v -> onUploadClicked());
        binding.mSettingsLayout.setOnClickListener(v -> onSettingsClicked());
        binding.mRecordLayout.setOnClickListener(v -> onRecordClicked());
        return binding.getRoot();
        // Inflate the layout for this fragment
    }

    private void onRecordClicked() {
        Intent intent=new Intent(requireActivity(),mRecord.class);
        intent.putExtra("username",userViewModel.getUser().getName());
        startActivity(intent);
    }

    private void onUploadClicked() {
        Intent intent=new Intent(requireActivity(),mUpload.class);
        intent.putExtra("username",userViewModel.getUser().getName());
        startActivity(intent);
    }

    private void onSettingsClicked() {
        Intent intent=new Intent(requireActivity(),settings.class);
        intent.putExtra("username",userViewModel.getUser().getName());
        startActivity(intent);
    }

    private void onDownloadClicked() {
        Intent intent=new Intent(requireActivity(),mDownload.class);
        intent.putExtra("username",userViewModel.getUser().getName());
        startActivity(intent);
    }

    private void onCollectionClicked() {
        Intent intent=new Intent(requireActivity(),mCollection.class);
        intent.putExtra("username",userViewModel.getUser().getName());
        startActivity(intent);
    }
//recordR.setLister(docsInfo->{
////        MainActivity.this.runOnUiThread(()->{
////            ui
////        });
////    }).get

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}