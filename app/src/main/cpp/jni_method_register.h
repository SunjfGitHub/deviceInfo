
#ifndef _NATIVE_FUNCTION_REGISTER_H
#define _NATIVE_FUNCTION_REGISTER_H

#include <jni.h>
#include <list>

namespace method_register {

    class RegisterClassFunction {

    public:
        RegisterClassFunction(std::string clazz,
                              std::string func_name,
                              std::string sig,
                              void *native_handler);

        std::string m_clazz_name;
        std::string m_function_name;
        std::string m_signature;
        void *m_native_handler;

        static bool register_init(JNIEnv *env);

        static int list_register_size();

        static bool push_rigister(RegisterClassFunction *obj);

        static RegisterClassFunction *pop_register();

    private:
        static std::list<RegisterClassFunction *> register_list;
    };

}//end namespace

#endif  //end _NATIVE_FUNCTION_REGISTER__


