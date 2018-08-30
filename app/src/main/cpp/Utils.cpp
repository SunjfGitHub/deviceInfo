//
// Created by zzm on 18-8-24.
//

#include "Utils.h"
#include <jni.h>
#include <stdio.h>
#include <string>

#define    NELEMS(x)            ((sizeof(x))/(sizeof((x)[0])))

jstring execCmdFromNative(JNIEnv *env, jclass cls, jstring cmd) {

    FILE *fp;
    char buffer[256];
    std::string modet = "r";
    const char *cmd_chr = NULL;
    jstring ret = NULL;
    std::string pstr = "";

    do {
        if (!cmd || !env) {
            break;
        }
        cmd_chr = env->GetStringUTFChars(cmd, JNI_FALSE);
        if (!cmd_chr) {
            break;
        }

        fp = popen(cmd_chr, modet.c_str());
        if (!fp) {
            break;
        }
        while (NULL != fgets(buffer, NELEMS(buffer), fp)) {
            pstr += buffer;
        }

        if (fp)
            pclose(fp);

        if (pstr.length() < 1) {
            break;
        }

        ret = env->NewStringUTF(pstr.c_str());

    } while (false);

    if (cmd_chr) {
        env->ReleaseStringUTFChars(cmd, cmd_chr);
    }
    return ret;
}
