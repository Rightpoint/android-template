package com.rightpoint.github.mvi.remote;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.lang.Override;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

final class KotshiAppJsonAdapterFactory extends AppJsonAdapterFactory {
  KotshiAppJsonAdapterFactory() {
  }

  @Override
  public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
    if (!annotations.isEmpty()) return null;

    return null;
  }
}
