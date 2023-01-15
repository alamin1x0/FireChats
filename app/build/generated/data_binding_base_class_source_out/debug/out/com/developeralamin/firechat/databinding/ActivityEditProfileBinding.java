// Generated by view binder compiler. Do not edit!
package com.developeralamin.firechat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.developeralamin.firechat.R;
import com.google.android.material.button.MaterialButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditProfileBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageView btnBack;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final LinearLayout toolbar;

  @NonNull
  public final MaterialButton updateBtn;

  @NonNull
  public final EditText userAddress;

  @NonNull
  public final EditText userEmail;

  @NonNull
  public final EditText userName;

  @NonNull
  public final EditText userPhone;

  private ActivityEditProfileBinding(@NonNull ScrollView rootView, @NonNull ImageView btnBack,
      @NonNull CircleImageView profileImage, @NonNull LinearLayout toolbar,
      @NonNull MaterialButton updateBtn, @NonNull EditText userAddress, @NonNull EditText userEmail,
      @NonNull EditText userName, @NonNull EditText userPhone) {
    this.rootView = rootView;
    this.btnBack = btnBack;
    this.profileImage = profileImage;
    this.toolbar = toolbar;
    this.updateBtn = updateBtn;
    this.userAddress = userAddress;
    this.userEmail = userEmail;
    this.userName = userName;
    this.userPhone = userPhone;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBack;
      ImageView btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.profile_image;
      CircleImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.toolbar;
      LinearLayout toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.updateBtn;
      MaterialButton updateBtn = ViewBindings.findChildViewById(rootView, id);
      if (updateBtn == null) {
        break missingId;
      }

      id = R.id.userAddress;
      EditText userAddress = ViewBindings.findChildViewById(rootView, id);
      if (userAddress == null) {
        break missingId;
      }

      id = R.id.userEmail;
      EditText userEmail = ViewBindings.findChildViewById(rootView, id);
      if (userEmail == null) {
        break missingId;
      }

      id = R.id.userName;
      EditText userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      id = R.id.userPhone;
      EditText userPhone = ViewBindings.findChildViewById(rootView, id);
      if (userPhone == null) {
        break missingId;
      }

      return new ActivityEditProfileBinding((ScrollView) rootView, btnBack, profileImage, toolbar,
          updateBtn, userAddress, userEmail, userName, userPhone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}