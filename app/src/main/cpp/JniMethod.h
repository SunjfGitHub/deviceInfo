//
// Created by zzm on 18-8-16.
//

#ifndef DEVICEINFO_JNIMETHOD_H
#define DEVICEINFO_JNIMETHOD_H

#include <jni.h>
#include <string>

#ifdef  __cplusplus
extern "C" {
#endif

jstring stringFromJNI(JNIEnv *env,
                      jobject);
#ifdef  __cplusplus
}
#endif

#endif //DEVICEINFO_JNIMETHOD_H
