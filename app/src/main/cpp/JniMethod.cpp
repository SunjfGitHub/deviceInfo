//
// Created by zzm on 18-8-16.
//

#include "JniMethod.h"
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring
JNICALL
stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}