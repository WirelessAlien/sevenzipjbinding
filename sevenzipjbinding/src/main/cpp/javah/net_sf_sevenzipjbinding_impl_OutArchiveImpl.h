#include <jni.h>

#ifndef _Included_net_sf_sevenzipjbinding_impl_OutArchiveImpl
#define _Included_net_sf_sevenzipjbinding_impl_OutArchiveImpl
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeUpdateItems
  (JNIEnv *, jobject, jobject, jint, jobject);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeSetProperties
  (JNIEnv *, jobject, jint, jint, jint, jstring, jboolean);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_OutArchiveImpl_nativeClose
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
