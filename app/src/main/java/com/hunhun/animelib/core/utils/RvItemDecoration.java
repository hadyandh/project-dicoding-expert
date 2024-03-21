package com.hunhun.animelib.core.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RvItemDecoration extends RecyclerView.ItemDecoration {
  private int spanCount;
  private int spacing;
  private int spacingVertical;
  private boolean includeEdge;

  public RvItemDecoration(int spanCount, int spacing, int spacingVertical, boolean includeEdge) {
    this.spanCount = spanCount; // columns
    this.spacing = spacing; // px
    this.spacingVertical = spacingVertical;
    this.includeEdge = includeEdge;
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    int position = parent.getChildAdapterPosition(view); // item position
    int column = position % spanCount; // item column

    if (includeEdge) {
      outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
      outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

      if (position < spanCount) { // top edge
        outRect.top = spacingVertical;
      }
      outRect.bottom = spacingVertical; // item bottom
    } else {
      outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
      outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
      if (position >= spanCount) {
        outRect.top = spacingVertical; // item top
      }
    }
  }
}