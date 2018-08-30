#include <jni.h>
#include <string>
#include "jni_method_register.h"
#include <iostream>
#include <jni.h>
#include <string>
#include <stdio.h>
#include <unistd.h>
#include <sys/prctl.h>
#include <libgen.h>
#include <android/log.h>

using namespace method_register;

static jboolean registerNatives(JNIEnv *env) {

    int reg_size = RegisterClassFunction::list_register_size();
    JNINativeMethod gMethods = {0};
    RegisterClassFunction *obj_ptr = NULL;
    jclass clazz = NULL;
    int ret = 0;

    for (int i = 0; i < reg_size; i++) {

        obj_ptr = RegisterClassFunction::pop_register();
        do {

            clazz = env->FindClass(obj_ptr->m_clazz_name.c_str());
            if (!clazz) {
                ret = -158001;
                break;
            }

            gMethods.fnPtr = obj_ptr->m_native_handler;
            gMethods.name = obj_ptr->m_function_name.c_str();
            gMethods.signature = obj_ptr->m_signature.c_str();

            if (env->RegisterNatives(clazz, &gMethods, 1) < 0) {
                ret = -158002;
                break;
            }

            goto break_cont;

        } while (false);
        return JNI_FALSE;

        break_cont:
        delete obj_ptr;
        continue;
    }

    return JNI_TRUE;
}

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
        if (JNI_OK != vm->GetEnv((void **) &env, JNI_VERSION_1_4)) {
            ret = -160001;
            break;
        };

        RegisterClassFunction::register_init(env);
        if (JNI_TRUE != (ret = registerNatives(env))) {
            break;
        }

        return JNI_VERSION_1_4;
    } while (0);
    return ret;
}