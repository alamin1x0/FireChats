// Generated by view binder compiler. Do not edit!
package com.developeralamin.firechat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.developeralamin.firechat.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChatBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView backBtn;

  @NonNull
  public final TextView inputName;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextInputEditText messagTextId;

  @NonNull
  public final ImageView messageBtn;

  @NonNull
  public final RecyclerView messageRecylerView;

  private ActivityChatBinding(@NonNull LinearLayout rootView, @NonNull ImageView backBtn,
      @NonNull TextView inputName, @NonNull LinearLayout linearLayout,
      @NonNull TextInputEditText messagTextId, @NonNull ImageView messageBtn,
      @NonNull RecyclerView messageRecylerView) {
    this.rootView = rootView;
    this.backBtn = backBtn;
    this.inputName = inputName;
    this.linearLayout = linearLayout;
    this.messagTextId = messagTextId;
    this.messageBtn = messageBtn;
    this.messageRecylerView = messageRecylerView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backBtn;
      ImageView backBtn = ViewBindings.findChildViewById(rootView, id);
      if (backBtn == null) {
        break missingId;
      }

      id = R.id.inputName;
      TextView inputName = ViewBindings.findChildViewById(rootView, id);
      if (inputName == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.messagTextId;
      TextInputEditText messagTextId = ViewBindings.findChildViewById(rootView, id);
      if (messagTextId == null) {
        break missingId;
      }

      id = R.id.messageBtn;
      ImageView messageBtn = ViewBindings.findChildViewById(rootView, id);
      if (messageBtn == null) {
        break missingId;
      }

      id = R.id.messageRecylerView;
      RecyclerView messageRecylerView = ViewBindings.findChildViewById(rootView, id);
      if (messageRecylerView == null) {
        break missingId;
      }

      return new ActivityChatBinding((LinearLayout) rootView, backBtn, inputName, linearLayout,
          messagTextId, messageBtn, messageRecylerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}