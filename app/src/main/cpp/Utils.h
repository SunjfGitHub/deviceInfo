//
// Created by zzm on 18-8-24.
//

#ifndef DEVICEINFO_UTILS_H
#define DEVICEINFO_UTILS_H

#include <jni.h>
#include <stdio.h>
#include <string>

#ifdef  __cplusplus
extern "C" {
#endif

jstring execCmdFromNative(JNIEnv *env, jclass cls, jstring cmd);

#ifdef  __cplusplus
}
#endif
#endif //DEVICEINFO_UTILS_H
