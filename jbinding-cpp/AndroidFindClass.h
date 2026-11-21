#ifndef ANDROIDFINDCLASS_H_
#define ANDROIDFINDCLASS_H_

#include <jni.h>

#if defined(ANDROID) || defined(__ANDROID__)
jclass findClass(JNIEnv * env, const char * className);
#endif

#endif /* ANDROIDFINDCLASS_H_ */
