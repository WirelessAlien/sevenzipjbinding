#include <jni.h>

#ifndef _Included_net_sf_sevenzipjbinding_impl_OutArchiveImpl
#define _Included_net_sf_sevenzipjbinding_impl_OutArchiveImpl
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeUpdateItems
  (JNIEnv *, jobject, jobject, jint, jobject);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeSetLevel
  (JNIEnv *, jobject, jint);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeSetSolid
  (JNIEnv *, jobject, jboolean);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeSetSolidFiles
  (JNIEnv *, jobject, jint);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeSetSolidSize
  (JNIEnv *, jobject, jlong);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeSetMultithreading
  (JNIEnv *, jobject, jint);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeClose
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
