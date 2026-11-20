#include <jni.h>

#ifndef _Included_net_sf_sevenzipjbinding_impl_InArchiveImpl
#define _Included_net_sf_sevenzipjbinding_impl_InArchiveImpl
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeExtract
  (JNIEnv *, jobject, jintArray, jboolean, jobject);

JNIEXPORT jint JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetNumberOfItems
  (JNIEnv *, jobject);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeClose
  (JNIEnv *, jobject);

JNIEXPORT jint JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetNumberOfArchiveProperties
  (JNIEnv *, jobject);

JNIEXPORT jobject JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetArchivePropertyInfo
  (JNIEnv *, jobject, jint);

JNIEXPORT jobject JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetArchiveProperty
  (JNIEnv *, jobject, jint);

JNIEXPORT jstring JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetStringArchiveProperty
  (JNIEnv *, jobject, jint);

JNIEXPORT jint JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetNumberOfProperties
  (JNIEnv *, jobject);

JNIEXPORT jobject JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetProperty
  (JNIEnv *, jobject, jint, jint);

JNIEXPORT jstring JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetStringProperty
  (JNIEnv *, jobject, jint, jint);

JNIEXPORT jobject JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeGetPropertyInfo
  (JNIEnv *, jobject, jint);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_impl_InArchiveImpl_nativeConnectOutArchive
  (JNIEnv *, jobject, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif
