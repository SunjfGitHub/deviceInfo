#include <jni.h>
#include <string>
#include <iostream>
#include <stdio.h>
#include <unistd.h>
#include <libgen.h>



/**
 * library load in main function.
 * @param vm
 * @param reserved
 * @return
 */
extern "C"
JNIEXPORT
jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env = NULL;
    jint ret = -1;
    char buf[256] = {0};
    do {
        // signal_init("/sdcard");
        if (JNI_OK != vm->GetEnv((void **) &env, JNI_VERSION_1_4)) {
            ret = -160001;
            break;
        };



        return JNI_VERSION_1_4;
    } while (0);
    return ret;
}
