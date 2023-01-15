// Generated by view binder compiler. Do not edit!
package com.developeralamin.firechat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.developeralamin.firechat.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final MaterialButton loginBtn;

  @NonNull
  public final TextView textRegistion;

  @NonNull
  public final TextInputEditText userEmail;

  @NonNull
  public final TextView userForgotPassword;

  @NonNull
  public final TextInputEditText userPasword;

  private ActivityLoginBinding(@NonNull ScrollView rootView, @NonNull MaterialButton loginBtn,
      @NonNull TextView textRegistion, @NonNull TextInputEditText userEmail,
      @NonNull TextView userForgotPassword, @NonNull TextInputEditText userPasword) {
    this.rootView = rootView;
    this.loginBtn = loginBtn;
    this.textRegistion = textRegistion;
    this.userEmail = userEmail;
    this.userForgotPassword = userForgotPassword;
    this.userPasword = userPasword;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.loginBtn;
      MaterialButton loginBtn = ViewBindings.findChildViewById(rootView, id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.textRegistion;
      TextView textRegistion = ViewBindings.findChildViewById(rootView, id);
      if (textRegistion == null) {
        break missingId;
      }

      id = R.id.userEmail;
      TextInputEditText userEmail = ViewBindings.findChildViewById(rootView, id);
      if (userEmail == null) {
        break missingId;
      }

      id = R.id.userForgotPassword;
      TextView userForgotPassword = ViewBindings.findChildViewById(rootView, id);
      if (userForgotPassword == null) {
        break missingId;
      }

      id = R.id.userPasword;
      TextInputEditText userPasword = ViewBindings.findChildViewById(rootView, id);
      if (userPasword == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ScrollView) rootView, loginBtn, textRegistion, userEmail,
          userForgotPassword, userPasword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
