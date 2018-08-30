
#include <jni.h>
#include <string>
#include "jni_method_register.h"
#include "JniMethod.h"
#include "Utils.h"

namespace method_register {
    pthread_mutex_t m_mutext = PTHREAD_MUTEX_INITIALIZER;
    std::list<RegisterClassFunction *> RegisterClassFunction::register_list;

    RegisterClassFunction::RegisterClassFunction(std::string clazz, std::string func_name,
                                                 std::string sig, void *native_handler) :
            m_function_name(func_name), m_signature(sig), m_native_handler(native_handler) {
        this->m_clazz_name = clazz;
    }

    bool RegisterClassFunction::push_rigister(RegisterClassFunction *obj) {
        pthread_mutex_lock(&m_mutext);
        register_list.push_back(obj);
        pthread_mutex_unlock(&m_mutext);
        return true;
    }

    int RegisterClassFunction::list_register_size() {
        pthread_mutex_lock(&m_mutext);
        int count = register_list.size();
        pthread_mutex_unlock(&m_mutext);
        return count;
    }

    RegisterClassFunction *RegisterClassFunction::pop_register() {
        pthread_mutex_lock(&m_mutext);
        do {
            if (register_list.empty())
                break;

            RegisterClassFunction *obj = register_list.front();
            register_list.pop_front();

            pthread_mutex_unlock(&m_mutext);
            return obj;
        } while (false);
        pthread_mutex_unlock(&m_mutext);
        return NULL;

    }

    bool RegisterClassFunction::register_init(JNIEnv *env) {

#define JNI_METHOD_CLZ "com/kkxl/deviceinfo/util/JniMethodUtils"
        push_rigister(
                new RegisterClassFunction(JNI_METHOD_CLZ, "stringFromJNI", "()Ljava/lang/String;",
                                          (void *) stringFromJNI));
        push_rigister(new RegisterClassFunction(JNI_METHOD_CLZ, "jniExecCmd",
                                                "(Ljava/lang/String;)Ljava/lang/String;",
                                                (void *) execCmdFromNative));

        return true;
    }


}//end namespace




