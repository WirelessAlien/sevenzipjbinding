#include <jni.h>

#ifndef _Included_net_sf_sevenzipjbinding_SevenZip
#define _Included_net_sf_sevenzipjbinding_SevenZip
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jstring JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeInitSevenZipLibrary
  (JNIEnv *, jclass);

JNIEXPORT jint JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeGetVersionMajor
  (JNIEnv *, jclass);

JNIEXPORT jint JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeGetVersionMinor
  (JNIEnv *, jclass);

JNIEXPORT jint JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeGetVersionBuild
  (JNIEnv *, jclass);

JNIEXPORT jstring JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeGetVersionVersion
  (JNIEnv *, jclass);

JNIEXPORT jstring JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeGetVersionDate
  (JNIEnv *, jclass);

JNIEXPORT jstring JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeGetVersionCopyright
  (JNIEnv *, jclass);

JNIEXPORT jobject JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeOpenArchive
  (JNIEnv *, jclass, jobject, jobject, jobject);

JNIEXPORT void JNICALL Java_net_sf_sevenzipjbinding_SevenZip_nativeCreateArchive
  (JNIEnv *, jclass, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif
