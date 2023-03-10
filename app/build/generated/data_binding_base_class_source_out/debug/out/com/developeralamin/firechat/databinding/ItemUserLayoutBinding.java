// Generated by view binder compiler. Do not edit!
package com.developeralamin.firechat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.developeralamin.firechat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemUserLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final LottieAnimationView callBtn;

  @NonNull
  public final TextView userAddress;

  @NonNull
  public final TextView userEmail;

  @NonNull
  public final TextView userName;

  @NonNull
  public final TextView userPhone;

  private ItemUserLayoutBinding(@NonNull CardView rootView, @NonNull LottieAnimationView callBtn,
      @NonNull TextView userAddress, @NonNull TextView userEmail, @NonNull TextView userName,
      @NonNull TextView userPhone) {
    this.rootView = rootView;
    this.callBtn = callBtn;
    this.userAddress = userAddress;
    this.userEmail = userEmail;
    this.userName = userName;
    this.userPhone = userPhone;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemUserLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemUserLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_user_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemUserLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.callBtn;
      LottieAnimationView callBtn = ViewBindings.findChildViewById(rootView, id);
      if (callBtn == null) {
        break missingId;
      }

      id = R.id.userAddress;
      TextView userAddress = ViewBindings.findChildViewById(rootView, id);
      if (userAddress == null) {
        break missingId;
      }

      id = R.id.userEmail;
      TextView userEmail = ViewBindings.findChildViewById(rootView, id);
      if (userEmail == null) {
        break missingId;
      }

      id = R.id.userName;
      TextView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      id = R.id.userPhone;
      TextView userPhone = ViewBindings.findChildViewById(rootView, id);
      if (userPhone == null) {
        break missingId;
      }

      return new ItemUserLayoutBinding((CardView) rootView, callBtn, userAddress, userEmail,
          userName, userPhone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
