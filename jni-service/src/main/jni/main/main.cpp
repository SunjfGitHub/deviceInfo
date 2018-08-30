//
// Created by hello on 18-8-20.
//

#include <jni.h>
#include <android/log.h>
#include <stdio.h>
int main()
{
    printf("hello world!\n");
    __android_log_print(ANDROID_LOG_DEBUG, "__FILE__", "%s\n", "hello world@");
    return 0;
}
